package br.com.agendapsf.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.agendapsf.models.Agenda;

@Repository
@Transactional
public class AgendaDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Agenda agenda){
		manager.persist(agenda);
		
	}


}
