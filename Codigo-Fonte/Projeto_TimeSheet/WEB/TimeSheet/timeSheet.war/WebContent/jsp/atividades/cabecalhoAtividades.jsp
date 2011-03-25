<div class="botoesJanela">			
	<!-- DATA DO CALENDARIO -->
	<div style="width:100%">
			<div class="foco">
				<div class="labelDetalhar" style="width:90px;padding-top:5px;">Colaborador:</div>
				<div style="float:left;text-align:left;margin-right:15px;padding-top:5px;">							
					<c:if test="${form.indicaChefe}">
						<html:select name="form" property="codigoFuncionario" styleId="colaborador" 
							styleClass="campo" style="width:300px;"
							onchange="recuperarAtividadesSubordinados();">
							<html:option value="#"><< - - - Selecione um Colaborador - - - >></html:option>								    
							<html:optionsCollection name="form" property="listaFuncionariosSubordinados" 
								label="nome" value="id" />
						</html:select>
					</c:if>		  
					<c:if test="${!form.indicaChefe}">
						${form.usuario.funcionario.nome}
					</c:if>		  
				</div>
			</div>					
				
			<div class="foco">
				<div class="labelDetalhar" style="width:70px;padding-top:5px;">Mês:</div>
				<div style="float:left;text-align:left;margin-right:15px;padding-top: 3px">
					<html:text styleClass="campoLeitura" name="form" property="mesConsulta" 
				  		size="10" maxlength="10" styleId="mesConsulta"
				  		/>
				</div>
				<div class="labelDetalhar" style="width:70px;padding-top:5px;">Ano:</div>
				<div style="float:left;text-align:left;margin-right:15px;padding-top: 3px">
					<html:text styleClass="campoLeitura" name="form" property="anoConsulta" 
				  		size="10" maxlength="10" styleId="anoConsulta"/>
				</div>
				<div style="float:left;text-align:left;margin-right:15px;">
					<a href="javascript:consultarAtividade();">
						<html:img src="${contexto}/WebContent/img/consultar.jpg" 
							title="consultar atividade" />
					</a>
		        </div>
			   	</div>
					<div style="float:right;text-align:left;margin-right:15px;">
						<c:if test="${form.indicaChefe}">
							<a href="javascript:cadastrarAtividades(500);">
						</c:if>
						<c:if test="${!form.indicaChefe}">
							<a href="javascript:cadastrarAtividades(330);">
						</c:if>
							<html:img src="${contexto}/WebContent/img/novoProcessoIcone.png" 
								title="nova atividade" onclick="javascript:cadastrarAtividades();"/>
						</a>
						
			        </div>						   
			   	<div>	
		   </div>
	</div>
</div>