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
	var altura = 415;
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

//METODOS DE VALIDACAO
function vazio(texto) {
	if(document.activeElement.tagName == 'INPUT') {
		for(i=0; i < texto.length; i++)
			if(texto.charAt(i) != ' ')
				return false;
		return true;
	}
	else
		return false;
		
}

function SaltaCampo(campo,prox,tammax,teclapres)
{
	var tecla = teclapres;
	vr = document.forms[0][campo].value;

	if(vazio(document.all.item(document.activeElement.getAttribute('name')).value))
		document.all.item(document.activeElement.getAttribute('name')).value = '';
	
	if( tecla == 109 || tecla == 189 || tecla == 188 || tecla == 110 || tecla == 111 || tecla == 223 || tecla == 108 )
	{
		document.forms[0][campo].value = vr.substr( 0, vr.length - 1 );
	}
	else
	{
	 	vr = vr.replace( "-", "" );
	 	vr = vr.replace( "/", "" );
	 	vr = vr.replace( "/", "" );
	 	vr = vr.replace( ",", "" );
	 	vr = vr.replace( ".", "" );
	 	vr = vr.replace( ".", "" );
	 	vr = vr.replace( ".", "" );
	 	vr = vr.replace( ".", "" );
	 	tam = vr.length;	

	 	if (tecla != 0 && tecla != 9 && tecla != 16 )
			if ( tam == tammax )
				document.forms[0][prox].focus() ;
	}
}

function FormataData(Campo,teclapres)
{
	var tecla = teclapres;
	vr = document.forms[0][Campo].value;
	vr = vr.replace( ".", "" );
	vr = vr.replace( "/", "" );
	vr = vr.replace( "/", "" );
	tam = vr.length + 1;

	if(vazio(document.all.item(document.activeElement.getAttribute('name')).value)) document.all.item(document.activeElement.getAttribute('name')).value = '';

	if ( tecla != 9 && tecla != 8 && tecla != 46 )
	{
		if ( tam > 2 && tam < 5 )
			document.forms[0][Campo].value = vr.substr( 0, tam - 2  ) + '/' + vr.substr( tam - 2, tam );
		if ( tam >= 5 && tam <= 10 )
			document.forms[0][Campo].value = vr.substr( 0, 2 ) + '/' + vr.substr( 2, 2 ) + '/' + vr.substr( 4, 4 );
	}
}

function ValidaData(data) {
	// Valida se a data entrada eh valida e se esta no formato dd/mm/aaaa
	// ou se é nula
	var dt;
	var fc_i;
	var fc_a1;
	var fc_str;
	var fc_CharsValidos = "0123456789"
	var fc_dia = data.substring(0, 2)
	var fc_b1 = data.substring(2, 3)
	var fc_mes = data.substring(3, 5)
	var fc_b2 = data.substring(5, 6)
	var fc_ano = data.substring(6, 10)

	if (data.length == 0) return(true);
	
	if (data.length != 10) return(false);
	
	fc_dia = data.substring(0, 2)
	fc_b1 = data.substring(2, 3)
	fc_mes = data.substring(3, 5)
	fc_b2 = data.substring(5, 6)
	fc_ano = data.substring(6, 10)

	dt = fc_dia + fc_mes + fc_ano

	for (fc_i = 0; fc_i <= 7; fc_i++) {
		fc_a1 = dt.substring(fc_i, ++fc_i);
		fc_str = fc_CharsValidos.indexOf(fc_a1);
		if (fc_str == -1) return(false);
	}
	
	if (fc_mes < 1 || fc_mes > 12) return(false);
	if (fc_b1 != '/')  return(false);
	if (fc_dia < 1 || fc_dia > 31) return(false);
	if (fc_b2 != '/')  return(false);
	if (fc_ano<1)  return(false);
	if (fc_mes == 4 || fc_mes == 6 || fc_mes == 9 || fc_mes == 11) {
		if (fc_dia == 31)  return(false);
		if (fc_ano < 1753) return(false);
	}
	if (fc_mes == 2){
		fc_a1 = parseInt(fc_ano/4);
		if (isNaN(fc_a1)) return(false);
	if (fc_dia > 29) return(false);
	if (fc_dia == 29 && ((fc_ano/4) != parseInt(fc_ano/4))) return(false);
	}
	
	return(true);
}

function ValidaHora(hora) {
	// Valida se a hora entrada eh valida e se esta no formato hh:mm
	// ou se é nula
	var hr;
	var fc_i;
	var fc_a1;
	var fc_str;
	var fc_CharsValidos = "0123456789"
	var fc_hora = hora.substring(0, 2)
	var fc_p1 = hora.substring(2, 3)
	var fc_min = hora.substring(3, 5)

	if (hora.length == 0) return(true);
	
	if (hora.length != 5) return(false);
	
	fc_hora = hora.substring(0, 2)
	fc_p1 = hora.substring(2, 3)
	fc_min = hora.substring(3, 5)

	hr = fc_hora + fc_min

	for (fc_i = 0; fc_i <= 3; fc_i++) {
		fc_a1 = hr.substring(fc_i, ++fc_i);
		fc_str = fc_CharsValidos.indexOf(fc_a1);
		if (fc_str == -1) return(false);
	}
	
	if (fc_hora > 23) return(false);
	if (fc_p1 != ':')  return(false);
	if (fc_min > 59) return(false);
		
	return(true);
}

function FormataHora(Campo,teclapres)
{
	var tecla = teclapres;
	vr = document.forms[0][Campo].value;
	vr = vr.replace( ".", "" );
	vr = vr.replace( ":", "" );
	vr = vr.replace( ":", "" );
	tam = vr.length + 1;

	if(vazio(document.all.item(document.activeElement.getAttribute('name')).value)) document.all.item(document.activeElement.getAttribute('name')).value = '';

	if ( tecla != 9 && tecla != 8 && tecla != 46 )
		if ( tam > 2 && tam <= 5 )
			document.forms[0][Campo].value = vr.substr( 0, tam - 2  ) + ':' + vr.substr( tam - 2, tam );
}

function LiberaBotao() {

	if(document.tarefa.data.value != '') 
	   document.tarefa.OK.disabled = false
	else
		document.tarefa.OK.disabled = true
}

function LiberaBotaoX() {

	if(document.tarefa.data.value != '')
		document.tarefa.X.disabled = false
	else
		document.tarefa.X.disabled = true
}

function LiberaBotaoPeriodo() {

	if(document.tarefa.data_final.value != '')
		document.tarefa.X.disabled = false
	else
		document.tarefa.X.disabled = true
}

function LiberaBotaohora() {

	if(document.tarefa.fim.value != '')
		document.tarefa.OK.disabled = false
	else
		document.tarefa.OK.disabled = true
}

function ComparaData () {

var data_inicial = new Date();
var data_final = new Date();
var dia_data_inicial;
var mes_data_inicial;
var ano_data_inicial;
var dia_data_final;
var mes_data_final;
var ano_data_final;

data_inicial = document.tarefa.data_inicial.value;
data_final = document.tarefa.data_final.value;

dia_data_inicial = (data_inicial.slice(0,2));
mes_data_inicial = (data_inicial.slice(3,5));
ano_data_inicial = (data_inicial.slice(6,10));

dia_data_final = (data_final.slice(0,2));
mes_data_final = (data_final.slice(3,5));
ano_data_final = (data_final.slice(6,10));

if (document.tarefa.data_final.value != "") {
	if (ano_data_final < ano_data_inicial) {
		alert('Data Final não pode ser menor que a Data Inicial');
		document.tarefa.data_final.value = '';
		document.tarefa.data_final.focus();
	}
		else {
			if ( (mes_data_final < mes_data_inicial) && (ano_data_final <= ano_data_inicial) ) {
				alert('Data Final não pode ser menor que a Data Inicial');
				document.tarefa.data_final.value = '';
				document.tarefa.data_final.focus();
			}
				else {
					if ( (dia_data_final < dia_data_inicial) && (mes_data_final <= mes_data_inicial) && (ano_data_final <= ano_data_inicial) ) {
						alert('Data Final não pode ser menor que a Data Inicial');
						document.tarefa.data_final.value = '';
						document.tarefa.data_final.focus();
					}
				}
		}
}
	
}


