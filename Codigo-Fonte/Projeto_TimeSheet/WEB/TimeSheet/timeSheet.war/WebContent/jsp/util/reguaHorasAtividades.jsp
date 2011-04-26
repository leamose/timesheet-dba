<div style='overflow-x: scroll;'>
	<table class="paneEstatistica" border="0" cellpadding="0" cellspacing="0" style="padding: 5px;">
		<!-- MES ATUAL -->
		<tr><th colspan="3" class="h1">${form.mesLiteral}</th></tr>
		<tr>
			<td>
				<table class="paneEstatistica" style="width: 130px;">
					<tr><th style="font-weight:bold;">dias:</th></tr>
					<tr><th style="font-weight:bold;">carga horaria:</th></tr>
					<tr><th style="font-weight:bold;">horas trabalhadas:</th></tr>
					<tr><th style="font-weight:bold;">saldo diário:</th></tr>
				</table>
			</td>
			<td>
				<table style="overflow:visible;" class="paneEstatistica">
					<tr>
						<c:forEach items="${form.listaHorasAtividadeVOs}" var="lfm">
							<th style="text-align: center;">${lfm.dia}</th>
						</c:forEach>
					</tr>
					<tr>
						<script>
							for (i=0; i<${form.tamanhoListaHoras}; i++) {
					  	    	document.write("<th  style='text-align: center;font-size: 10px'>08:00</th>");
						  	}
					  	</script>
					</tr>
					<tr>
						<c:forEach items="${form.listaHorasAtividadeVOs}" var="lfm" varStatus="status0">
							<th style="text-align: center;font-size: 10px">${lfm.horasTrabalhadas}</th>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach items="${form.listaHorasAtividadeVOs}" var="lfm" varStatus="status0">
							<script>							
							if(${lfm.indicaSaldoDevedor}){
								document.write("<th style='text-align: center;color: red;font-size: 10px'>${lfm.cargaHoraria}</th>");
							}else{
								document.write("<th style='text-align: center;font-size: 10px'>${lfm.cargaHoraria}</th>");
							}	
							</script>
						</c:forEach>
					</tr>
				</table>
			</td>
			<td>
			<table class="paneEstatistica" style="width: 230px;">
				<tr><th>&nbsp;</th></tr>
				<tr><th><b>total carga horaria:</b><%=request.getAttribute("totalCargaHoraria")%></th></tr>
				<tr><th><b>total horas trabalhadas:</b><%=request.getAttribute("totalHorasTrabalhadas")%></th></tr>
				<tr><th><b>total saldo diário:</b><%=request.getAttribute("totalSaldoDiario")%></th></tr>
			</table>
		</td>
		</tr>
	</table>
</div>







