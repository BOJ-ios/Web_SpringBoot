package com.example.webp.dulli;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
  // static폴더의 index.html 보다controller코딩이 우선순위
  @GetMapping("/")
  public String home() {
    return "home";
  }

  // 로그인
  @GetMapping("/ex01")
  public String ex01() {
    return "ex01";
  }

  @PostMapping("/ex01/answer")
  public String ex01Answer(String id, String password, Model model) {
    model.addAttribute("id", id);
    model.addAttribute("password", password);
    return "ex01Answer";
  }

  // 직급, 연봉
  @GetMapping("/ex02")
  public String ex02() {
    return "ex02";
  }

  @PostMapping("/ex02/answer")
  public String ex02Answer(String name, String po, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("po", po);
    int salary = 0;
    switch (po) {
      case "사원":
        salary = 3500;
      case "대리":
        salary = 5000;
      case "팀장":
        salary = 7000;
      case "임원":
        salary = 9900;
    }
    model.addAttribute("salary", salary);
    return "ex02Answer";
  }

  // 색상선택해서 background-color 바꾸기
  @GetMapping("/ex03")
  public String ex03() {
    return "ex03";
  }

  @PostMapping("/ex03/answer")
  public String ex03Answer(String name, String color, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("color", color);
    return "ex03Answer";
  }

  // 회원리스트
  @GetMapping("/ex04")
  public String ex04Answer(Model model) {
    ArrayList<String> list = new ArrayList<>();
    list.add("고흐");
    list.add("james");
    list.add("dooli");
    list.add("bread");
    model.addAttribute("list", list);
    return "ex04";
  }
}
