package br.com.dba.timesheet.pojo;

import java.util.Date;

import br.gov.mj.core.pojo.POJO;


public class Atividade implements POJO<Integer> {

	private Integer id;			
	private Integer atividade_original;			
	private Tipo_Atividade tipo_atividade;			
	private Produto_Servico produto_servico;			
	private Projeto projeto;			
	private Metodologia metodologia;			
	private OP op;			
	private Funcionario funcionario;			
	private Cliente cliente;			
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
	public void setAtividade_original(Integer atividade_original_id) {
		this.atividade_original = atividade_original_id;
	}
	public Tipo_Atividade getTipo_atividade() {
		return tipo_atividade;
	}
	public void setTipo_atividade(Tipo_Atividade tipo_atividade_id) {
		this.tipo_atividade = tipo_atividade_id;
	}
	public Produto_Servico getProduto_servico() {
		return produto_servico;
	}
	public void setProduto_servico(Produto_Servico produto_servico_id) {
		this.produto_servico = produto_servico_id;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto_id) {
		this.projeto = projeto_id;
	}
	public Metodologia getMetodologia() {
		return metodologia;
	}
	public void setMetodologia(Metodologia metodologia_id) {
		this.metodologia = metodologia_id;
	}
	public OP getOp() {
		return op;
	}
	public void setOp(OP op_id) {
		this.op = op_id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente_id) {
		this.cliente = cliente_id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario_id) {
		this.funcionario = funcionario_id;
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