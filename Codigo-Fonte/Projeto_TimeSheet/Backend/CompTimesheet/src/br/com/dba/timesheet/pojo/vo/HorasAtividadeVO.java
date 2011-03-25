package br.com.dba.timesheet.pojo.vo;

import java.io.Serializable;
import java.util.Date;

public class HorasAtividadeVO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String cargaHoraria;
    private Integer ano;
    private Integer mes;
    private Integer dia;        
    private String horasTrabalhadas;
    private Boolean indicaSaldoDevedor = false;
	
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public Boolean getIndicaSaldoDevedor() {
		return indicaSaldoDevedor;
	}
	public void setIndicaSaldoDevedor(Boolean indicaSaldoDevedor) {
		this.indicaSaldoDevedor = indicaSaldoDevedor;
	}
    

    
    
    
    
}
