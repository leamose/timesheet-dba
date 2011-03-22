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
				open_popPpAtividade(temOutrasAtividades, contexto + '/atividade/detalhar.do?codigoTimeSheet='+codigoTimeSheet, null, "Detalhar Atividade", 720, 445) ;
			}		
	
			//ALTERAR
			function alterarAtividade(codigoTimeSheet, temOutrasAtividades) {
				open_popPpAtividade(temOutrasAtividades, contexto + '/atividade/alterar.do?codigoTimeSheet='+codigoTimeSheet, retornoInicio, "Alterar Atividade", 720, 445) ;
			}		
	
			//EXCLUIR
			function excluirAtividade(codigoTimeSheet) {
				var form = document.forms[0];
				form.action = contexto + '/atividade/excluir.do?codigoTimeSheet='+codigoTimeSheet; 
				form.submit();
			}
		
			//HOMOLOGAR ATIVIDADE
			function avaliarAtividade(codigoTimeSheet) {
				open_popPpAtividade(false, contexto + '/avaliacaoAtividade/inicio.do?codigoTimeSheet='+codigoTimeSheet, retornoInicio, "Aprovar Atividade", 720, 250);
			}
			
		</script>
	
		
		<%@include file="/WebContent/jsp/erro/erroGeral.jsp"%>
	
	
		<!-- MIOLO -->
		<div id="miolo" style="background-color:#fff; background-image:none;height:78%;">
			<html:form action="/atividade/inicio.do">
			
				
				<table style="width:100%;height:9%;">
		        	<tr>
		        		<td>
			        		<span style="color:red;"><html:errors/></span>
			        		
							<span class="msgSucesso">
			    				<html:messages id="msg" message="true" >
								   	<image src="${contexto}/WebContent/img/accept.png"/>
								   	<c:out value="${msg}"/>	
								</html:messages>
	
				    		</span>	
				    		
						</td>
					</tr>
				</table>
			
				<div class="botoesJanela">			
					<!-- DATA DO CALENDARIO -->
					<div style="width:100%">
							<div class="foco">
								<div class="labelDetalhar" style="width:90px;padding-top:5px;">Colaborador:</div>
								<div style="float:left;text-align:left;margin-right:15px;padding-top:5px;">							
									<c:if test="${form.indicaChefe}">
										<html:select name="form" property="codigoFuncionario" styleId="colaborador" styleClass="campo" style="width:300px;">								    
											<html:optionsCollection name="form" property="listaFuncionariosSubordinados" 
												label="descricao" value="codigoFuncionario" />
										</html:select>
									</c:if>		  
									<c:if test="${!form.indicaChefe}">
										${form.usuario.funcionario.nome}
									</c:if>		  
								</div>
							</div>					
								
							<div class="foco">
								<div class="labelDetalhar" style="width:70px;padding-top:5px;">Mês/Ano:&nbsp; </div>
								<div style="float:left;text-align:left;margin-right:15px;padding-top: 3px">
									<html:text styleClass="campoLeitura" name="form" property="dataParaPesquisa" 
								  		size="10" maxlength="10" styleId="dataParaPesquisa"
								  		onkeydown="FormataData(this,event.keyCode);"
								  		onblur="if(! ValidaData(this.value)) { alert('Data Inválida'); this.value = ''; this.focus(); };"/>
								</div>
								<div style="float:left;text-align:left;margin-right:15px;">
									<html:img src="${contexto}/WebContent/img/consultar.jpg" 
										title="aprovado" onclick="javascript:consultarAtividade();"/>
						        </div>
						   </div>
					</div>
				</div>
				
				<div style="height:450px">	
					<display:table name="form.listaTimeSheetVO" style="width:100%;padding-bottom:20px;" 
						class="lista" id="tabela" length="100" pagesize="15" 
						requestURI="/atividade/inicio.do" cellspacing="0" htmlId="resultado">
						<display:column style="width:1%;" >
							<!--<img src="${contexto}/WebContent/img/aprov_mao.gif" title="aprovado"/>-->												
						</display:column>						
						<display:column property="dataHoraInicio" title="Data" 
							format="{0,date,dd/MM/yyyy}" style="width:2%;"/>
							
						<display:column property="dataHoraInicio" title="Início Previsto" 
							format="{0,date,HH:mm}" style="width:2%;"/>
							
						<display:column property="dataHoraFim" title="Fim Previsto" 
							format="{0,date,HH:mm}" style="width:2%;" />
							
						<display:column property="numeroProjeto" title="No. Projeto" style="width:2%;" />
						<display:column property="descricaoAtividade" title="Atividade" 
							style="width:30%;"  maxLength="50"/>	
							
						<display:column property="observacao" title="Observação" 
							style="width:30%;"  maxLength="40"/>	
							
						<display:column property="ultimaAtividade" title="Observação Superior" style="width:17%;" maxLength="25"/>
						<display:column title="Ações" style="width:10%;">
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
								
								<c:if test="${form.indicaChefe}">
									<a href="javascript:avaliarAtividade(${tabela.codigoTimeSheet});">
										<html:img  src="${contexto}/WebContent/img/responderAutoP.png" 
											title="avaliar atividade"/>
									</a>
								</c:if>
							</center>
												
						</display:column>
					</display:table>
				</div>
				<div style="float:left; padding-right: 15px;padding-top: 50px; ">
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
				
			</html:form>
		</div>   	
		
		<!-- FIM MIOLO -->
				
	</tiles:put>
</tiles:insert>
