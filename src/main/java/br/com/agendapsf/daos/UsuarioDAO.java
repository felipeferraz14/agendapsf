package br.com.agendapsf.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.agendapsf.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Usuario usuario) {
		
		manager.persist(usuario);
		
	}
	
	public List<String> listarCelular(){
		List<String> resultList =  manager.createNativeQuery("select p.celular from Usuario p").getResultList();
		return resultList;
	}
	
	public List<Usuario> listarUsuarios(){
		List<Usuario> resultList =  manager.createQuery("select p from Usuario p", Usuario.class).getResultList();
		return resultList;
	}

	public void deletar(Usuario usuario) {
		manager.createQuery("Delete from Usuario p where id =" + usuario.getId()).executeUpdate();
	}

	public boolean comparar(Usuario usuario) {
		
		List<Usuario> result = manager.createQuery("select p from Usuario p ", Usuario.class).getResultList();
		
		for (Usuario usuario2 : result)
			if(usuario2.getCartSUS().equals(usuario.getCartSUS())){
				return  true;
				}
			 	return false;			
	}

	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		manager.merge(usuario);
		
	}


}
