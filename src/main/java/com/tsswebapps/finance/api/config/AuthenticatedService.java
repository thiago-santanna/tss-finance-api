package com.tsswebapps.finance.api.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tsswebapps.finance.api.model.Usuario;
import com.tsswebapps.finance.api.repository.IPessoaRepository;

@Service
public class AuthenticatedService implements UserDetailsService {
	
	@Autowired
	private IPessoaRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username)  {
		Optional<Usuario> pessoa = repository.findByEmail(username);
		
		if (pessoa.isPresent()) {
			return pessoa.get();
		}
		throw new UsernameNotFoundException("User or password not found.");
	}

}
