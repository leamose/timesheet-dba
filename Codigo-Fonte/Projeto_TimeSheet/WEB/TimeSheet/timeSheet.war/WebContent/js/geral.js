function habilitarDiv(div){
	document.getElementById(div).style.display = '';				
}

function operacaoCancelada() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/operacaoCancelada.do'; 
	form.submit();
}

//CADASTRAR ATIVIDADE
function cadastrarAtividades() {
	open_popPpAtividade(contexto + '/atividade/cadastrarAtividade.do', retornoCadastrarAtividades, "Cadastrar Atividade") ;
}

function retornoCadastrarAtividades() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/retornoCadastrarAtividade.do'; 
	form.submit();
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

//CONSULTAR ATIVIDADE
function consultarAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/consultar.do'; 
	form.submit();
}

//DETALHAR
function detalharAtividade() {
	open_popPpAtividade(contexto + '/atividade/detalhar.do', retornoDetalharAtividade, "Detalhar Atividade") ;
}

function retornoDetalharAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/retornoDetalhar.do'; 
	form.submit();
}

//ALTERAR
function alterarAtividade() {
	open_popPpAtividade(contexto + '/atividade/alterar.do', retornoAlterarAtividade, "Alterar Atividade") ;
}

function retornoAlterarAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/retornoAlterar.do'; 
	form.submit();
}

//EXCLUIR
function excluirAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/excluir.do'; 
	form.submit();
}

//SAIR
function sair() {
	var form = document.forms[0];
	form.action = contexto + '/login.do'; 
	form.submit();
}

//VOLTAR
function voltar() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/voltar.do'; 
	form.submit();
}

//APROVAR
function aprovarAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/aprovar.do'; 
	form.submit();
}

//REPROVAR
function reprovarAtividade() {
	open_popPpAtividade(contexto + '/atividade/reprovar.do', returnoReprovarAtividade, "Reprovar Atividade") ;
}

function returnoReprovarAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/retornoReprovar.do'; 
	form.submit();
}

function returnSalvarPopUp() {	
	var form = document.forms[0];
	form.action = contexto + '/atividade/inicio.do';
	form.submit();
}

//PESQUISAR FUNCIONARIO
function pesquisarFuncionario() {	
	open_popPpPesquisaFunc(contexto + '/funcionario/consultar.do', retornoPesquisarFuncionario, "Pesquisa Funcionario") ;
}

function retornoPesquisarFuncionario() {	
	var form = document.forms[0];
	form.action = contexto + '/funcionario/retornoConsultar.do';
	form.submit();
}

function confirmaOperacao() {
	window.parent.hidePopWin(true);	
}	
			
function cancelaOperacao() {
	window.parent.hidePopWin(false);
}

//ABRE POPUP ATIVIDADES
function open_popPpAtividade(url, urlRetorno, titulo) {
	var largura = 720;
	var altura = 318;
	parent.showPopWin(url, largura, altura, "100", titulo,0, urlRetorno);
}

//ABRE POPUP PESQUISA FUNCIONARIOS
function open_popPpPesquisaFunc(url, urlRetorno, titulo) {
	var largura = 720;
	var altura = 300;
	parent.showPopWin(url, largura, altura, "100", titulo,0, urlRetorno);
}

//ABRE POPUP FUNCIONARIOS
function open_popPpFuncionario(url, urlRetorno, titulo) {
	var largura = 700;
	var altura = 252;
	parent.showPopWin(url, largura, altura, "100", titulo,0, urlRetorno);
}
