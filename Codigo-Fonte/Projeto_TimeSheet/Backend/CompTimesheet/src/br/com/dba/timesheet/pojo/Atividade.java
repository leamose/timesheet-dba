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
@Table(name="atividade", schema="TS")
public class Atividade implements POJO<Integer> {

    @Id
    @Column(name="codigoAtividade", nullable=false)   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @Column(name="descricao")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name="codigoTipoAtividade", nullable=false)    
	private TipoAtividade tipoAtividade;
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}
	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }	

}