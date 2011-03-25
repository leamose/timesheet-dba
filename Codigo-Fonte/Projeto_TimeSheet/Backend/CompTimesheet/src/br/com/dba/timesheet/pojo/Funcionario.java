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
@Table(name="funcionario", schema="TS")
public class Funcionario implements POJO<Integer> {
	
    @Id
    @Column(name="codigoFuncionario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @Column(name="codigoFuncionarioSubstituto", nullable=false)
	private Integer funcionarioSubstituto;
	
    @Column(name="codigoFuncionarioChefe", nullable=false)
	private Integer codigoFuncionarioChefe;
	
    @Column(name="nome")
	private String nome;
	
    @Column(name="cargo")
	private String cargo;
	
    @Column(name="indicaChefe")
	private Boolean indicaChefe;
	
    @Column(name="indicaFerias")
	private Boolean indicaFerias;
	
    @Column(name="horaTrabalhoInicio")
	private Integer horaTrabalhoInicio;
	
    @Column(name="horaTrabalhoFim")
	private Integer horaTrabalhoFim;
	
    @Column(name="horaAlmocoInicio")
	private Integer horaAlmocoInicio;
	
    @Column(name="horaAlmocoFim")
	private Integer horaAlmocoFim;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFuncionarioSubstituto() {
		return funcionarioSubstituto;
	}
	public void setFuncionarioSubstituto(Integer substituto) {
		this.funcionarioSubstituto = substituto;
	}
	public Integer getCodigoFuncionarioChefe() {
		return codigoFuncionarioChefe;
	}
	public void setCodigoFuncionarioChefe(Integer chefe_id) {
		this.codigoFuncionarioChefe = chefe_id;
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
	public Boolean getIndicaChefe() {
		return indicaChefe;
	}
	public void setIndicaChefe(Boolean chefe) {
		this.indicaChefe = chefe;
	}
	public Boolean getIndicaFerias() {
		return indicaFerias;
	}
	public void setIndicaFerias(Boolean ferias) {
		this.indicaFerias = ferias;
	}
	public Integer getHoraTrabalhoInicio() {
		return horaTrabalhoInicio;
	}
	public void setHoraTrabalhoInicio(Integer hora_trabalho_inicio) {
		this.horaTrabalhoInicio = hora_trabalho_inicio;
	}
	public Integer getHoraTrabalhoFim() {
		return horaTrabalhoFim;
	}
	public void setHoraTrabalhoFim(Integer hora_trabalho_fim) {
		this.horaTrabalhoFim = hora_trabalho_fim;
	}
	public Integer getHoraAlmocoInicio() {
		return horaAlmocoInicio;
	}
	public void setHoraAlmocoInicio(Integer hora_almoco_inicio) {
		this.horaAlmocoInicio = hora_almoco_inicio;
	}
	public Integer getHoraAlmocoFim() {
		return horaAlmocoFim;
	}
	public void setHoraAlmocoFim(Integer hora_almoco_fim) {
		this.horaAlmocoFim = hora_almoco_fim;
	}

}
