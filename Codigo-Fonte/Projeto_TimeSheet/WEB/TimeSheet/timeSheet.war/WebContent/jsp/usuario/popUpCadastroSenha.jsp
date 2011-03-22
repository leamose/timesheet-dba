<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".popUp">	
	<tiles:put name="corpo" type="string">
		
		<div class="conteudo-formulario-detalhamento">
			<div class="formulario" style="width:auto; height:auto; padding-bottom:0px;">
				<html:form action="/senha/alterarSenha" method="post">
					<html:hidden property="login" value="${form.login}"/>
					<html:hidden property="codigoUsuario" value="${form.codigoUsuario}"/>
					
					<div class="foco" style="width:500px;">
					  	<div class="labelDetalhar">Login:</div>
					  	<div class="input_position">${form.login}</div>
					</div>													
					<div class="foco" style="width:80%;">
					  	<div class="labelDetalhar">Senha*:</div>
					  	<div class="input_position">
						  	<html:text styleClass="campoLeitura" name="form" property="senha" size="10"/>
						</div>
					</div>									
										    
				    <div class="botoesMeio">
				    	<html:image src="${contexto}/WebContent/img/salvarAzul.jpg" alt="salvar"/>
					   	<html:img src="${contexto}/WebContent/img/cancelar.jpg" 
				    		onclick="javascript:cancelaOperacao();"  width="128" height="20" alt="cancelar" />
				    </div>			    
				</html:form>
	        </div>
		</div>		
	</tiles:put>
</tiles:insert>
