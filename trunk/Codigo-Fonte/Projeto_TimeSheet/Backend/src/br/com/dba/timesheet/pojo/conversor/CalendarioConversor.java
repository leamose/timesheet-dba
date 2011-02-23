/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Calendario;
import br.com.dba.timesheet.vo.CalendarioVO;

/**
 * @author fabio.pinho
 *
 */
public class CalendarioConversor implements Conversor<Calendario, CalendarioVO> {
	
	
	public List<CalendarioVO> converterListaPojoParaVo(List<Calendario> pojos) {
		List<CalendarioVO> vos = new ArrayList<CalendarioVO>();
		
		for(Calendario pojo:pojos) {
			vos.add(converterPojoParaVo(pojo));
		}
		return vos;
	}
	
	
	
	public List<Calendario> converterListaVoParaPojo(List<CalendarioVO> vos) {
		List<Calendario> pojos = new ArrayList<Calendario>();
		
		for (CalendarioVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public CalendarioVO converterPojoParaVo(Calendario pojo) {
		CalendarioVO vo = new CalendarioVO();		
		vo.setId(pojo.getId());
		vo.setCarga_horaria(pojo.getCarga_horaria());
		vo.setData_calendario(pojo.getData_calendario());
		vo.setHora_fim(pojo.getHora_fim());
		vo.setHora_inicio(pojo.getHora_inicio());
		return vo;
	}
	
	
	
	public Calendario converterVoParaPojo(CalendarioVO vo) {
		Calendario pojo = new Calendario();		
		pojo.setId(vo.getId());		
		pojo.setCarga_horaria(vo.getCarga_horaria());
		pojo.setData_calendario(vo.getData_calendario());
		pojo.setHora_fim(vo.getHora_fim());
		pojo.setHora_inicio(vo.getHora_inicio());		
		return pojo;
	}
	
}