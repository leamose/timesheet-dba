/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.vo.FuncionarioVO;
import br.gov.mj.core.pojo.conversor.Conversor;

/**
 * @author fabio.pinho
 *
 */
public class FuncionarioConversor implements Conversor<Funcionario, FuncionarioVO> {
	
	
	public List<FuncionarioVO> converterListaPojoParaVo(List<Funcionario> pojos) {
		List<FuncionarioVO> vos = new ArrayList<FuncionarioVO>();
		
		for(Funcionario andamento:pojos) {
			vos.add(converterPojoParaVo(andamento));
		}
		return vos;
	}
	
	public List<Funcionario> converterListaVoParaPojo(List<FuncionarioVO> vos) {
		List<Funcionario> pojos = new ArrayList<Funcionario>();
		
		for (FuncionarioVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public FuncionarioVO converterPojoParaVo(Funcionario pojo) {
		FuncionarioVO vo = new FuncionarioVO();		
		vo.setCargo(pojo.getCargo());
		vo.setChefe(pojo.getChefe());
		vo.setChefe_id(pojo.getChefe_id());
		vo.setFerias(pojo.getFerias());
		vo.setHora_almoco_fim(pojo.getHora_almoco_fim());
		vo.setHora_almoco_inicio(pojo.getHora_almoco_inicio());
		vo.setHora_trabalho_fim(pojo.getHora_almoco_fim());
		vo.setHora_trabalho_inicio(pojo.getHora_trabalho_inicio());
		vo.setId(pojo.getId());
		vo.setNome(pojo.getNome());
		vo.setSubstituto_id(pojo.getSubstituto());		
		return vo;
	}
	
	public Funcionario converterVoParaPojo(FuncionarioVO vo) {
		Funcionario pojo = new Funcionario();		
		pojo.setCargo(vo.getCargo());
		pojo.setChefe(vo.getChefe());
		pojo.setChefe_id(vo.getChefe_id());
		pojo.setFerias(vo.getFerias());
		pojo.setHora_almoco_fim(vo.getHora_almoco_fim());
		pojo.setHora_almoco_inicio(vo.getHora_almoco_inicio());
		pojo.setHora_trabalho_fim(vo.getHora_almoco_fim());
		pojo.setHora_trabalho_inicio(vo.getHora_trabalho_inicio());
		pojo.setId(vo.getId());
		pojo.setNome(vo.getNome());
		pojo.setSubstituto(vo.getSubstituto_id());
		return pojo;
	}
	
}
