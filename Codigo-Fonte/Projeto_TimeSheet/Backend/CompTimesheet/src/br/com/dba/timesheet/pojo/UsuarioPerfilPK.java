package br.com.dba.timesheet.pojo;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */


public class UsuarioPerfilPK implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="codigoUsuario")
	private Usuario usuario;			
	
    @ManyToOne
    @JoinColumn(name="codigoCliente")    
    private Cliente cliente;

   
    /**
     * @return the codigoCliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCliente(Cliente codigoCliente) {
        this.cliente = codigoCliente;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
	
	
	
}