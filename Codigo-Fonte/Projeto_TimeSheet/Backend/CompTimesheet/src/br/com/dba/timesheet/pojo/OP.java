package br.com.dba.timesheet.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author F�bio Oliveira de Pinho
 * @version 1.0
 */

@Entity
@Table(name="op", schema="TS")
public class OP implements POJO<Integer> {
	
    @Id
    @Column(name="codigoOP")    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @ManyToOne
    @JoinColumn(name="codigoCliente", nullable=false)
    private Cliente cliente;
	
    @Column(name="descricao", length = 250)
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
