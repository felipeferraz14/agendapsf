package br.com.agendapsf.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.agendapsf.models.Procedimento;

@Repository
@Transactional
public class ProcedimentoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Procedimento procedimento){
		
		manager.persist(procedimento);
	}
	
	public List<Procedimento> listar(){
		return manager.createQuery("select p from Procedimento p", Procedimento.class).getResultList();
	}
	
	public void deletar(Procedimento procedimento){
		System.out.println("Procedimento será deletado...");
		System.out.println(procedimento.getId());
		System.out.println(procedimento.getDescricao());
		manager.createQuery("delete from Procedimento p where id =" + procedimento.getId()).executeUpdate();
		 
	}

}
