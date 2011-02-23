/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.vo.ClienteVO;
import br.com.dba.timesheet.vo.OPVO;

/**
 * @author fabio.pinho
 *
 */
public class OPConversor implements Conversor<OP, OPVO> {
	
	
	public List<OPVO> converterListaPojoParaVo(List<OP> pojos) {
		List<OPVO> vos = new ArrayList<OPVO>();
		
		for(OP andamento:pojos) {
			vos.add(converterPojoParaVo(andamento));
		}
		return vos;
	}
	
	public List<OP> converterListaVoParaPojo(List<OPVO> vos) {
		List<OP> pojos = new ArrayList<OP>();
		
		for (OPVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}
	
	public OPVO converterPojoParaVo(OP pojo) {
		OPVO vo = new OPVO();		
		vo.setCliente_id(converterPojoParaVo(pojo.getCliente()));
		vo.setDescricao(pojo.getDescricao());
		vo.setId(pojo.getId());
		return vo;
	}
	
	public OP converterVoParaPojo(OPVO vo) {
		OP pojo = new OP();		
		pojo.setCliente(converterVoParaPojo(vo.getCliente_id()));
		pojo.setDescricao(vo.getDescricao());
		pojo.setId(vo.getId());
		return pojo;
	}
	
	public ClienteVO converterPojoParaVo(Cliente pojo){
        return new ClienteConversor().converterPojoParaVo(pojo);
    }
    
    public Cliente converterVoParaPojo(ClienteVO vo){
        return new ClienteConversor().converterVoParaPojo(vo);
    }
	
}
