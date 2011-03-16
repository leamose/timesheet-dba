<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".mainLayout">	
	<tiles:put name="corpo" type="string"> 
	
		<script>
		
			//CONSULTAR ATIVIDADE
			function consultarAtividade() {
				var form = document.forms[0];
				form.action = contexto + '/atividade/consultar.do'; 
				form.submit();
			}
	
			//DETALHAR
			function detalharAtividade(codigoTimeSheet, temOutrasAtividades) {
				open_popPpAtividade(temOutrasAtividades, contexto + '/atividade/detalhar.do?codigoTimeSheet='+codigoTimeSheet, null, "Detalhar Atividade", 720, 402) ;
			}		
	
			//ALTERAR
			function alterarAtividade(codigoTimeSheet, temOutrasAtividades) {
				open_popPpAtividade(temOutrasAtividades, contexto + '/atividade/alterar.do?codigoTimeSheet='+codigoTimeSheet, null, "Alterar Atividade", 720, 402) ;
			}		
	
			//EXCLUIR
			function excluirAtividade(codigoTimeSheet) {
				var form = document.forms[0];
				form.action = contexto + '/atividade/excluir.do?codigoTimeSheet='+codigoTimeSheet; 
				form.submit();
			}
		
			//HOMOLOGAR ATIVIDADE
			function avaliarAtividade(codigoTimeSheet) {
				open_popPpAtividade(false, contexto + '/avaliacaoAtividade/inicio.do?codigoTimeSheet='+codigoTimeSheet, null, "Aprovar Atividade", 720, 300);
			}
			
		</script>
	
		<!-- MIOLO -->
		<div id="miolo" style="background-color:#fff; background-image:none;height:78%;">
			<html:form action="/atividade/inicio.do">
				<div class="botoesJanela">			
					<!-- DATA DO CALENDARIO -->
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td width="150px;">&nbsp;</td>
								<th valign="middle">DATA DA ATIVIDADE:&nbsp; </th>
								<td valign="middle">
									<html:text styleClass="campoLeitura" name="form" property="dataParaPesquisa" 
								  		size="10" maxlength="10" styleId="dataParaPesquisa"
								  		onkeydown="FormataData(this,event.keyCode);"
								  		onblur="if(! ValidaData(this.value)) { alert('Data Inválida'); this.value = ''; this.focus(); };"/>
								</td>
								<td>	
									<html:img src="${contexto}/WebContent/img/consultar.jpg" 
										title="aprovado" onclick="javascript:consultarAtividade();"/>
								</td>
							</tr>
						</table>
				</div>
				
				<div style="height:420px">	
					<display:table name="${form.listaTimeSheetVO}" style="width:100%;padding-bottom:20px;" class="lista" id="tabela" 
						length="100" pagesize="20" requestURI="/atividade/inicio.do" cellspacing="0"
						 htmlId="resultado">
						<display:column style="width:1%;" >
							<img src="${contexto}/WebContent/img/aprov_mao.gif" title="aprovado"/>												
						</display:column>						
						<display:column property="dataHoraInicio" title="Data" 
							format="{0,date,dd/MM/yyyy}" style="width:2%;"/>
							
						<display:column property="dataHoraInicio" title="Início Previsto" 
							format="{0,date,HH:MM}" style="width:2%;"/>
							
						<display:column property="dataHoraInicio" title="Fim Previsto" 
							format="{0,date,HH:MM}" style="width:2%;" />
							
						<display:column property="numeroProjeto" title="No. Projeto" style="width:2%;" />
						<display:column property="descricaoAtividade" title="Atividade" 
							style="width:55%;"  maxLength="70"/>	
						<display:column property="login" title="Ultima atividade"/>
						<display:column title="Ações" style="width:auto;" >
							<center>
								<a href="javascript:detalharAtividade(${tabela.codigoTimeSheet}, ${tabela.outrasAtividades ne ''});">
									<html:img  src="${contexto}/WebContent/img/abrir.png" title="detalhar atividade"/>
								</a>
								
								<a href="javascript:alterarAtividade(${tabela.codigoTimeSheet}, ${tabela.outrasAtividades ne ''});">						
									<html:img  src="${contexto}/WebContent/img/alterar.png" title="alterar atividade"/>
								</a>
								
								<a href="javascript:excluirAtividade(${tabela.codigoTimeSheet});">
									<html:img  src="${contexto}/WebContent/img/excluir.png" title="excluir atividade"/>
								</a>
								
								<a href="javascript:avaliarAtividade(${tabela.codigoTimeSheet});">
									<html:img  src="${contexto}/WebContent/img/responderAutoP.png" 
										title="avaliar atividade"/>
								</a>
							</center>
												
						</display:column>
					</display:table>
				</div>
				<div style="float:left; padding-right: 15px;padding-top: 30px; ">
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
					
				
				<div style="float:right; padding-right: 25px; padding-top: 30px;padding-bottom:10px">Aceitar Todos :  <html:checkbox name="form" property="observacao"/></div>
			</html:form>
		</div>   	
		
		<!-- FIM MIOLO -->
				
	</tiles:put>
</tiles:insert>
