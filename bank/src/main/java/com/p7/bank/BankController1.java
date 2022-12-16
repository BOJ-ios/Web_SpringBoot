package com.p7.bank;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController1 {
  @Autowired
  private MemberRepository memRep;
  @Autowired
  private QARepository qaRep;

  @GetMapping("/login")
  public String login(Model mo) {
    // int count = memRep.countId();
    mo.addAttribute("count", memRep.countId());
    return "login";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session, Model mo) {
    mo.addAttribute("id", session.getAttribute("id"));
    session.invalidate();
    return "logout";
  }

  @GetMapping("/member/register")
  public String memberRegister() {
    return "memberRegister_edit";
  }

  @GetMapping("/member/insert")
  public String memberInsert(String id, String pw, String name, String phone, Model mo) {
    if (memRep.existsById(id)) { // 이미 존재하는 아이디
      mo.addAttribute("msg", id + "은(는) 이미 사용되고 있는 아이디입니다.");
      mo.addAttribute("url", "back");
    } else {
      Member m = new Member();
      m.id = id;
      m.pw = pw;
      m.name = name;
      m.phone = phone;
      m.balance = 0;
      memRep.save(m);
      mo.addAttribute("msg", id + "님, 반갑습니다!! (로그인 화면으로 이동)");
      mo.addAttribute("url", "/login");
    }
    return "popups";
  }

  @GetMapping("/login/check")
  public String loginCheck(HttpSession session, String id, Model mo) {
    if (memRep.existsById(id)) { /* 정상 로그인 */
      session.setAttribute("id", id);
      return "redirect:/menu";
    } else {
      mo.addAttribute("msg", id
          + "은(는) 미등록 아이디입니다. 확인 후 로그인 부탁드립니다.");
      mo.addAttribute("url", "/login");
      return "popups";
    }
  }

  @GetMapping("/menu")
  public String menu(HttpSession session, Model mo) {
    if (session.getAttribute("id") == null) {
      mo.addAttribute("msg", "로그인 후 이용해 주세요.");
      mo.addAttribute("url", "/login");
      return "popups";
    } else {
      mo.addAttribute("id", session.getAttribute("id"));
      return "menu";
    }
  }

  @GetMapping("/member/list")
  public String memberList(HttpSession session, Model model) {
    String id = (String) session.getAttribute("id");
    if (id == null) {
      model.addAttribute("msg", "login first");
      model.addAttribute("url", "/login");
      return "popups";
    } else if (id.equals("admin")) {
      List<Member> list = memRep.findAll();
      model.addAttribute("list", list);
      return "memberList";
    } else {
      model.addAttribute("msg", id + "Here is for admin user");
      model.addAttribute("url", "/menu");
      return "popups";
    }
  }

  @GetMapping("/member/viplist")
  public String viplist(Model model) {
    List<Member> list = memRep.findVip();
    model.addAttribute("list", list);
    return "vipList";
  }

  @GetMapping("/myinfo")
  public String myinfo(HttpSession session, Model mo) {
    String id = (String) session.getAttribute("id");
    int qcount = qaRep.findQCount(id);
    mo.addAttribute("qcount", qcount);
    Member m = memRep.findById(id).get();
    mo.addAttribute("m", m);
    DecimalFormat df = new DecimalFormat("###,###");
    mo.addAttribute("won", df.format(m.balance) + " 원");
    return "myinfo";
  }

  @GetMapping("/myinfo/update")
  public String myinfoUpdate(HttpSession session, String pw, String name, String phone,
      Model mo, String h_pw, String h_name, String h_phone) {
    String id = (String) session.getAttribute("id");
    if (pw.equals(h_pw) && name.equals(h_name) && phone.equals(h_phone)) {
      mo.addAttribute("msg", "변경된 사항이 없습니다.");
      mo.addAttribute("url", "/myinfo");
    } else if (memRep.updateMyinfo(id, pw, name, phone) == 0) {
      mo.addAttribute("msg", "정보 변경 실패. 고객센터로 문의하세요.");
      mo.addAttribute("url", "back");
    } else {
      mo.addAttribute("msg", id + "님의 정보가 변경되었습니다.");
      mo.addAttribute("url", "/myinfo");
    }
    return "popups";
  }
}
