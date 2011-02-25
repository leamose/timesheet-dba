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