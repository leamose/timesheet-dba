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
@Table(name="configuracao", schema="TS")
public class Configuracao implements POJO<Integer> {
	
    @Id
    @Column(name="codigoConfiguracao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Column(name="horaInicio")
    private Integer horaInicio;
    
    @Column(name="horaFim")
    private Integer horaFim;

    @Column(name="horaAlmocoInicio")
    private Integer horaAlmocoInicio;
    
    @Column(name="horaAlmocoFim")
    private Integer horaAlmocoFim;

    @Column(name="minimoAlmoco")
    private Integer minimoAlmoco;

    @ManyToOne
    @JoinColumn(name="anoMes")  
    private TotalHorasMes totalHorasMes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Integer horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Integer getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Integer horaFim) {
		this.horaFim = horaFim;
	}

	public Integer getHoraAlmocoInicio() {
		return horaAlmocoInicio;
	}

	public void setHoraAlmocoInicio(Integer horaAlmocoInicio) {
		this.horaAlmocoInicio = horaAlmocoInicio;
	}

	public Integer getHoraAlmocoFim() {
		return horaAlmocoFim;
	}

	public void setHoraAlmocoFim(Integer horaAlmocoFim) {
		this.horaAlmocoFim = horaAlmocoFim;
	}

	public Integer getMinimoAlmoco() {
		return minimoAlmoco;
	}

	public void setMinimoAlmoco(Integer minimoAlmoco) {
		this.minimoAlmoco = minimoAlmoco;
	}

	public TotalHorasMes getTotalHorasMes() {
		return totalHorasMes;
	}

	public void setTotalHorasMes(TotalHorasMes totalHorasMes) {
		this.totalHorasMes = totalHorasMes;
	}
    
}
