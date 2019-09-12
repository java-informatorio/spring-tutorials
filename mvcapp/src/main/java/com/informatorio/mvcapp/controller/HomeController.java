package com.informatorio.mvcapp.controller;

import com.informatorio.mvcapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String showHome(User user) {
    return "home";
  }
}
