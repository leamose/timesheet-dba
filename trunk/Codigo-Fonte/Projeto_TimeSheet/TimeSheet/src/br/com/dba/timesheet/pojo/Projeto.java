package br.com.dba.timesheet.pojo;

import br.gov.mj.core.pojo.POJO;

public class Projeto implements POJO<Integer> {

	private Integer id;
	private Metodologia metodologia;
	private Integer numero_projeto;
	private String descricao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Metodologia getMetodologia() {
		return metodologia;
	}
	public void setMetodologia(Metodologia metodologia) {
		this.metodologia = metodologia;
	}
	public Integer getNumero_projeto() {
		return numero_projeto;
	}
	public void setNumero_projeto(Integer numero_projeto) {
		this.numero_projeto = numero_projeto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}