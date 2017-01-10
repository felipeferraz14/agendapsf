package br.com.agendapsf.daos;

import java.util.List;

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

	public List<Agenda> listar() {
		
		List<Agenda> list = manager.createQuery("Select p from Agenda p", Agenda.class).getResultList();
		
		return list;
	}

	public void deletar(Agenda agenda) {
		manager.createQuery("Delete from Agenda p where id = " + agenda.getId()).executeUpdate();
	}


}
