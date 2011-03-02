<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>...::: TIMESHEET :::...</title>
		<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${contexto}/WebContent/js/prototype.js"> </script>
		<script type="text/javascript" src="${contexto}/WebContent/js/window.js"> </script>
		<script type="text/javascript" src="${contexto}/WebContent/js/servidor.js"> </script>
		<link href="${contexto}/WebContent/css/default.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/mac_os_x.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div id="wrap">	
			<div id="headerModulo"></div>		
			<div id="main">
				<span style="color:red;">
					<span style="color: red;">${param.mensagem}</span>
				</span>
				<div id="corpologin">
					<div class="topologin"></div>
					<div class="formulario">
						<div style="width: 770px; float: left; background-image: url('${contexto}/WebContent/img/bg_login.jpg'); background-repeat: repeat-x; margin-bottom: 5px; vertical-align: middle; height: 121px;">
							<img src="${contexto}/WebContent/img/cadeado.jpg" width="261" height="121" 
								style="float: left;" />
								
							<html:form action="/inicio/logar.do" method="post">
								<div class="foco" style="margin-top: 32px;">
									<div class="labelLogin">Usu&aacute;rio:</div>
									<input type="text" name="j_username" maxlength="100" style="width: 120px;" 
										class="campoLogin"/>
								</div>

								<div class="foco" style="margin-top: 32px;">
									<div class="labelLogin">Senha:</div>
									<input type="password" name="j_password" style="width: 120px;" 
										class="campoLogin"/>
								</div>								
								<br><br>
								<a href="#" class="button" onclick="javascript:document.forms[0].submit();">	
									<img src="${contexto}/WebContent/img/entrar.png"/>
								</a>
							</html:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
