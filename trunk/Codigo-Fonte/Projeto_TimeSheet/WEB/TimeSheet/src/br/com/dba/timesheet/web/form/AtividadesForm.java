package br.com.dba.timesheet.web.form;

import java.sql.Date;
import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import br.com.dba.timesheet.dominios.Dominio;
import br.com.dba.timesheet.vo.AtividadeVO;
import br.com.dba.timesheet.vo.ClienteVO;
import br.com.dba.timesheet.vo.MetodologiaVO;
import br.com.dba.timesheet.vo.OPVO;
import br.com.dba.timesheet.vo.ProdutoServicoVO;
import br.com.dba.timesheet.vo.TimeSheetVO;

public class AtividadesForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String codigoAtividade;
	private String codigoCliente;
	private String codigoOp;
	private String codigoMetodologia;
	private String codigoProdutoServico;		
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
    public List<ProdutoServicoVO> getListaProdutosServicos() {
        return listaProdutosServicos;
    }

    /**
     * @param listaProdutosServicos the listaProdutosServicos to set
     */
    public void setListaProdutosServicos(
            List<ProdutoServicoVO> listaProdutosServicos) {
        this.listaProdutosServicos = listaProdutosServicos;
    }

    private Date data_hora_inicio;	
	private Date data_hora_fim;		
	private String observacao;	
	private Boolean alteracao_data_avaliacao;	
	private List<Dominio> listaDiasDaSemana;
	private List<TimeSheetVO> listaTimeSheet;
	private List<AtividadeVO> listaAtividades;
	private List<ClienteVO> listaClientes;
	private List<MetodologiaVO> listaMetodologias;
	private List<OPVO> listaOPs;
	private List<ProdutoServicoVO> listaProdutosServicos;
	
	private String data;
	private String diaAtividade;
    private String inicioPrevisto;
    private String terminoPrevisto;
    private String horasDiarias;
    private String saldoDiario;
    private String descricaoOp;
    private String descricaoMetodologia;
    private String numeroProjeto;
    private String descricaoAtividade;    
    private String descricaoProjeto;
    private String outros;
    private String observacoes;	
    
    /**
     * Funcionario Form
     */
    private Integer substituto_id;
    private Integer chefe_id;
    private String nome;
    private String cargo;
    private Boolean chefe;
    private Integer hora_trabalho_inicio;
    private Integer hora_trabalho_fim;
    private Integer hora_almoco_inicio;
    private Integer hora_almoco_fim;
    private Boolean ferias;
	
	public List<AtividadeVO> getListaAtividades() {
		return listaAtividades;
	}

	public void setListaAtividades(List<AtividadeVO> listaAtividades) {
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
	public Date getData_hora_inicio() {
		return data_hora_inicio;
	}
	public void setData_hora_inicio(Date data_hora_inicio) {
		this.data_hora_inicio = data_hora_inicio;
	}
	public Date getData_hora_fim() {
		return data_hora_fim;
	}
	public void setData_hora_fim(Date data_hora_fim) {
		this.data_hora_fim = data_hora_fim;
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
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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
     * @return the substituto_id
     */
    public Integer getSubstituto_id() {
        return substituto_id;
    }

    /**
     * @param substituto_id the substituto_id to set
     */
    public void setSubstituto_id(Integer substituto_id) {
        this.substituto_id = substituto_id;
    }

    /**
     * @return the chefe_id
     */
    public Integer getChefe_id() {
        return chefe_id;
    }

    /**
     * @param chefe_id the chefe_id to set
     */
    public void setChefe_id(Integer chefe_id) {
        this.chefe_id = chefe_id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the chefe
     */
    public Boolean getChefe() {
        return chefe;
    }

    /**
     * @param chefe the chefe to set
     */
    public void setChefe(Boolean chefe) {
        this.chefe = chefe;
    }

    /**
     * @return the hora_trabalho_inicio
     */
    public Integer getHora_trabalho_inicio() {
        return hora_trabalho_inicio;
    }

    /**
     * @param hora_trabalho_inicio the hora_trabalho_inicio to set
     */
    public void setHora_trabalho_inicio(Integer hora_trabalho_inicio) {
        this.hora_trabalho_inicio = hora_trabalho_inicio;
    }

    /**
     * @return the hora_trabalho_fim
     */
    public Integer getHora_trabalho_fim() {
        return hora_trabalho_fim;
    }

    /**
     * @param hora_trabalho_fim the hora_trabalho_fim to set
     */
    public void setHora_trabalho_fim(Integer hora_trabalho_fim) {
        this.hora_trabalho_fim = hora_trabalho_fim;
    }

    /**
     * @return the hora_almoco_inicio
     */
    public Integer getHora_almoco_inicio() {
        return hora_almoco_inicio;
    }

    /**
     * @param hora_almoco_inicio the hora_almoco_inicio to set
     */
    public void setHora_almoco_inicio(Integer hora_almoco_inicio) {
        this.hora_almoco_inicio = hora_almoco_inicio;
    }

    /**
     * @return the hora_almoco_fim
     */
    public Integer getHora_almoco_fim() {
        return hora_almoco_fim;
    }

    /**
     * @param hora_almoco_fim the hora_almoco_fim to set
     */
    public void setHora_almoco_fim(Integer hora_almoco_fim) {
        this.hora_almoco_fim = hora_almoco_fim;
    }

    /**
     * @return the ferias
     */
    public Boolean getFerias() {
        return ferias;
    }

    /**
     * @param ferias the ferias to set
     */
    public void setFerias(Boolean ferias) {
        this.ferias = ferias;
    }

    /**
     * @return the listaTimeSheet
     */
    public List<TimeSheetVO> getListaTimeSheet() {
        return listaTimeSheet;
    }

    /**
     * @param listaTimeSheet the listaTimeSheet to set
     */
    public void setListaTimeSheet(List<TimeSheetVO> listaTimeSheet) {
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
    public List<ClienteVO> getListaClientes() {
        return listaClientes;
    }

    /**
     * @param listaClientes the listaClientes to set
     */
    public void setListaClientes(List<ClienteVO> listaClientes) {
        this.listaClientes = listaClientes;
    }

    /**
     * @return the listaOPs
     */
    public List<OPVO> getListaOPs() {
        return listaOPs;
    }

    /**
     * @param listaOPs the listaOPs to set
     */
    public void setListaOPs(List<OPVO> listaOPs) {
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
    public List<MetodologiaVO> getListaMetodologias() {
        return listaMetodologias;
    }

    /**
     * @param listaMetodologias the listaMetodologias to set
     */
    public void setListaMetodologias(List<MetodologiaVO> listaMetodologias) {
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
	
}
