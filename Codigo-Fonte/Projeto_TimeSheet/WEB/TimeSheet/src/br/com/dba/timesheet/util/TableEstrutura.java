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

		if(row.getCodigoSituacaoAtividade()!=null 
				&& (row.getCodigoSituacaoAtividade().equals(Constantes.NAO_HOMOLOGADO)
				|| row.getCodigoSituacaoAtividade().equals(Constantes.HOMOLOGADO_COM_ALTERACOES))){
			return "avaliado";
		}else{
			return null;
		}
	}
	
	public String getCodigoSituacaoAtividade(){
		TimeSheetVO row = (TimeSheetVO)getCurrentRowObject();
		
		if(row.getCodigoSituacaoAtividade() == null || row.getCodigoSituacaoAtividade()==0){			
			return "<img src=\"/timesheet/WebContent/img/aguardando_aprov.gif\" title=\"aprovado\"/>";
		}else if(row.getCodigoSituacaoAtividade()!=null 
				&& (row.getCodigoSituacaoAtividade().equals(Constantes.NAO_HOMOLOGADO)
				|| row.getCodigoSituacaoAtividade().equals(Constantes.HOMOLOGADO_COM_ALTERACOES))){
			return "<img src=\"/timesheet/WebContent/img/reprov_mao.gif\" title=\"aprovado\"/>";
		}else{
			return "<img src=\"/timesheet/WebContent/img/aprov_mao.gif\" title=\"aprovado\"/>";
		}
	}

}
