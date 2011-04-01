<div class="botoesJanela">			
	<!-- DATA DO CALENDARIO -->
	<div style="width:100%">
			
		<div style="height: 180px; overflow-y:auto;  ">
			<!-- COMBO COLABORADOR SUBORDINADOS-->
			<div class="foco">
				<div class="labelDetalhar">Colaborador:</div>
				
					<!-- VERIFICA SE O COLABORADOR É CHEFE E ADICIONA UMA COMBO COM OS COLABORADORES SUBORDINADOS-->
					<c:if test="${form.indicaChefe}">
						<html:select name="form" property="codigoFuncionario" styleId="colaborador" 
							styleClass="campo" style="width:300px;"
							onchange="recuperarAtividadesSubordinados();">
							<html:option value="#"><< - - - Selecione um Colaborador - - - >></html:option>								    
							<html:optionsCollection name="form" property="listaFuncionariosSubordinados" 
								label="nome" value="id" />
						</html:select>
					</c:if>		  
					<!-- VERIFICA SE O COLABORADOR NÃO É CHEFE E COLOCA SOMENTE O NOME -->
					<c:if test="${!form.indicaChefe}">
						${form.usuario.funcionario.nome}
					</c:if>		  
				</div>
			<!-- FIM COMBO COLABORADOR -->					
				
				<!-- CAMPOS DA CONSULTA -->	
				<div class="labelDetalhar" style="width:50px;padding-top:5px;padding-left: 25px;">Mês:</div>
				<div style="float:left;text-align:left;margin-right:15px;padding-top: 3px">
					<html:text styleClass="campoLeitura" name="form" property="mesConsulta" 
				  		size="10" maxlength="10" styleId="mesConsulta"
				  		/>
				</div>
				<div class="labelDetalhar" style="width:50px;padding-top:5px;">Ano:</div>
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
		        <!-- FIM CAMPOS DA CONSULTA -->
		        
			  
					<div style="float:right;text-align:left;margin-right:15px;">
						<c:if test="${form.indicaChefe && form.acao eq ACAO_AVALIAR }">
							<a href="javascript:abrirPopUpAtividade(610);">
						</c:if>
						<c:if test="${form.indicaChefe}">
							<a href="javascript:abrirPopUpAtividade(370);">
						</c:if>
						<c:if test="${!form.indicaChefe}">
							<a href="javascript:abrirPopUpAtividade(370);">
						</c:if>
							<html:img src="${contexto}/WebContent/img/novoProcessoIcone.png" 
								title="nova atividade" onclick="#"/>
						</a>
						
			        </div>						   
			   	<div>	
		   </div>
		</div>
	</div>
</div>