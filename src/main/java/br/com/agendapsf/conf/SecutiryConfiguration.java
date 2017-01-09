package br.com.agendapsf.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.agendapsf.daos.LoginDAO;

@EnableWebMvcSecurity
public class SecutiryConfiguration extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private LoginDAO usuarioDAO;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/views/formUsuario").permitAll()
		.antMatchers("/imagens/**").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/url-magica-jifhdaiucaiudjaiosd342cdsoicks").permitAll()
		.anyRequest().authenticated()
	    .and().formLogin().loginPage("/login").permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(usuarioDAO);
//		/*.passwordEncoder(new BCryptPasswordEncoder());*/
//	}

}
