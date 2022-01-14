package com.tsswebapps.finance.api.webapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

  @GetMapping("/web/hello")
  public String webHello(HttpServletRequest request) {
	request.setAttribute("hello", "Hello, sou o recurso do front-end.");  
	
    return "web-hello";
  }
}
