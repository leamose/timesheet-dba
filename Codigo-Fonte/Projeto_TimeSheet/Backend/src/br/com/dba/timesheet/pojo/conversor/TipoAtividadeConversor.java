/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Tipo_Atividade;
import br.com.dba.timesheet.vo.Tipo_AtividadeVO;

/**
 * @author fabio.pinho
 *
 */
public class TipoAtividadeConversor implements Conversor<Tipo_Atividade, Tipo_AtividadeVO> {
	
	
	public List<Tipo_AtividadeVO> converterListaPojoParaVo(List<Tipo_Atividade> pojos) {
		List<Tipo_AtividadeVO> vos = new ArrayList<Tipo_AtividadeVO>();
		
		for(Tipo_Atividade andamento:pojos) {
			vos.add(converterPojoParaVo(andamento));
		}
		return vos;
	}
	
	public List<Tipo_Atividade> converterListaVoParaPojo(List<Tipo_AtividadeVO> vos) {
		List<Tipo_Atividade> pojos = new ArrayList<Tipo_Atividade>();
		
		for (Tipo_AtividadeVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public Tipo_AtividadeVO converterPojoParaVo(Tipo_Atividade pojo) {
		Tipo_AtividadeVO vo = new Tipo_AtividadeVO();		
		vo.setDescricao(pojo.getDescricao());
		vo.setId(pojo.getId());
		return vo;
	}
	
	public Tipo_Atividade converterVoParaPojo(Tipo_AtividadeVO vo) {
		Tipo_Atividade pojo = new Tipo_Atividade();		
		pojo.setDescricao(vo.getDescricao());
		pojo.setId(vo.getId());
		return pojo;
	}
}
