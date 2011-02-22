package br.com.dba.timesheet.servicos;

import java.util.List;

import br.com.dba.timesheet.vo.Tipo_AtividadeVO;
import br.gov.mj.core.exception.ParametroInvalidoException;

/**
 * Este componente é responsável por manipular os dados do Timesheet.
 * 
 */
 public interface Timesheet {
	 
	 List<Tipo_AtividadeVO> listarTodosTipoAtividades() throws ParametroInvalidoException;	 
	 
}