/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Perfil;
import br.com.dba.timesheet.vo.PerfilVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class PerfilConversor implements Conversor<Perfil, PerfilVO> {
	
	
	public List<PerfilVO> converterListaPojoParaVo(List<Perfil> pojos) {
		List<PerfilVO> vos = new ArrayList<PerfilVO>();
		
		for(Perfil pojo:pojos) {
			vos.add(converterPojoParaVo(pojo));
		}
		return vos;
	}
	
	public List<Perfil> converterListaVoParaPojo(List<PerfilVO> vos) {
		List<Perfil> pojos = new ArrayList<Perfil>();
		
		for (PerfilVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public PerfilVO converterPojoParaVo(Perfil pojo) {
		PerfilVO vo = new PerfilVO();		
		vo.setId(pojo.getId());
		vo.setDescricao(pojo.getDescricao());
		return vo;
	}
	
	
	
	public Perfil converterVoParaPojo(PerfilVO vo) {
		Perfil pojo = new Perfil();		
		pojo.setId(vo.getId());		
		pojo.setDescricao(vo.getDescricao());		
		return pojo;
	}
	
}