package br.com.agendapsf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String logar(){
		
		return "loginForm";
	}
	
	@RequestMapping("/")
	public String redirect(){
		
		return "home";
	}
	

}
