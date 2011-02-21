package br.com.dba.timesheet.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.mj.core.pojo.POJO;

@Entity
@Table(name="tipo_atividade", schema="DBA")
public class Tipo_Atividade implements POJO<Integer> {

	@Id
	@Column(name="id")	
	private Integer id;
	
	@Column(name="descricao")
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
