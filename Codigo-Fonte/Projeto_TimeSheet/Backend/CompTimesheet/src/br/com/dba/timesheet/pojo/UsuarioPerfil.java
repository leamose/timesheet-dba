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
@Table(name="usuarioPerfil", schema="TS")
public class UsuarioPerfil extends UsuarioPerfilPK implements POJO<UsuarioPerfilPK>{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
	private UsuarioPerfilPK id;

    /**
     * @return the id
     */
    public UsuarioPerfilPK getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UsuarioPerfilPK id) {
        this.id = id;
    }
    	
}