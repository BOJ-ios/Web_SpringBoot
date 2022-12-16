package com.p7.bank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class problemController {

  @GetMapping("/problem")
  public String problem() {
    return "problem";
  }

  @PostMapping("/problem/result")
  public String result(String a1, String a2, String a3, String a4, String a5, Model mo) {
    int score = 0;
    List<Boolean> list = new ArrayList<>();
    String[] submit = { a1, a2, a3, a4, a5 };
    String[] answer = { "서울", "2", "menu", "9", "hello" };
    for (int i = 0; i < answer.length; i++) {
      if (submit[i].equals(answer[i])) {
        score += 20;
        list.add(true);
      } else {
        list.add(false);
      }
    }
    mo.addAttribute("list", list);
    mo.addAttribute("score", score);
    return "problemResult";
  }
}
