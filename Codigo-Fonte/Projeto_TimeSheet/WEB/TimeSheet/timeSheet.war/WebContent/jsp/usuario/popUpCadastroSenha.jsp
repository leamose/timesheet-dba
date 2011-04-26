<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${contexto}/WebContent/css/displaytag.css" rel="stylesheet" type="text/css"/>
		<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css"/>
		<link href="${contexto}/WebContent/css/submodal.css" rel="stylesheet" type="text/css"/>
		
		<script type="text/javascript" src="${contexto}/WebContent/js/geral.js"></script>
		<script type="text/javascript" src="${contexto}/WebContent/js/prototype.js"></script>
		<script type="text/javascript" src="${contexto}/WebContent/js/submodal.js"></script>
		<script type="text/javascript" src="${contexto}/WebContent/js/submodalsource.js"></script>


</head>
	<body>
		<div id="wrap"> 
		<div id="header"></div> 
			<div id="main">
				<div id="corpologin"" style="width:770px;margin: 5%">
					<div class="topologin"></div>
				
				    <div class="formulario" >
				    	<div style=" width:770px; float:left; background-image:url(img/bg_login.jpg); background-repeat:repeat-x; margin-bottom:5px; vertical-align:middle; height:121px;">
				    
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
								  	<html:password styleClass="campoLeitura" name="form" property="senha" size="10"/>
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
				    <div class="final_login"></div>
				    
				</div>
			</div> 
		
		</div> 
	
	</body>
</html>



