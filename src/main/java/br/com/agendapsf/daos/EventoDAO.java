package br.com.agendapsf.daos;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.agendapsf.models.Evento;

@Repository
@Transactional
public class EventoDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public void gravar(Evento evento){
		manager.persist(evento);
	}
	
	public List<Evento> listar(){
		List<Evento> eventos = manager.createQuery("select p from Evento p", Evento.class).getResultList();
		return eventos;
	}

	public void deletar(Evento evento) {
		
		manager.createQuery("Delete from Evento p where p.id =" + evento.getId()).executeUpdate();
	}
}
