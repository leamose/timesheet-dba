function habilitarDiv(div){
	document.getElementById(div).style.display = '';				
}

function operacaoCancelada() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/operacaoCancelada.do'; 
	form.submit();
}

function cadastrarAtividades() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/cadastrarAtividade.do'; 
	form.submit();
}

function consultarAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/consultar.do'; 
	form.submit();
}

function detalharAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/detalhar.do'; 
	form.submit();
}

function alterarAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/alterar.do'; 
	form.submit();
}

function excluirAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/excluir.do'; 
	form.submit();
}

function sair() {
	var form = document.forms[0];
	form.action = contexto + '/login.do'; 
	form.submit();
}

function voltar() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/voltar.do'; 
	form.submit();
}

function aprovarAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/aprovar.do'; 
	form.submit();
}

function reprovarAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/reprovar.do'; 
	form.submit();
}

function returnSalvarPopUp() {
	alert("entrei")
	var form = document.forms[0];
	form.action = contexto + '/atividade/inicio.do';
	form.submit();
}

function confirmaOperacao() {
	window.parent.hidePopWin(true);	
}	
			
function cancelaOperacao() {
	window.parent.hidePopWin(false);
}

function open_popPp() {
	var largura = 730;
	var altura = 353;
	parent.showPopWin(contexto + "/atividade/abrePopUpCadastrarAtividade.do", largura, altura, "100", "Cadastrar Atividade",0, returnSalvarPopUp);
}

function open_popPpFuncionario() {
	var largura = 730;
	var altura = 257;
	parent.showPopWin(contexto + "/funcionario/abrePopUpCadastrarFuncionario.do", largura, altura, "100", "Cadastrar Funcionario",0, returnSalvarPopUp);
}
