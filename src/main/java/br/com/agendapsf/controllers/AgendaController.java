package br.com.agendapsf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.agendapsf.daos.AgendaDAO;
import br.com.agendapsf.daos.ProcedimentoDAO;
import br.com.agendapsf.models.Agenda;
import br.com.agendapsf.models.Procedimento;
import br.com.agendapsf.models.Usuario;
import br.com.agendapsf.sms.SMS;

@Controller
public class AgendaController {
	
	@Autowired
	private AgendaDAO agendaDAO;
	
	@Autowired
	private ProcedimentoDAO procedimentoDAO;
		
	SMS sms = new SMS();

	@RequestMapping("/formAgenda")
	public ModelAndView form(){
		
		List<Procedimento> procedimentos = procedimentoDAO.listar();
	
		ModelAndView mv = new ModelAndView("formAgenda");
		mv.addObject("procedimentos", procedimentos);
		return mv;
	}
	
	@RequestMapping("/cadagenda")
	public String gravar(Agenda agenda){
		String proced = "";
		
		List<Procedimento> listar = procedimentoDAO.listar();
		for(Procedimento procedimento : listar){
			if(agenda.getProcedimento().getId() == procedimento.getId()){
				proced = procedimento.getDescricao();
			}
			
		}
		Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		String name = "";
		String celular= "";
		if (usuarioLogado  instanceof UserDetails ) {
		   username= ( (UserDetails)usuarioLogado).getUsername();
		   name = ((Usuario)usuarioLogado).getNomeUsuario();
		   celular = ((Usuario)usuarioLogado).getCelular();		   
		} else {
		   username = usuarioLogado .toString();
		}
	
		
		String mensagem = name + "\n" 
		+ proced + " Agendado com sucesso!" + "\n" + "Sistema de Agendamento";
		String numero = celular;
		System.out.println(mensagem);
		System.out.println(numero);
		
		sms.enviar(mensagem, numero );
		agendaDAO.gravar(agenda);
		return "ok";
	
	}
	
	@RequestMapping("/listaAgendas")
	public ModelAndView listarAgendas(){
		List<Agenda> agendas = agendaDAO.listar();
		ModelAndView mv = new ModelAndView("listaAgendas");
		System.out.println(agendas.size());
		mv.addObject("agendas", agendas);
		return mv;
	}
	
	@RequestMapping("/deletarAgenda")
	public String deletarAgenda(Agenda agenda){
		System.out.println(agenda.getId());
		agendaDAO.deletar(agenda);
		return "deletado";
		
	}

	
	
}
