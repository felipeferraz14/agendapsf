package br.com.agendapsf.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
public class Usuario implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String nomeUsuario;
	@NotBlank
	private String cartSUS;
	private String enderecoUsuario;
	private String cidadeUsuario;
	private UF UF;
	private String senha;
	@OneToMany(fetch=FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();
	@OneToOne
	private PostoSaude postosaude;
	private String telefone;
	private String celular;
	
	
	public PostoSaude getPostosaude() {
		return postosaude;
	}
	public void setPostosaude(PostoSaude postosaude) {
		this.postosaude = postosaude;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCartSUS() {
		return cartSUS;
	}
	public void setCartSUS(String cartSUS) {
		this.cartSUS = cartSUS;
	}
	public UF getUF() {
		return UF;
	}
	public void setUF(UF uF) {
		UF = uF;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}
	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}
	public String getCidadeUsuario() {
		return cidadeUsuario;
	}
	public void setCidadeUsuario(String cidadeUsuario) {
		this.cidadeUsuario = cidadeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}
	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		return this.cartSUS;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	

	
	

}
