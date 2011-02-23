package br.com.dba.timesheet.vo;

import java.io.Serializable;

import br.com.dba.timesheet.pojo.Metodologia;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class ProjetoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private MetodologiaVO metodologia;
	private Integer numero_projeto;
	private String descricao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
    public MetodologiaVO getMetodologia() {
        return metodologia;
    }
    public void setMetodologia(MetodologiaVO metodologia) {
        this.metodologia = metodologia;
    }
}
