package br.com.dba.timesheet.pojo;

import br.gov.mj.core.pojo.POJO;

public class Cliente implements POJO<Integer> {
	
	private Integer id;
	private String nome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
