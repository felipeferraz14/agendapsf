package br.com.agendapsf.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.agendapsf.models.PostoSaude;

@Transactional
@Repository
public class PostoSaudeDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(PostoSaude postosaude){
		manager.persist(postosaude);
	}
	
	public List<PostoSaude> listar(){
		return manager.createQuery("select p from PostoSaude p", PostoSaude.class).getResultList();
	}

	public void deletar(PostoSaude postosaude) {

		manager.createQuery("Delete from PostoSaude p where p.id = " + postosaude.getId()).executeUpdate();
	}

}
