package br.com.dba.timesheet.pojo;

import java.io.Serializable;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author F�bio Oliveira de Pinho
 * @version 1.0
 */
public interface POJO <Id extends Serializable> {

	void setId(Id id);
	
}
