package br.com.dba.timesheet.web.form;

import org.apache.struts.validator.ValidatorForm;

import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.TotalHorasMes;
import br.com.dba.timesheet.pojo.Usuario;

public class ConfigurarForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
    private Integer codigoConfiguracao;
    private Integer codigoUsuario;
    private Integer mininoAlmoco;
    private TotalHorasMes totalHorasMes;
    private String mesLiteral;
    private Sessao sessao;
    private String[] totalHoras;    
    private String ano;     
    private Usuario usuario;
    private String horaTrabalhoInicio;
    private String horaTrabalhoFim;
    private String horaAlmocoInicio;
    private String horaAlmocoFim;

	public Integer getCodigoConfiguracao() {
		return codigoConfiguracao;
	}

	public void setCodigoConfiguracao(Integer codigoConfiguracao) {
		this.codigoConfiguracao = codigoConfiguracao;
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

	public String getMesLiteral() {
		return mesLiteral;
	}

	public void setMesLiteral(String mesLiteral) {
		this.mesLiteral = mesLiteral;
	}

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getHoraTrabalhoInicio() {
		return horaTrabalhoInicio;
	}

	public void setHoraTrabalhoInicio(String horaTrabalhoInicio) {
		this.horaTrabalhoInicio = horaTrabalhoInicio;
	}

	public String getHoraTrabalhoFim() {
		return horaTrabalhoFim;
	}

	public void setHoraTrabalhoFim(String horaTrabalhoFim) {
		this.horaTrabalhoFim = horaTrabalhoFim;
	}

	public String getHoraAlmocoInicio() {
		return horaAlmocoInicio;
	}

	public void setHoraAlmocoInicio(String horaAlmocoInicio) {
		this.horaAlmocoInicio = horaAlmocoInicio;
	}

	public String getHoraAlmocoFim() {
		return horaAlmocoFim;
	}

	public void setHoraAlmocoFim(String horaAlmocoFim) {
		this.horaAlmocoFim = horaAlmocoFim;
	}
	
}
