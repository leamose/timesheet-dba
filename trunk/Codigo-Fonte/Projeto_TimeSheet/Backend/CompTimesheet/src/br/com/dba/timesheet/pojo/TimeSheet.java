package br.com.dba.timesheet.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */

@Entity
@Table(name="timeSheet", schema="TS")
public class TimeSheet implements POJO<Integer> {

    @Id
    @Column(name="codigoTimeSheet", nullable=false) 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;    
    
    @Column(name="dataHoraInicio", nullable=false)
    private Date dataHoraInicio;
    
    @Column(name="dataHoraFim", nullable=true)
    private Date dataHoraFim; 
    
    @Column(name="observacao")
    private String observacao;

    @Column(name="outrasAtividades", length = 255)
    private String outrasAtividades;
    
    @Column(name="indicaAlteracaoDataAvaliacao")    
    private Boolean indicaAlteracaoDataAvaliacao;

    @ManyToOne
    @JoinColumn(name="codigoAtividade", nullable=false)  
    private Atividade atividade;
	
//    @ManyToOne
//    @JoinColumn(name="tipo_atividade", nullable=false)    
//	private Tipo_Atividade tipo_atividade;
	
    @ManyToOne
    @JoinColumn(name="codigoProdutoServico", nullable=false)
	private ProdutoServico produtoServico;
	
    @ManyToOne
    @JoinColumn(name="codigoProjeto")
	private Projeto projeto;		
	
    @ManyToOne
    @JoinColumn(name="codigoMetodologia", nullable=false)
	private Metodologia metodologia;
	
    @ManyToOne
    @JoinColumn(name="codigoOp", nullable=false)
	private OP op;			
	
    @ManyToOne
    @JoinColumn(name="codigoFuncionario", nullable=false)
	private Funcionario funcionario;	
	
    @ManyToOne
    @JoinColumn(name="codigoCliente", nullable=false)
	private Cliente cliente;		
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProdutoServico getProdutoServico() {
		return produtoServico;
	}
	public void setProdutoServico(ProdutoServico produtoServico) {
		this.produtoServico = produtoServico;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public Metodologia getMetodologia() {
		return metodologia;
	}
	public void setMetodologia(Metodologia metodologia) {
		this.metodologia = metodologia;
	}
	public OP getOp() {
		return op;
	}
	public void setOp(OP op) {
		this.op = op;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public Date getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Boolean getIndicaAlteracaoDataAvaliacao() {
		return indicaAlteracaoDataAvaliacao;
	}
	public void setIndicaAlteracaoDataAvaliacao(Boolean indicaAlteracaoDataAvaliacao) {
		this.indicaAlteracaoDataAvaliacao = indicaAlteracaoDataAvaliacao;
	}
    /**
     * @return the outrasAtividades
     */
    public String getOutrasAtividades() {
        return outrasAtividades;
    }
    /**
     * @param outrasAtividades the outrasAtividades to set
     */
    public void setOutrasAtividades(String outrasAtividades) {
        this.outrasAtividades = outrasAtividades;
    }
    /**
     * @return the atividade
     */
    public Atividade getAtividade() {
        return atividade;
    }
    /**
     * @param atividade the atividade to set
     */
    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }	

}