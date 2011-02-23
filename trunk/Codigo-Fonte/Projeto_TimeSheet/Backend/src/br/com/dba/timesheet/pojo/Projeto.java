package br.com.dba.timesheet.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */

@Entity
@Table(name="projeto", schema="DBA")
public class Projeto implements POJO<Integer> {

    @Id
    @Column(name="id")
	private Integer id;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="metodologia", nullable=false)
	private Metodologia metodologia;
	
	@Column(name="numero_projeto")
	private Integer numero_projeto;
	
	@Column(name="descricao")
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
