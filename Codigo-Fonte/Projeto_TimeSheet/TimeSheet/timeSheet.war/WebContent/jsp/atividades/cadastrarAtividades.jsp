<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TimeSheet</title>
	<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css" /> 
	<link href="${contexto}/WebContent/css/default.css" rel="stylesheet" type="text/css" />
	<link href="${contexto}/WebContent/css/mac_os_x.css" rel="stylesheet" type="text/css" />
	<link href="${contexto}/WebContent/css/tooltip.css" rel="stylesheet" media="screen"/>
</head>

	<body style="background-color:#fff; background-image:none;">
		
		<html:form action="/atividade/cadastarAtividade.do">
		
			<table border width="1200" class="lista" style="margin:0px; padding:0px;" border="0" 
				cellspacing="0" cellpadding="0">
			  
				<tr>
					<th colspan="17" class="h1"><center>Atividade</center></th>  	
				</tr>
				<tr>
					 <th colspan="2" class="h1"><center>Dia para a atividade</center></th>
					 <th colspan="2" class="h1"><center>Início previsto</center></th>
					 <th colspan="2" class="h1"><center>Término previsto</center></th>
					 <th colspan="2" class="h1"><center>Horas díarias</center></th>
					 <th colspan="2" class="h1"><center>Saldo díario</center></th>
					 <th colspan="3" class="h1"><center>Centro de Custo</center></th>
					 <th colspan="4" class="h1"><center>Atividades a ser realizada</center></th>
				</tr>
				<tr>
					 <td><center>Data</center></td>
					 <td><center>Dia</center></td>
					 <td><center>Hora</center></td>
					 <td><center>Minuto</center></td>
					 <td><center>Hora</center></td>
					 <td><center>Minuto</center></td>
					 <td><center>Hora</center></td>
					 <td><center>Minuto</center></td>
					 <td><center>Hora</center></td>
					 <td><center>Minuto</center></td>                
					 <td width="420px"><center>OP</center></td>        
					 <td width="420px"><center>Metodologia</center></td>        
					 <td><center>No. Projeto</center></td>        
					 <td width="420px"><center>Atividade</center></td>        
					 <td width="120px"><center>Produto/Servico</center></td>        
					 <td width="420px"><center>Outros</center></td>        
					 <td width="420px"><center>Observações</center></td>
				</tr>
				<tr> 
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>
					 <td>
					 	<html:select property="id">
					 		<html:option value="teste">Teste</html:option>
						</html:select>
					</td>
					 <td><html:text property="id" size="5"/></td>
					 <td><html:text property="id" size="5"/></td>        
					 <td><html:text property="id" size="5"/></td>        
				</tr> 
				<tr> 
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>
					 <td>&nbsp;</td>        
					 <td>&nbsp;</td>        
				</tr> 
			     
			</table>
			
			<br><br><br>
    		<html:image src="${contexto}/WebContent/img/incluir.jpg"/>
    		
    	</html:form>
    	
	</body>
</html>
