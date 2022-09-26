package com.example.webp.dulli;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
  // static폴더의 index.html 보다controller코딩이 우선순위
  @GetMapping("/")
  public String home() {
    return "home";
  }
  
  @GetMapping("/ex01")
  public String ex01(){
    return "ex01";
  }
  @PostMapping("/ex01/answer")
  public String ex01Answer(String id, String password, Model model) {
    model.addAttribute("id", id);
    model.addAttribute("password", password);
    return "ex01Answer";
  }

  @GetMapping("/Quiz_03")
  public String Quiz_03(){
    return "wise";
  }
  @PostMapping("/Quiz03/answer")
  public String Quiz_03_Answer(String wiseperson, String wisesaying, Model model) {
    model.addAttribute("wiseperson", wiseperson);
    model.addAttribute("wisesaying", wisesaying);
    return "wiseAnswer";
  }

  @GetMapping("/Quiz_04")
  public String Quiz_04(){
    return "bread";
  }
  @PostMapping("/Quiz04/answer")
  public String Quiz_04_Answer(String bread_kinds, String bread_cost, Integer count,Model model) {
    model.addAttribute("bread_kinds", bread_kinds);
    model.addAttribute("bread_cost", bread_cost);
    model.addAttribute("count", count);
    return "breadAnswer";
  }
}
