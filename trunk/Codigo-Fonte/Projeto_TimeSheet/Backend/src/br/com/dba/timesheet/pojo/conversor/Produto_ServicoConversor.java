/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.Produto_Servico;
import br.com.dba.timesheet.vo.MetodologiaVO;
import br.com.dba.timesheet.vo.Produto_ServicoVO;

/**
 * @author fabio.pinho
 *
 */
public class Produto_ServicoConversor implements Conversor<Produto_Servico, Produto_ServicoVO> {
	
	
	public List<Produto_ServicoVO> converterListaPojoParaVo(List<Produto_Servico> pojos) {
		List<Produto_ServicoVO> vos = new ArrayList<Produto_ServicoVO>();
		
		for(Produto_Servico andamento:pojos) {
			vos.add(converterPojoParaVo(andamento));
		}
		return vos;
	}
	
	public List<Produto_Servico> converterListaVoParaPojo(List<Produto_ServicoVO> vos) {
		List<Produto_Servico> pojos = new ArrayList<Produto_Servico>();
		
		for (Produto_ServicoVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public Produto_ServicoVO converterPojoParaVo(Produto_Servico pojo) {
		Produto_ServicoVO vo = new Produto_ServicoVO();		
		vo.setDescricao(pojo.getDescricao());
		vo.setId(pojo.getId());
		vo.setMetodologia(converterPojoParaVo(pojo.getMetodologia()));
		return vo;
	}
	
	public Produto_Servico converterVoParaPojo(Produto_ServicoVO vo) {
		Produto_Servico pojo = new Produto_Servico();		
		pojo.setDescricao(vo.getDescricao());
		pojo.setId(vo.getId());
		pojo.setMetodologia(converterVoParaPojo(vo.getMetodologia()));
		return pojo;
	}
	
	public MetodologiaVO converterPojoParaVo(Metodologia pojo){
        return new MetodologiaConversor().converterPojoParaVo(pojo);
    }
    
    public Metodologia converterVoParaPojo(MetodologiaVO vo){
        return new MetodologiaConversor().converterVoParaPojo(vo);
    }
	
}
