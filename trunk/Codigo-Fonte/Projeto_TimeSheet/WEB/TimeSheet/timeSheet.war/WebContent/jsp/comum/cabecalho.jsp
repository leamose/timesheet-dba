<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<script>

	//ABRE POPUP FUNCIONARIOS
	function open_popPpFuncionario(url, urlRetorno, titulo) {
		var largura = 700;
		var altura = 452;
		parent.showPopWin(url, largura, altura, "50", titulo,0, urlRetorno);
	}

	//CADASTRAR ATIVIDADE
	function cadastrarAtividades() {
		open_popPpAtividade(false, contexto + '/atividade/cadastrarAtividade.do?acao=salvar', retornoInicio, "Cadastrar Atividade", 720, 445);
	}
	
	function configurar() {
		var form = document.forms[0];
		form.action = contexto + '/configurar/inicio.do'; 
		form.submit();
	}

	//CADASTRAR FUNCIONARIO
	function cadastrarFuncionario() {	
		var form = document.forms[0];
		form.action = contexto + '/funcionario/cadastrarFuncionario.do'; 
		form.submit();
	}

	//SAIR
	function sair() {
		var form = document.forms[0];
		form.action = contexto + '/logout.do'; 
		form.submit();
	}
</script>


<!-- TOPO -->
	<div id="header">	
		<div class="barraTextoTopo">
			<table width="100%" cellpadding="0">
				<tr>
					<th colspan="5"  align="left">PLANEJAMENTO INDIVIDUAL DE ATIVIDADES DIÁRIAS</th>
				</tr>
				<tr>
					<th colspan="5"
						style="border-bottom:1px solid #FFF; padding-bottom:4px;">
							<div style="text-align:left;float:center">Cliente: Ministerio da Justiça</div>
					</th>
				</tr>
				<tr>
					<td>
						<table width="480px;" >
							<tr>
								<th width="32%" align="right">Calendário padrão:</th>
								<td width="8%" align="left">8h00</td>
								<td width="15%" align="left">18h00</td>
								<th width="15%" align="right">MÊS:</th>
								<td align="left">Março</td>						
							</tr>
							<tr>
								<th align="right">Almoço:</th>
								<td align="left"> 12h00</td>
								<td align="left">14h00</td>
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
						</td>
						<td>
						<table>
							<tr>
								<th width="32%" align="right">Saldo diario:</th>
								<td width="8%" align="left">8</td>														
							</tr>
							<tr>
								<th align="right">Saldo Mensal:</th>
								<td align="left"> 130</td>
							</tr>
							<tr>
								<th align="right">Banco de Horas:</th>
								<td align="left">0</td>								
							</tr>
						</table>
					</td>
				</tr>
				
			</table>			
		</div>
		<div class="barraIcones">
			<html:form action="/atividade/inicio" method="post">
				<a href="#" onclick="javascript:cadastrarAtividades();">
					<html:img src="${contexto}/WebContent/img/novoContratoIcone.png" title="atividade"/></a>					
				<a href="#" onclick="javascript:cadastrarFuncionario();">
					<html:img src="${contexto}/WebContent/img/cadastrarUsuario.png" title="funcionário"/></a>
				<a href="#" onclick="javascript:configurar();">
					<html:img src="${contexto}/WebContent/img/configurarQuestionarios.png" title="configurar"/></a>
				<a href="#" onclick="javascript:sair();">
			    	<html:img src="${contexto}/WebContent/img/sair.png" alt="sair"/>
			    </a>
			</html:form>
		</div>
	</div>
	<!-- FIM TOPO -->