package com.tsswebapps.finance.api.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {

	@GetMapping("/login")
	public String userAuth(Model model) {
		return "user-auth";
	}
	
}
