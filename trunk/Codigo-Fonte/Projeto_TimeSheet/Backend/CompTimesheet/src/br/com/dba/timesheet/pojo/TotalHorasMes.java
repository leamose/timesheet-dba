package br.com.dba.timesheet.pojo;

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
@Table(name="totalHorasMes", schema="TS")
public class TotalHorasMes implements POJO<String> {

	@Id
	@Column(name="anoMes")
	private String id;
	
	@Column(name="totalHorasMes", length = 6)
	private Integer totalHorasMes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getTotalHorasMes() {
		return totalHorasMes;
	}

	public void setTotalHorasMes(Integer totalHorasMes) {
		this.totalHorasMes = totalHorasMes;
	}

   
	
}
