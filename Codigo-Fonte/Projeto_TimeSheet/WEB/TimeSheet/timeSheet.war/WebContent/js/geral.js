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

/***********************************************
* Collapsible Frames script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for use
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

var columntype=""
var defaultsetting=""

function getCurrentSetting(){
if (document.body)
	return (document.body.cols)? document.body.cols : document.body.rows
}

function setframevalue(coltype, settingvalue){
	if (coltype=="rows")
		document.body.rows=settingvalue
	else if (coltype=="cols")
		document.body.cols=settingvalue
}

function resizeFrame(contractsetting){
	if (getCurrentSetting()!=defaultsetting)
		setframevalue(columntype, defaultsetting)
	else
		setframevalue(columntype, contractsetting)
}

function init(){
	if (!document.all && !document.getElementById) return
	if (document.body!=null){
		columntype=(document.body.cols)? "cols" : "rows"
		defaultsetting=(document.body.cols)? document.body.cols : document.body.rows
	}
	else
		setTimeout("init()",100)
}

setTimeout("init()",100)