<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<script>

	//SAIR
	function sair() {
		var form = document.forms[0];
		form.action = contexto + '/sair.do'; 
		form.submit();
	}
</script>


<!-- TOPO -->
	<div id="header">
		<div>	
		<div class="titulo">
			<div class="foco" style="width: 50%;margin-left: 9%;"><p>PLANEJAMENTO INDIVIDUAL DE ATIVIDADES DIÁRIAS</p></div>
			
			<div class="barraIcones" style="margin-right: 11%;">				
				<a href="#" onclick="javascript:sair();">
			    	<html:img src="${contexto}/WebContent/img/sair.png" alt="sair"/>
			    </a>			
			</div>		
		</div>				
	</div>
</div>
		<div class="infoUsuario" style="margin-right: 11%;color: white;"><strong>Usuário:</strong> ${form.usuario.login}</div>
	<!-- FIM TOPO -->