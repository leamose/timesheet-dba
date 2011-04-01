package br.com.dba.timesheet.servicos;

import java.util.Date;
import java.util.List;

import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.IdentificadorSenhaIncorretosException;
import br.com.dba.timesheet.exceptions.LogonBloqueadoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
import br.com.dba.timesheet.exceptions.UsuarioNaoEncontradoException;
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
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.pojo.vo.HorasAtividadeVO;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;

/**
 * Este componente é responsável por manipular os dados do Timesheet.
 * 
 */
 public interface Seguranca {
	 

	 /**
	  * Altera um Usuario.
	  * @param pojo
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 void alterarUsuario(Usuario pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 
	 /**
      * Efetua uma consulta pela chave primária do Usuario.
      * @param id
      * @return
      * @throws ParametroInvalidoException
      */
	 Usuario getUsuario(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Efetua uma consulta pelo objeto Usuario.
	  * @param id
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 Usuario getUsuario(Usuario pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;

	 /**
	  * Efetua uma consulta de Usuario.
	  * @param id
	  * @return
	  * @throws ParametroInvalidoException
	  */
	 List<Usuario> consultarUsuario(Usuario pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException;
	 
	 
    /**
     * Método responsável por autenticar o usuário e verificar algumas informações de
     * acesso como permissão e disponibilidade de sessões para criação.
     * 
     * @param identificador
     * @param senha
     * @param nomeMaquina
     * @param ipMaquina
     * @return Sessao
     * @throws IdentificadorSenhaIncorretosException
     * @throws ParametroInvalidoException
     * @throws LogonBloqueadoException
     * @throws ErroInternoException
     */
	Sessao autenticarUsuario(String login, String senha)throws IdentificadorSenhaIncorretosException, ParametroInvalidoException, LogonBloqueadoException,
			ErroInternoException;
	
	/**
	 * Método para verificar se uma sessão ainda esta ativa.
	 * @param sessao
	 * @return
	 * @throws SessaoInvalidaException
	 */
	 boolean isSessaoValida(Sessao sessao) throws ParametroInvalidoException;
	 
}