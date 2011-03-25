package br.com.dba.timesheet.pojo;

import java.util.Date;

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
@Table(name="usuario", schema="TS")
public class Usuario implements POJO<Integer> {
	
    @Id
    @Column(name="codigoUsuario", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @ManyToOne
    @JoinColumn(name="codigoFuncionario")
	private Funcionario funcionario;
	
    @Column(name="login")
	private String login;
	
    @Column(name="senha")
	private String senha;
	
    @Column(name="indicaBloqueado")
	private Boolean indicaBloqueado;

    @Column(name="indicaAlterarSenha")
    private Boolean indicaAlterarSenha;
	
    @Column(name="dataUltimoLogin")
	private Date dataUltimoLogin;

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

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the indicaBloqueado
     */
    public Boolean getIndicaBloqueado() {
        return indicaBloqueado;
    }

    /**
     * @param indicaBloqueado the indicaBloqueado to set
     */
    public void setIndicaBloqueado(Boolean indicaBloqueado) {
        this.indicaBloqueado = indicaBloqueado;
    }

    /**
     * @return the indicaAlterarSenha
     */
    public Boolean getIndicaAlterarSenha() {
        return indicaAlterarSenha;
    }

    /**
     * @param indicaAlterarSenha the indicaAlterarSenha to set
     */
    public void setIndicaAlterarSenha(Boolean indicaAlterarSenha) {
        this.indicaAlterarSenha = indicaAlterarSenha;
    }

    /**
     * @return the dataUltimoLogin
     */
    public Date getDataUltimoLogin() {
        return dataUltimoLogin;
    }

    /**
     * @param dataUltimoLogin the dataUltimoLogin to set
     */
    public void setDataUltimoLogin(Date dataUltimoLogin) {
        this.dataUltimoLogin = dataUltimoLogin;
    }
	
	
}
