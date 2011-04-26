<div class="botoesJanela">			
	<!-- DATA DO CALENDARIO -->
	<div style="width:100%">
		<div style="height: 180px; overflow-y:auto;">
			<!-- COMBO COLABORADOR SUBORDINADOS-->
			<div class="foco">
				<div class="labelDetalhar" style="padding-top: 2.5px;">Colaborador:*</div>
					<div id="consultaCombo" style="display: none; width: 420px;padding-top: 2.5px;">				
						<!-- VERIFICA SE O COLABORADOR É CHEFE E ADICIONA UMA COMBO COM OS COLABORADORES SUBORDINADOS-->
						<c:if test="${form.indicaChefe}">
							<html:select name="form" property="codigoFuncionario" styleId="colaborador" 
								styleClass="campo" style="width:300px;">
								<html:option value="#"><< - - - Selecione um Colaborador - - - >></html:option>								    
								<html:optionsCollection name="form" property="listaFuncionariosSubordinados" 
									label="nome" value="id" />
							</html:select>
						</c:if>		  
						<!-- VERIFICA SE O COLABORADOR NÃO É CHEFE E COLOCA SOMENTE O NOME -->
						<c:if test="${!form.indicaChefe}">
							<div style="float:left;text-align:left;margin-right:15px;padding-top: 3px">
								${form.usuario.funcionario.nome}
							</div>
						</c:if>		  
					</div>
					
					<div style="float:left;text-align:left;margin-right:15px;padding-top: 3px" id="consultaCombo2">
						${form.usuario.funcionario.nome}
					</div>		  
				
				</div>
				
				
				
				
				<!-- FIM COMBO COLABORADOR -->					
				<div id="consulta" style="display:none;">
					<!-- CAMPOS DA CONSULTA -->	
					<div class="labelDetalhar" style="width:50px;padding-top:5px;padding-left: 25px;">Mês:*</div>
					<div style="float:left;text-align:left;margin-right:15px;padding-top: 3px">
						<html:text styleClass="campoLeitura" name="form" property="mesConsulta" 
					  		size="10" maxlength="10" styleId="mesConsulta"
					  		/>
					</div>
					<div class="labelDetalhar" style="width:50px;padding-top:5px;">Ano:*</div>
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
				   	<div>
			   	</div>	
		   </div>
			        <!-- FIM CAMPOS DA CONSULTA -->
						<div style="float:right;text-align:left;margin-right:15px;display: none" id="cadastroAtividade">
							<a href="javascript:abrirPopUpAtividade(430);"><html:img src="${contexto}/WebContent/img/novoProcessoIcone.png" 
								title="nova atividade" onclick="#"/></a>
							
				        </div>						   
		</div>
	</div>
</div>