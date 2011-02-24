<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head> 
		<link href="${contexto}/WebContent/css/displaytag.css" rel="stylesheet" type="text/css"/>
		<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/default.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/mac_os_x.css" rel="stylesheet" type="text/css" />
		<link type="text/css" rel="stylesheet" href="${contexto}/WebContent/css/calendario.css"/>
		<link rel="stylesheet" href="${contexto}/WebContent/css/tooltip.css" media="screen"/>
		<script type="text/javascript" src="${contexto}/WebContent/js/geral.js"></script>

		<script type="text/javascript">
			var contexto = '${contexto}';
		</script>

	</head>

    <body >					
    	<tiles:insert name="cabecalho" />
		<tiles:insert name="corpo" />
    </body>
</html>