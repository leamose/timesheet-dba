<div style="height:390px; padding-bottom: 15px;overflow: auto">	
	<display:table name="form.listaTimeSheetVO" style="width:99.5%;padding-bottom:20px;margin-left: 2px;" 
		class="lista" id="tabela" length="100" pagesize="15" cellpadding="0" 
		requestURI="/atividade/inicio.do" cellspacing="0" htmlId="resultado" rules="cols">
		<display:column style="width:1%;" >
			<!--<img src="${contexto}/WebContent/img/aprov_mao.gif" title="aprovado"/>-->												
		</display:column>						
		<display:column property="dataHoraInicio" title="Data" 
			format="{0,date,dd/MM/yyyy}" style="width:2%;"/>
			
		<display:column property="dataHoraInicio" title="Início Previsto" 
			format="{0,date,HH:mm}" style="width:2%;"/>
			
		<display:column property="dataHoraFim" title="Fim Previsto" 
			format="{0,date,HH:mm}" style="width:2%;" />
			
		<display:column property="numeroProjeto" title="No. Projeto" style="width:2%;" />
		<display:column property="descricaoProduto" title="Produto" 
			style="width:20%;"  maxLength="25"/>	
		
		<display:column property="descricaoAtividade" title="Atividade" 
			style="width:30%;"  maxLength="30"/>	
			
		<display:column property="observacao" title="Observação" 
			style="width:15%;"  maxLength="18"/>	
			
		<display:column property="observacaoPrivada" title="Observação Superior" style="width:15%;" 
			maxLength="25"/>
			
		<display:column title="Ações" style="width:8%;">
			<center>
				<!-- DETALHAR -->
				<c:if test="${form.indicaChefe}">
					<a href="javascript:detalharAtividade(${tabela.codigoTimeSheet}, ${tabela.outrasAtividades ne ''}, 510);">
				</c:if>
				<c:if test="${!form.indicaChefe}">
					<a href="javascript:detalharAtividade(${tabela.codigoTimeSheet}, ${tabela.outrasAtividades ne ''}, 330);">
				</c:if>
					<html:img  src="${contexto}/WebContent/img/abrir.png" title="detalhar atividade"/>
				</a>
				
				<!-- ALTERAR -->
				<c:if test="${form.indicaChefe}">
					<a href="javascript:alterarAtividade(${tabela.codigoTimeSheet}, ${tabela.outrasAtividades ne ''},510);">
				</c:if>
				<c:if test="${!form.indicaChefe}">
					<a href="javascript:alterarAtividade(${tabela.codigoTimeSheet}, ${tabela.outrasAtividades ne ''},330);">
				</c:if>				
					<html:img  src="${contexto}/WebContent/img/alterar.png" title="alterar atividade"/>
				</a>
				
				<!-- REMOVER -->
				<a href="javascript:excluirAtividade(${tabela.codigoTimeSheet}, ${tabela.codigoHistoricoTimeSheet});">
					<html:img  src="${contexto}/WebContent/img/excluir.png" title="excluir atividade"/>
				</a>
				
				<c:if test="${form.indicaChefe && form.indicaAvaliacao}">
					<a href="javascript:avaliarAtividade(${tabela.codigoTimeSheet}, ${tabela.outrasAtividades ne ''},510);">				
						<html:img  src="${contexto}/WebContent/img/responderAutoP.png" title="avaliar atividade"/>
						</a>
				</c:if>
			</center>
		</display:column>
	</display:table>
</div>