/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.vo.MetodologiaVO;

/**
 * @author fabio.pinho
 *
 */
public class MetodologiaConversor implements Conversor<Metodologia, MetodologiaVO> {
	
	
	public List<MetodologiaVO> converterListaPojoParaVo(List<Metodologia> pojos) {
		List<MetodologiaVO> vos = new ArrayList<MetodologiaVO>();
		
		for(Metodologia andamento:pojos) {
			vos.add(converterPojoParaVo(andamento));
		}
		return vos;
	}
	
	
	
	public List<Metodologia> converterListaVoParaPojo(List<MetodologiaVO> vos) {
		List<Metodologia> pojos = new ArrayList<Metodologia>();
		
		for (MetodologiaVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	
	
	public MetodologiaVO converterPojoParaVo(Metodologia pojo) {
		MetodologiaVO vo = new MetodologiaVO();		
		vo.setId(pojo.getId());
		vo.setDescricao(pojo.getDescricao());
		return vo;
	}
	
	
	
	public Metodologia converterVoParaPojo(MetodologiaVO vo) {
		Metodologia pojo = new Metodologia();		
		pojo.setDescricao(vo.getDescricao());
		pojo.setId(vo.getId());
		return pojo;
	}
	
}
