<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".popUp">	
	<tiles:put name="corpo" type="string">
		
		<script language="javascript">
			
			//REFRESH NA TELA PAI
			if(<%=request.getAttribute("submiter")%>) {
				confirmaOperacao();
			} 
			
			function outros(div){
				document.getElementById(div).style.display = '';				
			}
	
			function outrasAtividades(form){
				
				for (var i = 0; i < form.codigoAtividade.options.length; i++) {
			        if (form.codigoAtividade.options[i].selected){
			        	if(form.codigoAtividade.options[i].value == 6){        		
			        		document.getElementById('outros').style.display = '';
			        	}else{
			        		document.getElementById('outros').style.display = 'none';
			        	}
			        }
			      }
			}
			
			function retornoCadastrarAtividades() {				
				if(validarCampos()){
					var form = document.forms[0];
					form.action = contexto + '/atividade/salvar.do';				
					form.submit();											
				}
			}
		
			function retornoAlterarAtividade() {
				if(validarCampos()){
					var form = document.forms[0];
					form.action = contexto + '/atividade/retornoAlterar.do';
					form.submit();
				}
			}

			function popularComboProdutoServico() {
				var form = document.forms[0];
				form.action = contexto + '/atividade/popularComboProdutoServico.do';
				form.submit();
			}
			
			function validarCampos() {
	
				if (document.forms[0].data.value == ""){
			       alert("Esqueceu de especificar a data da atividade ");
			       document.forms[0].data.focus();
			       return false;
			    }
	
			    if (document.forms[0].dataHoraInicio.value == ""){
				   alert("Esqueceu de especificar a data inicial da atividade ");
				   document.forms[0].dataHoraInicio.focus();
				   return false;
			    }
	
			    if (document.forms[0].dataHoraFim.value == ""){
			       alert("Esqueceu de especificar a data final da atividade ");
			       document.forms[0].dataHoraFim.focus();
			       return false;
			    }
	
			    if (document.forms[0].dataHoraInicio.value == ""){
			       alert("Esqueceu de especificar a hora que a atividade foi iniciada ");
			       document.forms[0].dataHoraInicio.focus();
			       return false;
			    }
	
			    if (document.forms[0].dataHoraFim.value == ""){
				     alert("Esqueceu de especificar a hora que a atividade foi finalizada ");
				     document.forms[0].dataHoraFim.focus();
				     return false;
			    }
				
				if(document.forms[0].op.value == '#') {
					alert("Esqueceu de selecionar uma OP !");
					document.forms[0].op.focus();
					return false;
				}
				if(document.forms[0].codigoMetodologia.value == '#') {
					alert("Esqueceu de selecionar uma Metodologia !");
					document.forms[0].codigoMetodologia.focus();
					return false;
				}
				if(document.forms[0].codigoCliente.value == '#') {
					alert("Esqueceu de selecionar uma Cliente !");
					document.forms[0].codigoCliente.focus();
					return false;
				}
				if(document.forms[0].codigoAtividade.value == '#') {
					alert("Esqueceu de selecionar uma Atividade !");
					document.forms[0].codigoAtividade.focus();
					return false;
				}
				if(document.forms[0].codigoProdutoServico.value == '#') {
					alert("Esqueceu de selecionar uma Produto / Serviço !");
					document.forms[0].codigoProdutoServico.focus();
					return false;
				}
				
				return true;
			}  
		</script>
		
		<div class="conteudo-formulario-detalhamento">
			<div class="formulario" style="width:auto; height:auto; padding-bottom:0px;">
				<html:form action="/atividade/salvar" method="post">
					<div class="foco" style="width:98%;">
					  	<div class="labelDetalhar" >Data Atividade:*</div>
					  	<div class="input_position">
						  	<html:text styleClass="campoLeitura" name="form" property="data" 
						  		size="10" maxlength="10" 
						  		onkeydown="FormataData(this,event.keyCode);" 
						  		onkeyup="SaltaCampo(this,1,8,event.keyCode);"
						  		onchange="valor=this.value; this.value = ''; this.value =valor;"
						  		onblur="if(! ValidaData(this.value)) { alert('Data Inválida'); this.value = ''; this.focus(); };"
						  		disabled="${form.desabilitarCampo}"/>
						  	<font face="Tahoma" size="2" color="Gray">&nbsp;ddmmyyyy</font>
						</div>
					</div>													
					<div class="foco" style="width:98%;">
					  	<div class="labelDetalhar">Início Previsto:*</div>
					  	<div class="input_position">
						  	<html:text styleClass="campoLeitura" name="form" property="dataHoraInicio" size="5" maxlength="5"
						  		onkeydown="FormataHora(this,event.keyCode);" 
						  		onkeyup="SaltaCampo(this,2,5,event.keyCode);" 
						  		onclick="valor=this.value; this.value = ''; this.value =valor;"
						  		onblur="if(! ValidaHora(this.value)) { alert('Hora Inválida'); this.value = ''; this.focus(); };"
						  		disabled="${form.desabilitarCampo}"/>
						  	<font face="Tahoma" size="2" color="Gray">&nbsp;24:00hs</font>
						</div>
					</div>									
					<div class="foco">
					  	<div class="labelDetalhar">Termino Previsto:*</div>
					  	<div class="input_position">
						  	<html:text styleClass="campoLeitura" name="form" property="dataHoraFim" size="5" maxlength="5"
						  		onkeydown="FormataHora(this,event.keyCode);" 
						  		onkeyup="SaltaCampo(this,3,5,event.keyCode);  " 
						  		onclick="valor=this.value; this.value = ''; this.value =valor;"
						  		onblur="if(! ValidaHora(this.value)) { alert('Hora Inválida'); this.value = ''; this.focus(); };"
						  		disabled="${form.desabilitarCampo}"/>
						  	<font face="Tahoma" size="2" color="Gray">&nbsp;24:00hs</font>
						</div>
					</div>															
					<div class="foco" style="width:80%;">
					  	<div class="labelDetalhar">OP:*</div>
					  	<div class="input_position">
					  		<html:select name="form" property="codigoOp" styleId="op" 
						  		style="width:auto" styleClass="campo" disabled="${form.desabilitarCampo}">
						  		<html:option value="#"><< - - - Selecione uma OP - - - >></html:option>								    
								<html:optionsCollection name="form" property="listaOPs" 
									label="descricao" value="id" />
							</html:select>						  	
					  	</div>
					</div>							
					<div class="foco" style="width:98%;">
						<div class="labelDetalhar">Nº Projeto:*</div>
					  	<div class="input_position">
						  	<html:text styleClass="campoLeitura" name="form" property="numeroProjeto" size="5" disabled="${form.desabilitarCampo}"/>
						</div>
					</div>							
					<div class="foco" style="width:73%;">
						<div class="labelDetalhar">Nome do Projeto:*</div>
					  	<div class="input_position">
						  	<html:text styleClass="campoLeitura" name="form" property="nomeProjeto" size="55" disabled="${form.desabilitarCampo}"/>
						</div>
					</div>							
					<div class="foco">
						<div class="labelDetalhar">Cliente:*</div>
					  	<div class="input_position">
						  	<html:select name="form" property="codigoCliente" styleId="cliente" 
						  		style="width:auto" styleClass="campo" disabled="${form.desabilitarCampo}">
						  		<html:option value="#"><< - - - Selecione um Cliente - - - >></html:option>								    
								<html:optionsCollection name="form" property="listaClientes" 
									label="nome" value="id" />
							</html:select>							
						</div>
					</div>
					<div class="foco" style="width:90%;">
						<div class="labelDetalhar">Metodologia:*</div>
						<div class="input_position">							
							<html:select name="form" property="codigoMetodologia" styleId="metodologia" 
						  		style="width:auto" styleClass="campo" disabled="${form.desabilitarCampo}"
						  		onchange="popularComboProdutoServico();">
						  		<html:option value="#"><< - - - Selecione uma Metodologia - - - >></html:option>								    
								<html:optionsCollection name="form" property="listaMetodologias" 
									label="descricao" value="id" />
							</html:select>		  
						</div>
					</div>											
					<div class="foco">
						<div class="labelDetalhar">Produto/Serviço:*</div>
					  	<div class="input_position">						  	
						  	<html:select name="form" property="codigoProdutoServico" styleId="atividade" 
						  		style="width:auto" styleClass="campo" disabled="${form.desabilitarCampo}">			
						  		<html:option value="#"><< - - - Selecione uma Produto / Serviço - - - >></html:option>					    
								<html:optionsCollection name="form" property="listaProdutosServicos" 
									label="descricao" value="id" />
							</html:select>	
						</div>
					</div>
					<div class="foco" style="width:80%;">
						<div class="labelDetalhar">Atividade:*</div>
					  	<div class="input_position">
						  	<html:select name="form" property="codigoAtividade" styleId="atividade" 
						  		style="width:auto" styleClass="campo" 
						  		onchange="javascript:outrasAtividades(this.form);"
						  		disabled="${form.desabilitarCampo}">		
						  		<html:option value="#"><< - - - Selecione uma Atividade - - - >></html:option>						    
								<html:optionsCollection name="form" property="listaAtividades" 
									label="descricao" value="id" />
							</html:select>							
						</div>
					</div>
					<div class="foco">
						<div class="labelDetalhar">Observações:</div>
					  	<div class="input_position">
						  	<html:textarea styleClass="campo" name="form" style="width:520px; height:50px;" 
						  		property="observacao" cols="45" rows="2" disabled="${form.desabilitarCampo}"></html:textarea>
						</div>
					</div>
					<div class="foco" id="outros" style="display:none;">
							<div class="labelDetalhar">Outros:</div>
							<div class="input_position">
							  	<html:textarea styleClass="campo" name="form" style="width:520px; height:50px;" 
							  		property="outros" cols="45" rows="2" disabled="${form.desabilitarCampo}"></html:textarea>
							</div>
					</div>					
					<div class="botoesMeio">
				    	<a href="#">
					    	<c:if test="${form.acao eq 'salvar' }">
							    	<img src="${contexto}/WebContent/img/confirmar.jpg" width="128" height="20" alt="salvar"
						    			onclick="retornoCadastrarAtividades();"/>
							</c:if>
							<c:if test="${form.acao eq 'alterar' }">
						    	<img src="${contexto}/WebContent/img/confirmar.jpg" width="128" height="20" alt="salvar"
					    			onclick="javascript:retornoAlterarAtividade();"/>
					    	</c:if>
				    			
					    </a>
					    <a href="#">
						   	
						   	<c:if test="${form.acao ne 'detalhar'}">
							   	<img src="${contexto}/WebContent/img/cancelar.jpg" 
						    		onclick="javascript:cancelaOperacao();"  
						    		alt="cancelar" />
					    	</c:if>

						   	<c:if test="${form.acao eq 'detalhar'}">
							   	<img src="${contexto}/WebContent/img/voltar.png" 
						    		onclick="javascript:cancelaOperacao();"  
						    		alt="cancelar" />
					    	</c:if>
					    </a>
				    </div>	
				    
				    <html:hidden property="id" />
				    <html:hidden property="acao" />
					
					<c:if test="${form.outros ne ''}">
						<script language="javascript">
							document.getElementById('outros').style.display = '';
						</script>
					</c:if>

					<c:if test="${form.outros eq null }">
						<script language="javascript">
							document.getElementById('outros').style.display = 'none';
						</script>
					</c:if>
						    		    
				</html:form>
	        </div>
		</div>
		
				
	</tiles:put>
</tiles:insert>
