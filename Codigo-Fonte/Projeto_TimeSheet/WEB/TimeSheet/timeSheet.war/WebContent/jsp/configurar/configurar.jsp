<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".secundarias">	
	
	<tiles:put name="corpo" type="string"> 
		<div id="main">
			<div id="corpo">
				<div class="cabecalho">
			    	<div class="titulo-formulario-pesquisa">Configura��o</div>
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
					
				    	<div class="foco" style="width:50%;">
			                <div class="labelDetalhar" style="width:150px;">Hora Trabalho In�cio:</div>
			                <div class="input_position">
			                	<html:text styleClass="campo" name="form" property="hora_trabalho_fim" size="15"/>
			                </div>
			            </div>
				    	<div class="foco">
			                <div class="labelDetalhar" style="width:150px;">Hora Trabalho Fim:</div>
			                <div class="input_position">
			                	<html:text styleClass="campo" name="form" property="hora_trabalho_fim" size="16"/>
			                </div>
			            </div>
				    	<div class="foco" style="width:50%;">
			                <div class="labelDetalhar" style="width:150px;">Hora Almoco In�cio:</div>
							<div class="input_position">			                	
			                	<html:text styleClass="campo" name="form" property="hora_almoco_inicio" size="15"/>
			                </div>
			                	
			            </div>
				    	<div class="foco" >
			                <div class="labelDetalhar" style="width:150px;">Hora Almoco Fim:</div>
			               	<div class="input_position">	
			               		<html:text styleClass="campo" name="form" property="hora_trabalho_fim" size="16"/>
			               	</div>
			            </div>
				    	<div class="foco" style="width:50%;">
			                <div class="labelDetalhar" style="width:150px;">M�nimo:</div>
			               	<div class="input_position">	
			               		<html:text styleClass="campo" name="form" property="mininoAlmoco" size="15"/>
			               	</div>
			            </div>
				    	
			            
			            
			            <div class="subtitulo" style="width:590px; margin-bottom:1px; margin-top:10px;">Total horas no m�s</div>

						<table style="width:800px;" class="paneEstatistica" border="0" cellspacing="0" cellpadding="0">
						  <tr>
						
						    <th class="h1">Janeiro</th>
						    <th class="h1">Fevereiro</th>
						    <th class="h1">Mar�o</th>
						    <th class="h1">Abril</th>
						    <th class="h1">Maio</th>
						    <th class="h1">Junho</th>
						    <th class="h1">Julho</th>
						    <th class="h1">Agosto</th>
						    <th class="h1">Setembro</th>
						    <th class="h1">Outubro</th>
						    <th class="h1">Novembro</th>
						    <th class="h1">Dezembro</th>
						    </tr>
						  <tr>
						    <th>	
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>
						    <th>	
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>						    
						    <th>
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>
						    <th>
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>						    
						    <th>
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>
						    <th>
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>						    
						    <th>
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>
						    <th>
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>						    
						   <th>
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>
						    <th>
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>						    
						    <th>
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>
						    <th>
						    	<div class="input_position_total">	
			               			<html:text styleClass="campo" name="form" property="totalHorasMes" size="3"/>
			               		</div>
			               	</th>						    
						  </tr>						  
						  </table>
			            
			            
			            
			            
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
