<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="/WEB-INF/tlds/c-1_0-rt.tld" prefix="c" %>

<c:set var="contexto">${pageContext.request.contextPath}</c:set>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>...::: SisRH - FCT :::...</title>
		<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${contexto}/WebContent/js/prototype.js"> </script>
		<script type="text/javascript" src="${contexto}/WebContent/js/window.js"> </script>
		<script type="text/javascript" src="${contexto}/WebContent/js/servidor.js"> </script>
		<link href="${contexto}/WebContent/css/default.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/mac_os_x.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div id="wrap">
			<div id="header"></div>
			<div id="main">
				<span style="color:red;">
					<span style="color: red;">${param.mensagem}</span>
				</span>
				<div id="corpologin">
					<br></br><br></br><br></br><br></br>
					<a href="${contexto}">Retornar</a>
					<br></br><br></br><br></br><br></br>
				</div>
			</div>
		</div>
	</body>
</html>
