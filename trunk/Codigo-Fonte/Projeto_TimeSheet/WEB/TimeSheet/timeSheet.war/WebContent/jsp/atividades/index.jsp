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
				form.action = '${contexto}/atividade/cadastrarAtividade.do'; 
				form.submit();
			}
			
			function sair() {
				var form = document.forms[0];
				form.action = '${contexto}/login.do'; 
				form.submit();
			}
			
		</script>
		
	</head>
	<body>
		<!-- TOPO -->
		<div id="header">	
			<div class="barraTextoTopo">
				<table width="71%" cellspacing="0">
					<tr>
						<th colspan="5" align="left">PLANEJAMENTO INDIVIDUAL DE ATIVIDADES DIÁRIAS</th>
					</tr>
					<tr>
						<th colspan="5">
							<div style="text-align:left;float:center">Cliente: Ministerio da Justiça</div>
						</th>
					</tr>
					<tr>
						<th width="32%" align="right">Calendário padrão:</th>
						<td width="8%" align="left">8h00</td>
						<td width="15%" align="left">18h00</td>
						<th width="15%" align="right">MÊS:</th>
						<td align="left">Dezembro</td>						
					</tr>
					<tr>
						<th align="right">Almoço:</th>
						<td align="left"> 8h00</td>
						<td align="left">18h00</td>
						<th width="10%" align="right">Minino: </th>
						<td align="left">1h</td>
					</tr>
					<tr>
						<th align="right">Total horas no mês:</th>
						<td align="left">176</td>
						<td>&nbsp;</td>						
						<th align="right">ANO:</th>
						<td align="left">2010</td>
					</tr>
				</table>
			</div>
			<div class="barraIcones">
				<html:form action="/funcionario/cadastarFuncionario" method="post">
					<a href="#" onclick="javascript:cadastrarAtividades();">
						<html:img src="${contexto}/WebContent/img/novoContratoIcone.png" title="atividade"/>
					</a>					
					<a href="#" onclick="javascript:document.forms[0].submit();">
						<html:img src="${contexto}/WebContent/img/cadastrarUsuario.png" title="funcionário"/>
					</a>
										
				    
					<a href="#" onclick="javascript:sair();">
				    	<html:img src="${contexto}/WebContent/img/sair.png" alt="sair"/>
				    </a>
				</html:form>
			</div>
		</div>
		<!-- FIM TOPO -->


		<!-- MIOLO -->
		<div style="background-color:#fff; background-image:none;height:84%;">
			<div class="botoesJanela" ></div>		
				<html:form action="/atividade/inicio.do">
					<display:table name="${listaAtividades}" style="width:98%;" class="lista" id="tabela" 
						length="100" pagesize="15" requestURI="/atividade/inicio.do" cellspacing="0">
						<display:column style="width:auto;">
							<img src="${contexto}/WebContent/img/aprov_mao.gif" title="aprovado"/></a>
						</display:column>
						<display:column property="data" title="Data">
							<img src="${contexto}/WebContent/img/aprov_mao.gif" width="14" height="14" 
								title="aprovado" style="border:none;" /></a>
						</display:column>
						<display:column property="inicioPrevisto" title="Início"/>
						<display:column property="terminoPrevisto" title="Fim"/>
						<display:column property="horasDiarias" title="Horas"/>
						<display:column property="saldoDiario" title="Saldo"/>											
						<display:column property="descricaoOp" title="OP"/>
						<display:column property="descricaoMetodologia" title="Metodologia"/>
						<display:column property="numeroProjeto" title="No. Projeto"/>
						<display:column property="descricaoAtividade" title="Atividade" style="width:20%"/>
						<display:column property="produtoServico" title="Produto/Servico"/>
						<display:column property="outros" title="Outros"/>
						<display:column property="observacoes" title="Observações"/>
					</display:table>
				</html:form>
		</div>   	
		<!-- FIM MIOLO -->
	</body>
</html>
