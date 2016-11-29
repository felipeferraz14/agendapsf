package br.com.agendapsf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.agendapsf.daos.MedicoDAO;
import br.com.agendapsf.models.Medico;

@Controller
public class MedicoController {
	
	@Autowired
	private MedicoDAO medicodao;
	
	@RequestMapping("/formMedico")
	public String cadMedico(){
		
		return "formMedico";
	}
	
	@RequestMapping("/medico")
	public String gravar(Medico medico){
		medicodao.gravar(medico);
		return "ok";
	}
	

}
