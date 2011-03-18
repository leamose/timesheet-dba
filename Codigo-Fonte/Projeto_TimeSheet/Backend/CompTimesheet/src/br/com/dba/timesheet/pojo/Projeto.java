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
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */

@Entity
@Table(name="projeto", schema="TS")
public class Projeto implements POJO<Integer> {

    @Id
    @Column(name="codigoProjeto") 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
    
    @ManyToOne
    @JoinColumn(name="codigoMetodologia", nullable=false)
	private Metodologia metodologia;
	
	@Column(name="numeroProjeto")
	private Integer numeroProjeto;
	
	@Column(name="nome", length = 100)
	private String nome;
	
	
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
	public Integer getNumeroProjeto() {
		return numeroProjeto;
	}
	public void setNumeroProjeto(Integer numero_projeto) {
		this.numeroProjeto = numero_projeto;
	}
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }	
}