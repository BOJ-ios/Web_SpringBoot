package com.example.sql.p5;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

  // memberList
  @Autowired
  private MemberRepository memRep;

  @GetMapping("/member/list")
  public String memberList(Model mo) {
    List<Member> list = memRep.findAll();
    mo.addAttribute("list", list);
    return "memberList";
  }

  // saleList
  @Autowired
  private SaleRepository saleRep;

  @GetMapping("/saleList")
  public String Sale(Model mo) {
    List<Sale> list = saleRep.findAll();
    mo.addAttribute("list", list);
    return "saleList";
  }

  // register
  @GetMapping("/member/register")
  public String memberRegister() {
    return "memberRegister";
  }

  // register insert
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
} // Controller class
