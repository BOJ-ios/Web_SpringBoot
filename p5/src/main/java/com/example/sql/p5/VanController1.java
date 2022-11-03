package com.example.sql.p5;

import java.util.List;
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
} // Controller class
