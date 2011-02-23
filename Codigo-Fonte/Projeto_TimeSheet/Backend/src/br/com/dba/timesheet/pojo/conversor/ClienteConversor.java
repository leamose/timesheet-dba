/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.vo.ClienteVO;

/**
 * @author fabio.pinho
 *
 */
public class ClienteConversor implements Conversor<Cliente, ClienteVO> {
	
	
	public List<ClienteVO> converterListaPojoParaVo(List<Cliente> pojos) {
		List<ClienteVO> vos = new ArrayList<ClienteVO>();
		
		for(Cliente andamento:pojos) {
			vos.add(converterPojoParaVo(andamento));
		}
		return vos;
	}	
	
	public List<Cliente> converterListaVoParaPojo(List<ClienteVO> vos) {
		List<Cliente> pojos = new ArrayList<Cliente>();
		
		for (ClienteVO vo : vos) {
			pojos.add(converterVoParaPojo(vo));
		}
		return pojos;
	}	
	
	public ClienteVO converterPojoParaVo(Cliente pojo) {
		ClienteVO vo = new ClienteVO();		
		vo.setId(pojo.getId());
		vo.setNome(pojo.getNome());
		return vo;
	}
	
	public Cliente converterVoParaPojo(ClienteVO vo) {
		Cliente pojo = new Cliente();		
		pojo.setId(vo.getId());
		pojo.setNome(vo.getNome());
		return pojo;
	}
	
}
