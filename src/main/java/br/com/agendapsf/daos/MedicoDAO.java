package br.com.agendapsf.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.agendapsf.models.Medico;

@Repository
@Transactional
public class MedicoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Medico medico){
		
		manager.persist(medico);
		
	}
	
	public List<Medico> listar(){
		return manager.createQuery("select p from Medico p", Medico.class).getResultList();
	}

}
