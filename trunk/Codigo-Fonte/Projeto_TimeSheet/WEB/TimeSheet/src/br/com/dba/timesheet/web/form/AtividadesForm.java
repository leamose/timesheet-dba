package br.com.dba.timesheet.web.form;

import java.sql.Date;
import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import br.com.dba.timesheet.dominios.Dominio;
import br.com.dba.timesheet.vo.AtividadeVO;
import br.com.dba.timesheet.vo.ClienteVO;
import br.com.dba.timesheet.vo.MetodologiaVO;
import br.com.dba.timesheet.vo.OPVO;
import br.com.dba.timesheet.vo.TimeSheetVO;

public class AtividadesForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String atividade;
	private String cliente;
	private String op;
	private String metodologia;
	private Integer tipo_atividade_id;
	private Integer projeto_id;	
	private Integer metodologia_id;	
	private Integer op_id;	
	private Integer cliente_id;	
	private Integer funcionario_id;	
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
	
	public String data;
	public String diaAtividade;
    public String inicioPrevisto;
    public String terminoPrevisto;
    public String horasDiarias;
    public String saldoDiario;
    public String descricaoOp;
    public String descricaoMetodologia;
    public String numeroProjeto;
    public String descricaoAtividade;
    public String produtoServico;
    public String descricaoProjeto;
    public String outros;
    public String observacoes;	
    
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
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public Integer getTipo_atividade_id() {
		return tipo_atividade_id;
	}
	public void setTipo_atividade_id(Integer tipo_atividade_id) {
		this.tipo_atividade_id = tipo_atividade_id;
	}
	public Integer getProjeto_id() {
		return projeto_id;
	}
	public void setProjeto_id(Integer projeto_id) {
		this.projeto_id = projeto_id;
	}
	public Integer getMetodologia_id() {
		return metodologia_id;
	}
	public void setMetodologia_id(Integer metodologia_id) {
		this.metodologia_id = metodologia_id;
	}
	public Integer getOp_id() {
		return op_id;
	}
	public void setOp_id(Integer op_id) {
		this.op_id = op_id;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public Integer getFuncionario_id() {
		return funcionario_id;
	}
	public void setFuncionario_id(Integer funcionario_id) {
		this.funcionario_id = funcionario_id;
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
     * @return the produtoServico
     */
    public String getProdutoServico() {
        return produtoServico;
    }

    /**
     * @param produtoServico the produtoServico to set
     */
    public void setProdutoServico(String produtoServico) {
        this.produtoServico = produtoServico;
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
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
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
    public String getOp() {
        return op;
    }

    /**
     * @param op the op to set
     */
    public void setOp(String op) {
        this.op = op;
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
    public String getMetodologia() {
        return metodologia;
    }

    /**
     * @param metodologia the metodologia to set
     */
    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }
	
}
