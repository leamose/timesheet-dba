<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".secundarias">	
	<tiles:put name="corpo" type="string"> 
		<div style="background-color:#fff; background-image:none;height:84%;">
		<div class="botoesJanela" ></div>
			<html:form action="/funcionario/salvar" method="post">
			    <div class="formulario" style="height:450px">					    						
					<!-- Espaco para mensagens -->
			    	<div class="boxMensagemS">
			          	<div class="textoMensagemS">Alguns erros foram encontrados. Por favor, reveja os campos assinalados em vermelho.</div>
			            <div class="iconeMensagemS">
			            	<html:img src="${contexto}/WebContent/img/block.png" width="32" height="32" />
			            </div>
			        </div>
			    	<div class="foco" style="width:auto;">
			   			<div class="label">Nome: *</div>
			          	<html:text styleClass="campo" name="form" property="nome" size="122"/>
					</div>
				
					<div class="foco" style="width:1180px;">
			   			<div class="label">Cargo:</div>
			          	<html:text styleClass="campo" name="form" property="cargo" size="122"/>
					</div>	
			    
			    	<div class="foco">
		                <div class="label">Hora Trabalho Início:</div>
		                <html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
		            </div>
			    	<div class="foco">
		                <div class="label">Hora Trabalho Fim:</div>
		                <html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
		            </div>
			    	<div class="foco">
		                <div class="label">Hora Almoco Início:</div>
		                <html:text styleClass="campo" name="form" property="hora_almoco_inicio"/>
		            </div>
			    	<div class="foco">
		                <div class="label">Hora Almoco Fim:</div>
		               	<html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
		            </div>
		            
		            <div class="foco">
			   			<div class="label">Chefe:</div>
			          	<html:checkbox styleClass="campo" property="chefe" />
					</div>
		            <div class="foco">
			   			<div class="label">Férias:</div>
			          	<html:checkbox styleClass="campo" property="ferias" />
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
	</tiles:put>
</tiles:insert>
