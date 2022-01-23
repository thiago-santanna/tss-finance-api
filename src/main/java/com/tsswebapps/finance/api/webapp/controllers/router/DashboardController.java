package com.tsswebapps.finance.api.webapp.controllers.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("financas")
public class DashboardController {
	
	@GetMapping("/resumo")
	public String dashboard() {
		System.out.println("redirecionado para dash");
		
		return "financas/resumo";
	}
}
