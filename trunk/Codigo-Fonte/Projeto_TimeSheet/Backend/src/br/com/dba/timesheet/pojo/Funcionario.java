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
@Table(name="funcionario", schema="DBA")
public class Funcionario implements POJO<Integer> {
	
    @Id
    @Column(name="id")
	private Integer id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="substituto_id", nullable=false)
	private Funcionario substituto;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="chefe_id", nullable=false)
	private Funcionario chefe_id;
	
    @Column(name="nome")
	private String nome;
	
    @Column(name="cargo")
	private String cargo;
	
    @Column(name="chefe")
	private Boolean chefe;
	
    @Column(name="ferias")
	private Boolean ferias;
	
    @Column(name="hora_trabalho_inicio")
	private Integer hora_trabalho_inicio;
	
    @Column(name="hora_trabalho_fim")
	private Integer hora_trabalho_fim;
	
    @Column(name="hora_almoco_inicio")
	private Integer hora_almoco_inicio;
	
    @Column(name="hora_almoco_fim")
	private Integer hora_almoco_fim;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Funcionario getSubstituto() {
		return substituto;
	}
	public void setSubstituto(Funcionario substituto) {
		this.substituto = substituto;
	}
	public Funcionario getChefe_id() {
		return chefe_id;
	}
	public void setChefe_id(Funcionario chefe_id) {
		this.chefe_id = chefe_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Boolean getChefe() {
		return chefe;
	}
	public void setChefe(Boolean chefe) {
		this.chefe = chefe;
	}
	public Boolean getFerias() {
		return ferias;
	}
	public void setFerias(Boolean ferias) {
		this.ferias = ferias;
	}
	public Integer getHora_trabalho_inicio() {
		return hora_trabalho_inicio;
	}
	public void setHora_trabalho_inicio(Integer hora_trabalho_inicio) {
		this.hora_trabalho_inicio = hora_trabalho_inicio;
	}
	public Integer getHora_trabalho_fim() {
		return hora_trabalho_fim;
	}
	public void setHora_trabalho_fim(Integer hora_trabalho_fim) {
		this.hora_trabalho_fim = hora_trabalho_fim;
	}
	public Integer getHora_almoco_inicio() {
		return hora_almoco_inicio;
	}
	public void setHora_almoco_inicio(Integer hora_almoco_inicio) {
		this.hora_almoco_inicio = hora_almoco_inicio;
	}
	public Integer getHora_almoco_fim() {
		return hora_almoco_fim;
	}
	public void setHora_almoco_fim(Integer hora_almoco_fim) {
		this.hora_almoco_fim = hora_almoco_fim;
	}

}
