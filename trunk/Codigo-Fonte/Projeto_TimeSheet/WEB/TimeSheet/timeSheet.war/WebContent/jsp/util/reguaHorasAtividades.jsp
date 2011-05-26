	<div style="width: 11.4%; float: left; ">
		<table class="paneEstatistica" width="100%">
			<tr><th colspan="3" class="h1">${form.mesLiteral}</th></tr>
			<tr><th style="font-size:10px; font-weight:bold;">Dias:</th></tr>
			<tr><th style="font-size:10px;font-weight:bold;">Carga Horária:</th></tr>
			<tr><th style="font-size:10px;font-weight:bold;">Horas Trabalhadas:</th></tr>
			<tr><th style="font-size:10px;font-weight:bold;">Saldo Diário:</th></tr>
			<tr><th style="font-size:10px;font-weight:bold;">Saldo Acumulado:</th></tr>
		</table>
	</div>		
	<div style="width: 79.6%; overflow-x: scroll;float:left;">
		<table class="paneEstatistica" style="overflow: auto">
			<tr><th colspan="35" class="h1">&nbsp;</th></tr>
			<tr>
				<c:forEach items="${form.listaHorasAtividadeVOs}" var="lfm">
					<td style="text-align: center;font-size: 10px">${lfm.dia}</td>
				</c:forEach>
			</tr>
			<tr>
				<script>
					for (i=0; i<${form.tamanhoListaHoras}; i++) {
			  	    	document.write("<td  style='text-align: center;font-size: 10px'>08:00</td>");
				  	}
			  	</script>
			</tr>
			<tr>
				<c:forEach items="${form.listaHorasAtividadeVOs}" var="lfm" >
					<td style="text-align: center;font-size: 10px">${lfm.horasTrabalhadas}</td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach items="${form.listaHorasAtividadeVOs}" var="lha" >
					<script>							
					if(${lha.indicaSaldoDevedor}){
						document.write("<td style='text-align: center;color: red;font-size: 10px'>${lha.saldoDiario}</td>");
					}else{
						document.write("<td style='text-align: center;font-size: 10px'>${lha.saldoDiario}</td>");
					}	
					</script>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach items="${form.listaHorasAtividadeVOs}" var="lha" >
					<script>
						if(${lha.indicaSaldoAcumuladoDevedor}){
							document.write("<td style='text-align: center;color: red;font-size: 10px'>${lha.saldoAcumulado}</td>");
						}else{
							document.write("<td style='text-align: center;font-size: 10px'>${lha.saldoAcumulado}</td>");
						}						
					</script>
				</c:forEach>
			</tr>
			
		</table>
	</div>
	<div style="width:9%; float: left;">
		<table class="paneEstatistica" border="0" width="100%">
			<tr><th>&nbsp;</th></tr>
			<tr><th>&nbsp;</th></tr>
			<tr><th style="font-size:10px; font-weight:bold;">total:${form.totalCargaHoraria}</th></tr>
			<tr><th style="font-size:10px; font-weight:bold;">total:${form.totalHorasTrabalhadas}</th></tr>
			<tr><th style="font-size:10px; font-weight:bold;">total:${form.totalSaldoDiario}</th></tr>
			<tr><th style="font-size:10px; font-weight:bold;">total:${form.totalSaldoAcumulado}</th></tr>		
		</table>
	</div>
