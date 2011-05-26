<div style="overflow: auto;">	
	<display:table name="form.listaTimeSheetVO" style="width:98%; padding-bottom:2%;margin-left: 0.5%;margin-right:0.5%; " 
		class="lista" id="tabela" length="100" pagesize="15" cellpadding="0" 
		requestURI="/atividade/inicio.do" cellspacing="0" htmlId="resultado" 
		decorator="br.com.dba.timesheet.util.TableEstrutura">
		
			<display:column style="width:1%;" property="codigoSituacaoAtividade" title=""/>
			
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
				style="width:30%;"  maxLength="40"/>	
				
			<display:column property="observacao" title="Observação" 
				style="width:15%;"  maxLength="18"/>	
				
			<display:column property="observacaoAvaliacaoAtividade" title="Observação Superior" style="width:15%;" 
				maxLength="20" />
				
			<display:column title="Ações" style="width:8%;">
					<!-- DETALHAR -->
					<a href="javascript:detalharAtividade(${tabela.codigoTimeSheet}, ${tabela.outrasAtividades ne ''}, 430);"><html:img  src="${contexto}/WebContent/img/abrir.png" title="detalhar atividade"/></a>
				
					<!-- ALTERAR -->
					<c:if test="${tabela.habilitaBotaoAlterar}">
						<a href="javascript:alterarAtividade(${tabela.codigoTimeSheet}, ${tabela.outrasAtividades ne ''},430);"><html:img  src="${contexto}/WebContent/img/alterar.png" title="alterar atividade"/></a>
					</c:if>
					<!-- REMOVER -->
					<a href="javascript:excluirAtividade(${tabela.codigoTimeSheet}, ${tabela.codigoHistoricoTimeSheet});"><html:img  src="${contexto}/WebContent/img/excluir.png" title="excluir atividade"/></a>
					
					
					<!-- CHEFE -->
					<c:if test="${form.indicaChefe && form.indicaAvaliacao}">
						<a href="javascript:avaliarAtividade(${tabela.codigoTimeSheet}, ${tabela.outrasAtividades ne ''},520);"><html:img  src="${contexto}/WebContent/img/responderAutoP.png" title="avaliar atividade"/></a>
					</c:if>
			</display:column>			
	</display:table>
</div>
