package br.com.dba.timesheet.web.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import br.com.dba.timesheet.vo.TipoAtividadeVO;

public class LoginForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	private String senha;
	
	private Integer tipoAtividade;
	
	private List<TipoAtividadeVO> listaAtividades;
	
	public Integer getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(Integer tipo_atividade_id) {
		this.tipoAtividade = tipo_atividade_id;
	}

	public List<TipoAtividadeVO> getListaAtividades() {
		return listaAtividades;
	}

	public void setListaAtividades(List<TipoAtividadeVO> listaAtividades) {
		this.listaAtividades = listaAtividades;
	}

	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
