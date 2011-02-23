/*
 * Classname:			Dominio.java
 * Version:				$Revision: 1.0
 * Date:				11/07/2005
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.dominios;

import java.io.Serializable;
import java.text.Collator;
import java.util.Locale;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class Dominio implements Comparable, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
    private String descricao;
    
    public Dominio() {}
    
    public Dominio(String codigo) {
        this.codigo = codigo;
    }
    
    public Dominio(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @return Returns the codigo.
     */
    public String getCodigo() {
        return this.codigo;
    }
    /**
     * @param codigo The codigo to set.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * @return Returns the descricao.
     */
    public String getDescricao() {
        return this.descricao;
    }
    /**
     * @param descricao The descricao to set.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return this.descricao;
    }

    /**
     * @see java.lang.Comparable#compareTo(Object)
     */
    public int compareTo(Object object) {
        if (object instanceof Dominio ) {
            Dominio myClass = (Dominio) object;  
  //          return this.descricao.compareToIgnoreCase(myClass.descricao);
            return  Collator.getInstance(new Locale("pt-BR")).compare(this.descricao, myClass.descricao);
        } else {
            return 0;
        }
    }
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1440932429, -2015410703).appendSuper(
                super.hashCode()).append(this.codigo)
                .toHashCode();
    }    
    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Dominio)) {
            return false;
        }
        Dominio rhs = (Dominio) object;
        return this.codigo.equals(rhs.getCodigo());
    }
}
