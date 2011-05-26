<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>


<%@page import="br.com.dba.timesheet.pojo.Sessao"%>

<tiles:insert definition=".mainLayout">
	
	<tiles:put name="corpo" type="string"> 
	
		<script>

			//CONSULTAR ATIVIDADE
			function consultarAtividade() {				
				var form = document.forms[0];
				form.action = contexto + '/atividade/consultar.do'; 
				form.submit();
			}

			//INICIO CONSULTAR ATIVIDADE
			function inicioConsultarAtividade() {				
				var form = document.forms[0];
				form.action = contexto + '/atividade/inicioConsultar.do?mostraConsulta=true&consulta=true'; 
				form.submit();
			}
				
			//DETALHAR
			function detalharAtividade(codigoTimeSheet, temOutrasAtividades, altura) {
				open_popPpAtividade(temOutrasAtividades, contexto + '/atividade/detalhar.do?popUp=true&acao=<%=Constantes.ACAO_DETALHAR%>&codigoTimeSheet='+codigoTimeSheet, null, "Detalhar Atividade", 800, altura);				
			}		
	
			//ALTERAR
			function alterarAtividade(codigoTimeSheet, temOutrasAtividades, altura) {
				open_popPpAtividade(temOutrasAtividades, contexto + '/atividade/alterar.do?popUp=true&acao=<%=Constantes.ACAO_ALTERAR%>&codigoTimeSheet='+codigoTimeSheet, retornoInicio, "Alterar Atividade", 800, altura) ;
			}		
	
			//EXCLUIR
			function excluirAtividade(codigoTimeSheet, codigoHistoricoTimeSheet) {
				if(confirm('Confirma a exclusão do registro?')){
					var form = document.forms[0];
					form.action = contexto + '/atividade/excluir.do?codigoTimeSheet='+codigoTimeSheet+'&codigoHistoricoTimeSheet='+codigoHistoricoTimeSheet; 
					form.submit();
				}
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
			<html:hidden name="form" property="codigoAvaliacao"/>
			<html:hidden property="mostraConsulta" value="${form.consulta}"/>
		
		<div class="base">
			<!-- TOPO -->	
			<div style="top: 0">		
			<%@include file="/WebContent/jsp/comum/cabecalhoPrincipal.jsp"%>
			</div>
			<div style="clear: both"></div>
			<!-- MIOLO -->
			<div id="miolo" style="background-color:#fff; width:100%; height:70%; position: absolute;">
				
				<!-- CABECALHO ATIVIDADES(consulta, adicao de atividade, escolha de colaborador subordinado) -->
				<%@include file="/WebContent/jsp/atividades/miolo.jsp" %>
				<div style="clear: both"></div>
			</div>
			
			<!-- RODAPÉ -->
			<%@include file="/WebContent/jsp/atividades/rodape.jsp" %>
		</div>	 	
				
			
		</html:form>
		
		
		<!-- FIM MIOLO -->
				
	</tiles:put>
</tiles:insert>
