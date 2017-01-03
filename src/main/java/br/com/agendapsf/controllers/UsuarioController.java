package br.com.agendapsf.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result){
		List<PostoSaude> postos = postosaudeDAO.listar();
		ModelAndView mv = new ModelAndView("formUsuario");
		mv.addObject("UF", UF.values());
		mv.addObject("postos", postos);
		mv.addObject("usuario", usuario);

		if(usuarioDAO.comparar(usuario) == true){			
			return mv;
		} else 
			{	
				if(result.hasErrors()){
					System.out.println(result.getFieldError());
					return mv;
					}
					usuarioDAO.gravar(usuario);
					return new ModelAndView("ok");
		}	
	}
	
	@RequestMapping("/editusuario")
	public String gravarEdit(@Valid Usuario usuario, BindingResult result){
		
		
			if(result.hasErrors()){
				return "formUsuario";
				}
				usuarioDAO.atualizar(usuario);
				return "ok";
		
	}
	
	@RequestMapping("listarCelular")
	public ModelAndView listarTelefone(){
		List<String> celulares = usuarioDAO.listarCelular();
		ModelAndView mv = new ModelAndView("listarCelular");
		mv.addObject("celulares", celulares);
		return mv ;
	}

//	No momento de buscar usuário, 
//	retornar para a página com o usuário buscado
//	e também com o formulário carregado para editar
	
	@RequestMapping("buscarUsuario")
	public ModelAndView buscarUsuario(String cartao ){
		Usuario usuarioselecionado = new Usuario();
		List<Usuario> usuarios = usuarioDAO.listarUsuarios();
		List<PostoSaude> postos = postosaudeDAO.listar();
		ModelAndView mv = new ModelAndView("editUsuario");
		
		for (Usuario usuario : usuarios) {
			if (usuario.getCartSUS().equals(cartao)){
				usuarioselecionado = usuario;
				System.out.println("usuario encontrado!" + usuarioselecionado.getNomeUsuario());
					mv.addObject("usuarios", usuarioselecionado);	
					mv.addObject("UF", UF.values());
					mv.addObject("postos", postos);
			}
		}
		return mv;
	}
	
//	Verificar controle no banco, caso 
//	haja alguma agenda feita para o 	
//	paciente ser inativado e não deletado
	
	@RequestMapping("deletarUsuario")
	public String deletar(Usuario usuario){
		System.out.println("deletando.....");
		System.out.println(usuario.getId());
		usuarioDAO.deletar(usuario); 
		return "deletado"; 
	}	
}
