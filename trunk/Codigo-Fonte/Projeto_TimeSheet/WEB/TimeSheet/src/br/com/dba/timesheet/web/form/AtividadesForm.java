package br.com.dba.timesheet.web.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import br.com.dba.timesheet.dominios.Dominio;
import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.ProdutoServico;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.SituacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.pojo.vo.HorasAtividadeVO;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;


public class AtividadesForm extends ValidatorForm{
	
	private static final long serialVersionUID = 1L;
		
	
	private Integer id;
	private String acao; 
	private Boolean desabilitarCampo;
	private Integer codigoAtividade;
	private Integer codigoCliente;
	private Integer codigoOp;
	private Integer codigoMetodologia;
	private Integer codigoProdutoServico;		
	private Integer codigoTimeSheet;		
	private Integer codigoFuncionario;		
	private Integer codigoFuncionarioLogado;		
	private Integer codigoUsuario;
	private Integer codigoFuncionarioSubordinado;
	private Integer codigoSituacaoAtividade;	
	private Integer tamanhoListaHoras;	
	private Integer codigoHistoricoTimeSheet;
	
	private Sessao sessao;

    private String dataHoraInicio;	
	private String dataHoraFim;		
	private String observacao;	
	
	private String data;
	private String dataParaPesquisa;
	private String diaAtividade;
    private String inicioPrevisto;
    private String terminoPrevisto;
    private String horasDiarias;
    private String saldoDiario;
    private String descricaoOp;
    private String descricaoMetodologia;
    private String numeroProjeto;
    private String nomeProjeto;
    private String descricaoAtividade;    
    private String descricaoProjeto;
    private String anoConsulta;
    private String mesConsulta;
    
    //Descricao do Mes : Exemplo (Março, Abril....)
    private String mesLiteral;
    private String outros;    	
    private String observacaoChefia;	
	private String observacaoPrivada;
    
	private Boolean alteracao_data_avaliacao;	
    private Boolean indicaChefe;
    private Boolean indicaSaldoDevedor;
    
    //indica se o funcionario sera avaliado, no caso de ser a mesma pessoa, ela nao pode se auto-avaliar
    private Boolean indicaAvaliacao;
    
    //Listas
    private List<Dominio> listaDiasDaSemana = new ArrayList<Dominio>();
    private List<TimeSheet> listaTimeSheet = new ArrayList<TimeSheet>();
    private List<TimeSheetVO> listaTimeSheetVO = new ArrayList<TimeSheetVO>();
    private List<HistoricoTimeSheet> listaHistoricoTimeSheet = new ArrayList<HistoricoTimeSheet>();
    private List<Atividade> listaAtividades = new ArrayList<Atividade>();
    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private List<Metodologia> listaMetodologias = new ArrayList<Metodologia>();
    private List<OP> listaOPs = new ArrayList<OP>();
    private List<ProdutoServico> listaProdutosServicos = new ArrayList<ProdutoServico>();
    private List<Funcionario> listaFuncionariosSubordinados = new ArrayList<Funcionario>();
    private List<HorasAtividadeVO> listaHorasAtividadeVOs = new ArrayList<HorasAtividadeVO>();
    private List<SituacaoAtividade> listaSituacaoAtividade = new ArrayList<SituacaoAtividade>();
    
    //POJO's
    private TimeSheet timeSheet;
    private SituacaoAtividade situacaoAtividade;
    private Atividade atividades;
    private Cliente clientes;
    private Metodologia metodologias;
    private OP oPs;
    private ProdutoServico produtosServicos;
    private HistoricoTimeSheet historicoTimeSheet;
    private Usuario usuario;
    private Funcionario subordinado;
    private Funcionario funcionario;
    private Projeto projeto;
    
    public void limparFormulario(){
        setAlteracao_data_avaliacao(false);
        setAtividades(null);
        setDesabilitarCampo(false);
        setClientes(null);
        setCodigoAtividade(null);
        setCodigoMetodologia(null);
        setCodigoOp(null);
        setCodigoProdutoServico(null);      
        setCodigoTimeSheet(null);
        setData("");
        setDataHoraFim("");
        setDataHoraInicio("");
        setDescricaoAtividade("");
        setDescricaoMetodologia("");
        setDescricaoOp("");
        setDescricaoMetodologia("");
        setDiaAtividade("");
        setFuncionario(null); 
        setHistoricoTimeSheet(null);
        setHorasDiarias("");      
        setInicioPrevisto("");
        setNomeProjeto("");
        setNumeroProjeto("");
        setCodigoCliente(null);
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public Boolean getDesabilitarCampo() {
		return desabilitarCampo;
	}
	public void setDesabilitarCampo(Boolean desabilitarCampo) {
		this.desabilitarCampo = desabilitarCampo;
	}
	public Integer getCodigoAtividade() {
		return codigoAtividade;
	}
	public void setCodigoAtividade(Integer codigoAtividade) {
		this.codigoAtividade = codigoAtividade;
	}
	public Integer getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public Integer getCodigoOp() {
		return codigoOp;
	}
	public void setCodigoOp(Integer codigoOp) {
		this.codigoOp = codigoOp;
	}
	public Integer getCodigoMetodologia() {
		return codigoMetodologia;
	}
	public void setCodigoMetodologia(Integer codigoMetodologia) {
		this.codigoMetodologia = codigoMetodologia;
	}
	public Integer getCodigoProdutoServico() {
		return codigoProdutoServico;
	}
	public void setCodigoProdutoServico(Integer codigoProdutoServico) {
		this.codigoProdutoServico = codigoProdutoServico;
	}
	public Integer getCodigoTimeSheet() {
		return codigoTimeSheet;
	}
	public void setCodigoTimeSheet(Integer codigoTimeSheet) {
		this.codigoTimeSheet = codigoTimeSheet;
	}
	public Integer getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(Integer codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	public Integer getCodigoFuncionarioLogado() {
		return codigoFuncionarioLogado;
	}
	public void setCodigoFuncionarioLogado(Integer codigoFuncionarioLogado) {
		this.codigoFuncionarioLogado = codigoFuncionarioLogado;
	}
	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(Integer codigoUsuarioLogado) {
		this.codigoUsuario = codigoUsuarioLogado;
	}
	public Integer getCodigoFuncionarioSubordinado() {
		return codigoFuncionarioSubordinado;
	}
	public void setCodigoFuncionarioSubordinado(Integer codigoFuncionarioSubordinado) {
		this.codigoFuncionarioSubordinado = codigoFuncionarioSubordinado;
	}
	public Integer getCodigoSituacaoAtividade() {
		return codigoSituacaoAtividade;
	}
	public void setCodigoSituacaoAtividade(Integer codigoSituacaoAtividade) {
		this.codigoSituacaoAtividade = codigoSituacaoAtividade;
	}
	public String getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(String dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public String getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(String dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Boolean getAlteracao_data_avaliacao() {
		return alteracao_data_avaliacao;
	}
	public void setAlteracao_data_avaliacao(Boolean alteracaoDataAvaliacao) {
		alteracao_data_avaliacao = alteracaoDataAvaliacao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDataParaPesquisa() {
		return dataParaPesquisa;
	}
	public void setDataParaPesquisa(String dataParaPesquisa) {
		this.dataParaPesquisa = dataParaPesquisa;
	}
	public String getDiaAtividade() {
		return diaAtividade;
	}
	public void setDiaAtividade(String diaAtividade) {
		this.diaAtividade = diaAtividade;
	}
	public String getInicioPrevisto() {
		return inicioPrevisto;
	}
	public void setInicioPrevisto(String inicioPrevisto) {
		this.inicioPrevisto = inicioPrevisto;
	}
	public String getTerminoPrevisto() {
		return terminoPrevisto;
	}
	public void setTerminoPrevisto(String terminoPrevisto) {
		this.terminoPrevisto = terminoPrevisto;
	}
	public String getHorasDiarias() {
		return horasDiarias;
	}
	public void setHorasDiarias(String horasDiarias) {
		this.horasDiarias = horasDiarias;
	}
	public String getSaldoDiario() {
		return saldoDiario;
	}
	public void setSaldoDiario(String saldoDiario) {
		this.saldoDiario = saldoDiario;
	}
	public String getDescricaoOp() {
		return descricaoOp;
	}
	public void setDescricaoOp(String descricaoOp) {
		this.descricaoOp = descricaoOp;
	}
	public String getDescricaoMetodologia() {
		return descricaoMetodologia;
	}
	public void setDescricaoMetodologia(String descricaoMetodologia) {
		this.descricaoMetodologia = descricaoMetodologia;
	}
	public String getNumeroProjeto() {
		return numeroProjeto;
	}
	public void setNumeroProjeto(String numeroProjeto) {
		this.numeroProjeto = numeroProjeto;
	}
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}
	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}
	public String getDescricaoProjeto() {
		return descricaoProjeto;
	}
	public void setDescricaoProjeto(String descricaoProjeto) {
		this.descricaoProjeto = descricaoProjeto;
	}
	public String getMesLiteral() {
		return mesLiteral;
	}
	public void setMesLiteral(String mesLiteral) {
		this.mesLiteral = mesLiteral;
	}
	public String getOutros() {
		return outros;
	}
	public void setOutros(String outros) {
		this.outros = outros;
	}
	public String getObservacaoChefia() {
		return observacaoChefia;
	}
	public void setObservacaoChefia(String observacaoChefia) {
		this.observacaoChefia = observacaoChefia;
	}
	public String getObservacaoPrivada() {
		return observacaoPrivada;
	}
	public void setObservacaoPrivada(String observacaoPrivada) {
		this.observacaoPrivada = observacaoPrivada;
	}
	public Boolean getIndicaChefe() {
		return indicaChefe;
	}
	public void setIndicaChefe(Boolean indicaChefe) {
		this.indicaChefe = indicaChefe;
	}
	public List<Dominio> getListaDiasDaSemana() {
		return listaDiasDaSemana;
	}
	public void setListaDiasDaSemana(List<Dominio> listaDiasDaSemana) {
		this.listaDiasDaSemana = listaDiasDaSemana;
	}
	public List<TimeSheet> getListaTimeSheet() {
		return listaTimeSheet;
	}
	public void setListaTimeSheet(List<TimeSheet> listaTimeSheet) {
		this.listaTimeSheet = listaTimeSheet;
	}
	public List<TimeSheetVO> getListaTimeSheetVO() {
		return listaTimeSheetVO;
	}
	public void setListaTimeSheetVO(List<TimeSheetVO> listaTimeSheetVO) {
		this.listaTimeSheetVO = listaTimeSheetVO;
	}
	public List<HistoricoTimeSheet> getListaHistoricoTimeSheet() {
		return listaHistoricoTimeSheet;
	}
	public void setListaHistoricoTimeSheet(
			List<HistoricoTimeSheet> listaHistoricoTimeSheet) {
		this.listaHistoricoTimeSheet = listaHistoricoTimeSheet;
	}
	public List<Atividade> getListaAtividades() {
		return listaAtividades;
	}
	public void setListaAtividades(List<Atividade> listaAtividades) {
		this.listaAtividades = listaAtividades;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public List<Metodologia> getListaMetodologias() {
		return listaMetodologias;
	}
	public void setListaMetodologias(List<Metodologia> listaMetodologias) {
		this.listaMetodologias = listaMetodologias;
	}
	public List<OP> getListaOPs() {
		return listaOPs;
	}
	public void setListaOPs(List<OP> listaOPs) {
		this.listaOPs = listaOPs;
	}
	public List<ProdutoServico> getListaProdutosServicos() {
		return listaProdutosServicos;
	}
	public void setListaProdutosServicos(List<ProdutoServico> listaProdutosServicos) {
		this.listaProdutosServicos = listaProdutosServicos;
	}
	public List<Funcionario> getListaFuncionariosSubordinados() {
		return listaFuncionariosSubordinados;
	}
	public void setListaFuncionariosSubordinados(
			List<Funcionario> listaFuncionariosSubordinados) {
		this.listaFuncionariosSubordinados = listaFuncionariosSubordinados;
	}
	public List<HorasAtividadeVO> getListaHorasAtividadeVOs() {
		return listaHorasAtividadeVOs;
	}
	public void setListaHorasAtividadeVOs(
			List<HorasAtividadeVO> listaHorasAtividadeVOs) {
		this.listaHorasAtividadeVOs = listaHorasAtividadeVOs;
	}
	public List<SituacaoAtividade> getListaSituacaoAtividade() {
		return listaSituacaoAtividade;
	}
	public void setListaSituacaoAtividade(
			List<SituacaoAtividade> listaSituacaoAtividade) {
		this.listaSituacaoAtividade = listaSituacaoAtividade;
	}
	public TimeSheet getTimeSheet() {
		return timeSheet;
	}
	public void setTimeSheet(TimeSheet timeSheet) {
		this.timeSheet = timeSheet;
	}
	public SituacaoAtividade getSituacaoAtividade() {
		return situacaoAtividade;
	}
	public void setSituacaoAtividade(SituacaoAtividade situacaoAtividade) {
		this.situacaoAtividade = situacaoAtividade;
	}
	public Atividade getAtividades() {
		return atividades;
	}
	public void setAtividades(Atividade atividades) {
		this.atividades = atividades;
	}
	public Cliente getClientes() {
		return clientes;
	}
	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}
	public Metodologia getMetodologias() {
		return metodologias;
	}
	public void setMetodologias(Metodologia metodologias) {
		this.metodologias = metodologias;
	}
	public OP getoPs() {
		return oPs;
	}
	public void setoPs(OP oPs) {
		this.oPs = oPs;
	}
	public ProdutoServico getProdutosServicos() {
		return produtosServicos;
	}
	public void setProdutosServicos(ProdutoServico produtosServicos) {
		this.produtosServicos = produtosServicos;
	}
	public HistoricoTimeSheet getHistoricoTimeSheet() {
		return historicoTimeSheet;
	}
	public void setHistoricoTimeSheet(HistoricoTimeSheet historicoTimeSheet) {
		this.historicoTimeSheet = historicoTimeSheet;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Funcionario getSubordinado() {
		return subordinado;
	}
	public void setSubordinado(Funcionario subordinado) {
		this.subordinado = subordinado;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Boolean getIndicaAvaliacao() {
		return indicaAvaliacao;
	}

	public void setIndicaAvaliacao(Boolean indicaAvaliacao) {
		this.indicaAvaliacao = indicaAvaliacao;
	}

	public String getAnoConsulta() {
		return anoConsulta;
	}

	public void setAnoConsulta(String anoConsulta) {
		this.anoConsulta = anoConsulta;
	}

	public String getMesConsulta() {
		return mesConsulta;
	}

	public void setMesConsulta(String mesConsulta) {
		this.mesConsulta = mesConsulta;
	}

	public Integer getTamanhoListaHoras() {
		return tamanhoListaHoras;
	}

	public void setTamanhoListaHoras(Integer tamanhoListaHoras) {
		this.tamanhoListaHoras = tamanhoListaHoras;
	}

	public Boolean getIndicaSaldoDevedor() {
		return indicaSaldoDevedor;
	}

	public void setIndicaSaldoDevedor(Boolean indicaSaldoDevedor) {
		this.indicaSaldoDevedor = indicaSaldoDevedor;
	}

	public Integer getCodigoHistoricoTimeSheet() {
		return codigoHistoricoTimeSheet;
	}

	public void setCodigoHistoricoTimeSheet(Integer codigoHistoricoTimeSheet) {
		this.codigoHistoricoTimeSheet = codigoHistoricoTimeSheet;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
}
