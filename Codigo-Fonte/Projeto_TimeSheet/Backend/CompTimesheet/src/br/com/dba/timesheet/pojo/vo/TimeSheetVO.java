package br.com.dba.timesheet.pojo.vo;

import java.io.Serializable;
import java.util.Date;

public class TimeSheetVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //TIMESHEET
    private Integer codigoTimeSheet;    
    private Date dataHoraInicio;
    private Date dataHoraFim; 
    private String observacao;
    private String outrasAtividades;
    private Boolean indicaAlteracaoDataAvaliacao;
    private Integer codigoAtividade;
    private Integer codigoProdutoServico;
    private Integer codigoProjeto;        
    private Integer codigoMetodologia;
    private Integer codigoOp;          
    private Integer codigoFuncionario;    
    private Integer codigoCliente;
    private Boolean habilitaBotaoAlterar;
    
    //PRODUTO
    private String descricaoProduto;
    
    //FORMULARIO
    private String nomeProjeto;
    public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	private String login;
    private Integer numeroProjeto;
    private String descricaoAtividade;
    private String ultimaAtividade;
    
    //HISTORICOTIMESHEET
    private Integer codigoHistoricoTimeSheet;    
    private Date dataOperacao; 
    private String tipoOperacao;
    private Integer codigoUsuario;        
    
    //AVALIACAOATIVIDADE
    private Integer codigoAvaliacaoTimeSheet;
    private String observacaoAvaliacaoAtividade;
    private String observacaoPrivada;
    private Date dataInicio;
    private Date dataFim; 
    private Integer codigoSituacaoAtividade;
    private Integer codigoFuncionarioAvaliador;
    
    /**
     * @return the codigoTimeSheet
     */
    public Integer getCodigoTimeSheet() {
        return codigoTimeSheet;
    }

    /**
     * @return the dataHoraInicio
     */
    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    /**
     * @return the dataHoraFim
     */
    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @return the outrasAtividades
     */
    public String getOutrasAtividades() {
        return outrasAtividades;
    }

    /**
     * @return the indicaAlteracaoDataAvaliacao
     */
    public Boolean getIndicaAlteracaoDataAvaliacao() {
        return indicaAlteracaoDataAvaliacao;
    }

    /**
     * @return the codigoAtividade
     */
    public Integer getCodigoAtividade() {
        return codigoAtividade;
    }

    /**
     * @return the codigoProdutoServico
     */
    public Integer getCodigoProdutoServico() {
        return codigoProdutoServico;
    }

    /**
     * @return the codigoProjeto
     */
    public Integer getCodigoProjeto() {
        return codigoProjeto;
    }

    /**
     * @return the codigoMetodologia
     */
    public Integer getCodigoMetodologia() {
        return codigoMetodologia;
    }

    /**
     * @return the codigoOp
     */
    public Integer getCodigoOp() {
        return codigoOp;
    }

    /**
     * @return the codigoFuncionario
     */
    public Integer getCodigoFuncionario() {
        return codigoFuncionario;
    }

    /**
     * @return the codigoCliente
     */
    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * @return the codigoHistoricoTimeSheet
     */
    public Integer getCodigoHistoricoTimeSheet() {
        return codigoHistoricoTimeSheet;
    }

    /**
     * @return the dataOperacao
     */
    public Date getDataOperacao() {
        return dataOperacao;
    }

    /**
     * @return the tipoOperacao
     */
    public String getTipoOperacao() {
        if(tipoOperacao.equals("I")){
            tipoOperacao = "Inclusão";
        }else if(tipoOperacao.equals("A")){
            tipoOperacao = "Alteração";
        }else if(tipoOperacao.equals("E")){
            tipoOperacao = "Exclusão";
        }
        return tipoOperacao;
    }

    /**
     * @return the codigoUsuario
     */
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * @return the codigoAvaliacaoTimeSheet
     */
    public Integer getCodigoAvaliacaoTimeSheet() {
        return codigoAvaliacaoTimeSheet;
    }

    /**
     * @return the observacaoAvaliacaoAtividade
     */
    public String getObservacaoAvaliacaoAtividade() {
        return observacaoAvaliacaoAtividade;
    }

    /**
     * @return the observacaoPrivada
     */
    public String getObservacaoPrivada() {
        return observacaoPrivada;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @return the codigoSituacaoAtividade
     */
    public Integer getCodigoSituacaoAtividade() {
        return codigoSituacaoAtividade;
    }

    /**
     * @return the codigoFuncionarioAvaliador
     */
    public Integer getCodigoFuncionarioAvaliador() {
        return codigoFuncionarioAvaliador;
    }

    /**
     * @param codigoTimeSheet the codigoTimeSheet to set
     */
    public void setCodigoTimeSheet(Integer codigoTimeSheet) {
        this.codigoTimeSheet = codigoTimeSheet;
    }

    /**
     * @param dataHoraInicio the dataHoraInicio to set
     */
    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    /**
     * @param dataHoraFim the dataHoraFim to set
     */
    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @param outrasAtividades the outrasAtividades to set
     */
    public void setOutrasAtividades(String outrasAtividades) {
        this.outrasAtividades = outrasAtividades;
    }

    /**
     * @param indicaAlteracaoDataAvaliacao the indicaAlteracaoDataAvaliacao to set
     */
    public void setIndicaAlteracaoDataAvaliacao(Boolean indicaAlteracaoDataAvaliacao) {
        this.indicaAlteracaoDataAvaliacao = indicaAlteracaoDataAvaliacao;
    }

    /**
     * @param codigoAtividade the codigoAtividade to set
     */
    public void setCodigoAtividade(Integer codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    /**
     * @param codigoProdutoServico the codigoProdutoServico to set
     */
    public void setCodigoProdutoServico(Integer codigoProdutoServico) {
        this.codigoProdutoServico = codigoProdutoServico;
    }

    /**
     * @param codigoProjeto the codigoProjeto to set
     */
    public void setCodigoProjeto(Integer codigoProjeto) {
        this.codigoProjeto = codigoProjeto;
    }

    /**
     * @param codigoMetodologia the codigoMetodologia to set
     */
    public void setCodigoMetodologia(Integer codigoMetodologia) {
        this.codigoMetodologia = codigoMetodologia;
    }

    /**
     * @param codigoOp the codigoOp to set
     */
    public void setCodigoOp(Integer codigoOp) {
        this.codigoOp = codigoOp;
    }

    /**
     * @param codigoFuncionario the codigoFuncionario to set
     */
    public void setCodigoFuncionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * @param codigoHistoricoTimeSheet the codigoHistoricoTimeSheet to set
     */
    public void setCodigoHistoricoTimeSheet(Integer codigoHistoricoTimeSheet) {
        this.codigoHistoricoTimeSheet = codigoHistoricoTimeSheet;
    }

    /**
     * @param dataOperacao the dataOperacao to set
     */
    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    /**
     * @param tipoOperacao the tipoOperacao to set
     */
    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    /**
     * @param codigoUsuario the codigoUsuario to set
     */
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * @param codigoAvaliacaoTimeSheet the codigoAvaliacaoTimeSheet to set
     */
    public void setCodigoAvaliacaoTimeSheet(Integer codigoAvaliacaoTimeSheet) {
        this.codigoAvaliacaoTimeSheet = codigoAvaliacaoTimeSheet;
    }

    /**
     * @param observacaoAvaliacaoAtividade the observacaoAvaliacaoAtividade to set
     */
    public void setObservacaoAvaliacaoAtividade(String observacaoAvaliacaoAtividade) {
        this.observacaoAvaliacaoAtividade = observacaoAvaliacaoAtividade;
    }

    /**
     * @param observacaoPrivada the observacaoPrivada to set
     */
    public void setObservacaoPrivada(String observacaoPrivada) {
        this.observacaoPrivada = observacaoPrivada;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @param codigoSituacaoAtividade the codigoSituacaoAtividade to set
     */
    public void setCodigoSituacaoAtividade(Integer codigoSituacaoAtividade) {
        this.codigoSituacaoAtividade = codigoSituacaoAtividade;
    }

    /**
     * @param codigoFuncionarioAvaliador the codigoFuncionarioAvaliador to set
     */
    public void setCodigoFuncionarioAvaliador(Integer codigoFuncionarioAvaliador) {
        this.codigoFuncionarioAvaliador = codigoFuncionarioAvaliador;
    }

    /**
     * @return the nomeProjeto
     */
    public String getNomeProjeto() {
        return nomeProjeto;
    }

    /**
     * @return the numeroProjeto
     */
    public Integer getNumeroProjeto() {
        return numeroProjeto;
    }

    /**
     * @param nomeProjeto the nomeProjeto to set
     */
    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    /**
     * @param numeroProjeto the numeroProjeto to set
     */
    public void setNumeroProjeto(Integer numeroProjeto) {
        this.numeroProjeto = numeroProjeto;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
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
     * @return the ultimaAtividade
     */
    public String getUltimaAtividade() {
        
        if (!"".equals(getLogin()) &&  getLogin() != null
                && !"".equals(getTipoOperacao()) &&  getTipoOperacao() != null) {
            ultimaAtividade = getLogin() + " - " + getTipoOperacao();
            
        }

        return ultimaAtividade;
    }

    /**
     * @param ultimaAtividade the ultimaAtividade to set
     */
    public void setUltimaAtividade(String ultimaAtividade) {
        this.ultimaAtividade = ultimaAtividade;
    }

	public Boolean getHabilitaBotaoAlterar() {
		return habilitaBotaoAlterar;
	}

	public void setHabilitaBotaoAlterar(Boolean habilitaBotaoAlterar) {
		this.habilitaBotaoAlterar = habilitaBotaoAlterar;
	}

}
