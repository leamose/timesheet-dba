package br.com.dba.timesheet.servicos;

import java.util.Date;
import java.util.List;

import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.RegistroJaCadastradoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;
import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.Configuracao;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.ProdutoServico;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.SituacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.TipoAtividade;
import br.com.dba.timesheet.pojo.TotalHorasMes;
import br.com.dba.timesheet.pojo.vo.HorasAtividadeVO;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;

/**
 * Este componente é responsável por manipular os dados do Timesheet.
 * 
 */
 public interface Timesheet {
	 
     /**
      * Lista todos os TipoAtividades.
      * @return
      * @throws ParametroInvalidoException
      */
	 List<TipoAtividade> listarTodosTipoAtividades(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 

	 /**
	  * Lista todos os SituacaoAtividade.
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<SituacaoAtividade> listarTodasSituacaoAtividade(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Lista todos os ProdutoServico.
      * @return
      * @throws ParametroInvalidoException
      */
	 List<ProdutoServico> listarTodosProdutoServico(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
     /**
      * Lista todos os Metodologia.
      * @return
      * @throws ParametroInvalidoException
      */
	 List<Metodologia> listarTodasMetodologias(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * Lista todos os TimeSheet's (Atividades)
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<TimeSheet> listarTodosTimeSheet(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Lista todos os TimeSheet's (Atividades) ordenado pela data de inicio.
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<TimeSheet> listarTodosTimeSheetOrdenadoPorDataHoraInicio(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Lista todos os Cliente. 
      * @return
      * @throws ParametroInvalidoException
      */
	 List<Cliente> listarTodosCliente(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Lista todos os OP. 
      * @return
      * @throws ParametroInvalidoException
      */
	 List<OP> listarTodasOPs(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Lista todos os Atividades. 
      * @return
      * @throws ParametroInvalidoException
      */
	 List<Atividade> listarTodosAtividades(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Lista todos os TimeSheetVO pelo mes e ano. 
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<TimeSheetVO> getListaTimeSheetVOPeloMesAno(String mes, String ano, Integer codigoFuncionario, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Lista todos os TimeSheetVO pelo mes e ano. 
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 TimeSheetVO getTimeSheetEAvaliacaoAtividadePorIdTimeSheet(Integer codigoTimeSheet, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Lista todos os TimeSheetVO. 
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<HorasAtividadeVO> getListaHorasAtividadeVO(Date data, Integer codigoFuncionario,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * Salva um TimeSheet(Atividade).
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 TimeSheet salvarTimeSheet(TimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException, RegistroJaCadastradoException;

	 /**
	  * Salva um AvaliacaoAtividade.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 AvaliacaoAtividade salvarAvaliacaoAtividade(AvaliacaoAtividade pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Salva um SituacaoAtividade.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 SituacaoAtividade salvarSituacaoAtividade(SituacaoAtividade pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Salva um HistoricoTimeSheet.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 HistoricoTimeSheet salvarHistoricoTimeSheet(HistoricoTimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Altera um TimeSheet(Atividade).
      * @param pojo
      * @return
      * @throws ParametroInvalidoException
      */
	 void alterarTimeSheet(TimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Altera um AvaliacaoAtividade.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 void alterarAvaliacaoAtividade(AvaliacaoAtividade pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Remove um TimeSheet(Atividade).
      * @param pojo
      * @return
      * @throws ParametroInvalidoException
      */
	 void removerTimeSheet(TimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Remove um HistoricoTimeSheet(Atividade).
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 void removerHistoricoTimeSheet(HistoricoTimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Remove um AvaliacaoAtividade.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 void removerAvaliacaoAtividade(AvaliacaoAtividade pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Salva um Projeto(Atividade).
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 Projeto salvarProjeto(Projeto pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * Altera um Projeto(Atividade).
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 void alterarProjeto(Projeto pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * Remove um Projeto(Atividade).
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 void removerProjeto(Projeto pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Efetua uma consulta pela chave primária do Funcionario.
      * @param id
      * @throws ParametroInvalidoException
      */     
	 Funcionario getFuncionario(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Efetua uma consulta pela chave primária do SituacaoAtividade.
	  * @param id
	  * @throws ParametroInvalidoException
	  */     
	 SituacaoAtividade getSituacaoAtividade(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Efetua uma consulta pela chave primária do AvaliacaoAtividade.
	  * @param id
	  * @throws ParametroInvalidoException
	  */     
	 AvaliacaoAtividade getAvaliacaoAtividade(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * Efetua uma consulta pela chave primária do Cliente.
	  * @param id
	  * @throws ParametroInvalidoException
	  */	 
	 Cliente getCliente(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Efetua uma consulta pela chave primária do Atividade.
      * @param id
      * @throws ParametroInvalidoException
      */     
	 Atividade getAtividade(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * Efetua uma consulta pela chave primária do OP.
	  * @param id
	  * @throws ParametroInvalidoException
	  */     
	 OP getOP(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * Efetua uma consulta pela chave primária do Metodologia.
	  * @param id
	  * @throws ParametroInvalidoException
	  */     
	 Metodologia getMetodologia(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Efetua uma consulta pela chave primária do ProdutoServico.
      * @param id
      * @throws ParametroInvalidoException
      */     
	 ProdutoServico getProdutoServico(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Efetua uma consulta pela chave primária do TimeSheet.
	  * @param id
	  * @throws ParametroInvalidoException
	  */     
	 TimeSheet getTimeSheet(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * Efetua uma consulta pelo codigo de Metodologia.
	  * @param id
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<ProdutoServico> consultarProdutoServicoPeloCodigoMetodologia(Integer codigo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;	 

	 /**
	  * Efetua uma consulta pelo codigo de funcionario pelo codigofuncionariochefe.
	  * @param id
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<Funcionario> consultaFuncionariosPeloCodigoFuncionarioChefe(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;	 
	 
	 /**
      * Efetua uma consulta pelo codigo de TimeSheet.
      * @param id
      * @return
      * @throws ParametroInvalidoException
      */
	 List<HistoricoTimeSheet> getHistoricoPeloCodigoTimeSheet(Integer codigo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Efetua uma consulta pela chave primária do HistoricoTimeSheet.
      * @param id
      * @return
      * @throws ParametroInvalidoException
      */
	 HistoricoTimeSheet getHistoricoTimeSheet(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
      * Efetua uma consulta pela Data Operacao e Tipo Operacao.
      * @param id
      * @return
      * @throws ParametroInvalidoException
      */
	 List<HistoricoTimeSheet> getHistoricoPelaDataOperacao(Date data,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * Efetua uma consulta pela Data.
	  * @param id
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<TimeSheet> consultarTimeSheetPorDataHoraInicio(Date dataInicio, Date dataFim,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * 
	  * @param codigo
	  * @param sessao
	  * @return
	  * @throws ParametroInvalidoException
	  * @throws SessaoInvalidaException
	  */
	 List<ProdutoServico> getProdutoServicoPeloCodigoMetodologia(Integer codigo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * 
	  * @param sessao
	  * @return
	  * @throws ParametroInvalidoException
	  * @throws SessaoInvalidaException
	  */
	 List<Configuracao> listarTodosConfiguracao(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * 
	  * @param pojo
	  * @param sessao
	  * @throws ParametroInvalidoException
	  * @throws SessaoInvalidaException
	  */
	 void alterarTotalHorasMes(TotalHorasMes pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * 
	  * @param pojo
	  * @param sessao
	  * @throws ParametroInvalidoException
	  * @throws SessaoInvalidaException
	  */
	 void alterarConfiguracao(Configuracao pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 /**
	  * 
	  * @param pojo
	  * @param sessao
	  * @return
	  * @throws ParametroInvalidoException
	  * @throws SessaoInvalidaException
	  */
	 boolean verificaAtividadeJaCadastrada(TimeSheet pojo, Sessao sessao)throws ParametroInvalidoException, SessaoInvalidaException ;
	 
	 /**
	  * Consulta uma AvaliacaoAtividade pelo codigoTimeSheet
	  * @param codigoTimesheet
	  * @param sessao
	  * @return
	  * @throws ParametroInvalidoException
	  * @throws SessaoInvalidaException
	  */
	 AvaliacaoAtividade getAvaliacaoAtividadePeloCodigoTimeSheet(Integer codigoTimesheet,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
}