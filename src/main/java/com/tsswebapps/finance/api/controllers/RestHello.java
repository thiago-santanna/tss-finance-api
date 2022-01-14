package com.tsswebapps.finance.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestHello {
	
	@GetMapping("/hello")
	public String restHello() {
		return "Hello sou o recruso da Api.";
	}
}
