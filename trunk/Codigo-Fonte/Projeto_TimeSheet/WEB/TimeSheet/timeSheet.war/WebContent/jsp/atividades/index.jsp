<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".mainLayout">	
	<tiles:put name="corpo" type="string"> 
	
		<!-- MIOLO -->
		<div style="background-color:#fff; background-image:none;height:84%;">
			<div class="botoesJanela">
			
				<!-- DATA DO CALENDARIO -->
				<form action="">	
					<div class="foco">DATA DA ATIVIDADE: </div>
					<input onclick="ds_sh(this);" name="date" readonly="readonly" style="cursor: text" size="8"/>				
				</form>
				
			</div>					
				<html:form action="/atividade/inicio.do">
					<display:table name="${listaAtividades}" style="width:98%;" class="lista" id="tabela" 
						length="100" pagesize="15" requestURI="/atividade/inicio.do" cellspacing="0">
						<display:column style="width:4%;">
							<img src="${contexto}/WebContent/img/inativo.png" title="aprovado"/></a>
							<img src="${contexto}/WebContent/img/ativo.png" title="aprovado"/></a>
						</display:column>						
						<display:column property="data" title="Data"/>
						<display:column property="inicioPrevisto" title="Início"/>
						<display:column property="terminoPrevisto" title="Fim"/>
						<display:column property="horasDiarias" title="Horas"/>
						<display:column property="saldoDiario" title="Saldo"/>						
						<display:column property="numeroProjeto" title="No. Projeto"/>
						<display:column property="descricaoAtividade" title="Atividade" style="width:50%"/>	
						<display:column title="Ações">
							<center>
								<a href="#" onclick="javascript:detalharAtividade();">
									<img src="${contexto}/WebContent/img/abrir.png" width="14" height="14" 
										title="detalhar atividade" style="border:none;" /></a>
								<a href="#" onclick="javascript:alterarAtividade();">
								<img src="${contexto}/WebContent/img/alterarTabela.png" width="14" height="14" 
									title="alterar atividade" style="border:none;" /></a>
								<a href="#" onclick="javascript:excluirAtividade();">
								<img src="${contexto}/WebContent/img/excluir.png" width="14" height="14" 
									title="excluir atividade" style="border:none;" /></a>
							</center>
						</display:column>					
					</display:table>
				</html:form>
		</div>   	
		<!-- FIM MIOLO -->

		<!-- INICIO CALENDARIO -->
		<table class="ds_box" cellpadding="0" cellspacing="0" id="ds_conclass" style="display: none;">
			<tr>
				<td id="ds_calclass"></td>
			</tr>
		</table>
		
		<script type="text/javascript" src="${contexto}/WebContent/js/calendario.js"></script>
		<!-- FIM CALENDARIO -->
		
	</tiles:put>
</tiles:insert>
