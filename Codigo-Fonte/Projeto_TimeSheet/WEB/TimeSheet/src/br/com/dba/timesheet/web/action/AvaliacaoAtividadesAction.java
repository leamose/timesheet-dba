package br.com.dba.timesheet.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.util.UtilDate;
import br.com.dba.timesheet.web.form.AvaliacaoAtividadesForm;

public class AvaliacaoAtividadesAction extends TimeSheetComum {
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    	    
	    AvaliacaoAtividadesForm formulario = (AvaliacaoAtividadesForm) form;
	    
	    formulario.setListaSituacaoAtividade(getListarTodasSituacaoAtividade());
	    formulario.setId(Integer.valueOf(formulario.getCodigoTimeSheet()));	    
	    
	    try {
            TimeSheet timesheet = getTimeSheetPeloID(formulario.getId());
	    
            formulario.setData(UtilDate.getDataComoString(timesheet.getDataHoraInicio()));
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	    
	    
		return mapping.findForward("retorno");		
	}

	public ActionForward salvar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    
	    try {
    	    AvaliacaoAtividadesForm formulario = (AvaliacaoAtividadesForm) form;
    	    
    //	    formulario.setListaSituacaoAtividade(getListarTodasSituacaoAtividade());
    	    
    	    AvaliacaoAtividade avaliacaoAtividade = new AvaliacaoAtividade();
	    
    	    // TODO RECUPERANDO O USUARIO FABIO....ARRUMAR
    	    avaliacaoAtividade.setFuncionarioAvaliador(getFuncionarioPeloID(2));
    	    
    	    avaliacaoAtividade.setObservacao(formulario.getObservacao());
    	    avaliacaoAtividade.setObservacaoPrivada(formulario.getObservacaoPrivada());
    	    avaliacaoAtividade.setSituacaoAtividade(getSituacaoAtividadePeloID(Integer.valueOf(formulario.getCodigoSituacaoAtividade())));
    	    avaliacaoAtividade.setTimeSheet(getTimeSheetPeloID(formulario.getId()));
    	    
    	    try {
                getTimeSheetDelegate().salvarAvaliacaoAtividade(avaliacaoAtividade);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            
            
//	    } catch (ParseException e) {
//	        // TODO Auto-generated catch block
//	        e.printStackTrace();
	    } 
	    catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    return mapping.findForward("retorno");		
	}	
	
}
