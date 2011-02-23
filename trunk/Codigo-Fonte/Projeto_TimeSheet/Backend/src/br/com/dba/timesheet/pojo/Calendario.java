package br.com.dba.timesheet.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */

@Entity
@Table(name="calendario", schema="DBA")
public class Calendario implements POJO<Integer> {
    
    @Id
    @Column(name="id")
	private Integer id;
    
    @Column(name="data_calendario")
    @Temporal(TemporalType.DATE)
	private Date data_calendario;			
	
	@Column(name="carga_horaria")
	private Integer carga_horaria;
	
	@Column(name="hora_inicio")
	private Integer hora_inicio;
	
	@Column(name="hora_fim")
	private Integer hora_fim;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData_calendario() {
		return data_calendario;
	}
	public void setData_calendario(Date data_calendario) {
		this.data_calendario = data_calendario;
	}
	public Integer getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(Integer carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	public Integer getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Integer hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Integer getHora_fim() {
		return hora_fim;
	}
	public void setHora_fim(Integer hora_fim) {
		this.hora_fim = hora_fim;
	}	
	
}