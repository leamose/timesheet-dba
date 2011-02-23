<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Cadastrar Funcionario</title>
		<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/default.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/mac_os_x.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/tooltip.css" rel="stylesheet" media="screen"/>	
		
		<script type="text/javascript">
			function voltar() {
				var form = document.forms[0];
				form.action = '${contexto}/funcionario/voltar.do'; 
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
					<a href="#" onclick="javascript:sair();">										
				    	<html:img src="${contexto}/WebContent/img/sair.png" alt="sair"/>
				    </a>
				</html:form>
			</div>
		</div>
		<!-- FIM TOPO -->
		<div style="background-color:#fff; background-image:none;height:84%;">
		<div class="botoesJanela" ></div>
			<html:form action="/funcionario/salvar" method="post">
			    <div class="formulario">					    						
					<!-- Espaco para mensagens -->
			    	<div class="boxMensagemS">
			          	<div class="textoMensagemS">Alguns erros foram encontrados. Por favor, reveja os campos assinalados em vermelho.</div>
			            <div class="iconeMensagemS">
			            	<html:img src="${contexto}/WebContent/img/block.png" width="32" height="32" />
			            </div>
			        </div>
			    	<div class="foco" style="width:auto;">
			   			<div class="label">Nome: *</div>
			          	<html:text styleClass="campo" name="form" property="nome" size="122"/>
					</div>
				
					<div class="foco" style="width:880px;">
			   			<div class="label">Cargo:</div>
			          	<html:text styleClass="campo" name="form" property="cargo" size="122"/>
					</div>	
			    
			    	<div class="foco">
		                <div class="label">Hora Trabalho Início:</div>
		                <html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
		            </div>
			    	<div class="foco">
		                <div class="label">Hora Trabalho Fim:</div>
		                <html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
		            </div>
			    	<div class="foco">
		                <div class="label">Hora Almoco Início:</div>
		                <html:text styleClass="campo" name="form" property="hora_almoco_inicio"/>
		            </div>
			    	<div class="foco">
		                <div class="label">Hora Almoco Fim:</div>
		               	<html:text styleClass="campo" name="form" property="hora_trabalho_fim"/>
		            </div>
		            
		            <div class="foco">
			   			<div class="label">Chefe:</div>
			          	<html:checkbox styleClass="campo" property="chefe" />
					</div>
		            <div class="foco">
			   			<div class="label">Férias:</div>
			          	<html:checkbox styleClass="campo" property="ferias" />
					</div>
			    	
			    </div>
			    
			    <div class="final_formulario">
			    	<html:img src="${contexto}/WebContent/img/salvar.png" width="43" height="43" 
			    		onclick="javascript:document.forms[0].submit();"/>					    	
			    	<html:img src="${contexto}/WebContent/img/voltar.png" width="54" height="43" alt="voltar" 
			    		onclick="javascript:voltar();"/>
			    </div>
						
			</html:form>
		</div>
	</body>
</html>
