package br.com.agendapsf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.agendapsf.daos.PostoSaudeDAO;
import br.com.agendapsf.models.PostoSaude;
import br.com.agendapsf.models.UF;

@Controller
public class PostoSaudeController {
	
	@Autowired
	private PostoSaudeDAO postoSaudeDAO;
	
	@RequestMapping("formPsf")
	public ModelAndView form(){
			List<PostoSaude> postos = postoSaudeDAO.listar();
			ModelAndView mv = new ModelAndView("formPsf");
			mv.addObject("UF", UF.values());
			mv.addObject("postos", postos);
		return mv;
	}
	
	@RequestMapping("posto")
	public String gravar(PostoSaude postosaude){
		postoSaudeDAO.gravar(postosaude);
		return "ok";
	}
	
	@RequestMapping("unidades")
	public ModelAndView listar(){
		List<PostoSaude> postos = postoSaudeDAO.listar();
		 ModelAndView mv = new ModelAndView("listaPostos");
		 mv.addObject("postos", postos);
		return mv;
	}
	
	@RequestMapping("deletarpsf")
	public String deletar(PostoSaude postosaude){
		
		postoSaudeDAO.deletar(postosaude);
		
		return "deletado";
	}

}
