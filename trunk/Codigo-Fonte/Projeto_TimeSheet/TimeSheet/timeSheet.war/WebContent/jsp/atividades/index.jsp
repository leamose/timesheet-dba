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
	</head>
	
	</head>
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

		<!-- MIOLO -->
		<div style="background-color:#fff; background-image:none;height:50%">	
		<div class="botoesJanela" style=" word-spacing:10px;"></div>	
			<html:form action="/atividade/cadastarAtividade.do">
				<table class="lista" style="margin:0px; padding:0px;" width="100%" border="1"
					cellspacing="0" cellpadding="0" >				
					<tr>
						 <th colspan="2" class="h1"><center>Dia</center></th>
						 <th colspan="2" class="h1"><center>Início previsto</center></th>
						 <th colspan="2" class="h1"><center>Término previsto</center></th>
						 <th colspan="2" class="h1"><center>Horas díarias</center></th>
						 <th colspan="2" class="h1"><center>Saldo díario</center></th>
						 <th colspan="3" class="h1"><center>Centro de Custo</center></th>
						 <th colspan="5" class="h1"><center>Atividades a ser realizada</center></th>					 
					</tr>
					<tr>
						<td class="h1" width="120px"><center>Data</center></td>
						<td class="h1" width="120px"><center>Dia</center></td>
						<td class="h1" width="120px"><center>Hora</center></td>
						<td class="h1" width="120px"><center>Minuto</center></td>
						<td class="h1" width="120px"><center>Hora</center></td>
						<td class="h1" width="125px"><center>Minuto</center></td>
						<td class="h1" width="125px"><center>Hora</center></td>
						<td class="h1" width="120px"><center>Minuto</center></td>
						<td class="h1" width="120px"><center>Hora</center></td>
						<td class="h1" width="120px"><center>Minuto</center></td>                
						<td class="h1" width="420px"><center>OP</center></td>        
						<td class="h1" width="420px"><center>Metodologia</center></td>        
						<td class="h1" width="420px"><center>No. Projeto</center></td>        
						<td class="h1" width="420px"><center>Atividade</center></td>        
						<td class="h1" width="120px"><center>Produto/Servico</center></td>        
						<td class="h1" width="420px"><center>Outros</center></td>        
						<td width="420px"><center>Observações</center></td>
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
	   		</html:form> 
	   	</div>   	
		<!-- FIM MIOLO -->
		
		
		<div style="background-color:#ece9d8; background-image:none;">
			<div style="width:100%; height:10px; background-color:#00779e;">
				<a href="javascript:parent.resizeFrame('100,*,10')"><img style="float:right;" src="${contexto}/WebContent/img/setasEx.jpg" width="11" height="10" /></a>
			</div>		
			<div class="boxBotoesVertical">
				<img src="${contexto}/WebContent/img/imprimir.png" width="20" height="18" title="imprimir" />
	   			<img src="${contexto}/WebContent/img/recurso.png" width="20" height="21" title="recursos" />
			</div>
			
			<!-- INICIO TEXTAREA -->
			<div style="width:340px; margin-bottom: 10px;; float:right; display:table-column;">
				<div class="foco">
				  	<div class="label">Atividade a ser realizada:</div>
					<textarea class="campo" name="textarea" style="width:320px; height:50px;" id="textarea" cols="45" rows="2"></textarea>
				</div>
				<div class="foco">
					<div class="label">Observações:</div>
				  	<textarea class="campo" name="textarea2" style="width:320px; height:50px;" id="textarea2" cols="45" rows="2"></textarea>
				</div>
			</div>
			<!-- FIM TEXTAREA -->	
			
			<div class="foco">
			  	<div class="label">Data Atividade:</div>
			  	<input class="campoLeitura" name="input12" cols="" rows="" style="width:85px;" />
			</div>													
			<div class="foco">
			  	<div class="label">Dia Atividade:</div>
			  	<input class="campoLeitura" name="input12" cols="" rows="" style="width:77px;" />
			</div>															
			<div class="foco">
			  	<div class="label">Início Previsto:</div>
			  	<input class="campoLeitura" name="input3" cols="" rows="" style="width:82px;" />
			</div>									
			<div class="foco">
			  	<div class="label">Termino Previsto:</div>
			  	<input class="campoLeitura" name="input9" cols="" rows="" style="width:99px;" />
			</div>															
			<div class="foco">
			  	<div class="label">OP:</div>
			  	<input class="campoLeitura" name="input2" cols="" rows="" style="width:292px;" />
			</div>							
			<div class="foco">
			<div class="label">Metodologia:</div>
				<input class="campoLeitura" name="input7" cols="" rows="" style="width:80px;" />		  
			</div>											
			<div class="foco">
				<div class="label">Nº Projeto:</div>
			  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:61px;" />
			</div>							
			<div class="foco">
				<div class="label">Produto/Serviço:</div>
			  	<input class="campoLeitura" name="input11" cols="" rows="" style="width:95px;" />
			</div>
		</div>		
	</body>
</html>
