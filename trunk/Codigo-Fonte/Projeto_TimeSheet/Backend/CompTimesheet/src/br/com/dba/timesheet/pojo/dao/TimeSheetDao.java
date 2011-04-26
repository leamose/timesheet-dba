package br.com.dba.timesheet.pojo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.vo.HorasAtividadeVO;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;
import br.com.dba.timesheet.util.StringUtil;
import br.com.dba.timesheet.util.UtilDate;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class TimeSheetDao extends AbstractHibernateDAO<TimeSheet, Integer> {

	private SessionFactory sessionFactory;
	
	protected TimeSheetDao(SessionFactory sf) {
		super(sf);
		sessionFactory = sf;
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<TimeSheet> doGetClass() {
		return TimeSheet.class;
	}
    
	
	@SuppressWarnings({ "unchecked"})
    public List<TimeSheet> listaTodosTimeSheetOrdenadoPorDataHoraInicio()throws ParametroInvalidoException, DAOException{
		Criteria query = getSession().createCriteria(TimeSheet.class);
        query.addOrder(Order.asc("dataHoraInicio"));
        
        List resultado = query.list();
        
        return resultado != null && !resultado.isEmpty() ? resultado:null;
    }

    @SuppressWarnings("unchecked")
	public List<TimeSheet> consultarTimeSheetPorDataHoraInicio(Date dataInicio, Date dataFim) throws ParametroInvalidoException, DAOException{
        Criteria query = getSession().createCriteria(TimeSheet.class);
        query.add(Restrictions.between("dataHoraInicio", dataInicio, dataFim));
        query.addOrder(Order.asc("dataHoraInicio"));
        
        List resultado = query.list();
        
        return resultado != null && !resultado.isEmpty() ? resultado:null;
    }

    @SuppressWarnings("unchecked")
    public TimeSheetVO getTimeSheetEAvaliacaoAtividadePorIdTimeSheet(Integer codigoTimeSheet) throws ParametroInvalidoException, DAOException{
    	 StringBuilder hql = new StringBuilder(); 
         List<TimeSheetVO> lista = new ArrayList<TimeSheetVO>();
         try { 
 	        hql.append("SELECT timeSheet.codigoTimesheet, " +
 	              "timeSheet.dataHoraInicio, timeSheet.dataHoraFim, timeSheet.observacao, " +
 	              "timeSheet.outrasAtividades, timeSheet.indicaAlteracaoDataAvaliacao, timeSheet.codigoatividade, " +
 	              "timeSheet.codigoprodutoServico, timeSheet.codigoprojeto, timeSheet.codigometodologia, timeSheet.codigoop, " +
 	              "timeSheet.codigofuncionario, timeSheet.codigocliente," +
 	              "historico.codigohistoricotimesheet, historico.dataOperacao, historico.tipoOperacao," +
 	              "historico.codigousuario, historico.codigotimeSheet, " +
 	              "avaliacao.codigoavaliacaoatividade, " +
 	              " projeto.nome, projeto.numeroProjeto, usuario10_.login, atividade3_.descricao as descricaoAtividade, produtoser4_.descricao " +
 	              "   FROM TS.HistoricoTimeSheet historico " +
 	              "   INNER JOIN (select codigotimesheet, max(codigohistoricotimesheet) as codigohistoricotimesheet FROM TS.HistoricoTimeSheet " + 	              
 	              "  GROUP BY codigotimesheet) hts2 on historico.codigotimesheet=hts2.codigotimesheet and historico.codigohistoricotimesheet=hts2.codigohistoricotimesheet" +
 	              "   INNER JOIN TS.timeSheet timesheet on historico.codigoTimeSheet=timesheet.codigoTimeSheet AND timeSheet.codigoTimeSheet = " + codigoTimeSheet +
 	              "   LEFT JOIN TS.usuario usuario10_ on historico.codigousuario=usuario10_.codigoUsuario " +
 	              "   INNER JOIN TS.atividade atividade3_ on timesheet.codigoAtividade=atividade3_.codigoAtividade" + 
 	              "   INNER JOIN TS.produtoServico produtoser4_ on timesheet.codigoProdutoServico=produtoser4_.codigoProdutoServico" + 
 	              "   INNER JOIN TS.projeto projeto on timesheet.codigoProjeto=projeto.codigoProjeto " +
 	              "   INNER JOIN TS.metodologia metodologi6_ on timesheet.codigoMetodologia=metodologi6_.codigoMetodologia" + 
 	              "   INNER JOIN TS.op op7_ on timesheet.codigoOp=op7_.codigoOP " +
 	              "   INNER JOIN TS.funcionario funcionari8_ on timesheet.codigoFuncionario=funcionari8_.codigoFuncionario" + 
 	              "   INNER JOIN TS.cliente cliente9_ on timesheet.codigoCliente=cliente9_.codigoCliente" +
 	              "   LEFT JOIN (select codigotimesheet, max(codigoavaliacaoatividade) as codigoavaliacaoatividade FROM TS.avaliacaoAtividade" +
 	              " GROUP BY codigotimesheet) avaliacao on timesheet.codigoTimeSheet=avaliacao.codigoTimeSheet" +
 	              " ORDER BY timeSheet.dataHoraInicio" );
           
         
         PreparedStatement query  = null;      
         Connection conexao = getSession().connection();
         
         query = conexao.prepareStatement(hql.toString());
         
         ResultSet resultado = query.executeQuery();           
         
         while(resultado.next()){
             TimeSheetVO vo = new TimeSheetVO();
             
             vo.setCodigoTimeSheet(resultado.getInt("codigoTimeSheet")); 
             vo.setDataHoraInicio(resultado.getTimestamp("dataHoraInicio")); 
             vo.setDataHoraFim(resultado.getTimestamp("dataHoraFim")); 
             vo.setObservacao(resultado.getString("observacao")); 
             vo.setOutrasAtividades(resultado.getString("outrasAtividades")); 
             vo.setIndicaAlteracaoDataAvaliacao(resultado.getBoolean("indicaAlteracaoDataAvaliacao")); 
             vo.setCodigoAtividade(resultado.getInt("codigoatividade")); 
             vo.setCodigoProdutoServico(resultado.getInt("codigoprodutoServico")); 
             vo.setCodigoProjeto(resultado.getInt("codigoprojeto")); 
             vo.setCodigoMetodologia(resultado.getInt("codigometodologia")); 
             vo.setCodigoOp(resultado.getInt("codigoop")); 
             vo.setCodigoFuncionario(resultado.getInt("codigofuncionario")); 
             vo.setCodigoCliente(resultado.getInt("codigocliente")); 
             vo.setCodigoHistoricoTimeSheet(resultado.getInt("codigoHistoricoTimeSheet")); 
             vo.setDataOperacao(resultado.getTimestamp("dataOperacao")); 
             vo.setTipoOperacao(resultado.getString("tipoOperacao")); 
             vo.setCodigoUsuario(resultado.getInt("codigousuario"));
             
             vo.setCodigoAvaliacaoTimeSheet(resultado.getInt("codigoAvaliacaoAtividade"));
             if(vo.getCodigoAvaliacaoTimeSheet()!=null && vo.getCodigoAvaliacaoTimeSheet()!=0){
             	
             	AvaliacaoAtividadeDao avaliacaoDao = new AvaliacaoAtividadeDao(sessionFactory);
             	
             	//RECUPERA A AVALIACAO DA ATIVIDADE.
             	AvaliacaoAtividade avaliacaoAtividade = avaliacaoDao.get(vo.getCodigoAvaliacaoTimeSheet());
             	
 	            vo.setObservacaoAvaliacaoAtividade(avaliacaoAtividade.getObservacao()); 
 	            vo.setObservacaoPrivada(avaliacaoAtividade.getObservacaoPrivada()); 
 	            vo.setDataInicio(avaliacaoAtividade.getDataInicio()); 
 	            vo.setDataFim(avaliacaoAtividade.getDataFim()); 
 	            vo.setCodigoSituacaoAtividade(avaliacaoAtividade.getSituacaoAtividade()!=null?avaliacaoAtividade.getSituacaoAtividade().getId():null); 
 	            vo.setCodigoFuncionarioAvaliador(avaliacaoAtividade.getFuncionarioAvaliador()!=null ? avaliacaoAtividade.getFuncionarioAvaliador().getId():null);
             }
             
             
             
             vo.setNomeProjeto(resultado.getString("nome"));
             vo.setNumeroProjeto(resultado.getInt("numeroProjeto"));
             vo.setLogin(resultado.getString("login"));
             vo.setDescricaoAtividade(resultado.getString("descricaoAtividade"));
             vo.setDescricaoProduto(resultado.getString("descricao"));
             
             lista.add(vo);
             
         }
         
         
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return !lista.isEmpty() ? lista.get(0):null;
     }
    
    @SuppressWarnings("deprecation")
	public List<TimeSheetVO> getListaTimeSheetVO(Date dataInicio, Date dataFim, Integer codigoFuncionario) throws DAOException {
        StringBuilder hql = new StringBuilder(); 
        List<TimeSheetVO> lista = new ArrayList<TimeSheetVO>();
        try { 
	        hql.append("SELECT timeSheet.codigoTimesheet, " +
	              "timeSheet.dataHoraInicio, timeSheet.dataHoraFim, timeSheet.observacao, " +
	              "timeSheet.outrasAtividades, timeSheet.indicaAlteracaoDataAvaliacao, timeSheet.codigoatividade, " +
	              "timeSheet.codigoprodutoServico, timeSheet.codigoprojeto, timeSheet.codigometodologia, timeSheet.codigoop, " +
	              "timeSheet.codigofuncionario, timeSheet.codigocliente," +
	              "historico.codigohistoricotimesheet, historico.dataOperacao, historico.tipoOperacao," +
	              "historico.codigousuario, historico.codigotimeSheet, " +
	              "avaliacao.codigoavaliacaoatividade, " +
//	              "	avaliacao.observacao, avaliacao.observacaoPrivada, avaliacao.dataInicio, " +
//	              " avaliacao.dataFim, avaliacao.codigosituacaoAtividade, avaliacao.codigofuncionarioAvaliador," +
	              " projeto.nome, projeto.numeroProjeto, usuario10_.login, atividade3_.descricao as descricaoAtividade, produtoser4_.descricao " +
	              "   FROM TS.HistoricoTimeSheet historico " +
	              "   INNER JOIN (select codigotimesheet, max(codigohistoricotimesheet) as codigohistoricotimesheet FROM TS.HistoricoTimeSheet " +
	              "     WHERE datahorainicio between '" + dataInicio + "' and '" + dataFim + "' " +
	              "  GROUP BY codigotimesheet) hts2 on historico.codigotimesheet=hts2.codigotimesheet and historico.codigohistoricotimesheet=hts2.codigohistoricotimesheet" +
	              "   INNER JOIN TS.timeSheet timesheet on historico.codigoTimeSheet=timesheet.codigoTimeSheet AND timeSheet.codigofuncionario = " + codigoFuncionario +
	              "   LEFT JOIN TS.usuario usuario10_ on historico.codigousuario=usuario10_.codigoUsuario " +
	              "   INNER JOIN TS.atividade atividade3_ on timesheet.codigoAtividade=atividade3_.codigoAtividade" + 
	              "   INNER JOIN TS.produtoServico produtoser4_ on timesheet.codigoProdutoServico=produtoser4_.codigoProdutoServico" + 
	              "   INNER JOIN TS.projeto projeto on timesheet.codigoProjeto=projeto.codigoProjeto " +
	              "   INNER JOIN TS.metodologia metodologi6_ on timesheet.codigoMetodologia=metodologi6_.codigoMetodologia" + 
	              "   INNER JOIN TS.op op7_ on timesheet.codigoOp=op7_.codigoOP " +
	              "   INNER JOIN TS.funcionario funcionari8_ on timesheet.codigoFuncionario=funcionari8_.codigoFuncionario" + 
	              "   INNER JOIN TS.cliente cliente9_ on timesheet.codigoCliente=cliente9_.codigoCliente" +
	              "   LEFT JOIN (select codigotimesheet, max(codigoavaliacaoatividade) as codigoavaliacaoatividade FROM TS.avaliacaoAtividade" +
	              " GROUP BY codigotimesheet) avaliacao on timesheet.codigoTimeSheet=avaliacao.codigoTimeSheet" +
	              " ORDER BY timeSheet.dataHoraInicio" );
          
        
//        Query query=getSession().createSQLQuery(hql.toString()); 
//          
//          List<TimeSheetVO> lista = query.list();
        
        
        PreparedStatement query  = null;      
        Connection conexao = getSession().connection();
        
          query = conexao.prepareStatement(hql.toString());
        
        ResultSet resultado = query.executeQuery();           
        
        while(resultado.next()){
            TimeSheetVO vo = new TimeSheetVO();
            
            vo.setCodigoTimeSheet(resultado.getInt("codigoTimeSheet")); 
            vo.setDataHoraInicio(resultado.getTimestamp("dataHoraInicio")); 
            vo.setDataHoraFim(resultado.getTimestamp("dataHoraFim")); 
            vo.setObservacao(resultado.getString("observacao")); 
            vo.setOutrasAtividades(resultado.getString("outrasAtividades")); 
            vo.setIndicaAlteracaoDataAvaliacao(resultado.getBoolean("indicaAlteracaoDataAvaliacao")); 
            vo.setCodigoAtividade(resultado.getInt("codigoatividade")); 
            vo.setCodigoProdutoServico(resultado.getInt("codigoprodutoServico")); 
            vo.setCodigoProjeto(resultado.getInt("codigoprojeto")); 
            vo.setCodigoMetodologia(resultado.getInt("codigometodologia")); 
            vo.setCodigoOp(resultado.getInt("codigoop")); 
            vo.setCodigoFuncionario(resultado.getInt("codigofuncionario")); 
            vo.setCodigoCliente(resultado.getInt("codigocliente")); 
            vo.setCodigoHistoricoTimeSheet(resultado.getInt("codigoHistoricoTimeSheet")); 
            vo.setDataOperacao(resultado.getTimestamp("dataOperacao")); 
            vo.setTipoOperacao(resultado.getString("tipoOperacao")); 
            vo.setCodigoUsuario(resultado.getInt("codigousuario"));
            
            vo.setCodigoAvaliacaoTimeSheet(resultado.getInt("codigoAvaliacaoAtividade"));
            if(vo.getCodigoAvaliacaoTimeSheet()!=null && vo.getCodigoAvaliacaoTimeSheet()!=0){
            	
            	AvaliacaoAtividadeDao avaliacaoDao = new AvaliacaoAtividadeDao(sessionFactory);
            	
            	//RECUPERA A AVALIACAO DA ATIVIDADE.
            	AvaliacaoAtividade avaliacaoAtividade = avaliacaoDao.get(vo.getCodigoAvaliacaoTimeSheet());
            	
	            vo.setObservacaoAvaliacaoAtividade(avaliacaoAtividade.getObservacao()); 
	            vo.setObservacaoPrivada(avaliacaoAtividade.getObservacaoPrivada()); 
	            vo.setDataInicio(avaliacaoAtividade.getDataInicio()); 
	            vo.setDataFim(avaliacaoAtividade.getDataFim()); 
	            vo.setCodigoSituacaoAtividade(avaliacaoAtividade.getSituacaoAtividade()!=null?avaliacaoAtividade.getSituacaoAtividade().getId():null); 
	            vo.setCodigoFuncionarioAvaliador(avaliacaoAtividade.getFuncionarioAvaliador()!=null ? avaliacaoAtividade.getFuncionarioAvaliador().getId():null);
            }
            
            
            
            vo.setNomeProjeto(resultado.getString("nome"));
            vo.setNumeroProjeto(resultado.getInt("numeroProjeto"));
            vo.setLogin(resultado.getString("login"));
            vo.setDescricaoAtividade(resultado.getString("descricaoAtividade"));
            vo.setDescricaoProduto(resultado.getString("descricao"));
            
            lista.add(vo);
            
        }
        
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
         	return lista;
    }

    @SuppressWarnings("deprecation")
    public List<TimeSheetVO> getListaTimeSheet(Date dataInicio, Date dataFim, Integer codigoFuncionario) throws DAOException {
    	StringBuilder hql = new StringBuilder(); 
    	List<TimeSheetVO> lista = new ArrayList<TimeSheetVO>();
    	try { 
    		hql.append("select count(*) FROM TS.HistoricoTimeSheet " +
    		" WHERE  '" + dataFim +"' between datahorainicio and datahorafim " +
    		" OR '" + dataFim +"' between datahorainicio and datahorafim  GROUP BY codigotimesheet, datahorainicio" );
    		
    		PreparedStatement query  = null;      
    		Connection conexao = getSession().connection();
    		
    		query = conexao.prepareStatement(hql.toString());
    		
    		ResultSet resultado = query.executeQuery();           
    		
    		while(resultado.next()){
    			TimeSheetVO vo = new TimeSheetVO();
    			
    			vo.setCodigoTimeSheet(resultado.getInt("count"));
    			
    			lista.add(vo);
    			
    		}
    		
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return lista;
    }
    
    @SuppressWarnings("deprecation")
	public List<TimeSheetVO> getListaTimeSheetVOPeloMesAno(String mes, String ano, Integer codigoFuncionario) throws DAOException {
    	StringBuilder hql = new StringBuilder(); 
    	List<TimeSheetVO> lista = new ArrayList<TimeSheetVO>();
    	try { 
    		hql.append("SELECT timeSheet.codigoTimesheet, " +
    				"timeSheet.dataHoraInicio, timeSheet.dataHoraFim, timeSheet.observacao, " +
    				"timeSheet.outrasAtividades, timeSheet.indicaAlteracaoDataAvaliacao, timeSheet.codigoatividade, " +
    				"timeSheet.codigoprodutoServico, timeSheet.codigoprojeto, timeSheet.codigometodologia, timeSheet.codigoop, " +
    				"timeSheet.codigofuncionario, timeSheet.codigocliente," +
    				"historico.codigohistoricotimesheet, historico.dataOperacao, historico.tipoOperacao," +
    				"historico.codigousuario, historico.codigotimeSheet, " +
    				"avaliacao.codigoavaliacaoatividade, avaliacao.observacao as observacaoAvaliacao, avaliacao.observacaoPrivada, avaliacao.dataInicio, " +
    				"avaliacao.dataFim, avaliacao.codigosituacaoAtividade, avaliacao.codigofuncionarioAvaliador," +
    				"projeto.nome, projeto.numeroProjeto, usuario10_.login, atividade3_.descricao  as descricaoAtividade, produtoser4_.descricao " +
    				"   FROM TS.HistoricoTimeSheet historico " +
    				"   INNER JOIN (select codigotimesheet, max(codigohistoricotimesheet) as codigohistoricotimesheet FROM TS.HistoricoTimeSheet " +
//    				"     WHERE datahorainicio between '" + dataInicio + "' and '" + dataFim + "' " +
    				"     WHERE date_part('year', datahorainicio)  = " + ano + " and  date_part('month', datahorainicio)=" + mes + " " +
    				"  GROUP BY codigotimesheet) hts2 on historico.codigotimesheet=hts2.codigotimesheet and historico.codigohistoricotimesheet=hts2.codigohistoricotimesheet" +
    				"   INNER JOIN TS.timeSheet timesheet on historico.codigoTimeSheet=timesheet.codigoTimeSheet AND timeSheet.codigofuncionario = " + codigoFuncionario +
    				"   LEFT JOIN TS.usuario usuario10_ on historico.codigousuario=usuario10_.codigoUsuario " +
    				"   INNER JOIN TS.atividade atividade3_ on timesheet.codigoAtividade=atividade3_.codigoAtividade" + 
    				"   INNER JOIN TS.produtoServico produtoser4_ on timesheet.codigoProdutoServico=produtoser4_.codigoProdutoServico" + 
    				"   INNER JOIN TS.projeto projeto on timesheet.codigoProjeto=projeto.codigoProjeto " +
    				"   INNER JOIN TS.metodologia metodologi6_ on timesheet.codigoMetodologia=metodologi6_.codigoMetodologia" + 
    				"   INNER JOIN TS.op op7_ on timesheet.codigoOp=op7_.codigoOP " +
    				"   INNER JOIN TS.funcionario funcionari8_ on timesheet.codigoFuncionario=funcionari8_.codigoFuncionario" + 
    				"   INNER JOIN TS.cliente cliente9_ on timesheet.codigoCliente=cliente9_.codigoCliente" +
    				"   LEFT JOIN TS.avaliacaoAtividade avaliacao on timesheet.codigoTimeSheet=avaliacao.codigoTimeSheet" +
    		" ORDER BY timeSheet.dataHoraInicio" );
    		
    		
//        Query query=getSession().createSQLQuery(hql.toString()); 
//          
//          List<TimeSheetVO> lista = query.list();
    		
    		
    		PreparedStatement query  = null;      
    		Connection conexao = getSession().connection();
    		
    		query = conexao.prepareStatement(hql.toString());
    		
    		ResultSet resultado = query.executeQuery();           
    		
    		while(resultado.next()){
    			TimeSheetVO vo = new TimeSheetVO();
    			
    			vo.setCodigoTimeSheet(resultado.getInt("codigoTimeSheet")); 
    			vo.setDataHoraInicio(resultado.getTimestamp("dataHoraInicio")); 
    			vo.setDataHoraFim(resultado.getTimestamp("dataHoraFim")); 
    			vo.setObservacao(resultado.getString("observacao")); 
    			vo.setOutrasAtividades(resultado.getString("outrasAtividades")); 
    			vo.setIndicaAlteracaoDataAvaliacao(resultado.getBoolean("indicaAlteracaoDataAvaliacao")); 
    			vo.setCodigoAtividade(resultado.getInt("codigoatividade")); 
    			vo.setCodigoProdutoServico(resultado.getInt("codigoprodutoServico")); 
    			vo.setCodigoProjeto(resultado.getInt("codigoprojeto")); 
    			vo.setCodigoMetodologia(resultado.getInt("codigometodologia")); 
    			vo.setCodigoOp(resultado.getInt("codigoop")); 
    			vo.setCodigoFuncionario(resultado.getInt("codigofuncionario")); 
    			vo.setCodigoCliente(resultado.getInt("codigocliente")); 
    			vo.setCodigoHistoricoTimeSheet(resultado.getInt("codigoHistoricoTimeSheet")); 
    			vo.setDataOperacao(resultado.getTimestamp("dataOperacao")); 
    			vo.setTipoOperacao(resultado.getString("tipoOperacao")); 
    			vo.setCodigoUsuario(resultado.getInt("codigousuario"));
    			vo.setCodigoAvaliacaoTimeSheet(resultado.getInt("codigoAvaliacaoAtividade")); 
    			vo.setObservacaoAvaliacaoAtividade(resultado.getString("observacaoAvaliacao")); 
    			vo.setObservacaoPrivada(resultado.getString("observacaoPrivada")); 
    			vo.setDataInicio(resultado.getTimestamp("dataInicio")); 
    			vo.setDataFim(resultado.getTimestamp("dataFim")); 
    			vo.setCodigoSituacaoAtividade(resultado.getInt("codigosituacaoAtividade")); 
    			vo.setCodigoFuncionarioAvaliador(resultado.getInt("codigofuncionarioAvaliador"));
    			vo.setNomeProjeto(resultado.getString("nome"));
    			vo.setNumeroProjeto(resultado.getInt("numeroProjeto"));
    			vo.setLogin(resultado.getString("login"));
    			vo.setDescricaoAtividade(resultado.getString("descricaoAtividade"));
    			vo.setDescricaoProduto(resultado.getString("descricao"));
    			
    			lista.add(vo);
    			
    		}
    		
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return lista;
    }

    @SuppressWarnings({ "deprecation" })
    public List<HorasAtividadeVO> getListaHorasAtividadeVO(Integer ano, Integer mes, Integer codigofuncionario) throws DAOException {
    	StringBuilder hql = new StringBuilder(); 
    	List<HorasAtividadeVO> lista = new ArrayList<HorasAtividadeVO>();
    	try { 
    		hql.append("select  date_part('year', datahorainicio) as ano, " +
    				" date_part('month', datahorainicio)as mes," +
    				" date_part('day', datahorainicio)as dia," +
    				" sum(datahorafim - datahorainicio) as horasTrabalhadas," +
    				" interval '8 hours' - sum(datahorafim - datahorainicio) as cargaHoraria" +
    				" from ts.timesheet where date_part('year', datahorainicio)  = " + ano +
    				" and date_part('month', datahorainicio)=" + mes +
    				" and codigofuncionario=" + codigofuncionario +
    				" group by date_part('year', datahorainicio), date_part('month', datahorainicio), date_part('day', datahorainicio)" +
    				" order by date_part('year', datahorainicio), date_part('month', datahorainicio), date_part('day', datahorainicio)");
    		
    		PreparedStatement query  = null;      
    		Connection conexao = getSession().connection();
    		
    		query = conexao.prepareStatement(hql.toString());
    		
    		ResultSet resultado = query.executeQuery();
    		
    		while(resultado.next()){    			
    			HorasAtividadeVO vo = new HorasAtividadeVO();
    			
    			vo.setAno(resultado.getInt("ano")); 
    			vo.setDia(resultado.getInt("dia")); 
    			vo.setMes(resultado.getInt("mes")); 
    			if(resultado.getString("horasTrabalhadas")!=null){
    				vo.setHorasTrabalhadas(resultado.getString("horasTrabalhadas").substring(0, 5));
    			}else{
    				vo.setHorasTrabalhadas("00:00");    				
    			}
    			
    			if(resultado.getString("cargaHoraria")!=null){
    				String cargaHoraria = resultado.getString("cargaHoraria").substring(0, 5);
    				Integer saldo = Integer.valueOf(resultado.getString("cargaHoraria").substring(0, 2));
    				
    				if(saldo != 0 && saldo < 8){
    					vo.setIndicaSaldoDevedor(true);
    				}else{
    					String saldoPositivo = resultado.getString("cargaHoraria").substring(0, 1);
    					if(saldoPositivo.equals("-")){    						
    						cargaHoraria = StringUtil.formataSaldoPositivo(saldoPositivo,resultado.getString("cargaHoraria"));;
    					}
    				}
    				
    				vo.setCargaHoraria(cargaHoraria);
    				
    			}else{
    				vo.setCargaHoraria(resultado.getString("cargaHoraria"));
    				vo.setHorasTrabalhadas("00:00");
    				vo.setIndicaSaldoDevedor(true);
    			}
    			lista.add(vo);    			
    		}
    		
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return lista;
    }

    @SuppressWarnings({ "deprecation" })
    public List<HorasAtividadeVO> getTotalHorasTrabalhadas(Integer ano, Integer mes, Integer codigofuncionario) throws DAOException {
    	StringBuilder hql = new StringBuilder(); 
    	List<HorasAtividadeVO> lista = new ArrayList<HorasAtividadeVO>();
    	try { 
    		hql.append("select  date_part('month', datahorainicio) as mes, " +
    				" sum(datahorafim - datahorainicio) as totalHorasTrabalhadas " +
    				" from ts.timesheet where date_part('year', datahorainicio) = "+ ano + " " +
    				" and date_part('month', datahorainicio)= "+ mes +" " +
    				" and codigofuncionario=" + codigofuncionario + " " +
    				" group by date_part('month', datahorainicio) ");
    		
    		PreparedStatement query  = null;      
    		Connection conexao = getSession().connection();
    		
    		query = conexao.prepareStatement(hql.toString());
    		
    		ResultSet resultado = query.executeQuery();           
    		
    		while(resultado.next()){
    			HorasAtividadeVO vo = new HorasAtividadeVO();
    			vo.setMes(resultado.getInt("mes"));
    			vo.setHorasTrabalhadas(resultado.getString("totalHorasTrabalhadas"));
    			lista.add(vo);
    			
    		}
    		
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return lista;
    }
    
}