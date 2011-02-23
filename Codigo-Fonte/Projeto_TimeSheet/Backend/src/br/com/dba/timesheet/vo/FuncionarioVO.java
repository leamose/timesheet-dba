package br.com.dba.timesheet.vo;

import java.io.Serializable;

import br.com.dba.timesheet.pojo.Funcionario;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author F�bio Oliveira de Pinho
 * @version 1.0
 */
public class FuncionarioVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private FuncionarioVO substituto;
	private FuncionarioVO chefe_id;
	private String nome;
	private String cargo;
	private Boolean chefe;
	private Boolean ferias;
	private Integer hora_trabalho_inicio;
	private Integer hora_trabalho_fim;
	private Integer hora_almoco_inicio;
	private Integer hora_almoco_fim;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public FuncionarioVO getSubstituto() {
        return substituto;
    }
    public void setSubstituto(FuncionarioVO substituto) {
        this.substituto = substituto;
    }
    public FuncionarioVO getChefe_id() {
        return chefe_id;
    }
    public void setChefe_id(FuncionarioVO chefe_id) {
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
