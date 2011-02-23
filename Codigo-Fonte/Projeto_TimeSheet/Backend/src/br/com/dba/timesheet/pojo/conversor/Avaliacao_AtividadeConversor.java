/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Avaliacao_Atividade;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.Situacao_Atividade;
import br.com.dba.timesheet.vo.Avaliacao_AtividadeVO;
import br.com.dba.timesheet.vo.FuncionarioVO;
import br.com.dba.timesheet.vo.Situacao_AtividadeVO;

/**
 * @author fabio.pinho
 *
 */
public class Avaliacao_AtividadeConversor implements Conversor<Avaliacao_Atividade, Avaliacao_AtividadeVO> {
	
	
	public List<Avaliacao_AtividadeVO> converterListaPojoParaVo(List<Avaliacao_Atividade> pojos) {
		List<Avaliacao_AtividadeVO> vos = new ArrayList<Avaliacao_AtividadeVO>();
		
		for(Avaliacao_Atividade andamento:pojos) {
			vos.add(converterPojoParaVo(andamento));
		}
		return vos;
	}
	
	
	
	public List<Avaliacao_Atividade> converterListaVoParaPojo(List<Avaliacao_AtividadeVO> vos) {
		List<Avaliacao_Atividade> pojos = new ArrayList<Avaliacao_Atividade>();
		
		for (Avaliacao_AtividadeVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public Avaliacao_AtividadeVO converterPojoParaVo(Avaliacao_Atividade pojo) {
		Avaliacao_AtividadeVO vo = new Avaliacao_AtividadeVO();		
		vo.setId(pojo.getId());		
		vo.setObservacao(pojo.getObservacao());		
		vo.setObservacao_privada(pojo.getObservacao_privada());	
		vo.setSituacao_Atividade(converterPojoParaVo(pojo.getSituacao_Atividade()));
        vo.setAvaliador_id(converterPojoParaVo(pojo.getAvaliador_id()));
		return vo;
	}
	
	
	
	public Avaliacao_Atividade converterVoParaPojo(Avaliacao_AtividadeVO vo) {
		Avaliacao_Atividade pojo = new Avaliacao_Atividade();		
		pojo.setId(vo.getId());		
		pojo.setObservacao(vo.getObservacao());
		pojo.setObservacao_privada(vo.getObservacao_privada());
		pojo.setSituacao_Atividade(converterVoParaPojo(vo.getSituacao_Atividade()));
		pojo.setAvaliador_id(converterVoParaPojo(vo.getAvaliador_id()));
		return pojo;
	}

	public FuncionarioVO converterPojoParaVo(Funcionario pojo){
        return new FuncionarioConversor().converterPojoParaVo(pojo);
    }
    
    public Funcionario converterVoParaPojo(FuncionarioVO vo){
        return new FuncionarioConversor().converterVoParaPojo(vo);
    }
	
	public Situacao_AtividadeVO converterPojoParaVo(Situacao_Atividade pojo){
	    return new Situacao_AtividadeConversor().converterPojoParaVo(pojo);
	}
	
	public Situacao_Atividade converterVoParaPojo(Situacao_AtividadeVO vo){
	    return new Situacao_AtividadeConversor().converterVoParaPojo(vo);
	}
	
}
