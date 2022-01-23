package com.tsswebapps.finance.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticatedService authenticatedService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(authenticatedService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/usuario/cadastro").permitAll()
				.antMatchers(HttpMethod.POST, "/usuario/salvar").permitAll()
				.anyRequest().authenticated()
				.and()
				.httpBasic()
				.and()
				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/financas/resumo", true)
						.permitAll()
				)
				.logout(logout ->{ 
					logout.logoutUrl("/logout")
						.logoutSuccessUrl("/home");	
				})
			.csrf()
				.disable();
	}
}
