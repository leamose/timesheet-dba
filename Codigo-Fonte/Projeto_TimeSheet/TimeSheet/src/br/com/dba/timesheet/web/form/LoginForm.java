package br.com.dba.timesheet.web.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import br.com.dba.timesheet.vo.Tipo_AtividadeVO;

public class LoginForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	private String senha;
	
	public Integer getTipo_atividade_id() {
		return tipo_atividade_id;
	}

	public void setTipo_atividade_id(Integer tipo_atividade_id) {
		this.tipo_atividade_id = tipo_atividade_id;
	}

	public List<Tipo_AtividadeVO> getListaAtividades() {
		return listaAtividades;
	}

	public void setListaAtividades(List<Tipo_AtividadeVO> listaAtividades) {
		this.listaAtividades = listaAtividades;
	}

	private Integer tipo_atividade_id;
	
	private List<Tipo_AtividadeVO> listaAtividades;

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
