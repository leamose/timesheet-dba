package br.com.dba.timesheet.vo;

import java.io.Serializable;
import java.util.Date;

import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.Produto_Servico;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.Tipo_Atividade;

public class AtividadeVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;			
	private Integer atividade_original_id;			
	private Tipo_Atividade tipo_atividade_id;			
	private Produto_Servico produto_servico_id;			
	private Projeto projeto_id;			
	private Metodologia metodologia_id;			
	private OP op_id;			
	private Cliente cliente_id;			
	private Funcionario funcionario_id;			
	private Date data_hora_inicio;
	private Date data_hora_fim;			
	private String observacao;			
	private Boolean alteracao_data_avaliacao;
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAtividade_original_id() {
		return atividade_original_id;
	}
	public void setAtividade_original_id(Integer atividade_original_id) {
		this.atividade_original_id = atividade_original_id;
	}
	public Tipo_Atividade getTipo_atividade_id() {
		return tipo_atividade_id;
	}
	public void setTipo_atividade_id(Tipo_Atividade tipo_atividade_id) {
		this.tipo_atividade_id = tipo_atividade_id;
	}
	public Produto_Servico getProduto_servico_id() {
		return produto_servico_id;
	}
	public void setProduto_servico_id(Produto_Servico produto_servico_id) {
		this.produto_servico_id = produto_servico_id;
	}
	public Projeto getProjeto_id() {
		return projeto_id;
	}
	public void setProjeto_id(Projeto projeto_id) {
		this.projeto_id = projeto_id;
	}
	public Metodologia getMetodologia_id() {
		return metodologia_id;
	}
	public void setMetodologia_id(Metodologia metodologia_id) {
		this.metodologia_id = metodologia_id;
	}
	public OP getOp_id() {
		return op_id;
	}
	public void setOp_id(OP op_id) {
		this.op_id = op_id;
	}
	public Cliente getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}
	public Funcionario getFuncionario_id() {
		return funcionario_id;
	}
	public void setFuncionario_id(Funcionario funcionario_id) {
		this.funcionario_id = funcionario_id;
	}
	public Date getData_hora_inicio() {
		return data_hora_inicio;
	}
	public void setData_hora_inicio(Date data_hora_inicio) {
		this.data_hora_inicio = data_hora_inicio;
	}

}
