function outros(div){
	document.getElementById(div).style.display = '';				
}

function outrasAtividades(form){
	
	for (var i = 0; i < form.codigoAtividade.options.length; i++) {
        if (form.codigoAtividade.options[i].selected){
        	if(form.codigoAtividade.options[i].value == 6){        		
        		document.getElementById('outros').style.display = '';
        	}else{
        		document.getElementById('outros').style.display = 'none';
        	}
        }
      }
	
}

function operacaoCancelada() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/operacaoCancelada.do'; 
	form.submit();
}

//CADASTRAR ATIVIDADE
function cadastrarAtividades() {
	open_popPpAtividade(false, contexto + '/atividade/cadastrarAtividade.do?acao=salvar', null, "Cadastrar Atividade", 720, 402);
}

function retornoCadastrarAtividades() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/salvar.do';
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
function detalharAtividade(codigoTimeSheet, temOutrasAtividades) {
	open_popPpAtividade(temOutrasAtividades, contexto + '/atividade/detalhar.do?codigoTimeSheet='+codigoTimeSheet+'&acao=detalhar', retornoDetalharAtividade, "Detalhar Atividade", 720, 402) ;
}

function retornoDetalharAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/retornoDetalhar.do'; 
	form.submit();
}

//ALTERAR
function alterarAtividade(codigoTimeSheet, temOutrasAtividades) {
	open_popPpAtividade(temOutrasAtividades, contexto + '/atividade/alterar.do?codigoTimeSheet='+codigoTimeSheet+'&acao=alterar', null, "Alterar Atividade", 720, 402) ;
}

function retornoAlterarAtividade() {
	alert('entrou aki')
	var form = document.forms[0];
	form.action = contexto + '/atividade/retornoAlterar.do';
	alert(form.action);
	form.submit();
}

//EXCLUIR
function excluirAtividade(codigoTimeSheet) {
	var form = document.forms[0];
	form.action = contexto + '/atividade/excluir.do?codigoTimeSheet='+codigoTimeSheet+'&acao=excluir'; 
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
function aprovarAtividade(codigoTimeSheet) {
	open_popPpAtividade(false, contexto + '/avaliacaoAtividade/aprovar.do?codigoTimeSheet='+codigoTimeSheet, null, "Aprovar Atividade", 720, 300);
}
//APROVAR
function retornoAprovarAtividade(codigoTimeSheet) {
	var form = document.forms[0];
	form.action = contexto + '/avaliacaoAtividade/salvar.do?codigoTimeSheet='+codigoTimeSheet; 
	form.submit();
}

//REPROVAR
function reprovarAtividade(codigoTimeSheet) {
	open_popPpAtividade(false,contexto + '/avaliacaoAtividade/reprovar.do?codigoTimeSheet='+codigoTimeSheet, null, "Reprovar Atividade", 720, 300) ;
}

function returnoReprovarAtividade() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/retornoReprovar.do'; 
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
function open_popPpAtividade(temOutrasAtividades,url, urlRetorno, titulo, largura, altura) {	
	if(temOutrasAtividades){
		altura=465;
	}
			
	parent.showPopWin(url, largura, altura, "50", titulo,0, urlRetorno);
}

//ABRE POPUP PESQUISA FUNCIONARIOS
function open_popPpPesquisaFunc(url, urlRetorno, titulo) {
	var largura = 720;
	var altura = 300;
	var posicao = 100;
	
	parent.showPopWin(url, largura, altura, posicao, titulo, 10, urlRetorno);
}

//ABRE POPUP FUNCIONARIOS
function open_popPpFuncionario(url, urlRetorno, titulo) {
	var largura = 700;
	var altura = 452;
	parent.showPopWin(url, largura, altura, "50", titulo,0, urlRetorno);
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
	vr = campo.value;
	
	if( tecla == 109 || tecla == 189 || tecla == 188 || tecla == 110 || tecla == 111 || tecla == 223 || tecla == 108 )
	{
		campo.value = vr.substr( 0, vr.length - 1 );
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
	vr = Campo.value;
	vr = vr.replace( ".", "" );
	vr = vr.replace( "/", "" );
	vr = vr.replace( "/", "" );
	tam = vr.length + 1;

	if ( tecla != 9 && tecla != 8 && tecla != 46 )
	{
		if ( tam > 2 && tam < 5 )
			Campo.value = vr.substr( 0, tam - 2  ) + '/' + vr.substr( tam - 2, tam );
		if ( tam >= 5 && tam <= 10 )
			Campo.value = vr.substr( 0, 2 ) + '/' + vr.substr( 2, 2 ) + '/' + vr.substr( 4, 4 );
	}
}

function ValidaData(data) {
	// Valida se a data entrada eh valida e se esta no formato dd/mm/aaaa
	// ou se � nula
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
	// ou se � nula
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
		alert('Data Final n�o pode ser menor que a Data Inicial');
		document.tarefa.data_final.value = '';
		document.tarefa.data_final.focus();
	}
		else {
			if ( (mes_data_final < mes_data_inicial) && (ano_data_final <= ano_data_inicial) ) {
				alert('Data Final n�o pode ser menor que a Data Inicial');
				document.tarefa.data_final.value = '';
				document.tarefa.data_final.focus();
			}
				else {
					if ( (dia_data_final < dia_data_inicial) && (mes_data_final <= mes_data_inicial) && (ano_data_final <= ano_data_inicial) ) {
						alert('Data Final n�o pode ser menor que a Data Inicial');
						document.tarefa.data_final.value = '';
						document.tarefa.data_final.focus();
					}
				}
		}
}
	
}

function ValidaCampoTexto(){

	for (i=0; i < document.tarefa.elements.length;i++){
		if ((document.tarefa.elements[i].type == "textarea") || (document.tarefa.elements[i].type == "text")){
			for(j=0; j < document.tarefa.elements[i].value.length;j++){
				ch = document.tarefa.elements[i].value.charAt(j);
				if ((ch=='"') || (ch=="'")){
					alert("Caracter inv�lido --> " +(ch));
					flag = true;
					document.tarefa.elements[i].focus();
				}
			}					 
		}    
	}	
}

function validarCampos() {

	if (document.forms[0].data.value == ""){
       alert("Esqueceu de especificar a data da atividade ");
       document.forms[0].data.focus();
       return;
    }

    if (document.forms[0].dataHoraInicio.value == ""){
	   alert("Esqueceu de especificar a data inicial da atividade ");
	   document.forms[0].dataHoraInicio.focus();
	   return;
    }

    if (document.forms[0].dataHoraFim.value == ""){
       alert("Esqueceu de especificar a data final da atividade ");
       document.forms[0].dataHoraFim.focus();
       return;
    }

    if (document.forms[0].dataHoraInicio.value == ""){
       alert("Esqueceu de especificar a hora que a atividade foi iniciada ");
       document.forms[0].dataHoraInicio.focus();
       return;
    }

    if (document.forms[0].dataHoraFim.value == ""){
	     alert("Esqueceu de especificar a hora que a atividade foi finalizada ");
	     document.forms[0].dataHoraFim.focus();
	     return;
    }
	
	if(document.forms[0].op.value == '#') {
		alert("Esqueceu de selecionar uma OP !");
		document.forms[0].op.focus();
		return;
	}
	if(document.forms[0].codigoMetodologia.value == '#') {
		alert("Esqueceu de selecionar uma Metodologia !");
		document.forms[0].codigoMetodologia.focus();
		return;
	}
	if(document.forms[0].codigoCliente.value == '#') {
		alert("Esqueceu de selecionar uma Cliente !");
		document.forms[0].codigoCliente.focus();
		return;
	}
	if(document.forms[0].codigoAtividade.value == '#') {
		alert("Esqueceu de selecionar uma Atividade !");
		document.forms[0].codigoAtividade.focus();
		return;
	}
	if(document.forms[0].codigoProdutoServico.value == '#') {
		alert("Esqueceu de selecionar uma Produto / Servi�o !");
		document.forms[0].codigoProdutoServico.focus();
		return;
	}
}     




