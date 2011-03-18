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
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;

public class AtividadesForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String acao; 
	private Boolean desabilitarCampo;
	private String codigoAtividade;
	private String codigoCliente;
	private String codigoOp;
	private String codigoMetodologia;
	private String codigoProdutoServico;		
	private String codigoTimeSheet;		

    private String dataHoraInicio;	
	private String dataHoraFim;		
	private String observacao;	
	private Boolean alteracao_data_avaliacao;	
	
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
    private String outros;    	

    //Listas
    private List<Dominio> listaDiasDaSemana;
    private List<TimeSheet> listaTimeSheet = new ArrayList<TimeSheet>();
    private List<TimeSheetVO> listaTimeSheetVO = new ArrayList<TimeSheetVO>();
    private List<HistoricoTimeSheet> listaHistoricoTimeSheet = new ArrayList<HistoricoTimeSheet>();
    private List<Atividade> listaAtividades = new ArrayList<Atividade>();
    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private List<Metodologia> listaMetodologias = new ArrayList<Metodologia>();
    private List<OP> listaOPs = new ArrayList<OP>();
    private List<ProdutoServico> listaProdutosServicos = new ArrayList<ProdutoServico>();

    
    //POJO's
    private TimeSheet timeSheet;
    private Atividade atividades;
    private Cliente clientes;
    private Metodologia metodologias;
    private OP oPs;
    private ProdutoServico produtosServicos;
    private HistoricoTimeSheet historicoTimeSheet;
    private Usuario usuario;
    private Funcionario funcionario;
    private Projeto projeto;
    
    /**
     * @return the codigoProdutoServico
     */
    public String getCodigoProdutoServico() {
        return codigoProdutoServico;
    }

    /**
     * @param codigoProdutoServico the codigoProdutoServico to set
     */
    public void setCodigoProdutoServico(String codigoProdutoServico) {
        this.codigoProdutoServico = codigoProdutoServico;
    }

    /**
     * @return the listaProdutosServicos
     */
    public List<ProdutoServico> getListaProdutosServicos() {
        return listaProdutosServicos;
    }

    /**
     * @param listaProdutosServicos the listaProdutosServicos to set
     */
    public void setListaProdutosServicos(
            List<ProdutoServico> listaProdutosServicos) {
        this.listaProdutosServicos = listaProdutosServicos;
    }
    
	
	public List<Atividade> getListaAtividades() {
		return listaAtividades;
	}

	public void setListaAtividades(List<Atividade> listaAtividades) {
		this.listaAtividades = listaAtividades;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigoAtividade() {
		return codigoAtividade;
	}
	public void setCodigoAtividade(String atividade) {
		this.codigoAtividade = atividade;
	}	
	public String getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(String data_hora_inicio) {
		this.dataHoraInicio = data_hora_inicio;
	}
	public String getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(String data_hora_fim) {
		this.dataHoraFim = data_hora_fim;
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
	public void setAlteracao_data_avaliacao(Boolean alteracao_data_avaliacao) {
		this.alteracao_data_avaliacao = alteracao_data_avaliacao;
	}

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the inicioPrevisto
     */
    public String getInicioPrevisto() {
        return inicioPrevisto;
    }

    /**
     * @param inicioPrevisto the inicioPrevisto to set
     */
    public void setInicioPrevisto(String inicioPrevisto) {
        this.inicioPrevisto = inicioPrevisto;
    }

    /**
     * @return the terminoPrevisto
     */
    public String getTerminoPrevisto() {
        return terminoPrevisto;
    }

    /**
     * @param terminoPrevisto the terminoPrevisto to set
     */
    public void setTerminoPrevisto(String terminoPrevisto) {
        this.terminoPrevisto = terminoPrevisto;
    }

    /**
     * @return the horasDiarias
     */
    public String getHorasDiarias() {
        return horasDiarias;
    }

    /**
     * @param horasDiarias the horasDiarias to set
     */
    public void setHorasDiarias(String horasDiarias) {
        this.horasDiarias = horasDiarias;
    }

    /**
     * @return the saldoDiario
     */
    public String getSaldoDiario() {
        return saldoDiario;
    }

    /**
     * @param saldoDiario the saldoDiario to set
     */
    public void setSaldoDiario(String saldoDiario) {
        this.saldoDiario = saldoDiario;
    }

    /**
     * @return the descricaoOp
     */
    public String getDescricaoOp() {
        return descricaoOp;
    }

    /**
     * @param descricaoOp the descricaoOp to set
     */
    public void setDescricaoOp(String descricaoOp) {
        this.descricaoOp = descricaoOp;
    }

    /**
     * @return the descricaoMetodologia
     */
    public String getDescricaoMetodologia() {
        return descricaoMetodologia;
    }

    /**
     * @param descricaoMetodologia the descricaoMetodologia to set
     */
    public void setDescricaoMetodologia(String descricaoMetodologia) {
        this.descricaoMetodologia = descricaoMetodologia;
    }

    /**
     * @return the numeroProjeto
     */
    public String getNumeroProjeto() {
        return numeroProjeto;
    }

    /**
     * @param numeroProjeto the numeroProjeto to set
     */
    public void setNumeroProjeto(String numeroProjeto) {
        this.numeroProjeto = numeroProjeto;
    }

    /**
     * @return the descricaoAtividade
     */
    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    /**
     * @param descricaoAtividade the descricaoAtividade to set
     */
    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }
   
    /**
     * @return the descricaoProjeto
     */
    public String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    /**
     * @param descricaoProjeto the descricaoProjeto to set
     */
    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    /**
     * @return the outros
     */
    public String getOutros() {
        return outros;
    }

    /**
     * @param outros the outros to set
     */
    public void setOutros(String outros) {
        this.outros = outros;
    }

    /**
     * @return the diaAtividade
     */
    public String getDiaAtividade() {
        return diaAtividade;
    }

    /**
     * @param diaAtividade the diaAtividade to set
     */
    public void setDiaAtividade(String diaAtividade) {
        this.diaAtividade = diaAtividade;
    }

    /**
     * @return the listaDiasDaSemana
     */
    public List<Dominio> getListaDiasDaSemana() {
        return listaDiasDaSemana;
    }

    /**
     * @param listaDiasDaSemana the listaDiasDaSemana to set
     */
    public void setListaDiasDaSemana(List<Dominio> listaDiasDaSemana) {
        this.listaDiasDaSemana = listaDiasDaSemana;
    }    

    /**
     * @return the listaTimeSheet
     */
    public List<TimeSheet> getListaTimeSheet() {
        return listaTimeSheet;
    }

    /**
     * @param listaTimeSheet the listaTimeSheet to set
     */
    public void setListaTimeSheet(List<TimeSheet> listaTimeSheet) {
        this.listaTimeSheet = listaTimeSheet;
    }

    /**
     * @return the cliente
     */
    public String getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCodigoCliente(String cliente) {
        this.codigoCliente = cliente;
    }

    /**
     * @return the listaClientes
     */
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * @param listaClientes the listaClientes to set
     */
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    /**
     * @return the listaOPs
     */
    public List<OP> getListaOPs() {
        return listaOPs;
    }

    /**
     * @param listaOPs the listaOPs to set
     */
    public void setListaOPs(List<OP> listaOPs) {
        this.listaOPs = listaOPs;
    }

    /**
     * @return the op
     */
    public String getCodigoOp() {
        return codigoOp;
    }

    /**
     * @param op the op to set
     */
    public void setCodigoOp(String op) {
        this.codigoOp = op;
    }

    /**
     * @return the listaMetodologias
     */
    public List<Metodologia> getListaMetodologias() {
        return listaMetodologias;
    }

    /**
     * @param listaMetodologias the listaMetodologias to set
     */
    public void setListaMetodologias(List<Metodologia> listaMetodologias) {
        this.listaMetodologias = listaMetodologias;
    }

    /**
     * @return the metodologia
     */
    public String getCodigoMetodologia() {
        return codigoMetodologia;
    }

    /**
     * @param metodologia the metodologia to set
     */
    public void setCodigoMetodologia(String metodologia) {
        this.codigoMetodologia = metodologia;
    }

    /**
     * @return the nomeProjeto
     */
    public String getNomeProjeto() {
        return nomeProjeto;
    }

    /**
     * @param nomeProjeto the nomeProjeto to set
     */
    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    /**
     * @return the codigoTimeSheet
     */
    public String getCodigoTimeSheet() {
        return codigoTimeSheet;
    }

    /**
     * @param codigoTimeSheet the codigoTimeSheet to set
     */
    public void setCodigoTimeSheet(String codigoTimeSheet) {
        this.codigoTimeSheet = codigoTimeSheet;
    }

    /**
     * @return the acao
     */
    public String getAcao() {
        return acao;
    }

    /**
     * @param acao the acao to set
     */
    public void setAcao(String acao) {
        this.acao = acao;
    }

    /**
     * @return the timeSheet
     */
    public TimeSheet getTimeSheet() {
        return timeSheet;
    }

    /**
     * @param timeSheet the timeSheet to set
     */
    public void setTimeSheet(TimeSheet timeSheet) {
        this.timeSheet = timeSheet;
    }

    /**
     * @return the atividades
     */
    public Atividade getAtividades() {
        return atividades;
    }

    /**
     * @param atividades the atividades to set
     */
    public void setAtividades(Atividade atividades) {
        this.atividades = atividades;
    }

    /**
     * @return the clientes
     */
    public Cliente getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the metodologias
     */
    public Metodologia getMetodologias() {
        return metodologias;
    }

    /**
     * @param metodologias the metodologias to set
     */
    public void setMetodologias(Metodologia metodologias) {
        this.metodologias = metodologias;
    }

    /**
     * @return the oPs
     */
    public OP getoPs() {
        return oPs;
    }

    /**
     * @param oPs the oPs to set
     */
    public void setoPs(OP oPs) {
        this.oPs = oPs;
    }

    /**
     * @return the produtosServicos
     */
    public ProdutoServico getProdutosServicos() {
        return produtosServicos;
    }

    /**
     * @param produtosServicos the produtosServicos to set
     */
    public void setProdutosServicos(ProdutoServico produtosServicos) {
        this.produtosServicos = produtosServicos;
    }

    /**
     * @return the historicoTimeSheet
     */
    public HistoricoTimeSheet getHistoricoTimeSheet() {
        return historicoTimeSheet;
    }

    /**
     * @param historicoTimeSheet the historicoTimeSheet to set
     */
    public void setHistoricoTimeSheet(HistoricoTimeSheet historicoTimeSheet) {
        this.historicoTimeSheet = historicoTimeSheet;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
     * @return the projeto
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * @param projeto the projeto to set
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    /**
     * @return the campoEditavel
     */
    public Boolean getDesabilitarCampo() {
        return desabilitarCampo;
    }

    /**
     * @param campoEditavel the campoEditavel to set
     */
    public void setDesabilitarCampo(Boolean desabilitarCampo) {
        this.desabilitarCampo = desabilitarCampo;
    }
    
    public void limparFormulario(){
      setAlteracao_data_avaliacao(false);
      setAtividades(null);
      setDesabilitarCampo(false);
      setClientes(null);
      setCodigoAtividade("");
      setCodigoMetodologia("");
      setCodigoOp("");
      setCodigoProdutoServico("");      
      setCodigoTimeSheet("");
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

    /**
     * @return the dataParaPesquisa
     */
    public String getDataParaPesquisa() {
        return dataParaPesquisa;
    }

    /**
     * @param dataParaPesquisa the dataParaPesquisa to set
     */
    public void setDataParaPesquisa(String dataParaPesquisa) {
        this.dataParaPesquisa = dataParaPesquisa;
    }

    /**
     * @return the listaHistoricoTimeSheet
     */
    public List<HistoricoTimeSheet> getListaHistoricoTimeSheet() {
        return listaHistoricoTimeSheet;
    }

    /**
     * @param listaHistoricoTimeSheet the listaHistoricoTimeSheet to set
     */
    public void setListaHistoricoTimeSheet(
            List<HistoricoTimeSheet> listaHistoricoTimeSheet) {
        this.listaHistoricoTimeSheet = listaHistoricoTimeSheet;
    }

    /**
     * @return the listaTimeSheetVO
     */
    public List<TimeSheetVO> getListaTimeSheetVO() {
        return listaTimeSheetVO;
    }

    /**
     * @param listaTimeSheetVO the listaTimeSheetVO to set
     */
    public void setListaTimeSheetVO(List<TimeSheetVO> listaTimeSheetVO) {
        this.listaTimeSheetVO = listaTimeSheetVO;
    }
	
}
