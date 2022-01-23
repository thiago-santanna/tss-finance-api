package com.tsswebapps.finance.api.webapp.controllers.router;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

  @GetMapping("/web/hello")
  public String webHello(Model model) {
	model.addAttribute("hello", "Hello, sou o recurso do front-end.");  
	
    return "web-hello";
  }
}
