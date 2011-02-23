/**
 * 
 */
package br.com.dba.timesheet.pojo.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.Produto_Servico;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.Tipo_Atividade;
import br.com.dba.timesheet.vo.AtividadeVO;
import br.com.dba.timesheet.vo.ClienteVO;
import br.com.dba.timesheet.vo.MetodologiaVO;
import br.com.dba.timesheet.vo.OPVO;
import br.com.dba.timesheet.vo.Produto_ServicoVO;
import br.com.dba.timesheet.vo.ProjetoVO;
import br.com.dba.timesheet.vo.Tipo_AtividadeVO;

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
		vo.setAtividade_original(pojo.getAtividade_original());
		vo.setCliente(converterPojoParaVo(pojo.getCliente()));
		vo.setData_hora_inicio(pojo.getData_hora_inicio());
		vo.setMetodologia(converterPojoParaVo(pojo.getMetodologia()));
		vo.setOp(converterPojoParaVo(pojo.getOp()));
		vo.setAlteracao_data_avaliacao(pojo.getAlteracao_data_avaliacao());
		vo.setData_hora_fim(pojo.getData_hora_fim());
		vo.setProduto_servico(converterPojoParaVo(pojo.getProduto_servico()));
		vo.setProjeto(converterPojoParaVo(pojo.getProjeto()));
		vo.setObservacao(pojo.getObservacao());
		vo.setTipo_atividade(converterPojoParaVo(pojo.getTipo_atividade()));
		return vo;
	}
	
	
	
	public Atividade converterVoParaPojo(AtividadeVO vo) {
		Atividade pojo = new Atividade();		
		pojo.setId(vo.getId());
		pojo.setAtividade_original(vo.getAtividade_original());
		pojo.setCliente(converterVoParaPojo(vo.getCliente()));
		pojo.setData_hora_inicio(vo.getData_hora_inicio());
		pojo.setMetodologia(converterVoParaPojo(vo.getMetodologia()));
		pojo.setOp(converterVoParaPojo(vo.getOp()));
		pojo.setAlteracao_data_avaliacao(vo.getAlteracao_data_avaliacao());
		pojo.setData_hora_fim(vo.getData_hora_fim());
		pojo.setProduto_servico(converterVoParaPojo(vo.getProduto_servico()));
		pojo.setProjeto(converterVoParaPojo(vo.getProjeto()));
		pojo.setObservacao(vo.getObservacao());
		pojo.setTipo_atividade(converterVoParaPojo(vo.getTipo_atividade()));
		return pojo;
	}
	
	public ClienteVO converterPojoParaVo(Cliente pojo){
        return new ClienteConversor().converterPojoParaVo(pojo);
    }
    
    public Cliente converterVoParaPojo(ClienteVO vo){
        return new ClienteConversor().converterVoParaPojo(vo);
    }

    public MetodologiaVO converterPojoParaVo(Metodologia pojo){
        return new MetodologiaConversor().converterPojoParaVo(pojo);
    }
    
    public Metodologia converterVoParaPojo(MetodologiaVO vo){
        return new MetodologiaConversor().converterVoParaPojo(vo);
    }
    
    public OPVO converterPojoParaVo(OP pojo){
        return new OPConversor().converterPojoParaVo(pojo);
    }
    
    public OP converterVoParaPojo(OPVO vo){
        return new OPConversor().converterVoParaPojo(vo);
    }
    
    public Produto_ServicoVO converterPojoParaVo(Produto_Servico pojo){
        return new Produto_ServicoConversor().converterPojoParaVo(pojo);
    }
    
    public Produto_Servico converterVoParaPojo(Produto_ServicoVO vo){
        return new Produto_ServicoConversor().converterVoParaPojo(vo);
    }
    
    public ProjetoVO converterPojoParaVo(Projeto pojo){
        return new ProjetoConversor().converterPojoParaVo(pojo);
    }
    
    public Projeto converterVoParaPojo(ProjetoVO vo){
        return new ProjetoConversor().converterVoParaPojo(vo);
    }

    public Tipo_AtividadeVO converterPojoParaVo(Tipo_Atividade pojo){
        return new TipoAtividadeConversor().converterPojoParaVo(pojo);
    }
    
    public Tipo_Atividade converterVoParaPojo(Tipo_AtividadeVO vo){
        return new TipoAtividadeConversor().converterVoParaPojo(vo);
    }
	
}
