<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".secundarias">	
	
	<tiles:put name="corpo" type="string"> 
		<div id="main">
			<div id="corpo">
				<div class="cabecalho">
			    	<div class="titulo-formulario-pesquisa">Cadastro de Funcion�rio</div>
				</div>
			
				<html:form action="/funcionario/salvar" method="post">
				    
					<div class="formulario">
						<!-- Espaco para mensagens -->
						    	<div class="boxMensagemS">
						          	<div class="textoMensagemS">Alguns erros foram encontrados. Por favor, reveja os campos assinalados em vermelho.</div>
						            <div class="iconeMensagemS">
						            	<html:img src="${contexto}/WebContent/img/block.png" width="32" height="32" />
						            </div>
						        </div>	
						
				    	<div class="foco">
				   			<div class="labelDetalhar" style="width:150px;">Nome: *</div>
				   			<div class="input_position">
				          		<html:text styleClass="campo" name="form" property="nome" size="90"/>
				          		<a href="#">
					          		<html:img src="${contexto}/WebContent/img/pesquisarconfig.png"
					          			onclick="javascript:pesquisarFuncionario();"/>
					          	</a>
				          	</div>
						</div>
					
						<div class="foco" >
				   			<div class="labelDetalhar" style="width:150px;">Cargo:</div>
				   			<div class="input_position">
				          		<html:text styleClass="campo" name="form" property="cargo" size="62"/>
				          	</div>
						</div>	
				        <div class="foco">
				   			<div class="labelDetalhar" style="width:40px;">Chefe:</div>
				          	<div class="input_position">
				          		<html:checkbox styleClass="campo" property="chefe" />
				          	</div>
						</div>
			            <div class="foco" >
				   			<div class="labelDetalhar" style="width:40px;">F�rias:</div>
				          	<div class="input_position">
				          		<html:checkbox styleClass="campo" property="ferias" />
				          	</div>
						</div>
				    
				    	<div class="foco" style="width:46%;">
			                <div class="labelDetalhar" style="width:150px;">Hora Trabalho In�cio:</div>
			                <div class="input_position">
			                	<html:text styleClass="campo" name="form" property="hora_trabalho_inicio"/>
			                </div>
			            </div>
				    	<div class="foco">
			                <div class="labelDetalhar" style="width:130px;">Hora Trabalho Fim:</div>
			                <div class="input_position">
			                	<html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
			                </div>
			            </div>
				    	<div class="foco" style="width:46%;">
			                <div class="labelDetalhar" style="width:150px;">Hora Almoco In�cio:</div>
							<div class="input_position">			                	
			                	<html:text styleClass="campo" name="form" property="hora_almoco_inicio"/>
			                </div>
			                	
			            </div>
				    	<div class="foco" >
			                <div class="labelDetalhar" style="width:130px;">Hora Almoco Fim:</div>
			               	<div class="input_position">	
			               		<html:text styleClass="campo" name="form" property="hora_almoco_fim"/>
			               	</div>
			            </div>
				    </div>							
			            		            
					<div class="final_formulario" >
						<html:img src="${contexto}/WebContent/img/salvar.png" width="43" height="43" 
					    	onclick="javascript:document.forms[0].submit();"/>					    	
					    <html:img src="${contexto}/WebContent/img/voltar.png" width="54" height="43" alt="voltar" 
					    	onclick="javascript:voltar();"/>
					</div>					    
				</html:form>
			</div>							
		</div>				
	</tiles:put>
</tiles:insert>
