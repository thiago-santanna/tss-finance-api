package com.tsswebapps.finance.api.webapp.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tsswebapps.finance.api.model.Usuario;

public class UsuarioDTO {
	private String nome;
	private String email;
	private String senha;
	
	public UsuarioDTO() {}
	
	public UsuarioDTO(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [nome=" + nome + ", email=" + email + "]";
	}
	
	public Usuario toUsuario() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Usuario usuario = new Usuario();
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setSenha(encoder.encode(this.senha));		
		return usuario;
	}
}
