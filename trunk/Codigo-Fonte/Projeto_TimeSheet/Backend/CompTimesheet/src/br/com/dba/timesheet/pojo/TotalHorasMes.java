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
public class TotalHorasMes implements POJO<Integer> {

	@Id
	@Column(name="anoMes")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String anoMes;
	
	@Column(name="totalHorasMes", length = 250)
	private Integer id;

    /**
     * @return the anoMes
     */
    public String getAnoMes() {
        return anoMes;
    }

    /**
     * @param anoMes the anoMes to set
     */
    public void setAnoMes(String anoMes) {
        this.anoMes = anoMes;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }    
	
}
