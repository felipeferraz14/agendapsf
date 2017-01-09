package br.com.agendapsf.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agendapsf.daos.UsuarioDAO;
import br.com.agendapsf.models.PostoSaude;
import br.com.agendapsf.models.Role;
import br.com.agendapsf.models.UF;
import br.com.agendapsf.models.Usuario;

@Controller
public class LoginController {
	
	
	@Autowired
	private UsuarioDAO usuariodao;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String logar(){
		
		return "loginForm";
	}
	
	@RequestMapping("/")
	public String redirect(){
		
		return "home";
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping("/url-magica-jifhdaiucaiudjaiosd342cdsoicks")
	public String urlMagicaLogin(){
		
		Usuario usuario = new Usuario();
		usuario.setCartSUS("123456");
		usuario.setNomeUsuario("Admin");
		usuario.setSenha("1123456");
		usuario.setCelular("7399999999");
		usuario.setCidadeUsuario("Teixeira");
		usuario.setTelefone("7332919596");
		usuario.setPostosaude((PostoSaude) Arrays.asList(new PostoSaude(1)));
		usuario.setUF(UF.BA);
		usuario.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
		usuario.setEnderecoUsuario("TX");
		
		usuariodao.gravar(usuario); 
		
		return "Usuário Inserido com Sucesso";

		
	}
	

}
