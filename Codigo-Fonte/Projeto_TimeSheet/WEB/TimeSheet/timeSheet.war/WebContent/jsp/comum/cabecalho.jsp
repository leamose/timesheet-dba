<%@include file="/WebContent/jsp/comum/Global.jspf"%>


<!-- TOPO -->
	<div id="header">	
		<div class="barraTextoTopo">
			<table width="100%" cellpadding="0">
				<tr>
					<th colspan="5"  align="left">PLANEJAMENTO INDIVIDUAL DE ATIVIDADES DI�RIAS</th>
				</tr>
				<tr>
					<th colspan="5"
						style="border-bottom:1px solid #FFF; padding-bottom:4px;">
							<div style="text-align:left;float:center">Cliente: Ministerio da Justi�a</div>
					</th>
				</tr>
				<tr>
					<td>
						<table width="480px;" >
							<tr>
								<th width="32%" align="right">Calend�rio padr�o:</th>
								<td width="8%" align="left">8h00</td>
								<td width="15%" align="left">18h00</td>
								<th width="15%" align="right">M�S:</th>
								<td align="left">Dezembro</td>						
							</tr>
							<tr>
								<th align="right">Almo�o:</th>
								<td align="left"> 8h00</td>
								<td align="left">18h00</td>
								<th width="10%" align="right">Minino: </th>
								<td align="left">1h</td>
							</tr>
							<tr>
								<th align="right">Total horas no m�s:</th>
								<td align="left">176</td>
								<td>&nbsp;</td>						
								<th align="right">ANO:</th>
								<td align="left">2010</td>
							</tr>
						</table>
						</td>
						<td>
						<table>
							<tr>
								<th width="32%" align="right">Saldo diario:</th>
								<td width="8%" align="left">8h00</td>														
							</tr>
							<tr>
								<th align="right">Saldo Mensal:</th>
								<td align="left"> 8h00</td>
							</tr>
							<tr>
								<th align="right">Banco de Horas:</th>
								<td align="left">176</td>								
							</tr>
						</table>
					</td>
				</tr>
				
			</table>			
		</div>
		<div class="barraIcones">
			<html:form action="/funcionario/cadastarFuncionario" method="post">
				<a href="#" onclick="javascript:open_popPp();">
					<html:img src="${contexto}/WebContent/img/novoContratoIcone.png" title="atividade"/></a>					
				<a href="#" onclick="javascript:open_popPpFuncionario();">
					<html:img src="${contexto}/WebContent/img/cadastrarUsuario.png" title="funcion�rio"/></a>
				<a href="#" onclick="javascript:sair();">
			    	<html:img src="${contexto}/WebContent/img/sair.png" alt="sair"/>
			    </a>
			</html:form>
		</div>
	</div>
	<!-- FIM TOPO -->