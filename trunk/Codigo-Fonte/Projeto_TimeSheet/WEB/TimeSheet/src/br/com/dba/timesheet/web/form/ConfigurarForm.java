package br.com.dba.timesheet.web.form;

import org.apache.struts.validator.ValidatorForm;

import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.TotalHorasMes;
import br.com.dba.timesheet.pojo.Usuario;

public class ConfigurarForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
    private Integer codigoConfiguracao;
    private Integer hora_trabalho_inicio;
    private Integer hora_trabalho_fim;
    private Integer hora_almoco_inicio;
    private Integer hora_almoco_fim;
    private Integer mininoAlmoco;
    private TotalHorasMes totalHorasMes;
    
    private Sessao sessao;
    
    private String[] totalHoras;
    
    private String ano; 
    
    private Usuario usuario;

	public Integer getCodigoConfiguracao() {
		return codigoConfiguracao;
	}

	public void setCodigoConfiguracao(Integer codigoConfiguracao) {
		this.codigoConfiguracao = codigoConfiguracao;
	}

	public Integer getHora_trabalho_inicio() {
		return hora_trabalho_inicio;
	}

	public void setHora_trabalho_inicio(Integer horaTrabalhoInicio) {
		hora_trabalho_inicio = horaTrabalhoInicio;
	}

	public Integer getHora_trabalho_fim() {
		return hora_trabalho_fim;
	}

	public void setHora_trabalho_fim(Integer horaTrabalhoFim) {
		hora_trabalho_fim = horaTrabalhoFim;
	}

	public Integer getHora_almoco_inicio() {
		return hora_almoco_inicio;
	}

	public void setHora_almoco_inicio(Integer horaAlmocoInicio) {
		hora_almoco_inicio = horaAlmocoInicio;
	}

	public Integer getHora_almoco_fim() {
		return hora_almoco_fim;
	}

	public void setHora_almoco_fim(Integer horaAlmocoFim) {
		hora_almoco_fim = horaAlmocoFim;
	}

	public Integer getMininoAlmoco() {
		return mininoAlmoco;
	}

	public void setMininoAlmoco(Integer mininoAlmoco) {
		this.mininoAlmoco = mininoAlmoco;
	}

	public TotalHorasMes getTotalHorasMes() {
		return totalHorasMes;
	}

	public void setTotalHorasMes(TotalHorasMes totalHorasMes) {
		this.totalHorasMes = totalHorasMes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String[] getTotalHoras() {
		if (totalHoras == null) {
			totalHoras = new String[13];
		}
		return totalHoras;
	}

	public void setRespostaMarcada(String[] totalHoras) {
		this.totalHoras = totalHoras;
	}

	public void setTotalHoras(int posicao, String valor) {
		if (totalHoras == null) {
			totalHoras = new String[13];
		}
		this.totalHoras[posicao] = valor;
	}
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

}
