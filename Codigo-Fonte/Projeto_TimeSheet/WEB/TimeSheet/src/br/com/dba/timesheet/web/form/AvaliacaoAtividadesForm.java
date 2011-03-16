package br.com.dba.timesheet.web.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.ProdutoServico;
import br.com.dba.timesheet.pojo.SituacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;

public class AvaliacaoAtividadesForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String acao;
	private String codigoAtividade;
	private String codigoCliente;		
	private String codigoTimeSheet;		
	private String codigoSituacaoAtividade;		

    private String data;	
    private String dataHoraInicio;	
	private String dataHoraFim;		
	private String observacao;	
	private String observacaoPrivada;
    private String nomefuncionario;    	

    //Listas
    private List<TimeSheet> listaTimeSheet;
    private List<HistoricoTimeSheet> listaHistoricoTimeSheet;
    private List<SituacaoAtividade> listaSituacaoAtividade;
    private List<ProdutoServico> listaProdutosServicos;
    private List<Funcionario> listaFuncionarios;

    
    //POJO's
    private TimeSheet timeSheet;
    private SituacaoAtividade situacaoAtividade;
    private Funcionario funcionario;
    
    public void limparFormulario(){
      setCodigoAtividade("");
//      setCodigoTimeSheet("");      
      setDataHoraFim("");      
      setDataHoraInicio("");      
      setFuncionario(null);
      setCodigoCliente(null);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }



    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }



    /**
     * @return the codigoAtividade
     */
    public String getCodigoAtividade() {
        return codigoAtividade;
    }



    /**
     * @param codigoAtividade the codigoAtividade to set
     */
    public void setCodigoAtividade(String codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }



    /**
     * @return the codigoCliente
     */
    public String getCodigoCliente() {
        return codigoCliente;
    }



    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }



    /**
     * @return the codigoTimeSheet
     */
    public String getCodigoTimeSheet() {
        return this.codigoTimeSheet;
    }



    /**
     * @param codigoTimeSheet the codigoTimeSheet to set
     */
    public void setCodigoTimeSheet(String codigoTimeSheet) {
        this.codigoTimeSheet = codigoTimeSheet;
    }



    /**
     * @return the dataHoraInicio
     */
    public String getDataHoraInicio() {
        return dataHoraInicio;
    }



    /**
     * @param dataHoraInicio the dataHoraInicio to set
     */
    public void setDataHoraInicio(String dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }



    /**
     * @return the dataHoraFim
     */
    public String getDataHoraFim() {
        return dataHoraFim;
    }



    /**
     * @param dataHoraFim the dataHoraFim to set
     */
    public void setDataHoraFim(String dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }



    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }



    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
     * @return the listaSituacao
     */
    public List<SituacaoAtividade> getListaSituacaoAtividade() {
        return listaSituacaoAtividade;
    }



    /**
     * @param listaSituacao the listaSituacao to set
     */
    public void setListaSituacaoAtividade(List<SituacaoAtividade> listaSituacao) {
        this.listaSituacaoAtividade = listaSituacao;
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
    public void setListaProdutosServicos(List<ProdutoServico> listaProdutosServicos) {
        this.listaProdutosServicos = listaProdutosServicos;
    }



    /**
     * @return the listaFuncionarios
     */
    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }



    /**
     * @param listaFuncionarios the listaFuncionarios to set
     */
    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
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
     * @return the situacaoAtividade
     */
    public SituacaoAtividade getSituacaoAtividade() {
        return situacaoAtividade;
    }



    /**
     * @param situacaoAtividade the situacaoAtividade to set
     */
    public void setSituacaoAtividade(SituacaoAtividade situacaoAtividade) {
        this.situacaoAtividade = situacaoAtividade;
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
     * @return the codigoSituacaoAtividade
     */
    public String getCodigoSituacaoAtividade() {
        return codigoSituacaoAtividade;
    }



    /**
     * @param codigoSituacaoAtividade the codigoSituacaoAtividade to set
     */
    public void setCodigoSituacaoAtividade(String codigoSituacaoAtividade) {
        this.codigoSituacaoAtividade = codigoSituacaoAtividade;
    }



    /**
     * @return the nomefuncionario
     */
    public String getNomefuncionario() {
        return nomefuncionario;
    }



    /**
     * @param nomefuncionario the nomefuncionario to set
     */
    public void setNomefuncionario(String nomefuncionario) {
        this.nomefuncionario = nomefuncionario;
    }

    /**
     * @return the observacaoPrivada
     */
    public String getObservacaoPrivada() {
        return observacaoPrivada;
    }

    /**
     * @param observacaoPrivada the observacaoPrivada to set
     */
    public void setObservacaoPrivada(String observacaoPrivada) {
        this.observacaoPrivada = observacaoPrivada;
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

	
}
