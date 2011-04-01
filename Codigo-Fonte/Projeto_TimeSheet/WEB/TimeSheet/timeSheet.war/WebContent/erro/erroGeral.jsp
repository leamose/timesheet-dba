<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="/WEB-INF/tlds/c-1_0-rt.tld" prefix="c" %>

<c:set var="contexto">${pageContext.request.contextPath}</c:set>

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
					<div id="corpologin">
						<span style="color:red;">
							<span style="color: red;">${param.mensagem}</span>
						</span>
						<br></br><br></br><br></br><br></br>
						<c:if test="${param.popUp eq false or param.popUp eq ''}">							 
							<a href="${contexto}">Retornar</a>
						</c:if>
						<br></br><br></br><br></br><br></br>
					</div>
			</div>
		</div>
	</body>
</html>
