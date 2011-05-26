package br.com.dba.timesheet.util;

import org.displaytag.decorator.TableDecorator;

import br.com.dba.timesheet.pojo.vo.TimeSheetVO;

public class SituacaoDecorator extends TableDecorator {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	public String getCodigoSituacaoAtividade(){
		TimeSheetVO row = (TimeSheetVO)getCurrentRowObject();
		
		if(row.getObservacaoAvaliacaoAtividade() != null || "".equals(row.getObservacaoAvaliacaoAtividade()) ||
				"null".equals(row.getObservacaoAvaliacaoAtividade())){
			return "<img src='${contexto}/WebContent/img/reprov_mao.gif' title='aprovado'/>";
		}else{
			return "<img src='${contexto}/WebContent/img/aprov_mao.gif' title='aprovado'/>";
		}
	}

}
