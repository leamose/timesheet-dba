<table class="paneEstatistica" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<th colspan="2" class="h1">${form.mesLiteral}</th>
	</tr>
	<tr>
		<td width="12%">
			<table class="paneEstatistica">
				<tr>
					<th>carga horaria:</th>
				</tr>
				<tr>
					<th>horas trabalhadas:</th>
				</tr>
				<tr>
					<th>saldo diário:</th>
				</tr>
			</table>
		</td>
		<td style="width: 100%">
			<div style='overflow-x: scroll;'>
				<table style="overflow:auto;" class="paneEstatistica">
					<tr>
						<c:forEach items="${form.listaHorasAtividadeVOs}" var="lfm">
							<th style="text-align: center">${lfm.dia}</th>
						</c:forEach>
					</tr>
					<tr>
						<script>
							for (i=0; i<${form.tamanhoListaHoras}; i++) {
					  	    	document.write("<th  style='text-align: center;'>08:00</th>");
						  	}
					  	</script>
					</tr>
					<tr>
						<c:forEach items="${form.listaHorasAtividadeVOs}" var="lfm" varStatus="status0">
							<th style="text-align: center;">${lfm.horasTrabalhadas}</th>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach items="${form.listaHorasAtividadeVOs}" var="lfm" varStatus="status0">
							<script>							
							if(${lfm.indicaSaldoDevedor}){
								document.write("<th style='text-align: center;color: red'>${lfm.cargaHoraria}</th>");
							}else{
								document.write("<th style='text-align: center;'>${lfm.cargaHoraria}</th>");
							}	
							</script>
						</c:forEach>
					</tr>
				</table>
			</div>
		</td>
	</tr>
</table>







