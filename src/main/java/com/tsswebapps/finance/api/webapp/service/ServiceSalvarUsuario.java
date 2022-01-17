package com.tsswebapps.finance.api.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.api.model.Usuario;
import com.tsswebapps.finance.api.repository.IPessoaRepository;

@Service
public class ServiceSalvarUsuario {
	
	@Autowired
	public IPessoaRepository usuarioRepo;
	
	public void execute(Usuario usuario) {
		usuarioRepo.save(usuario);
	}
}
