<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".mainLayout">	
	<tiles:put name="corpo" type="string"> 
	
		
	
		<!-- MIOLO -->
		<div id="miolo" style="background-color:#fff; background-image:none;height:60%;">
			<div class="botoesJanela">			
				<!-- DATA DO CALENDARIO -->
				<form action="">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td width="150px;">&nbsp;</td>
							<th valign="middle">DATA DA ATIVIDADE:&nbsp; </td>
							<td valign="middle">
								<input onclick="ds_sh(this);" name="date" readonly="readonly" style="cursor: text" size="8"/>
							</td>
							<td>	
								<html:img src="${contexto}/WebContent/img/consultar.jpg" title="aprovado" onclick="javascript:consultarAtividade();"/>
							</td>
						</tr>
					</table>	
							
				</form>
				
			</div>					
			<html:form action="/atividade/inicio.do">
				<display:table name="${listaAtividades}" style="width:98%;" class="lista" id="tabela" 
					length="100" pagesize="15" requestURI="/atividade/inicio.do" cellspacing="0"
					 htmlId="resultado">
					<display:column style="width:4%;">
						<html:img  src="${contexto}/WebContent/img/aceitar.png" title="aprovado"/>
						<html:img src="${contexto}/WebContent/img/recu.png" title="aprovado"/>
					</display:column>						
					<display:column property="data" title="Data"/>
					<display:column property="inicioPrevisto" title="Início"/>
					<display:column property="terminoPrevisto" title="Fim"/>
					<display:column property="horasDiarias" title="Horas"/>
					<display:column property="saldoDiario" title="Saldo"/>						
					<display:column property="numeroProjeto" title="No. Projeto"/>
					<display:column property="descricaoAtividade" title="Atividade" style="width:50%"/>	
					<display:column title="Ações">
						<center>
							<a href="#" onclick="javascript:detalharAtividade();">
								<img src="${contexto}/WebContent/img/abrir.png" width="14" height="14" 
									title="detalhar atividade" style="border:none;" /></a>
							<a href="#" onclick="javascript:alterarAtividade();">
								<img src="${contexto}/WebContent/img/alterarTabela.png" width="14" height="14" 
									title="alterar atividade" style="border:none;" /></a>
							<a href="#" onclick="javascript:excluirAtividade();">
								<img src="${contexto}/WebContent/img/excluir.png" width="14" height="14" 
									title="excluir atividade" style="border:none;" /></a>
							<a href="#" onclick="javascript:excluirAtividade();">
								<img src="${contexto}/WebContent/img/aceitar.png" width="14" height="14" 
									title="aprovar atividade" style="border:none;" /></a>
							<a href="#" onclick="javascript:excluirAtividade();">
								<img src="${contexto}/WebContent/img/recu.png" width="14" height="14" 
									title="aprovar atividade" style="border:none;" /></a>								
						</center>
					</display:column>					
				</display:table>
				
				<div style="float:right; padding-right: 15px;">Aceitar Todos :  <html:checkbox name="form" property="observacao"/></div>
			</html:form>
		</div>   	
		
		<!-- FIM MIOLO -->
		
		<div style="width:100%; height:10px; background-color:#00779e;">
			<a href="javascript:habilitarDiv();"><img style="float:right;" src="${contexto}/WebContent/img/setasEx.jpg" width="11" height="10" /></a>
		</div>	
		<div id="rodape">	
			<div class="boxBotoesVertical">
				<img src="${contexto}/WebContent/img/imprimir.png" width="20" height="18" title="imprimir" />
	   			<img src="${contexto}/WebContent/img/recurso.png" width="20" height="21" title="recursos" />
			</div>
			
			<!-- INICIO TEXTAREA -->
			<div style="width:340px; margin-bottom: 10px;; float:right; display:table-column;">
				<div class="foco">
				  	<div class="label">Atividade a ser realizada:</div>
					<textarea class="campo" name="textarea" style="width:320px; height:50px;" id="textarea" cols="45" rows="2"></textarea>
				</div>
				<div class="foco">
					<div class="label">Observações:</div>
				  	<textarea class="campo" name="textarea2" style="width:320px; height:50px;" id="textarea2" cols="45" rows="2"></textarea>
				</div>
			</div>
			<!-- FIM TEXTAREA -->	
			
			<div class="foco">
			  	<div class="label">Data :</div>
			  	<input class="campoLeitura" name="input12" cols="" rows="" style="width:60px;" />
			</div>												
			<div class="foco">
			  	<div class="label">Início:</div>
			  	<input class="campoLeitura" name="input3" cols="" rows="" style="width:60px;" />
			</div>									
			<div class="foco">
			  	<div class="label">Termino:</div>
			  	<input class="campoLeitura" name="input9" cols="" rows="" style="width:60px;" />
			</div>															
			<div class="foco">
			  	<div class="label">OP:</div>
			  	<input class="campoLeitura" name="input2" cols="" rows="" style="width:292px;" />
			</div>							
			<div class="foco">
			<div class="label">Metodologia:</div>
				<input class="campoLeitura" name="input7" cols="" rows="" style="width:292px;" />		  
			</div>											
			<div class="foco">
				<div class="label">Nº Projeto:</div>
			  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:61px;" />
			</div>							
			<div class="foco">
				<div class="label">Produto/Serviço:</div>
			  	<input class="campoLeitura" name="input11" cols="" rows="" style="width:95px;" />
			</div>							
			<div class="foco">
				<div class="label">Data Avaliação:</div>
			  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:120px;" />
			</div>							
			<div class="foco">
				<div class="label">Início Avaliação:</div>
			  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:133px;" />
			</div>							
			<div class="foco">
				<div class="label">Termino Avaliação:</div>
			  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:148px;" />
			</div>							
			<div class="foco">
				<div class="label">Situação Avaliação:</div>
			  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:150px;" />
			</div>							
			<div class="foco">
				<div class="label">Observações Chefia:</div>
				<textarea class="campo" name="textarea2" style="width:290px; height:20px;" id="textarea2" cols="45" rows="2"></textarea>
			</div>								
			<div class="foco">
				<div class="label">Observações Chefia Privativas:</div>
				<textarea class="campo" name="textarea2" style="width:309px; height:20px;" id="textarea2" cols="45" rows="2"></textarea>
			</div>	
		</div>
		
		

		<!-- INICIO CALENDARIO -->
		<table class="ds_box" cellpadding="0" cellspacing="0" id="ds_conclass" style="display: none;">
			<tr>
				<td id="ds_calclass"></td>
			</tr>
		</table>
		
		<script type="text/javascript" src="${contexto}/WebContent/js/calendario.js"></script>
		<!-- FIM CALENDARIO -->
		
		<script type="text/javascript">
			function habilitarDiv(){
				display = document.getElementById('rodape').style.display;
				if(display == 'none'){
					document.getElementById('rodape').style.display = '';
					document.getElementById('miolo').style.height = '65%';
				}else{
					document.getElementById('rodape').style.display = 'none';
					document.getElementById('miolo').style.height = '85%';					
					
				}
				
				
			}
		</script>	
		
	</tiles:put>
</tiles:insert>
