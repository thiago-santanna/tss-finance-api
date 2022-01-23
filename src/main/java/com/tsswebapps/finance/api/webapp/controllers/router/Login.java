package com.tsswebapps.finance.api.webapp.controllers.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {

	@GetMapping("/login")
	public ModelAndView userAuth() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
}
