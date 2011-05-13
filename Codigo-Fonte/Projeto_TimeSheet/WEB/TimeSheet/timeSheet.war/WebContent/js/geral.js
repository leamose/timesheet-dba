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