package com.example.webp.dulli;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SurveyController {
  // Survey
  @GetMapping("/start")
  public String start() {
    return "/survey/start";
  }

  @PostMapping("/survey1")
  public String survey1(HttpSession session, String id) {
    session.setAttribute("id", id);
    return "/survey/survey1";
  }

  @PostMapping("/survey2")
  public String survey2(HttpSession session, String artist) {
    session.setAttribute("artist", artist);
    return "/survey/survey2";
  }

  @PostMapping("/thanks")
  public String thanks(HttpSession session, String musician) {
    session.setAttribute("musician", musician);
    return "/survey/thanks";
  }

  @GetMapping("/result")
  public String result(HttpSession session, Model model) {
    model.addAttribute("id", session.getAttribute("id"));
    model.addAttribute("artist", session.getAttribute("artist"));
    model.addAttribute("musician", session.getAttribute("musician"));
    return "/survey/result";
  }
}
