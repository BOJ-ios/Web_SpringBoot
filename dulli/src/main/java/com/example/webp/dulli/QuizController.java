package com.example.webp.dulli;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuizController {
  // 위인
  @GetMapping("/Quiz_03")
  public String Quiz_03() {
    return "/wise_bread/wise";
  }

  @PostMapping("/Quiz03/answer")
  public String Quiz_03_Answer(String wiseperson, String wisesaying, Model model) {
    model.addAttribute("wiseperson", wiseperson);
    model.addAttribute("wisesaying", wisesaying);
    return "/wise_bread/wiseAnswer";
  }

  // 빵
  @GetMapping("/Quiz_04")
  public String Quiz_04() {
    return "/wise_bread/bread";
  }

  @PostMapping("/Quiz04/answer")
  public String Quiz_04_Answer(String bread_kinds, String bread_cost, Integer count, Model model) {
    model.addAttribute("bread_kinds", bread_kinds);
    model.addAttribute("bread_cost", bread_cost);
    model.addAttribute("count", count);
    return "/wise_bread/breadAnswer";
  }

  // q06
  @GetMapping("/q06")
  public String q06() {
    return "/q06/q06";
  }

  @GetMapping("/q06/a")
  public String q06a() {
    return "/q06/q06a";
  }

  @GetMapping("/q06/b")
  public String q06b() {
    return "/q06/q06b";
  }

  @PostMapping("/q06/aa")
  public String q06aa(String first, String second, Model model) {
    model.addAttribute("first", first);
    model.addAttribute("second", second);
    return "/q06/q06aa";
  }

  @PostMapping("/q06/bb")
  public String q06aa(String job, Model model) {
    model.addAttribute("job", job);
    return "/q06/q06bb";
  }

  // q07
  @GetMapping("/home/plus")
  public String plus_home() {
    return "/q07/a.html";
  }

  @PostMapping("/home/result")
  public String q07(int a, int b, Model model) {
    model.addAttribute("sum", a + b);
    return "/q07/b.html";
  }

  // q08
  @GetMapping("/phone")
  public String q08() {
    return "/q08/phone";
  }

  @PostMapping("/phone/result")
  public String phone_result(HttpSession session, Model mo, String company, String model) {
    if (company.equals("삼성") || company.equals("애플")) {
      session.setAttribute("msg", company + " " + model + "를 선택해 주셔서 감사합니다!!");
      session.setAttribute("company", company);
      session.setAttribute("model", model);
    } else {
      session.setAttribute("msg", "해당 회사의 제품은 매진되었습니다.");
    }
    mo.addAttribute("msg", session.getAttribute("msg"));
    return "/q08/phoneThanks";
  }

  @GetMapping("/phone/session")
  public String logout(HttpSession session, Model mo) {
    mo.addAttribute("company", session.getAttribute("company"));
    mo.addAttribute("model", session.getAttribute("model"));
    session.invalidate();
    return "/q08/phoneSession";
  }
}
