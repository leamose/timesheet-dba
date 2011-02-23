package br.com.dba.timesheet.vo;

import java.io.Serializable;

import br.com.dba.timesheet.pojo.Cliente;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class OPVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private ClienteVO cliente_id;
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
    public ClienteVO getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(ClienteVO cliente_id) {
        this.cliente_id = cliente_id;
    }

}
