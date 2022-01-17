package com.tsswebapps.finance.api.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsswebapps.finance.api.model.Usuario;
import com.tsswebapps.finance.api.webapp.dto.UsuarioDTO;
import com.tsswebapps.finance.api.webapp.service.ServiceSalvarUsuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	public ServiceSalvarUsuario serviceSalvarUsuario;
	
	@GetMapping("/cadastro")
	public String cadastrar() {
		return "usuario/cadastrar";
	}
	
	@PostMapping("/salvar")
	public String salvarUsuario(UsuarioDTO reqUsuario) {
		Usuario usuario = reqUsuario.toUsuario();
		serviceSalvarUsuario.execute(usuario);
		return "redirect:/";
	}
}
