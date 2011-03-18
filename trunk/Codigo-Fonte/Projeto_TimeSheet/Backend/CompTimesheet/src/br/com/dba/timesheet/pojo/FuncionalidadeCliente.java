package br.com.dba.timesheet.pojo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name="funcionalidadeCliente", schema="TS")
public class FuncionalidadeCliente extends FuncionalidadeClientePK implements POJO<FuncionalidadeClientePK>{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
	private FuncionalidadeClientePK id;

    /**
     * @return the id
     */
    public FuncionalidadeClientePK getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(FuncionalidadeClientePK id) {
        this.id = id;
    }
    	
}