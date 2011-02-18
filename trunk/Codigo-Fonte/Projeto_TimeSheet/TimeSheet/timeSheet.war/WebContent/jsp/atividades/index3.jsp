<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/default.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/mac_os_x.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="css/tooltip.css" media="screen">		
		<title>Documento sem título</title>
		
		<script type="text/javascript">

			/***********************************************
			* Collapsible Frames script- © Dynamic Drive (www.dynamicdrive.com)
			* This notice must stay intact for use
			* Visit http://www.dynamicdrive.com/ for full source code
			***********************************************/
			
			var columntype=""
			var defaultsetting=""
			
			function getCurrentSetting(){
			if (document.body)
				return (document.body.cols)? document.body.cols : document.body.rows
			}
			
			function setframevalue(coltype, settingvalue){
				if (coltype=="rows")
					document.body.rows=settingvalue
				else if (coltype=="cols")
					document.body.cols=settingvalue
			}
			
			function resizeFrame(contractsetting){
				if (getCurrentSetting()!=defaultsetting)
					setframevalue(columntype, defaultsetting)
				else
					setframevalue(columntype, contractsetting)
			}
			
			function init(){
				if (!document.all && !document.getElementById) return
				if (document.body!=null){
					columntype=(document.body.cols)? "cols" : "rows"
					defaultsetting=(document.body.cols)? document.body.cols : document.body.rows
				}
				else
					setTimeout("init()",100)
			}
			
			setTimeout("init()",100)

		</script>
	</head>
	<frameset rows="100,*,160" frameborder="no" border="0" framespacing="0" id="framePrincipal">
	  <frame src="${contexto}/WebContent/jsp/atividades/topo.jsp" name="topFrame" 
	  	scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
	  <frame src="${contexto}/WebContent/jsp/atividades/miolo.jsp" name="mainFrame" 
	  	id="mainFrame" title="mainFrame" /><!--
	  <frame src="${contexto}/WebContent/jsp/atividades/rodape.jsp" name="bottomFrame" 
	  	scrolling="No" noresize="noresize" id="bottomFrame" title="bottomFrame" />
	  --><frame src="${contexto}/WebContent/jsp/atividades/rodape.jsp" name="bottomFrame" 
	  	scrolling="No" noresize="noresize" id="bottomFrame" title="bottomFrame" />
	</frameset>
	<noframes><body>
	</body></noframes>
</html>
