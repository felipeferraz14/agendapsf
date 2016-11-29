package br.com.agendapsf.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.agendapsf.daos.ProcedimentoDAO;
import br.com.agendapsf.models.Procedimento;

@Controller
public class ProcedimentoController {
	
	@Autowired
	private ProcedimentoDAO procedimentoDAO;
	
	@RequestMapping("formProced")
	public ModelAndView form(){
		List<Procedimento> procedimentos = procedimentoDAO.listar();		
		ModelAndView mv = new ModelAndView("formProced");
		mv.addObject("procedimentos", procedimentos);
		return mv;
		
	}
	
	@RequestMapping("procedimentos")
	public String gravar(Procedimento procedimento){
		procedimentoDAO.gravar(procedimento);		
		return "ok";
	}
	
	@RequestMapping("procedimentosdeletar")
	public String deletar(Procedimento procedimento){
		System.out.println("deletando.....");
		System.out.println(procedimento.getId());
		procedimentoDAO.deletar(procedimento);	
		
		return "deletado";
	}
	
}
