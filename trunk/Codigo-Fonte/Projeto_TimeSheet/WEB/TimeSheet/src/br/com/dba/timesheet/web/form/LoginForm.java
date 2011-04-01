package br.com.dba.timesheet.web.form;

import org.apache.struts.validator.ValidatorForm;

import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.Usuario;

public class LoginForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private String login;	
	private String senha;
	private Boolean indicaAlterarSenha;
	private Boolean indicaBloqueado;
	private Boolean indicaAcessoRestrito;
	private Integer codigoUsuario;

	public Boolean getIndicaAcessoRestrito() {
		return indicaAcessoRestrito;
	}
	
	public void setIndicaAcessoRestrito(Boolean indicaAcessoRestrito) {
		this.indicaAcessoRestrito = indicaAcessoRestrito;
	}
	
	public void limparFormulario(){
		setLogin(null);
		setSenha(null);
	}
	
	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Boolean getIndicaAlterarSenha() {
		return indicaAlterarSenha;
	}

	public void setIndicaAlterarSenha(Boolean indicaAlterarSenha) {
		this.indicaAlterarSenha = indicaAlterarSenha;
	}

	public Boolean getIndicaBloqueado() {
		return indicaBloqueado;
	}

	public void setIndicaBloqueado(Boolean indicaBloqueado) {
		this.indicaBloqueado = indicaBloqueado;
	}

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
