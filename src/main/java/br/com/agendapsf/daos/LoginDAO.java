package br.com.agendapsf.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.agendapsf.models.Usuario;

@Repository
public class LoginDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;
		
	public UserDetails loadUserByUsername(String cartSUS){
		Usuario usuario = manager.createQuery("select p from Usuario p where p.cartSUS = :cartSUS", Usuario.class)
				.setParameter("cartSUS", cartSUS).getSingleResult();
		System.out.println("nullo");
		if(usuario == null){
			System.out.println("nullo");
			throw new UsernameNotFoundException("Cartão SUS: "+ cartSUS +" não foi encontrado");
		} else {
			return usuario;
		}
		
	}


}
