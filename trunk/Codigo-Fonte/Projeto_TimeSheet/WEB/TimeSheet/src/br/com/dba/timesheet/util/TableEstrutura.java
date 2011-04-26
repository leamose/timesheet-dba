package br.com.dba.timesheet.util;

import org.displaytag.decorator.TableDecorator;

import br.com.dba.timesheet.pojo.vo.TimeSheetVO;

public class TableEstrutura extends TableDecorator {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String addRowClass() {
		
		TimeSheetVO row = (TimeSheetVO)getCurrentRowObject();

		if(row.getObservacaoAvaliacaoAtividade() != null || "".equals(row.getObservacaoAvaliacaoAtividade()) ||
				"null".equals(row.getObservacaoAvaliacaoAtividade())){
			return "avaliado";
		}else{
			return null;
		}
	}

}
