<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".secundarias">	
	<tiles:put name="corpo" type="string"> 
		
		<div class="conteudo-formulario-detalhamento">
			<html:form action="/atividade/salvar" method="post">
				<div class="formulario" style="width:auto; height:auto">
					<div class="foco">
			   			<div class="labelDetalhar" style="width:130px;">Nome: *</div>
			          	<div class="input_position">
				          	<html:text styleClass="campo" name="form" property="nome" 
				          		style="width:500px;"/>
				        </div>
					</div>
					<div class="foco">
			   			<div class="labelDetalhar" style="width:130px;">Cargo:</div>
			   			<div class="input_position">
			          		<html:text styleClass="campo" name="form" property="cargo" 
			          			style="width:500px;"/>
			          	</div>
					</div>	
			    
			    	<div class="foco" style="width:355px;">
		                <div class="labelDetalhar" style="width:130px;">Hora Trabalho Início:</div>
		                <div class="input_position">
		                	<html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
		                </div>
		            </div>
			    	<div class="foco">
		                <div class="labelDetalhar" style="width:130px;">Hora Trabalho Fim:</div>
		                <div class="input_position">
		                	<html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
		                </div>
		            </div>
			    	<div class="foco" style="width:355px;">
		                <div class="labelDetalhar" style="width:130px;">Hora Almoco Início:</div>
		                <div class="input_position" >
		                	<html:text styleClass="campo" name="form" property="hora_almoco_inicio"/>
		                </div>
		            </div>
			    	<div class="foco">
		                <div class="labelDetalhar" style="width:130px;">Hora Almoco Fim:</div>
		               	<div class="input_position">
		               		<html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
		               	</div>
		            </div>
		            <div class="foco" style="width:630px;">
			   			<div class="labelDetalhar" style="width:130px;">Chefe:</div>
			   			<div class="input_position">
			          		<html:checkbox styleClass="campo" property="chefe" />
			          	</div>
					</div>
		            <div class="foco">
			   			<div class="labelDetalhar" style="width:130px;">Férias:</div>
			   			<div class="input_position">
			          		<html:checkbox styleClass="campo" property="ferias" />
			          	</div>
					</div>
						    	
				    <div class="foco" style="float:right; clear:both;">
						<p>(<span class="obrigatorio">*</span>) Campo Obrigatório</p>
					</div>
	                    
	            </div>
			    <div class="final_formulario">
			    	<html:img src="${contexto}/WebContent/img/salvar.png" width="43" height="43" 
			    		onclick="javascript:confirmaOperacao();"/>					    	
			    	<html:img src="${contexto}/WebContent/img/voltar.png" width="54" height="43" alt="voltar" 
			    		onclick="javascript:cancelaOperacao();"/>
			    </div>						    
			</html:form>
		</div>		
	</tiles:put>
</tiles:insert>
