/*
 * Gerado pelo XDoclet - Não edite!
 */
package br.com.dba.timesheet.ejb;

/**
 * Interface Remota para TimesheetFacade.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface TimesheetFacade
   extends javax.ejb.EJBObject
{

   public java.util.List listarTodosTipoAtividades( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List listarTodosProdutoServico( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List listarTodasOPs( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List listarTodasMetodologias( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List listarTodosCliente( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List listarTodosTimeSheet( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List listarTodasSituacaoAtividade( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List listarTodosTimeSheetOrdenadoPorDataHoraInicio( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List consultarTimeSheetPorDataHoraInicio( java.util.Date dataInicio,java.util.Date dataFim,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List listarTodosAtividades( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.TimeSheet salvarTimeSheet( br.com.dba.timesheet.pojo.TimeSheet pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, br.com.dba.timesheet.exceptions.RegistroJaCadastradoException, java.rmi.RemoteException;

   public boolean verificaAtividadeJaCadastrada( br.com.dba.timesheet.pojo.TimeSheet pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.SituacaoAtividade salvarSituacaoAtividade( br.com.dba.timesheet.pojo.SituacaoAtividade pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.AvaliacaoAtividade salvarAvaliacaoAtividade( br.com.dba.timesheet.pojo.AvaliacaoAtividade pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public void alterarAvaliacaoAtividade( br.com.dba.timesheet.pojo.AvaliacaoAtividade pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public void removerAvaliacaoAtividade( br.com.dba.timesheet.pojo.AvaliacaoAtividade pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.HistoricoTimeSheet salvarHistoricoTimeSheet( br.com.dba.timesheet.pojo.HistoricoTimeSheet pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public void alterarTimeSheet( br.com.dba.timesheet.pojo.TimeSheet pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public void removerTimeSheet( br.com.dba.timesheet.pojo.TimeSheet pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public void removerHistoricoTimeSheet( br.com.dba.timesheet.pojo.HistoricoTimeSheet pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List consultarProdutoServicoPeloCodigoMetodologia( java.lang.Integer codigo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.SituacaoAtividade getSituacaoAtividade( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List listarTodosConfiguracao( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.Funcionario getFuncionario( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List consultaFuncionariosPeloCodigoFuncionarioChefe( java.lang.Integer codigoFuncionarioChefe,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.Cliente getCliente( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.Atividade getAtividade( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.OP getOP( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.Metodologia getMetodologia( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.ProdutoServico getProdutoServico( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.TimeSheet getTimeSheet( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.AvaliacaoAtividade getAvaliacaoAtividade( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.AvaliacaoAtividade getAvaliacaoAtividadePeloCodigoTimeSheet( java.lang.Integer codigoTimesheet,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.HistoricoTimeSheet getHistoricoTimeSheet( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List getHistoricoPeloCodigoTimeSheet( java.lang.Integer codigo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List getHistoricoPelaDataOperacao( java.util.Date data,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.Projeto salvarProjeto( br.com.dba.timesheet.pojo.Projeto pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public void alterarTotalHorasMes( br.com.dba.timesheet.pojo.TotalHorasMes pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public void alterarConfiguracao( br.com.dba.timesheet.pojo.Configuracao pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public void alterarProjeto( br.com.dba.timesheet.pojo.Projeto pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public void removerProjeto( br.com.dba.timesheet.pojo.Projeto pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List getListaTimeSheetVO( java.util.Date dataInicio,java.util.Date dataFim,java.lang.Integer codigoFuncionario,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.vo.TimeSheetVO getTimeSheetEAvaliacaoAtividadePorIdTimeSheet( java.lang.Integer codigoTimeSheet,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List getListaTimeSheetVOPeloMesAno( java.lang.String mes,java.lang.String ano,java.lang.Integer codigoFuncionario,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List getListaHorasAtividadeVO( java.util.Date data,java.lang.Integer codigoFuncionario,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List getProdutoServicoPeloCodigoMetodologia( java.lang.Integer codigo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

}
