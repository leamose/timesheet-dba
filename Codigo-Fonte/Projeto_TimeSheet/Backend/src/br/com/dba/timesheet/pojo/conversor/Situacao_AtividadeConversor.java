/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Situacao_Atividade;
import br.com.dba.timesheet.vo.Situacao_AtividadeVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class Situacao_AtividadeConversor implements Conversor<Situacao_Atividade, Situacao_AtividadeVO> {
	
	
	public List<Situacao_AtividadeVO> converterListaPojoParaVo(List<Situacao_Atividade> pojos) {
		List<Situacao_AtividadeVO> vos = new ArrayList<Situacao_AtividadeVO>();
		
		for(Situacao_Atividade pojo:pojos) {
			vos.add(converterPojoParaVo(pojo));
		}
		return vos;
	}
	
	public List<Situacao_Atividade> converterListaVoParaPojo(List<Situacao_AtividadeVO> vos) {
		List<Situacao_Atividade> pojos = new ArrayList<Situacao_Atividade>();
		
		for (Situacao_AtividadeVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public Situacao_AtividadeVO converterPojoParaVo(Situacao_Atividade pojo) {
		Situacao_AtividadeVO vo = new Situacao_AtividadeVO();		
		vo.setId(pojo.getId());
		vo.setDescricao(pojo.getDescricao());
		return vo;
	}
	
	
	
	public Situacao_Atividade converterVoParaPojo(Situacao_AtividadeVO vo) {
		Situacao_Atividade pojo = new Situacao_Atividade();		
		pojo.setId(vo.getId());		
		pojo.setDescricao(vo.getDescricao());		
		return pojo;
	}
	
}