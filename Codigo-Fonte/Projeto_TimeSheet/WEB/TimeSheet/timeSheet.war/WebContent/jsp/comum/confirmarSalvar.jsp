<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".fct">
	<tiles:put name="javascript" type="string">
	</tiles:put>
	<tiles:put name="corpo" type="string">
		<script type="text/javascript">
			window.parent.document.getElementById('imagemEmitirRelatorioFCT').style.display = 'none';
			window.parent.document.getElementById('imagemConfigQuestionarioFCT').style.display = 'none';
		</script>
	<html:form action="/fct/autoAvaliacao/salvarAutoAvaliacao.do" method="post">
		
			<table align="center">
				<tr>
					<td colspan="2"><div class="subtitulo" style="margin-left:65px; margin-top:125px;">Confirma a ${form.acao} do registro?</div></td>
				</tr>
				<tr>
					<td>
						<html:image src="${contexto}/WebContent/img/confirmar.jpg" style="margin-top:10px;"/>
					</td>
					<td>
						<a href="${contexto}/fct/autoAvaliacao/inicio.do?codigoDadosFuncionais=${form.codigoDadosFuncionais}&operacaoCancelada=true"> 
							<img src="${contexto}/WebContent/img/cancelar.jpg" style="margin-top:10px;">
						</a>
					</td>
				</tr>
			</table>
		
	</html:form>
	</tiles:put>
</tiles:insert>