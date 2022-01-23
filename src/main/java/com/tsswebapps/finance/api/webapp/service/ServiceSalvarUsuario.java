package com.tsswebapps.finance.api.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.api.model.Perfil;
import com.tsswebapps.finance.api.model.Usuario;
import com.tsswebapps.finance.api.repository.IUsuarioRepository;

@Service
public class ServiceSalvarUsuario {
	
	@Autowired
	public IUsuarioRepository usuarioRepo;
	
	public void execute(Usuario usuario) {
		Perfil perfilUsuario = new Perfil();
		perfilUsuario.setNome("USER");
		
		List<Perfil> perfis = new ArrayList<>();
		
		perfis.add(perfilUsuario);
		usuario.setPerfis(perfis);
		
		usuarioRepo.save(usuario);
	}
}
