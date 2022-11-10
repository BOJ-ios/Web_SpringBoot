package com.example.sql.p5;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VanController1 {
  @GetMapping("/")
  public String home() {
    return "home";
  }

  // saleList====================================
  @Autowired
  private SaleRepository saleRep;

  @GetMapping("/saleList")
  public String Sale(Model mo) {
    List<Sale> list = saleRep.findAll();
    mo.addAttribute("list", list);
    return "saleList";
  }

  // memberList==================================
  @Autowired
  private MemberRepository memRep;

  @GetMapping("/member/list")
  public String memberList(Model mo) {
    List<Member> list = memRep.findAll();
    mo.addAttribute("list", list);
    return "memberList";
  }

  // register====================================
  @GetMapping("/member/register")
  public String memberRegister() {
    return "memberRegister";
  }

  // register insert==============================
  @PostMapping("/member/insert")
  public String memberInsert(String id, String pw, String name, String phone, Model mo) {
    Member member = new Member();
    member.id = id;
    member.pw = pw;
    member.name = name;
    member.phone = phone;
    member.balance = 0;
    memRep.save(member);
    mo.addAttribute("msg", id + "님, 회원가입을 축하드립니다!!");
    return "popups";
  }

  // memo============================================
  @Autowired
  private MemoRepository memo_Repository;

  @GetMapping("/memo")
  public String memo() {
    return "/week9_homework/memo";
  }

  @PostMapping("/memo/insert")
  public String memoInsert(String title, String memo_content) {
    Memo memo = new Memo();
    memo.title = title;
    memo.memo = memo_content;
    memo_Repository.save(memo);
    return "/week9_homework/popups";
  }

  @GetMapping("/memo/list")
  public String memoList(Model mo) {
    List<Memo> list = memo_Repository.findAll(Sort.by(Sort.Direction.ASC, "wdate"));
    mo.addAttribute("list", list);
    return "/week9_homework/memoList";
  }

  // foods
  @GetMapping("/foods")
  public String foods() {
    return "foods";
  }

  @PostMapping("/foods/result")
  public String foodsResult(String gender, int age, String[] arr,
      int face, int grade, int omg, String comments, Model mo) {
    mo.addAttribute("gender", gender);
    mo.addAttribute("age", age);
    String temp = "";
    if (arr == null)
      temp = "없음";
    else {
      StringBuilder sb = new StringBuilder();
      int length = arr.length;
      for (int i = 0; i < length; i++) {
        sb.append(arr[i]);
        if (i != length - 1) {
          sb.append(", ");
        }
      }
      temp = sb.toString();
    }
    mo.addAttribute("foods", temp);
    mo.addAttribute("face", face);
    mo.addAttribute("grade", grade);
    mo.addAttribute("omg", omg);
    mo.addAttribute("comments", comments);
    return "foodsResult";
  }

  // star
  @Autowired
  private StarRepository starRep;

  @GetMapping("/star/1")
  public String star1(Model mo) {
    String choice1_1 = "테슬라 모델 3";
    String choice1_2 = "아이오닉 6";
    mo.addAttribute("choice1_1", choice1_1);
    mo.addAttribute("choice1_2", choice1_2);
    return "star1";
  }

  @GetMapping("/star/2")
  public String star2(HttpSession session, Model mo, String choice1) {
    session.setAttribute("choice1", choice1);
    String choice2_1 = "포르쉐 타이칸";
    String choice2_2 = "벤츠 EQE";
    mo.addAttribute("choice2_1", choice2_1);
    mo.addAttribute("choice2_2", choice2_2);
    return "star2";
  }

  @GetMapping("/star/3")
  public String star3(HttpSession session, Model mo, String choice2) {
    mo.addAttribute("choice1", session.getAttribute("choice1"));
    mo.addAttribute("choice2", choice2);
    return "star3";
  }

  @GetMapping("/star/winner")
  public String starWinner(String winner, Model mo) {
    // starRep.updateCount(winner);
    mo.addAttribute("winner", winner);
    return "starWinner";
  }

  @GetMapping("/star/list")
  public String starList(Model mo) {
    List<Star> list = starRep.findAll();
    mo.addAttribute("list", list);
    return "starList";
  }
} // Controller class
