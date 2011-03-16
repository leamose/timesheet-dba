package br.com.dba.timesheet.pojo;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author F�bio Oliveira de Pinho
 * @version 1.0
 */


public class FuncionalidadeClientePK implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="codigoFuncionario")
	private Funcionario funcionario;			
	
    @ManyToOne
    @JoinColumn(name="codigoCliente")    
    private Cliente cliente;

    /**
     * @return the codigoFuncionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param codigoFuncionario the codigoFuncionario to set
     */
    public void setFuncionario(Funcionario codigoFuncionario) {
        this.funcionario = codigoFuncionario;
    }

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
	
	
	
}