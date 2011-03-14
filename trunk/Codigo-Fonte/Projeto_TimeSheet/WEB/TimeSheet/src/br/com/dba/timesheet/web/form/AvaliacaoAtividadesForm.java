package br.com.dba.timesheet.web.form;

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
import br.com.dba.timesheet.pojo.SituacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.Usuario;

public class AvaliacaoAtividadesForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String codigoAtividade;
	private String codigoCliente;		
	private String codigoTimeSheet;		

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
    private String outros;    	

    //Listas
    private List<TimeSheet> listaTimeSheet;
    private List<HistoricoTimeSheet> listaHistoricoTimeSheet;
    private List<SituacaoAtividade> listaSituacao;
    private List<ProdutoServico> listaProdutosServicos;
    private List<Funcionario> listaFuncionarios;

    
    //POJO's
    private TimeSheet timeSheet;
    private SituacaoAtividade situacaoAtividade;
    private Funcionario funcionario;
    
    
    
    public void limparFormulario(){
      setCodigoAtividade("");
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
      setHorasDiarias("");      
      setInicioPrevisto("");
      setNomeProjeto("");
      setNumeroProjeto("");
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
        return codigoTimeSheet;
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
    public List<SituacaoAtividade> getListaSituacao() {
        return listaSituacao;
    }



    /**
     * @param listaSituacao the listaSituacao to set
     */
    public void setListaSituacao(List<SituacaoAtividade> listaSituacao) {
        this.listaSituacao = listaSituacao;
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

	
}
