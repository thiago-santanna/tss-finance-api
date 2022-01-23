package com.tsswebapps.finance.api.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.api.model.Usuario;
import com.tsswebapps.finance.api.repository.IUsuarioRepository;

@Service
public class AuthenticatedService implements UserDetailsService  {
	@Autowired
	private IUsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByEmail(username);
		
		if (usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Usuario ou senha inválidos.");
	}
}
