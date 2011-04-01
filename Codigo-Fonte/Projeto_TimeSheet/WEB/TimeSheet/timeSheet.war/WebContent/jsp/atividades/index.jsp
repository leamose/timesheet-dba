<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>


<%@page import="br.com.dba.timesheet.pojo.Sessao"%><tiles:insert definition=".mainLayout">
	
	<tiles:put name="corpo" type="string"> 
	
		<script>

			<%Sessao sessao = (Sessao)request.getAttribute("sessao");%>
		
			//CONSULTAR ATIVIDADE
			function consultarAtividade() {
				var form = document.forms[0];
				form.action = contexto + '/atividade/consultar.do'; 
				form.submit();
			}
	
			//DETALHAR
			function detalharAtividade(codigoTimeSheet, temOutrasAtividades, altura) {
				open_popPpAtividade(temOutrasAtividades, contexto + '/atividade/detalhar.do?popUp=true&acao=<%=Constantes.ACAO_DETALHAR%>&codigoTimeSheet='+codigoTimeSheet, null, "Detalhar Atividade", 790, altura);
			}		
	
			//ALTERAR
			function alterarAtividade(codigoTimeSheet, temOutrasAtividades, altura) {
				open_popPpAtividade(temOutrasAtividades, contexto + '/atividade/alterar.do?popUp=true&acao=<%=Constantes.ACAO_ALTERAR%>&codigoTimeSheet='+codigoTimeSheet, retornoInicio, "Alterar Atividade", 800, altura) ;
			}		
	
			//EXCLUIR
			function excluirAtividade(codigoTimeSheet, codigoHistoricoTimeSheet) {
				var form = document.forms[0];
				form.action = contexto + '/atividade/excluir.do?codigoTimeSheet='+codigoTimeSheet+'&codigoHistoricoTimeSheet='+codigoHistoricoTimeSheet; 
				form.submit();
			}

			//CADASTRAR ATIVIDADE
			function abrirPopUpAtividade(altura) {
				open_popPpAtividade(false, contexto + '/atividade/abrirPopUpAtividade.do?popUp=true&acao=<%=Constantes.ACAO_SALVAR%>' , retornoInicio, "Cadastrar Atividade", 800, altura);
			}

			//HOMOLOGAR ATIVIDADE
			function avaliarAtividade(codigoTimeSheet, temOutrasAtividades, altura) {
				open_popPpAtividade(temOutrasAtividades, contexto + '/avaliacaoAtividade/inicioAvaliacao.do?popUp=true&acao=<%=Constantes.ACAO_AVALIAR%>&codigoTimeSheet='+codigoTimeSheet, retornoInicio, "Avaliar Atividade", 800, altura);
			}

			//POPULA COMBO COLABORADOR
			function recuperarAtividadesSubordinados() {				
				if(document.forms[0].codigoFuncionario.value != '#') {
					var form = document.forms[0];
					form.action = contexto + '/atividade/recuperarAtividades.do';
					form.submit();
				}
			}
			
		</script>
	
		<html:form action="/atividade/inicio.do">		
		
			<html:hidden name="form" property="codigoUsuario"/>
			<html:hidden name="form" property="indicaChefe"/>
			<html:hidden name="form" property="codigoFuncionarioLogado"/>
			
			<%@include file="/WebContent/jsp/comum/cabecalhoPrincipal.jsp"%>
	
		<!-- MIOLO -->
		<div id="miolo" style="background-color:#fff; background-image:none;height:78%;">
			
				<!-- TABELA DE MENSAGENS DE ERRO DO SISTEMA -->
				<%@include file="/WebContent/jsp/erro/tabelaErros.jsp" %>
				
				<!-- CABECALHO ATIVIDADES(consulta, adicao de atividade, escolha de colaborador subordinado) -->
				<%@include file="/WebContent/jsp/atividades/cabecalhoAtividades.jsp" %>
				
				<!-- TABELA COM AS ATIVIDADES -->
				<%@include file="/WebContent/jsp/atividades/tabelaResultadoAtividades.jsp" %>
				
				
				<!-- TABELA COM OS HORARIOS, SALDO DIARIO e CARGA HORARIA -->
				<%@include file="/WebContent/jsp/util/reguaHorasAtividades.jsp" %>
				
				
				<!-- SITUACAO DAS ATIVIDADES -->
				<div style="float:left; padding-right: 15px;padding-top: 5px;">
					<table align="center">
					 <tr>
					   <td><font face="tahoma,arial,  helvetica" size="2">
					   		<img src="${contexto}/WebContent/img/aprov_mao.gif"/>Aprovado</font></td>
					   <td>&nbsp;</td>
					   <td><font face="tahoma,arial,  helvetica" size="2">
					   		<img src="${contexto}/WebContent/img/reprov_mao.gif"/>Reprovado</font></td> 
					   <td>&nbsp;</td>
					   <td><font face=" tahoma,arial, helvetica" size="2">
					   		<img src="${contexto}/WebContent/img/aguardando_aprov.gif"/>Aguardando Aprovação</font></td>
					
					 </tr>
					</table>
				</div>
				
			</div>   	
			
		</html:form>
		
		<!-- FIM MIOLO -->
				
	</tiles:put>
</tiles:insert>
