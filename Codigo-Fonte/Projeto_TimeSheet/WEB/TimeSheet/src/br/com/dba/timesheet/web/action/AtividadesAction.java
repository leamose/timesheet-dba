package br.com.dba.timesheet.web.action;

import java.io.IOException;
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
import br.com.dba.timesheet.struts.BaseDispatchAction;
import br.com.dba.timesheet.vo.AtividadeVO;
import br.com.dba.timesheet.vo.ClienteVO;
import br.com.dba.timesheet.vo.MetodologiaVO;
import br.com.dba.timesheet.vo.OPVO;
import br.com.dba.timesheet.vo.ProdutoServicoVO;
import br.com.dba.timesheet.vo.TimeSheetVO;
import br.com.dba.timesheet.web.form.AtividadesForm;


public class AtividadesAction extends BaseDispatchAction {
	
    private List<AtividadeVO> listarTodasAtividades = null;
    private List<ClienteVO> listarTodosClientes = null;
    private List<OPVO> listarTodasOPs = null;
    private List<MetodologiaVO> listarTodasMetodologias = null;
    private List<ProdutoServicoVO> listarTodosProdutosServicos = null;
    
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
	    try {
    		AtividadesForm formulario = (AtividadesForm) form;
    
            List<TimeSheetVO> listaTimeSheet = getTimeSheetDelegate().listarTodosTimeSheet();
    		
    		
    		formulario.setListaTimeSheet(listaTimeSheet);
    		
    //		request.setAttribute("listaAtividades", listaAtividades);
		} catch (ErroInternoException e) {
		    e.printStackTrace();
		} catch (ParametroInvalidoException e) {
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
    	    
    	    TimeSheetVO vo = new TimeSheetVO();
    	    
    	    //COMBOS
            vo.setAtividade(getTimeSheetDelegate().getAtividade(Integer.valueOf(formulario.getCodigoAtividade())));
            vo.setCliente(getTimeSheetDelegate().getCliente(Integer.valueOf(formulario.getCodigoCliente())));
            vo.setMetodologia(getTimeSheetDelegate().getMetodologia(Integer.valueOf(formulario.getCodigoMetodologia())));
            vo.setOp(getTimeSheetDelegate().getOP(Integer.valueOf(formulario.getCodigoOp())));
            vo.setProdutoServico(getTimeSheetDelegate().getOP(Integer.valueOf(formulario.getCodigoProdutoServico())));
            
            
            //TEXTOS
            vo.setDataHoraInicio(formulario.getData_hora_inicio());
            vo.setDataHoraFim(formulario.getData_hora_fim());
            vo.setObservacao(formulario.getObservacao());
//            vo.setProjeto( formulario.getNumeroProjeto());
            vo.setOutrasAtividades(formulario.getOutros());
            
            getTimeSheetDelegate().salvarTimeSheet(vo);
            
            
            
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    return mapping.findForward("retorno");        
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
            
            formulario.setListaAtividades(getListarTodasAtividades()) ;
            formulario.setListaDiasDaSemana(listaDominios.getListaDiasDaSemana());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		return mapping.findForward("retorno");        
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
        
    }

    //************************************
    //* GETTER's e SETTER's
    //************************************
    
    /**
     * @return the listarTodasAtividades
     */
    public List<AtividadeVO> getListarTodasAtividades() {
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
    public void setListarTodasAtividades(List<AtividadeVO> listarTodasAtividades) {
        this.listarTodasAtividades = listarTodasAtividades;
    }

    /**
     * @return the listarTodosClientes
     */
    public List<ClienteVO> getListarTodosClientes() {
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
    public void setListarTodosClientes(List<ClienteVO> listarTodosClientes) {
        this.listarTodosClientes = listarTodosClientes;
    }

    /**
     * @return the listarTodasOPs
     */
    public List<OPVO> getListarTodasOPs() {
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
    public void setListarTodasOPs(List<OPVO> listarTodasOPs) {
        this.listarTodasOPs = listarTodasOPs;
    }
    
    /**
     * @return the listarTodasMetodologias
     */
    public List<MetodologiaVO> getListarTodasMetodologias() {
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
            List<MetodologiaVO> listarTodasMetodologias) {
        this.listarTodasMetodologias = listarTodasMetodologias;
    }
    
    /**
     * @return the listarTodosProdutosServicos
     */
    public List<ProdutoServicoVO> getListarTodosProdutosServicos() {
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
            List<ProdutoServicoVO> listarTodosProdutosServicos) {
        this.listarTodosProdutosServicos = listarTodosProdutosServicos;
    }

    //*********************************************
    //* CONSULTAS :
    //*********************************************
    public List<AtividadeVO> listarTodosAtividades()
    throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodosAtividades();
    }

    public List<ClienteVO> listarTodosClientes()
    throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodosCliente();
    }

    public List<OPVO> listarTodasOPs()
    throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodasOPs();
    }

    public List<MetodologiaVO> listarTodasMetodologias()
    throws ParametroInvalidoException {
        return getTimeSheetDelegate().listarTodasMetodologias();
    }

    public List<ProdutoServicoVO> listarTodosProdutoServico()
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
