package br.com.dba.timesheet.web.form;

import java.sql.Date;

import org.apache.struts.validator.ValidatorForm;

public class UsuarioForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer funcionario_id;
	
	private String login;
	
	private String senha;
	
	private Boolean bloqueado;
	
	private Date ultimo_login;
	
	private Boolean alterar_senha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFuncionario_id() {
		return funcionario_id;
	}

	public void setFuncionario_id(Integer funcionario_id) {
		this.funcionario_id = funcionario_id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Date getUltimo_login() {
		return ultimo_login;
	}

	public void setUltimo_login(Date ultimo_login) {
		this.ultimo_login = ultimo_login;
	}

	public Boolean getAlterar_senha() {
		return alterar_senha;
	}

	public void setAlterar_senha(Boolean alterar_senha) {
		this.alterar_senha = alterar_senha;
	}
	
}
