package com.tsswebapps.finance.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticatedService authenticatedService;
	
//	@Autowired
//	DataSource dataSource;

	
	  @Override 
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		auth.userDetailsService(authenticatedService).passwordEncoder(new BCryptPasswordEncoder()); 
	}
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic()
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.GET, "/usuario/cadastro").permitAll()
					.antMatchers(HttpMethod.POST, "/usuario/salvar").permitAll()
					.antMatchers(HttpMethod.GET, "/usuario/esqueci").permitAll()
					.anyRequest().authenticated()
				.and()
					.formLogin()
					.loginPage("/login")
					.permitAll()
				.and()
					.logout()
					.permitAll()
				.and()
					.cors()
				.and()
					.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
					.csrf()
					.disable();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();

		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", configuration);

		return source;
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		
//		/* Bloco usado em aula pra criar um usuário pra dev em produção é usado o que está abaixo
//		 * UserDetails user = User .builder() .username("thiago")
//		 * .password(encoder.encode("102057")) .roles("ADM") .build();
//		 * 
//		 * auth.jdbcAuthentication() .dataSource(dataSource) .passwordEncoder(encoder)
//		 * .withUser(user);
//		 */
//		  
//		 auth.jdbcAuthentication() 
//		 	.dataSource(dataSource) 
//		 	.passwordEncoder(encoder);		
//		
//	}

}
