<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Cadastrar Funcionario</title>
		<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/default.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/mac_os_x.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/tooltip.css" rel="stylesheet" media="screen"/>	
		
		<script type="text/javascript">
			function voltar() {
				var form = document.forms[0];
				form.action = '${contexto}/funcionario/voltar.do'; 
				form.submit();
			}
			
		</script>
			
	</head>

	<body>
		<html:form action="/funcionario/salvar" method="post">
						
			<div id="wrap">
				<div id="header">
				    <div class="barraIcones">
				    	<img src="${contexto}/WebContent/img/sair.png" alt="sair" width="29" height="30" style="float:right;" />
				    </div>
				</div>
				<div id="main">
					<div id="corpo">
						<div class="cabecalho">				    	
					        <div class="infoUsuario">
					        	<strong>Usuário:</strong> Fulano de Tal da Silva <strong>Perfil:</strong> Adminstrador
					        </div>
						</div>
					    <div class="formulario">
					    						
							<!-- Espaco para mensagens -->
					    	<div class="boxMensagemS">
					          	<div class="textoMensagemS">Alguns erros foram encontrados. Por favor, reveja os campos assinalados em vermelho.</div>
					            <div class="iconeMensagemS">
					            	<img src="${contexto}/WebContent/img/block.png" width="32" height="32" />
					            </div>
					        </div>
					    
					    	<div class="foco" style="width:auto;">
					   			<div class="label">Nome: *</div>
					          	<input class="campo" name="" type="text" style="width:750px;" value="" />
							</div>
						
							<div class="foco" style="width:auto;">
					   			<div class="label">Cargo: *</div>
					          	<input class="campo" name="" type="text" style="width:750px;" value="" />
							</div>	
					    
					    	<div class="foco">
				                <div class="label">Hora Trabalho Início:</div>
				                <input class="campo" name="" type="text" style="width:118px;" />
				            </div>
					    	<div class="foco">
				                <div class="label">Hora Trabalho Fim:</div>
				                <input class="campo" name="" type="text" style="width:108px;" />
				            </div>
					    	<div class="foco">
				                <div class="label">Hora Almoco Início:</div>
				                <input class="campo" name="" type="text" style="width:110px;" />
				            </div>
					    	<div class="foco">
				                <div class="label">Hora Almoco Fim:</div>
				                <input class="campo" name="" type="text" style="width:98px;" />
				            </div>
					    	
					    </div>
					    
					    <div class="final_formulario">
					    	<img src="${contexto}/WebContent/img/salvar.png" width="43" height="43" 
					    		onclick="javascript:document.forms[0].submit();"/>					    	
					    	<img src="${contexto}/WebContent/img/voltar.png" width="54" height="43" alt="voltar" 
					    		onclick="javascript:voltar();"/>
					    </div>
					</div>
				</div>
			</div>
		</html:form>
	</body>
</html>
