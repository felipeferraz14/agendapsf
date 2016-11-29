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
		ModelAndView mv = new ModelAndView("formUsuario");
		mv.addObject("UF", UF.values());
		mv.addObject("postos", postos);
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
	
	@RequestMapping("deletarusuario")
	public String deletar(String cartao){
		
		// verificar cartão se é de algum usuário
		List<Usuario> usuarios = usuarioDAO.listarUsuarios();
		
		for (Usuario usuario : usuarios) {
			if (usuario.getCartSUS().equals(cartao)){
				System.out.println("usuario encontrado!" + usuario.getNomeUsuario());
				usuarioDAO.deletar(usuario); 
				return "deletado"; 
			} else {
				System.out.println("usuario não encontrado!");
				
			}
		}
		return "formUsuario"; 
	}
	
	
	
	
}
