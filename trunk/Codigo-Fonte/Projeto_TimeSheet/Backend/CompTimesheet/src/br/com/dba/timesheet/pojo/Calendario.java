package br.com.dba.timesheet.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="calendario", schema="TS")
public class Calendario implements POJO<Integer> {
    
    @Id
    @Column(name="codigoCalendario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @Column(name="data")
	private Date data;			
	
	@Column(name="cargaHoraria")
	private Integer cargaHoraria;
	
	@Column(name="horaInicio")
	private Integer horaInicio;
	
	@Column(name="hora_fim")
	private Integer hora_fim;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data_calendario) {
		this.data = data_calendario;
	}
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer carga_horaria) {
		this.cargaHoraria = carga_horaria;
	}
	public Integer getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Integer hora_inicio) {
		this.horaInicio = hora_inicio;
	}
	public Integer getHora_fim() {
		return hora_fim;
	}
	public void setHora_fim(Integer hora_fim) {
		this.hora_fim = hora_fim;
	}	
	
}