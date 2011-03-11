package br.com.dba.timesheet.web.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.dominios.ListaDominios;
import br.com.dba.timesheet.ejb.TimesheetDelegate;
import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.ProdutoServico;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.struts.BaseDispatchAction;
import br.com.dba.timesheet.util.UtilDate;
import br.com.dba.timesheet.web.form.AtividadesForm;


public class AtividadesAction extends BaseDispatchAction {
	
    private List<Atividade> listarTodasAtividades = null;
    private List<Cliente> listarTodosClientes = null;
    private List<OP> listarTodasOPs = null;
    private List<Metodologia> listarTodasMetodologias = null;
    private List<ProdutoServico> listarTodosProdutosServicos = null;
    
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
	    try {
    		AtividadesForm formulario = (AtividadesForm) form;
    
            List<TimeSheet> listaTimeSheet = getTimeSheetDelegate().listarTodosTimeSheet();    		
    		
    		formulario.setListaTimeSheet(listaTimeSheet);
    		
		} catch (ErroInternoException e) {
		    e.printStackTrace();
		}catch (ParametroInvalidoException e) {
		    e.printStackTrace();
		}
		
		return mapping.findForward("cadastro");		
	}   
	
	public ActionForward operacaoCancelada(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("retorno");        
	}
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    
	    try {
    	    AtividadesForm formulario = (AtividadesForm) form;
    	    
    	    TimeSheet timeSheet = preencherTimeSheet(formulario);    	    
    	    salvarTimeSheet(timeSheet);
    	    
    	    HistoricoTimeSheet historicoTimeSheet = preencherHistoricoTimeSheet(timeSheet);            
            salvarHistoricoTimeSheet(historicoTimeSheet);
            
            
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    return mapping.findForward("retorno");        
	}

    public void salvarTimeSheet(TimeSheet pojo)
            throws ParametroInvalidoException {
        getTimeSheetDelegate().salvarTimeSheet(pojo);
    }

    public void salvarHistoricoTimeSheet(HistoricoTimeSheet pojo)
    throws ParametroInvalidoException {
        getTimeSheetDelegate().salvarHistoricoTimeSheet(pojo);
    }

	
	 /**
     * Cria e preenche o objeto TimeSheet com os dados da tela. 
     * 
     * @param formulario
     * @param metodologia
     * @return
     * @throws ParametroInvalidoException
     */
    public TimeSheet preencherTimeSheet(AtividadesForm formulario)
            throws ParametroInvalidoException {
        
        TimeSheet pojo = new TimeSheet();

        try {            
            
            //COMBOS
            pojo.setAtividade(getTimeSheetDelegate().getAtividade(Integer.valueOf(formulario.getCodigoAtividade())));
            pojo.setCliente(getTimeSheetDelegate().getCliente(Integer.valueOf(formulario.getCodigoCliente())));
            Metodologia metodologia = getTimeSheetDelegate().getMetodologia(Integer.valueOf(formulario.getCodigoMetodologia()));
            pojo.setMetodologia(metodologia);
            pojo.setOp(getTimeSheetDelegate().getOP(Integer.valueOf(formulario.getCodigoOp())));
            pojo.setProdutoServico(getTimeSheetDelegate().getProdutoServico(Integer.valueOf(formulario.getCodigoProdutoServico())));
    
            // TODO RECUPERANDO O USUARIO FABIO....ARRUMAR
            pojo.setFuncionario(getTimeSheetDelegate().getFuncionario(3));
                        
            Projeto projetoSalvo = salvarProjeto(formulario, metodologia);
            
            pojo.setProjeto(projetoSalvo);
            
            //TEXTOS
            pojo.setDataHoraInicio(UtilDate.getDataHora(formulario.getData() + " " + formulario.getDataHoraInicio() + ":00"));
            pojo.setDataHoraFim(UtilDate.getDataHora(formulario.getData() + " " + formulario.getDataHoraInicio() + ":00"));
            pojo.setObservacao(formulario.getObservacao());
            pojo.setOutrasAtividades(formulario.getOutros());
            
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return pojo;
    }

    /**
     * Cria e preenche o objeto HistoricoTimeSheet com os dados da tela. 
     * 
     * @param timeSheet
     * @param metodologia
     * @return
     * @throws ParametroInvalidoException
     */
    public HistoricoTimeSheet preencherHistoricoTimeSheet(TimeSheet timeSheet)throws ParametroInvalidoException {
        
        HistoricoTimeSheet pojo = new HistoricoTimeSheet();
        
        //COMBOS
        pojo.setAtividade(timeSheet.getAtividade());
        pojo.setCliente(timeSheet.getCliente());
        pojo.setMetodologia(timeSheet.getMetodologia());
        pojo.setOp(timeSheet.getOp());
        pojo.setProdutoServico(timeSheet.getProdutoServico());
        pojo.setFuncionario(timeSheet.getFuncionario());        
        pojo.setProjeto(timeSheet.getProjeto());
        pojo.setTimeSheet(timeSheet);
        
        //TEXTOS
        pojo.setDataHoraInicio(new Date());
        pojo.setDataHoraFim(new Date());
        pojo.setObservacao(timeSheet.getObservacao());
        
        return pojo;
    }

    
    /**
     * Salva o objeto Projeto no banco. 
     * 
     * @param formulario
     * @param metodologia
     * @return
     * @throws ParametroInvalidoException
     */
    public Projeto salvarProjeto(AtividadesForm formulario,
            Metodologia metodologia) throws ParametroInvalidoException {
        Projeto projeto = new Projeto();       
        projeto.setMetodologia(metodologia);
        projeto.setNome(formulario.getNomeProjeto());
        projeto.setNumeroProjeto(Integer.valueOf(formulario.getNumeroProjeto()));
        
        Projeto projetoSalvo = getTimeSheetDelegate().salvarProjeto(projeto);
        return projetoSalvo;
    }

	public ActionForward excluir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
		return mapping.findForward("retorno");        
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
	    try {
            AtividadesForm formulario = (AtividadesForm) form;
            
            ListaDominios listaDominios = new ListaDominios();
            preencherFormulario(formulario, listaDominios);
            
            TimeSheet timesheet = getTimeSheet(Integer.valueOf(formulario.getCodigoTimeSheet()));
            
            if(timesheet != null){
                formulario.setData(UtilDate.getDataComoString(timesheet.getDataHoraInicio()));
                formulario.setDataHoraInicio(UtilDate.getHoraComoString(timesheet.getDataHoraInicio()));
                formulario.setDataHoraFim(UtilDate.getHoraComoString(timesheet.getDataHoraInicio()));
                formulario.setCodigoOp(Integer.toString(timesheet.getOp().getId()));
                formulario.setCodigoMetodologia(Integer.toString(timesheet.getMetodologia().getId()));
                formulario.setNomeProjeto(timesheet.getProjeto().getNome());
                formulario.setNumeroProjeto(Integer.toString(timesheet.getProjeto().getNumeroProjeto()));
                formulario.setCodigoCliente(Integer.toString(timesheet.getCliente().getId()));
                formulario.setCodigoAtividade(Integer.toString(timesheet.getAtividade().getId()));
                formulario.setCodigoProdutoServico(Integer.toString(timesheet.getProdutoServico().getId()));
                formulario.setObservacao(timesheet.getObservacao());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
		return mapping.findForward("retorno");        
	}

    public TimeSheet getTimeSheet(Integer id)
            throws ParametroInvalidoException {
        return getTimeSheetDelegate().getTimeSheet(id);
    }


	public ActionForward retornoAlterar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    return mapping.findForward("retorno");        
	}

	
	public ActionForward detalhar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
	    try {

	        AtividadesForm formulario = (AtividadesForm) form;
            
            ListaDominios listaDominios = new ListaDominios();
            
            formulario.setListaAtividades(getListarTodasAtividades()) ;
            formulario.setListaDiasDaSemana(listaDominios.getListaDiasDaSemana());
            
        } catch (IOException e) {
            e.printStackTrace();
        }       
	    
		return mapping.findForward("retorno");        
	}

	public ActionForward retornoDetalhar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    return mapping.findForward("retorno");        
	}

    public ActionForward voltar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("voltar");       
    }
    
    public ActionForward consultar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retorno");       
    }
    
    public ActionForward aprovar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retorno");       
    }
    
    public ActionForward reprovar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        
        try {

            AtividadesForm formulario = (AtividadesForm) form;
            
            ListaDominios listaDominios = new ListaDominios();
            
            formulario.setListaAtividades(getListarTodasAtividades()) ;
            formulario.setListaDiasDaSemana(listaDominios.getListaDiasDaSemana());
            
        } catch (IOException e) {
            e.printStackTrace();
        }       
        
        return mapping.findForward("retorno");       
    }

    public ActionForward retornoReprovar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retorno");       
    }
    
    public ActionForward cadastrarAtividade(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        
        try {
            AtividadesForm formulario = (AtividadesForm) form;
            
            ListaDominios listaDominios = new ListaDominios();
            
            //Lista para as combos.
            preencherFormulario(formulario, listaDominios);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       return mapping.findForward("retorno");      
    }


    public ActionForward retornoCadastrarAtividade(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retorno");      
    }

    //*********************************************
    //* METODOS AUXILIARES :
    //*********************************************
    public void preencherFormulario(AtividadesForm formulario,
            ListaDominios listaDominios) throws IOException {
        
        formulario.setListaAtividades(getListarTodasAtividades()) ;
        formulario.setListaDiasDaSemana(listaDominios.getListaDiasDaSemana());
        formulario.setListaClientes(getListarTodosClientes());
        formulario.setListaOPs(getListarTodasOPs());
        formulario.setListaMetodologias(getListarTodasMetodologias());
        formulario.setListaProdutosServicos(getListarTodosProdutosServicos());
        
    }

    //************************************
    //* GETTER's e SETTER's
    //************************************
    
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
    public void setListarTodasMetodologias(
            List<Metodologia> listarTodasMetodologias) {
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
    public void setListarTodosProdutosServicos(
            List<ProdutoServico> listarTodosProdutosServicos) {
        this.listarTodosProdutosServicos = listarTodosProdutosServicos;
    }

    //*********************************************
    //* CONSULTAS :
    //*********************************************
    public List<Atividade> listarTodosAtividades()
    throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodosAtividades();
    }

    public List<Cliente> listarTodosClientes()
    throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodosCliente();
    }

    public List<OP> listarTodasOPs()
    throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodasOPs();
    }

    public List<Metodologia> listarTodasMetodologias()
    throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodasMetodologias();
    }

    public List<ProdutoServico> listarTodosProdutoServico()
    throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodosProdutoServico();
    }
    

    //*********************************************
    //* DELEGATE :
    //*********************************************
    public TimesheetDelegate getTimeSheetDelegate() {
        return TimesheetDelegate.getInstancia();
    }



    
}
