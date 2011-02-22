/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.vo.ProjetoVO;
import br.gov.mj.core.pojo.conversor.Conversor;

/**
 * @author fabio.pinho
 *
 */
public class ProjetoConversor implements Conversor<Projeto, ProjetoVO> {
	
	
	public List<ProjetoVO> converterListaPojoParaVo(List<Projeto> pojos) {
		List<ProjetoVO> vos = new ArrayList<ProjetoVO>();
		
		for(Projeto andamento:pojos) {
			vos.add(converterPojoParaVo(andamento));
		}
		return vos;
	}
	
	public List<Projeto> converterListaVoParaPojo(List<ProjetoVO> vos) {
		List<Projeto> pojos = new ArrayList<Projeto>();
		
		for (ProjetoVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public ProjetoVO converterPojoParaVo(Projeto pojo) {
		ProjetoVO vo = new ProjetoVO();		
		vo.setDescricao(pojo.getDescricao());
		vo.setId(pojo.getId());
		vo.setMetodologia(pojo.getMetodologia());
		vo.setNumero_projeto(pojo.getNumero_projeto());
		return vo;
	}
	
	public Projeto converterVoParaPojo(ProjetoVO vo) {
		Projeto pojo = new Projeto();		
		pojo.setDescricao(vo.getDescricao());
		pojo.setId(vo.getId());
		pojo.setMetodologia(vo.getMetodologia());
		pojo.setNumero_projeto(vo.getNumero_projeto());
		return pojo;
	}
	
}
