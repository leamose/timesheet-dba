<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".secundarias">	
	
	<tiles:put name="corpo" type="string"> 
		<div id="main">
			<div id="corpo">
				<div class="cabecalho">
			    	<div class="titulo-formulario-pesquisa">Cadastro de Funcionário</div>
				</div>
			
				<html:form action="/funcionario/salvar" method="post">
				    
					<div class="formulario">
						
						
				    	<div class="foco" style="width:49%;">
			                <div class="labelDetalhar" style="width:150px;">Hora Trabalho Início:</div>
			                <div class="input_position">
			                	<html:text styleClass="campo" name="form" property="hora_trabalho_fim" size="15"/>
			                </div>
			            </div>
				    	<div class="foco">
			                <div class="labelDetalhar" style="width:130px;">Hora Trabalho Fim:</div>
			                <div class="input_position">
			                	<html:text styleClass="campo" name="form" property="hora_trabalho_fim" size="16"/>
			                </div>
			            </div>
				    	<div class="foco" style="width:50%;">
			                <div class="labelDetalhar" style="width:150px;">Hora Almoco Início:</div>
							<div class="input_position">			                	
			                	<html:text styleClass="campo" name="form" property="hora_almoco_inicio" size="15"/>
			                </div>
			                	
			            </div>
				    	<div class="foco" >
			                <div class="labelDetalhar" style="width:120px;">Hora Almoco Fim:</div>
			               	<div class="input_position">	
			               		<html:text styleClass="campo" name="form" property="hora_trabalho_fim" size="16"/>
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
