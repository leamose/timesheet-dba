package br.com.dba.timesheet.pojo;

import br.gov.mj.core.pojo.POJO;

public class OP implements POJO<Integer> {
	
	private Integer id;
	private Cliente cliente;
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente_id) {
		this.cliente = cliente_id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
