package br.com.dba.timesheet.web.form;

import org.apache.struts.validator.ValidatorForm;

import br.com.dba.timesheet.pojo.Usuario;

public class LoginForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private String login;	
	private String senha;
	
	private Usuario usuario;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
