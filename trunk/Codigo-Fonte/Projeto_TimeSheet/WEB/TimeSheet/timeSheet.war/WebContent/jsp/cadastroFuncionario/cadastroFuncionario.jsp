<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".secundarias">	
	<tiles:put name="corpo" type="string"> 
		
		<div align="center">
        
            <div class="conteudo">
        
            	<div class="formulario-listagem">
	            	<div class="barra-titulo">
	                	<div class="titulo-formulario-pesquisa">
	            	        Cadastro de Funcionarios
	                    </div>
	            	</div>
		            <div class="conteudo-formulario-detalhamento">
						<html:form action="/funcionario/salvar" method="post">
						    <div class="formulario" style="width:auto; height:auto">				    						
								
						    	<div class="foco">
						   			<div class="labelDetalhar" style="width:130px;">Nome: *</div>
						          	<div class="input_position">
							          	<html:text styleClass="campo" name="form" property="nome" 
							          		style="width:600px;"/>
							        </div>
								</div>
							
								<div class="foco">
						   			<div class="labelDetalhar" style="width:130px;">Cargo:</div>
						   			<div class="input_position">
						          		<html:text styleClass="campo" name="form" property="cargo" 
						          			style="width:600px;"/>
						          	</div>
								</div>	
						    
						    	<div class="foco">
					                <div class="labelDetalhar" style="width:130px;">Hora Trabalho Início:</div>
					                <div class="input_position">
					                	<html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
					                </div>
					            </div>
						    	<div class="foco">
					                <div class="labelDetalhar" style="width:130px;">Hora Trabalho Fim:</div>
					                <div class="input_position" style="width:550px;">
					                	<html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
					                </div>
					            </div>
						    	<div class="foco">
					                <div class="labelDetalhar" style="width:130px;">Hora Almoco Início:</div>
					                <div class="input_position" style="width:550px;">
					                	<html:text styleClass="campo" name="form" property="hora_almoco_inicio"/>
					                </div>
					            </div>
						    	<div class="foco">
					                <div class="labelDetalhar" style="width:130px;">Hora Almoco Fim:</div>
					               	<div class="input_position">
					               		<html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
					               	</div>
					            </div>
					            
					            <div class="foco">
						   			<div class="labelDetalhar" style="width:130px;">Chefe:</div>
						   			<div class="input_position" style="width:550px;">
						          		<html:checkbox styleClass="campo" property="chefe" />
						          	</div>
								</div>
					            <div class="foco">
						   			<div class="labelDetalhar" style="width:130px;">Férias:</div>
						   			<div class="input_position">
						          		<html:checkbox styleClass="campo" property="ferias" />
						          	</div>
								</div>
						    	
						    </div>
						    
						    <div class="final_formulario">
						    	<html:img src="${contexto}/WebContent/img/salvar.png" width="43" height="43" 
						    		onclick="javascript:document.forms[0].submit();"/>					    	
						    	<html:img src="${contexto}/WebContent/img/voltar.png" width="54" height="43" alt="voltar" 
						    		onclick="javascript:voltar();"/>
						    </div>
									
						</html:form>
					</div>
				</div>
			</div>
		</div>
	</tiles:put>
</tiles:insert>
