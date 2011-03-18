package br.com.dba.timesheet.servicos;

import java.util.Date;
import java.util.List;

import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;
import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.ProdutoServico;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.SituacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.TipoAtividade;
import br.com.dba.timesheet.pojo.Usuario;
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
	 List<TipoAtividade> listarTodosTipoAtividades() throws ParametroInvalidoException;
	 

	 /**
	  * Lista todos os SituacaoAtividade.
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<SituacaoAtividade> listarTodasSituacaoAtividade() throws ParametroInvalidoException;
	 
	 /**
      * Lista todos os ProdutoServico.
      * @return
      * @throws ParametroInvalidoException
      */
	 List<ProdutoServico> listarTodosProdutoServico() throws ParametroInvalidoException;
	 
     /**
      * Lista todos os Metodologia.
      * @return
      * @throws ParametroInvalidoException
      */
	 List<Metodologia> listarTodasMetodologias() throws ParametroInvalidoException;
	 
	 /**
	  * Lista todos os TimeSheet's (Atividades)
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<TimeSheet> listarTodosTimeSheet() throws ParametroInvalidoException;

	 /**
	  * Lista todos os TimeSheet's (Atividades) ordenado pela data de inicio.
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<TimeSheet> listarTodosTimeSheetOrdenadoPorDataHoraInicio()throws ParametroInvalidoException;
	 
	 /**
      * Lista todos os Cliente. 
      * @return
      * @throws ParametroInvalidoException
      */
	 List<Cliente> listarTodosCliente() throws ParametroInvalidoException;
	 
	 /**
      * Lista todos os OP. 
      * @return
      * @throws ParametroInvalidoException
      */
	 List<OP> listarTodasOPs() throws ParametroInvalidoException;
	 
	 /**
      * Lista todos os Atividades. 
      * @return
      * @throws ParametroInvalidoException
      */
	 List<Atividade> listarTodosAtividades() throws ParametroInvalidoException;

	 /**
	  * Lista todos os TimeSheetVO. 
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<TimeSheetVO> getListaTimeSheetVO(Date dataInicio, Date dataFim) throws ParametroInvalidoException;
	 
	 /**
	  * Salva um TimeSheet(Atividade).
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 TimeSheet salvarTimeSheet(TimeSheet pojo) throws ParametroInvalidoException;

	 /**
	  * Salva um AvaliacaoAtividade.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 AvaliacaoAtividade salvarAvaliacaoAtividade(AvaliacaoAtividade pojo) throws ParametroInvalidoException;

	 /**
	  * Salva um SituacaoAtividade.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 SituacaoAtividade salvarSituacaoAtividade(SituacaoAtividade pojo) throws ParametroInvalidoException;

	 /**
	  * Salva um HistoricoTimeSheet.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 HistoricoTimeSheet salvarHistoricoTimeSheet(HistoricoTimeSheet pojo) throws ParametroInvalidoException;
	 
	 /**
      * Altera um TimeSheet(Atividade).
      * @param pojo
      * @return
      * @throws ParametroInvalidoException
      */
	 void alterarTimeSheet(TimeSheet pojo) throws ParametroInvalidoException;

	 /**
	  * Altera um AvaliacaoAtividade.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 void alterarAvaliacaoAtividade(AvaliacaoAtividade pojo) throws ParametroInvalidoException;
	 
	 /**
      * Remove um TimeSheet(Atividade).
      * @param pojo
      * @return
      * @throws ParametroInvalidoException
      */
	 void removerTimeSheet(TimeSheet pojo) throws ParametroInvalidoException;

	 /**
	  * Remove um AvaliacaoAtividade.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 void removerAvaliacaoAtividade(AvaliacaoAtividade pojo) throws ParametroInvalidoException;

	 /**
	  * Salva um Projeto(Atividade).
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 Projeto salvarProjeto(Projeto pojo) throws ParametroInvalidoException;
	 
	 /**
	  * Altera um Projeto(Atividade).
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 void alterarProjeto(Projeto pojo) throws ParametroInvalidoException;
	 
	 /**
	  * Remove um Projeto(Atividade).
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 void removerProjeto(Projeto pojo) throws ParametroInvalidoException;
	 
	 /**
      * Efetua uma consulta pela chave primária do Funcionario.
      * @param id
      * @throws ParametroInvalidoException
      */     
	 Funcionario getFuncionario(Integer id) throws ParametroInvalidoException;

	 /**
	  * Efetua uma consulta pela chave primária do SituacaoAtividade.
	  * @param id
	  * @throws ParametroInvalidoException
	  */     
	 SituacaoAtividade getSituacaoAtividade(Integer id) throws ParametroInvalidoException;
	 
	 /**
	  * Efetua uma consulta pela chave primária do Cliente.
	  * @param id
	  * @throws ParametroInvalidoException
	  */	 
	 Cliente getCliente(Integer id) throws ParametroInvalidoException;
	 
	 /**
      * Efetua uma consulta pela chave primária do Atividade.
      * @param id
      * @throws ParametroInvalidoException
      */     
	 Atividade getAtividade(Integer id) throws ParametroInvalidoException;
	 
	 /**
	  * Efetua uma consulta pela chave primária do OP.
	  * @param id
	  * @throws ParametroInvalidoException
	  */     
	 OP getOP(Integer id) throws ParametroInvalidoException;
	 
	 /**
	  * Efetua uma consulta pela chave primária do Metodologia.
	  * @param id
	  * @throws ParametroInvalidoException
	  */     
	 Metodologia getMetodologia(Integer id) throws ParametroInvalidoException;
	 
	 /**
      * Efetua uma consulta pela chave primária do ProdutoServico.
      * @param id
      * @throws ParametroInvalidoException
      */     
	 ProdutoServico getProdutoServico(Integer id) throws ParametroInvalidoException;

	 /**
	  * Efetua uma consulta pela chave primária do TimeSheet.
	  * @param id
	  * @throws ParametroInvalidoException
	  */     
	 TimeSheet getTimeSheet(Integer id) throws ParametroInvalidoException;
	 
	 /**
	  * Efetua uma consulta pelo codigo de Metodologia.
	  * @param id
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<ProdutoServico> consultarProdutoServicoPeloCodigoMetodologia(Integer codigo) throws ParametroInvalidoException;	 
	 
	 /**
      * Efetua uma consulta pelo codigo de TimeSheet.
      * @param id
      * @return
      * @throws ParametroInvalidoException
      */
	 List<HistoricoTimeSheet> getHistoricoPeloCodigoTimeSheet(Integer codigo)throws ParametroInvalidoException;
	 
	 /**
      * Efetua uma consulta pela chave primária do HistoricoTimeSheet.
      * @param id
      * @return
      * @throws ParametroInvalidoException
      */
	 HistoricoTimeSheet getHistoricoTimeSheet(Integer id) throws ParametroInvalidoException;
	 
	 /**
      * Efetua uma consulta pela chave primária do Usuario.
      * @param id
      * @return
      * @throws ParametroInvalidoException
      */
	 Usuario getUsuario(Integer id) throws ParametroInvalidoException;

	 /**
	  * Efetua uma consulta de Usuario.
	  * @param id
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<Usuario> consultarUsuario(Usuario pojo) throws ParametroInvalidoException;
	 
	 /**
      * Efetua uma consulta pela Data Operacao e Tipo Operacao.
      * @param id
      * @return
      * @throws ParametroInvalidoException
      */
	 List<HistoricoTimeSheet> getHistoricoPelaDataOperacao(Date data)throws ParametroInvalidoException;
	 
	 /**
	  * Efetua uma consulta pela Data.
	  * @param id
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<TimeSheet> consultarTimeSheetPorDataHoraInicio(Date dataInicio, Date dataFim) throws ParametroInvalidoException;
	 
	 List<ProdutoServico> getProdutoServicoPeloCodigoMetodologia(Integer codigo) throws ParametroInvalidoException;
	 
}