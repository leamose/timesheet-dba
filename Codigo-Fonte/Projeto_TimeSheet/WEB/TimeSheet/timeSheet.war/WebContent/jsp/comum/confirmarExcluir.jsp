<%@include file="/WebContent/paginas/comum/Global.jspf"%>

<tiles:insert definition=".fct">
	<tiles:put name="corpo" type="string">
		<script type="text/javascript">
			window.parent.document.getElementById('imagemEmitirRelatorioFCT').style.display = 'none';
			window.parent.document.getElementById('imagemConfigQuestionarioFCT').style.display = 'none';
		</script>
	<html:form action="/fct/autoAvaliacao/excluirAutoAvaliacao.do" method="post">
		
		<html:hidden name="form" property="codigoDadosFuncionais"/>
		<html:hidden name="form" property="codigoAvaliacao"/>
		<html:hidden property="controle" name="form" value="true"/>
		

			<table align="center">
				<tr>
					<td colspan="2"><div class="subtitulo" style="margin-left:65px; margin-top:125px;">Confirma a exclusão do registro?</div></td>
				</tr>
				<tr>					
					<td>
						<html:image src="${contexto}/WebContent/img/confirmar.jpg" style="margin-top:10px;" 
							onclick="javascript:document.forms[0].controle.value=true"/>
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