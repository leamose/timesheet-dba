package br.com.dba.timesheet.pojo;

import br.gov.mj.core.pojo.POJO;

public class Produto_Servico implements POJO<Integer> {
	
	private Integer id;
	private Metodologia metodologia;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
