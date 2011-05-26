function operacaoCancelada() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/operacaoCancelada.do'; 
	form.submit();
}

function retornoInicio() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/inicio.do';
	form.submit();
}

//VOLTAR
function voltar() {
	var form = document.forms[0];
	form.action = contexto + '/atividade/voltar.do'; 
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
	parent.showPopWin(url, largura, altura, "50", titulo,0, urlRetorno);
}

//ABRE POPUP PESQUISA FUNCIONARIOS
function open_popPpPesquisaFunc(url, urlRetorno, titulo) {
	var largura = 720;
	var altura = 300;
	var posicao = 100;
	
	parent.showPopWin(url, largura, altura, posicao, titulo, 10, urlRetorno);
}

function SaltaCampo(campo,prox,tammax,teclapres)
{
	var tecla = teclapres;
	vr = campo.value;
	
	if( tecla == 109 || tecla == 189 || tecla == 188 || tecla == 110 || tecla == 111 || tecla == 223 || tecla == 108 ){
		campo.value = vr.substr( 0, vr.length - 1 );
	}else{
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

function FormataData(campo)
{
	var v = campo.value;
    v=v.replace(/\D/g,"")                    //Remove tudo o que não é dígito
    v=v.replace(/(\d{2})(\d)/,"$1/$2")    
    v=v.replace(/(\d{2})(\d)/,"$1/$2")    
    campo.value = v;
}

function FormataHora(Campo)
{
	vr = Campo.value;
	vr = vr.replace( ".", "" );
	vr = vr.replace( ":", "" );
	vr = vr.replace( ":", "" );
	tam = vr.length + 1;

		if ( tam > 2 && tam <= 5 )
			Campo.value = vr.substr( 0, tam - 2  ) + ':' + vr.substr( tam - 2, tam );
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