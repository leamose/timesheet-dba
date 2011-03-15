package br.com.dba.timesheet.web.action;

import java.util.List;

import br.com.dba.timesheet.ejb.TimesheetDelegate;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.ProdutoServico;
import br.com.dba.timesheet.pojo.SituacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.struts.BaseDispatchAction;

public class TimeSheetComum extends BaseDispatchAction{

    private List<Atividade> listarTodasAtividades = null;
    private List<Cliente> listarTodosClientes = null;
    private List<OP> listarTodasOPs = null;
    private List<Metodologia> listarTodasMetodologias = null;
    private List<ProdutoServico> listarTodosProdutosServicos = null;
    private List<SituacaoAtividade> listarTodasSituacaoAtividade = null;

    
    //*********************************************
    //* GETTER's e SETTER's :
    //*********************************************
    /**
     * @return the listarTodasAtividades
     */
    public List<Atividade> getListarTodasAtividades() {
        try {
           if (this.listarTodasAtividades == null) {
               this.listarTodasAtividades = listarTodosAtividades();
           }
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
        return this.listarTodasAtividades;
    }

    /**
     * @return the listarTodasAtividades
     */
    public List<SituacaoAtividade> getListarTodasSituacaoAtividade() {
        try {
            if (this.listarTodasSituacaoAtividade == null) {
                this.listarTodasSituacaoAtividade = listarTodasSituacaoAtividade();
            }
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
        return this.listarTodasSituacaoAtividade;
    }

    /**
     * @param listarTodasAtividades the listarTodasAtividades to set
     */
    public void setListarTodasSituacaoAtividade(List<SituacaoAtividade> listarTodasSituacaoAtividade) {
        this.listarTodasSituacaoAtividade = listarTodasSituacaoAtividade;
    }

    /**
     * @param listarTodasAtividades the listarTodasAtividades to set
     */
    public void setListarTodasAtividades(List<Atividade> listarTodasAtividades) {
        this.listarTodasAtividades = listarTodasAtividades;
    }

    /**
     * @return the listarTodosClientes
     */
    public List<Cliente> getListarTodosClientes() {
        try {
            if (listarTodosClientes == null) {
                    listarTodosClientes = listarTodosClientes();
            }
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listarTodosClientes;
    }

    /**
     * @param listarTodosClientes the listarTodosClientes to set
     */
    public void setListarTodosClientes(List<Cliente> listarTodosClientes) {
        this.listarTodosClientes = listarTodosClientes;
    }

    /**
     * @return the listarTodasOPs
     */
    public List<OP> getListarTodasOPs() {
        try {
            if (listarTodasOPs == null) {
                    listarTodasOPs = listarTodasOPs();
            }
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }            
    
        return listarTodasOPs;
        
    }

    /**
     * @param listarTodasOPs the listarTodasOPs to set
     */
    public void setListarTodasOPs(List<OP> listarTodasOPs) {
        this.listarTodasOPs = listarTodasOPs;
    }

    /**
     * @return the listarTodasMetodologias
     */
    public List<Metodologia> getListarTodasMetodologias() {
        try {
            if (listarTodasMetodologias == null) {
                    listarTodasMetodologias = listarTodasMetodologias();
            }
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }            
    
        return listarTodasMetodologias;
    }

    /**
     * @param listarTodasMetodologias the listarTodasMetodologias to set
     */
    public void setListarTodasMetodologias(List<Metodologia> listarTodasMetodologias) {
        this.listarTodasMetodologias = listarTodasMetodologias;
    }

    /**
     * @return the listarTodosProdutosServicos
     */
    public List<ProdutoServico> getListarTodosProdutosServicos() {
        try {
            if (listarTodosProdutosServicos == null) {
                listarTodosProdutosServicos = listarTodosProdutoServico();            
            }
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listarTodosProdutosServicos;
    }

    /**
     * @param listarTodosProdutosServicos the listarTodosProdutosServicos to set
     */
    public void setListarTodosProdutosServicos(List<ProdutoServico> listarTodosProdutosServicos) {
        this.listarTodosProdutosServicos = listarTodosProdutosServicos;
    }

    public List<Atividade> listarTodosAtividades() throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodosAtividades();
    }

    public List<Cliente> listarTodosClientes() throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodosCliente();
    }

    public List<OP> listarTodasOPs() throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodasOPs();
    }

    public List<Metodologia> listarTodasMetodologias() throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodasMetodologias();
    }

    public List<ProdutoServico> listarTodosProdutoServico()
        throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodosProdutoServico();
    }

    public List<SituacaoAtividade> listarTodasSituacaoAtividade()
        throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodasSituacaoAtividade();
    }

    
    //*********************************************
    //* CRUD's :
    //*********************************************
    public void salvarTimeSheet(TimeSheet pojo)
            throws ParametroInvalidoException {
            getTimeSheetDelegate().salvarTimeSheet(pojo);
            }

    public void salvarHistoricoTimeSheet(HistoricoTimeSheet pojo)
            throws ParametroInvalidoException {
                getTimeSheetDelegate().salvarHistoricoTimeSheet(pojo);
            }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     */
    public OP getOPPeloID(Integer id) {
        OP pojo = null;
        try{    
            pojo = getTimeSheetDelegate().getOP(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     */
    public ProdutoServico getProdutoServicoPeloID(Integer id) {
        ProdutoServico pojo = null;
        try{    
            pojo = getTimeSheetDelegate().getProdutoServico(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     */
    public Cliente getClientePeloID(Integer id) {
        Cliente pojo = null;
        try{    
            pojo = getTimeSheetDelegate().getCliente(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     */
    public Atividade getAtividadePeloID(Integer id) {
        Atividade pojo = null;
        try{    
            pojo = getTimeSheetDelegate().getAtividade(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     */
    public Metodologia getMetodologiaPeloID(Integer id) {
        Metodologia pojo = null;
        try {
            pojo = getTimeSheetDelegate().getMetodologia(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pojo;
    }    

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     */
    public Funcionario getFuncionarioPeloID(Integer id) {
        Funcionario pojo = null;
        try {
            pojo = getTimeSheetDelegate().getFuncionario(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     */
    public SituacaoAtividade getSituacaoAtividadePeloID(Integer id) {
        SituacaoAtividade pojo = null;
        try {
            pojo = getTimeSheetDelegate().getSituacaoAtividade(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pojo;
    }
    
    public TimeSheet getTimeSheetPeloID(Integer id)
        throws ParametroInvalidoException {
        return getTimeSheetDelegate().getTimeSheet(id);
    }
    
  //*********************************************
    //* DELEGATES :
    //*********************************************
    public TimesheetDelegate getTimeSheetDelegate() {
        return TimesheetDelegate.getInstancia();
    }

    public void alterarTimeSheet(TimeSheet pojo) {
        try {
            getTimeSheetDelegate().alterarTimeSheet(pojo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

}
