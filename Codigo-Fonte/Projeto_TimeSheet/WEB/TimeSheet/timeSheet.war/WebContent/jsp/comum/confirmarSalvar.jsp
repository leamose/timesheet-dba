<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".secundarias">	
	<tiles:put name="corpo" type="string">	
		<div style="background-color:#fff; background-image:none;height:84%;">
			<div class="botoesJanela" ></div>	
			<html:form action="/atividade/confirmaSalvar" method="post">
				<table align="center">
					<tr>
						<td colspan="2">
							<div class="subtitulo" style="margin-left:5px; margin-top:125px;">
								<center>Confirma a inclusão do registro?</center>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<html:image src="${contexto}/WebContent/img/confirmar.jpg" style="margin-top:10px;"/>
						</td>
						<td>
							<html:image src="${contexto}/WebContent/img/cancelar.jpg" style="margin-top:10px;"
								onclick="javascript:operacaoCancelada();"/>							
						</td>
					</tr>
				</table>
			</html:form>
		</div>
	</tiles:put>
</tiles:insert>