package br.com.agendapsf.models;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Agenda {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Procedimento procedimento;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Future
	private Date dataAtendimento;
	@OneToOne
	private Usuario usuario;
	
	

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataAtendimento() {
		return dataAtendimento;
	}
	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	
	
	

}
