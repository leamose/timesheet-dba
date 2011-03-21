<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".popUp">	
	<tiles:put name="corpo" type="string">
		
		<script>
			//RETORNO HOMOLOGAR ATIVIDADE
			function retornoAprovarAtividade(codigoTimeSheet) {
				var form = document.forms[0];
				form.action = contexto + '/avaliacaoAtividade/salvar.do?codigoTimeSheet='+codigoTimeSheet; 
				form.submit();
			}
		</script>
		
		<div class="conteudo-formulario-detalhamento">
			<div class="formulario" style="width:auto; height:auto; padding-bottom:0px;">
				<html:form action="/avaliacaoAtividade/salvar" method="post">
					
					<html:hidden property="id"/>
					<html:hidden property="acao"/>
					
					<div class="foco" >
					  	<div class="labelDetalhar">Data Atividade:</div>
					  	<div class="input_position">${form.data}</div>
					</div>													
					<div class="foco" style="width:80%;">
					  	<div class="labelDetalhar">Situação:</div>
					  	<div class="input_position">
					  		<html:select name="form" property="codigoSituacaoAtividade" styleId="situacao" 
						  		style="width:auto" styleClass="campo">
						  		<html:option value="#"><< - - - Selecione uma Situacao - - - >></html:option>								    
								<html:optionsCollection name="form" property="listaSituacaoAtividade" 
									label="descricao" value="id" />
							</html:select>						  	
					  	</div>
					</div>
					<div class="foco">
						<div class="labelDetalhar">Observações:</div>
					  	<div class="input_position">
						  	<html:textarea styleClass="campo" name="form" style="width:520px; height:50px;" 
						  		property="observacao" cols="45" rows="2"></html:textarea>
						</div>
					</div>
					<div class="foco" id="outros">
							<div class="labelDetalhar">Observações Privada:</div>
							<div class="input_position">
							  	<html:textarea styleClass="campo" name="form" style="width:520px; height:50px;" 
							  		property="observacaoPrivada" cols="40" rows="2"></html:textarea>
							</div>
					</div>					
					<div class="botoesMeio">
				    	<a href="#">
					    	<img src="${contexto}/WebContent/img/confirmar.jpg" width="128" height="20" alt="salvar"
						    	onclick="javascript:retornoAprovarAtividade();confirmaOperacao();"/>
					    </a>
					    <a href="#">
						   	<img src="${contexto}/WebContent/img/cancelar.jpg" 
					    		onclick="javascript:cancelaOperacao();" alt="cancelar" />
					    </a>
				    </div>  		    
				</html:form>
	        </div>
		</div>
		
				
	</tiles:put>
</tiles:insert>
