package br.com.agendapsf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostoSaude {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nomePsf;
	private String endPsf;
	private String cidadePsf;
	private UF UF;
	
	public PostoSaude() {
	}
	public PostoSaude(int i){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomePsf() {
		return nomePsf;
	}
	public void setNomePsf(String nomePsf) {
		this.nomePsf = nomePsf;
	}
	public String getEndPsf() {
		return endPsf;
	}
	public void setEndPsf(String endPsf) {
		this.endPsf = endPsf;
	}
	public String getCidadePsf() {
		return cidadePsf;
	}
	public void setCidadePsf(String cidadePsf) {
		this.cidadePsf = cidadePsf;
	}
	public UF getUF() {
		return UF;
	}
	public void setUF(UF uF) {
		UF = uF;
	}

	
	
}
