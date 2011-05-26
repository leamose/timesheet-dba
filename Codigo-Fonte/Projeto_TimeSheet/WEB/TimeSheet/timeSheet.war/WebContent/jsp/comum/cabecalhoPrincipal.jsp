<script>
	//REFRESH NA TELA PAI
	if(<%=request.getAttribute("submiter")%>) {
		confirmaOperacao();
	} 

	function mostraConsulta(){
		document.getElementById('consulta').style.display = '';				
		document.getElementById('consultaCombo').style.display = '';				
		document.getElementById('consultaCombo2').style.display = 'none';				
		document.getElementById('cadastroAtividade').style.display = 'none';				
	}

	function escondeConsulta(){
		document.getElementById('consulta').style.display = 'none';				
		document.getElementById('consultaCombo').style.display = 'none';				
		document.getElementById('consultaCombo2').style.display = '';				
		document.getElementById('cadastroAtividade').style.display = '';				
	}

	//ABRE POPUP FUNCIONARIOS
	function open_popPpFuncionario(url, urlRetorno, titulo) {
		var largura = 700;
		var altura = 452;
		parent.showPopWin(url, largura, altura, "50", titulo,0, urlRetorno);
	}	
	
	function configurar() {
		var form = document.forms[0];
		form.action = contexto + '/configurar/inicio.do'; 
		form.submit();
	}

	function inicioAtividade() {
		var form = document.forms[0];
		form.action = contexto + '/atividade/inicio.do?mostraConsulta=false&consulta=false&indicaAvaliacao=false'; 
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
		form.action = contexto + '/sair.do'; 
		form.submit();
	}
</script>


	<div id="header">
		<div class="titulo" style="padding-left: 8px;">
			<div class="foco" style="width: 40%;"><p>PLANEJAMENTO INDIVIDUAL DE ATIVIDADES DIÁRIAS</p></div>			
			<div class="barraIcones">
				<a href="#" onclick="javascript:escondeConsulta();inicioAtividade();">
					<html:img src="${contexto}/WebContent/img/iconeTarefas.png" title="minhas atividade"/></a>
				<c:if test="${form.indicaChefe}">
					<a href="#" onclick="javascript:mostraConsulta();inicioConsultarAtividade();">
						<html:img src="${contexto}/WebContent/img/pesquisarAtividade.png" title="atividade"/></a>
					<a href="#" onclick="javascript:configurar();">
						<html:img src="${contexto}/WebContent/img/configurarQuestionarios.png" title="configurar"/></a>
				</c:if>
					
				<c:if test="${form.indicaChefe}">						
					<a href="#" onclick="javascript:cadastrarFuncionario();">
						<html:img src="${contexto}/WebContent/img/cadastrarUsuario.png" title="funcionário"/></a>					
				</c:if>	
				<a href="#" onclick="javascript:sair();">
			    	<html:img src="${contexto}/WebContent/img/sair.png" alt="sair"/>
			    </a>			
			</div>	
		</div>	
		<div style="color: #fff">
		<!-- CABECALHO COLABORADOR -->
			<div class="foco" style="width: 25%;">
				<div class="labelDetalhar" style="width: 50%;">Calendário padrão:</div>
				<div class="input_position">8h00</div>
				<div class="input_position">18h00</div>
			</div>
			<div class="foco" style="width: 20%">
				<div class="labelDetalhar" style="width: 27%">Almoço:</div>
				<div class="input_position"> 12h00</div>
				<div class="input_position">14h00</div>
			</div>
			<div class="foco" style="width: 20%">
				<div class="labelDetalhar" style="width: 35%">MÊS/ANO:</div>
				<div class="input_position">${form.mesLiteral}</div>
				<div class="input_position">2011</div>
			</div>
			<div class="infoUsuario"><strong>Usuário:</strong> ${form.usuario.login}</div>
		</div>			
	</div>
