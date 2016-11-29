package br.com.agendapsf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.agendapsf.daos.EventoDAO;
import br.com.agendapsf.daos.UsuarioDAO;
import br.com.agendapsf.models.Evento;
import br.com.agendapsf.sms.SMS;

@Controller
public class EventoController {
	
	@Autowired
	private EventoDAO eventodao;
	
	@Autowired
	private UsuarioDAO usuariodao;
	
	@RequestMapping("formEventos")
	public ModelAndView form(){
		List<Evento> eventos = eventodao.listar();
		ModelAndView mv = new ModelAndView("formEventos");
		mv.addObject("eventos", eventos);
		return mv;	
		
	}
	
	@RequestMapping(value="eventos", method = RequestMethod.POST)
	public String gravar(Evento evento){
		eventodao.gravar(evento);
		return "ok";
	}
	
	@RequestMapping(value="eventos", method = RequestMethod.GET)
	public ModelAndView listar(){
		List<Evento> eventos = eventodao.listar();
		ModelAndView mv = new ModelAndView("listaEventos");
		mv.addObject("eventos", eventos);
		return mv;		
	}
	
	
	@RequestMapping("enviarEventos")
	public String enviarEventos(){
		List<String> celulares = usuariodao.listarCelular();
		List<Evento> eventos = eventodao.listar();
		
		String mensagem;
		String numero;
		
		SMS sms = new SMS();
		
		for(String celular : celulares){
			
			mensagem = "Eventos: " + "\n" + eventos.toString() + "\n" + " Sistema de Agendamento";
			numero = celular;
			System.out.println(mensagem);
			System.out.println(numero);
			
			
			sms.enviar(mensagem, numero);
			
		}
				return "ok";
	}
	
	@RequestMapping("deletarevento")
	public String deletarEvento(Evento evento){
		
		eventodao.deletar(evento);
		
		return "deletado";
	}

}
