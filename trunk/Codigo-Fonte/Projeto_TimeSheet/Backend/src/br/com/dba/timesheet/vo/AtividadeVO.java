package br.com.dba.timesheet.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class AtividadeVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;			
	private Integer atividade_original;			
	private Tipo_AtividadeVO tipo_atividade;			
	private Produto_ServicoVO produto_servico;			
	private ProjetoVO projeto;			
	private MetodologiaVO metodologia;			
	private OPVO op;			
	private ClienteVO cliente;			
	private FuncionarioVO funcionario;			
	private Date data_hora_inicio;
	private Date data_hora_fim;			
	private String observacao;			
	private Boolean alteracao_data_avaliacao;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAtividade_original() {
        return atividade_original;
    }
    public void setAtividade_original(Integer atividade_original) {
        this.atividade_original = atividade_original;
    }
    public Tipo_AtividadeVO getTipo_atividade() {
        return tipo_atividade;
    }
    public void setTipo_atividade(Tipo_AtividadeVO tipo_atividade) {
        this.tipo_atividade = tipo_atividade;
    }
    public Produto_ServicoVO getProduto_servico() {
        return produto_servico;
    }
    public void setProduto_servico(Produto_ServicoVO produto_servico) {
        this.produto_servico = produto_servico;
    }
    public ProjetoVO getProjeto() {
        return projeto;
    }
    public void setProjeto(ProjetoVO projeto) {
        this.projeto = projeto;
    }
    public MetodologiaVO getMetodologia() {
        return metodologia;
    }
    public void setMetodologia(MetodologiaVO metodologia) {
        this.metodologia = metodologia;
    }
    public OPVO getOp() {
        return op;
    }
    public void setOp(OPVO op) {
        this.op = op;
    }
    public ClienteVO getCliente() {
        return cliente;
    }
    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }
    public FuncionarioVO getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(FuncionarioVO funcionario) {
        this.funcionario = funcionario;
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
}
