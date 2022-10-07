package com.example.webp.dulli;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  @GetMapping("/login")
  public String login() {
    return "/login/login";
  }

  @PostMapping("/login/check")
  public String loginCheck(HttpSession session, String id) {
    ArrayList<String> list = new ArrayList<>();
    list.add("고흐");
    list.add("빅맥");
    list.add("dooli");
    list.add("bread");
    if (list.contains(id)) {
      session.setAttribute("id", id);
      return "redirect:/menu";
    } else {
      return "/login/popups";
    }
  }

  @GetMapping("/menu")
  public String menu(HttpSession session, Model model) {
    model.addAttribute("id", session.getAttribute("id"));
    return "/login/menu";
  }

  @GetMapping("/popups")
  public String popups() {
    return "/login/popups";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session, Model model) {
    model.addAttribute("id", session.getAttribute("id"));
    session.invalidate();
    return "/login/logout";
  }
}