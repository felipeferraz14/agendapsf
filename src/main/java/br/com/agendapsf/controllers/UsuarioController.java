package br.com.agendapsf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.agendapsf.daos.PostoSaudeDAO;
import br.com.agendapsf.daos.UsuarioDAO;
import br.com.agendapsf.models.PostoSaude;
import br.com.agendapsf.models.UF;
import br.com.agendapsf.models.Usuario;

@Controller
public class UsuarioController {
	
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired 
	private PostoSaudeDAO postosaudeDAO;
	
	@RequestMapping("formUsuario")
	public ModelAndView form(){
		List<PostoSaude> postos = postosaudeDAO.listar();
		List<Usuario> usuarios = usuarioDAO.listarUsuarios();
		ModelAndView mv = new ModelAndView("formUsuario");
		mv.addObject("UF", UF.values());
		mv.addObject("postos", postos);
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	@RequestMapping("/usuario")
	public String gravar(Usuario usuario){
		usuarioDAO.gravar(usuario);
		return "ok";
	}
	
	@RequestMapping("listarCelular")
	public ModelAndView listarTelefone(){
		List<String> celulares = usuarioDAO.listarCelular();
		ModelAndView mv = new ModelAndView("listarCelular");
		mv.addObject("celulares", celulares);
		return mv ;
	}
	
	@RequestMapping("buscarUsuario")
	public ModelAndView buscarUsuario(String cartao ){
		Usuario usuarioselecionado = new Usuario();
		List<Usuario> usuarios = usuarioDAO.listarUsuarios();
		ModelAndView mv = new ModelAndView("formUsuario2");
		

		for (Usuario usuario : usuarios) {
			if (usuario.getCartSUS().equals(cartao)){
				usuarioselecionado = usuario;
				System.out.println("usuario encontrado!" + usuarioselecionado.getNomeUsuario());
					mv.addObject("usuarios", usuarioselecionado);
				
			}
		}
		
		
		return mv;
		
	}
	
	@RequestMapping("deletarUsuario")
	public String deletar(Usuario usuario){
		System.out.println("deletando.....");
		System.out.println(usuario.getId());
		usuarioDAO.deletar(usuario); 
		return "deletado"; 
	}
	
	
	
	
}
