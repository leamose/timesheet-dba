<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/default.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/mac_os_x.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="css/tooltip.css" media="screen"/>		
		<title>Documento sem título</title>
		
		<script type="text/javascript">
			function habilitarDiv(div){
				document.getElementById(div).style.display = '';				
			}
		</script>
		
	</head>
	<body>
		<!-- TOPO -->
		<div id="header">	
			<div class="barraTextoTopo"></div>		
			<div class="barraIcones">
				<html:form action="/funcionario/cadastarFuncionario" method="post">
					<a href="#" onclick="javascript:document.forms[0].submit();">
						<html:img src="${contexto}/WebContent/img/cadastrarUsuario.png" title="usuário"/></a>
					<html:img src="${contexto}/WebContent/img/cadastrarChefia.png" title="chefia"/></a>					
				    <html:img src="${contexto}/WebContent/img/sair.png" alt="sair"/>
				</html:form>
			</div>
		</div>
		<!-- FIM TOPO -->

		<!-- MIOLO -->
		<div style="background-color:#fff; background-image:none;height:62%;">	
		<div class="botoesJanela" ></div>	
			<html:form action="/atividade/cadastarAtividade.do">
				<table class="lista" style="margin:2px; padding-left:2px; padding-right:5px;" width="100%" border="0"
					cellspacing="0" cellpadding="0" >
					<tr>
						<th class="h1" width="5%"><center>Data</center></td>
						<th class="h1" width="5%"><center>Início previsto</center></th>
						<th class="h1" width="5%"><center>Término previsto</center></th>
						<th class="h1" width="5%"><center>Horas díarias</center></th>
						<th class="h1" width="5%"><center>Saldo díario</center></th>
						<th class="h1" width="10%"><center>OP</center></td>        
						<th class="h1" width="10%"><center>Metodologia</center></td>        
						<th class="h1" width="10%"><center>No. Projeto</center></td>        
						<th class="h1" width="10%"><center>Atividade</center></td>        
						<th class="h1" width="10%"><center>Produto/Servico</center></td>        
						<th class="h1" width="10%"><center>Outros</center></td>        
						<th class="h1" width="10%"><center>Observações</center></td>
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
					</tr>			     
				</table>	
	   		</html:form> 
	   	</div>   	
		<!-- FIM MIOLO -->		
		
		<div style="background-color:#ece9d8; background-image:none;">
			<div style="width:100%; height:10px; background-color:#00779e;">
				<a href="#">
					<img style="float:right;" src="${contexto}/WebContent/img/setasEx.jpg" width="11" height="10" 
						onclick="javascript:habilitarDiv('camposAtividades');"/>
				</a>
			</div>					
			<div class="boxBotoesVertical">
				<img src="${contexto}/WebContent/img/imprimir.png" width="20" height="18" title="imprimir" />
		   		<img src="${contexto}/WebContent/img/recurso.png" width="20" height="21" title="cadastrar atividade" />
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
