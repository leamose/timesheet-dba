/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.vo.AtividadeVO;
import br.gov.mj.core.pojo.conversor.Conversor;

/**
 * @author fabio.pinho
 *
 */
public class AtividadeConversor implements Conversor<Atividade, AtividadeVO> {
	
	
	public List<AtividadeVO> converterListaPojoParaVo(List<Atividade> pojos) {
		List<AtividadeVO> vos = new ArrayList<AtividadeVO>();
		
		for(Atividade andamento:pojos) {
			vos.add(converterPojoParaVo(andamento));
		}
		return vos;
	}
	
	
	
	public List<Atividade> converterListaVoParaPojo(List<AtividadeVO> vos) {
		List<Atividade> pojos = new ArrayList<Atividade>();
		
		for (AtividadeVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public AtividadeVO converterPojoParaVo(Atividade pojo) {
		AtividadeVO vo = new AtividadeVO();		
		vo.setId(pojo.getId());
		vo.setAtividade_original_id(pojo.getAtividade_original());
		vo.setCliente_id(pojo.getCliente());
		vo.setData_hora_inicio(pojo.getData_hora_inicio());
		vo.setMetodologia_id(pojo.getMetodologia());
		vo.setOp_id(pojo.getOp());
		vo.setAlteracao_data_avaliacao(pojo.getAlteracao_data_avaliacao());
		vo.setData_hora_fim(pojo.getData_hora_fim());
		vo.setProduto_servico_id(pojo.getProduto_servico());
		vo.setProjeto_id(pojo.getProjeto());
		vo.setObservacao(pojo.getObservacao());
		vo.setTipo_atividade_id(pojo.getTipo_atividade());
		return vo;
	}
	
	
	
	public Atividade converterVoParaPojo(AtividadeVO vo) {
		Atividade pojo = new Atividade();		
		pojo.setId(vo.getId());
		pojo.setAtividade_original(vo.getAtividade_original_id());
		pojo.setCliente(vo.getCliente_id());
		pojo.setData_hora_inicio(vo.getData_hora_inicio());
		pojo.setMetodologia(vo.getMetodologia_id());
		pojo.setOp(vo.getOp_id());
		pojo.setAlteracao_data_avaliacao(vo.getAlteracao_data_avaliacao());
		pojo.setData_hora_fim(vo.getData_hora_fim());
		pojo.setProduto_servico(vo.getProduto_servico_id());
		pojo.setProjeto(vo.getProjeto_id());
		pojo.setObservacao(vo.getObservacao());
		pojo.setTipo_atividade(vo.getTipo_atividade_id());
		return pojo;
	}
	
}
