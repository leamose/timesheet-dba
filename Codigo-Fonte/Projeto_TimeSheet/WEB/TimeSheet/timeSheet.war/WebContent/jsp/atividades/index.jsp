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
			
			function cadastrarAtividades() {
				var form = document.forms[0];
				form.action = '${contexto}/atividade/cadastarAtividade.do'; 
				form.submit();
			}
			
		</script>
		
	</head>
	<body>
		<!-- TOPO -->
		<div id="header">	
			<div class="barraTextoTopo">
				<table width="71%" cellspacing="0">
				<tr><th class="h1" colspan="5">PLANEJAMENTO INDIVIDUAL DE ATIVIDADES DIÁRIAS</th></tr>
					<tr><th colspan="5"><div style="text-align:center;float:center">Cliente: Ministerio da Justiça</div></th></tr>
					<tr>
						<th width="35%"><div class="foco">Calendário padrão:</div></th>
						<td width="12%">8h00</td>
						<td width="15%">18h00</td>
						<th width="15%">MÊS:</th>
						<td>Dezembro</td>						
					</tr>
					<tr>
						<th><div class="foco">Almoço:</div></th>
						<td> 8h00</td>
						<td>18h00</td>
						<th width="10%">Minino: </th>
						<td>1h</td>
					</tr>
					<tr>
						<th><div class="foco">Total horas no mês:</div></th>
						<td>176</td>
						<td>&nbsp;</td>						
						<th>ANO</th>
						<td>2010</td>
					</tr>
				</table>
			</div>
			<div class="barraIcones">
				<html:form action="/funcionario/cadastarFuncionario" method="post">
					<a href="#" onclick="javascript:cadastrarAtividades();">
						<html:img src="${contexto}/WebContent/img/novoContratoIcone.png" title="atividade"/>
					</a>					
					<a href="#" onclick="javascript:document.forms[0].submit();">
						<html:img src="${contexto}/WebContent/img/cadastrarUsuario.png" title="usuário"/></a>
					<html:img src="${contexto}/WebContent/img/cadastrarChefia.png" title="chefia"/></a>					
				    <html:img src="${contexto}/WebContent/img/sair.png" alt="sair"/>
				</html:form>
			</div>
		</div>
		<!-- FIM TOPO -->


		<!-- MIOLO -->
		<div style="background-color:#fff; background-image:none;height:78%;">
			<div class="botoesJanela" ></div>		
				<html:form action="/atividade/cadastarAtividade.do">
					<display:table name="form.listaAtividades" style="width:640px;" class="lista" id="tabela" length="100" pagesize="5" 
						requestURI="/atividade/inicio.do">
						<display:column title="Data" />
						<display:column title="Início previsto"/>
						<display:column property="data_hora_fim" title="Término previsto"/>
						<display:column title="Horas díarias"/>
						<display:column title="Saldo díario"/>											
						<display:column property="op_id" title="OP"/>
						<display:column property="metodologia_id" title="Metodologia"/>
						<display:column property="projeto_id" title="No. Projeto"/>
						<display:column property="atividade_original_id" title="Atividade"/>
						<display:column title="Produto/Servico"/>
						<display:column title="Outros"/>
						<display:column title="Observações"/>
					</display:table>
				</html:form>
		</div>   	
		<!-- FIM MIOLO -->
	</body>
</html>
