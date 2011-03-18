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
@Table(name="historicoTimeSheet", schema="TS")
public class HistoricoTimeSheet implements POJO<Integer> {

    @Id
    @Column(name="codigoHistoricoTimeSheet")    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;    
    
    @Column(name="dataHoraInicio")
    private Date dataHoraInicio;
    
    @Column(name="dataHoraFim")
    private Date dataHoraFim; 

    @Column(name="dataOperacao")
    private Date dataOperacao; 
    
    @Column(name="observacao")
    private String observacao;

    @Column(name="tipoOperacao")
    private String tipoOperacao;
    
    @Column(name="indicaAlteracaoDataAvaliacao")    
    private Boolean indicaAlteracaoDataAvaliacao;

    @ManyToOne
    @JoinColumn(name="codigoAtividade")  
    private Atividade atividade;
	
    @ManyToOne
    @JoinColumn(name="codigoProdutoServico")
	private ProdutoServico produtoServico;
	
    @ManyToOne
    @JoinColumn(name="codigoProjeto")
	private Projeto projeto;		
	
    @ManyToOne
    @JoinColumn(name="codigoMetodologia")
	private Metodologia metodologia;
	
    @ManyToOne
    @JoinColumn(name="codigoOp")
	private OP op;			
	
    @ManyToOne
    @JoinColumn(name="codigoFuncionario")
	private Funcionario funcionario;	
	
    @ManyToOne
    @JoinColumn(name="codigoCliente")
	private Cliente cliente;		

    @ManyToOne
    @JoinColumn(name="codigoUsuario")
    private Usuario usuario;		

    @ManyToOne
    @JoinColumn(name="codigoTimeSheet", nullable=false)
    private TimeSheet timeSheet;		
	
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
     * @return the dataOperacao
     */
    public Date getDataOperacao() {
        return dataOperacao;
    }
    /**
     * @param dataOperacao the dataOperacao to set
     */
    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }
    /**
     * @return the tipoOperacao
     */
    public String getTipoOperacao() {
        return tipoOperacao;
    }
    /**
     * @param tipoOperacao the tipoOperacao to set
     */
    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
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

}