<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/default.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/mac_os_x.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${contexto}/WebContent/css/tooltip.css" media="screen">		
		<title>Documento sem título</title>
	</head></head>
	<body>
		<!-- TOPO -->
		<div id="header">	
			<div class="barraTextoTopo">Nome do Projeto - PFB: 000</div>		
			<div class="barraIcones">
				<html:form action="/funcionario/cadastarFuncionario" method="post">
					<a href="#" onclick="javascript:document.forms[0].submit();">
						<html:img src="${contexto}/WebContent/img/cadastrarUsuario.png" title="usuário"/></a>
			       	</a>								
					<html:img src="${contexto}/WebContent/img/cadastrarChefia.png" title="chefia"/></a>
					<html:img src="${contexto}/WebContent/img/voltarP.png" title="voltar" alt="Voltar" />
				    <html:img src="${contexto}/WebContent/img/sair.png" alt="sair"/>
				</html:form>
			</div>
		</div>
		<!-- FIM TOPO -->
	</body>
</html>
