/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Funcionalidade;
import br.com.dba.timesheet.vo.FuncionalidadeVO;

/**
 * @author fabio.pinho
 *
 */
public class FuncionalidadeConversor implements Conversor<Funcionalidade, FuncionalidadeVO> {
	
	
	public List<FuncionalidadeVO> converterListaPojoParaVo(List<Funcionalidade> pojos) {
		List<FuncionalidadeVO> vos = new ArrayList<FuncionalidadeVO>();
		
		for(Funcionalidade pojo:pojos) {
			vos.add(converterPojoParaVo(pojo));
		}
		return vos;
	}
	
	public List<Funcionalidade> converterListaVoParaPojo(List<FuncionalidadeVO> vos) {
		List<Funcionalidade> pojos = new ArrayList<Funcionalidade>();
		
		for (FuncionalidadeVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public FuncionalidadeVO converterPojoParaVo(Funcionalidade pojo) {
		FuncionalidadeVO vo = new FuncionalidadeVO();		
		vo.setId(pojo.getId());
		vo.setDescricao(pojo.getDescricao());
		return vo;
	}
	
	
	
	public Funcionalidade converterVoParaPojo(FuncionalidadeVO vo) {
		Funcionalidade pojo = new Funcionalidade();		
		pojo.setId(vo.getId());		
		pojo.setDescricao(vo.getDescricao());		
		return pojo;
	}
	
}