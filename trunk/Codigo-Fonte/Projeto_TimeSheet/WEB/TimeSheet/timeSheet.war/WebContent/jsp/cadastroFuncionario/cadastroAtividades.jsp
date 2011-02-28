<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".secundarias">	
	<tiles:put name="corpo" type="string">
		
		<div style="background-color:#fff; background-image:none;height:84%;">
			
			<div class="botoesJanela" ></div>
			
			<html:form action="/atividade/salvar" method="post">	
				<div class="formulario" style="height:400px">	
					<!-- Espaco para mensagens -->
			    	<div class="boxMensagemS">
			          	<div class="textoMensagemS">Alguns erros foram encontrados. Por favor, reveja os campos assinalados em vermelho.</div>
			            <div class="iconeMensagemS">
			            	<html:img src="${contexto}/WebContent/img/block.png" width="32" height="32" />
			            </div>
			        </div>	
			        
					<div class="foco">
					  	<div class="label">Data Atividade:</div>
					  	<html:text styleClass="campoLeitura" name="form" property="data" 
					  		style="width:85px;" />
					</div>													
					<div class="foco">
					  	<div class="label">Dia Atividade:</div>
					  	<html:select name="form" property="diaAtividade" styleId="diaAtividade" 
					  		style="width:85px"styleClass="campo">								    
							<html:optionsCollection name="form" property="listaDiasDaSemana" 
								label="descricao" value="descricao" />
						</html:select>
					</div>															
					<div class="foco">
					  	<div class="label">Início Previsto:</div>
					  	<html:text styleClass="campoLeitura" name="form" property="inicioPrevisto" 
					  		style="width:82px;" />
					</div>									
					<div class="foco" style="width:415px;">
					  	<div class="label">Termino Previsto:</div>
					  	<html:text styleClass="campoLeitura" name="form" property="terminoPrevisto" 
					  		style="width:99px;" />
					</div>															
					<div class="foco">
					  	<div class="label">OP:</div>
					  	<html:text styleClass="campoLeitura" name="form" property="descricaoOp" 
					  		style="width:415px;" />
					</div>							
					<div class="foco" style="width:515px;">
					<div class="label">Metodologia:</div>
						<html:text styleClass="campoLeitura" name="form" property="descricaoMetodologia" 
							style="width:415px;" />		  
					</div>											
					<div class="foco">
						<div class="label">Nº Projeto:</div>
					  	<html:text styleClass="campoLeitura" name="form" property="numeroProjeto" 
					  		style="width:85px;" />
					</div>							
					<div class="foco" style="width:310px;">
						<div class="label">Produto/Serviço:</div>
					  	<html:text styleClass="campoLeitura" name="form" property="produtoServico" 
					  		style="width:310px;" />
					</div>
					<div class="foco">
						<div class="label">Atividade:</div>
					  	<html:select name="form" property="tipo_atividade_id" styleId="atividades" 
					  		style="width:310px"styleClass="campo">								    
							<html:optionsCollection name="form" property="listaTipoAtividades" 
								label="descricao" value="descricao" />
						</html:select>
					</div>
					
					<div class="foco">
					  	<div class="label">Atividade a ser realizada:</div>
						<html:textarea styleClass="campo" name="form" style="width:415px; height:50px;" 
							property="produtoServico" cols="45" rows="2"></html:textarea>
					</div>
					<div class="foco">
						<div class="label">Observações:</div>
					  	<html:textarea styleClass="campo" name="form" style="width:415px; height:50px;" 
					  		property="observacoes" cols="45" rows="2"></html:textarea>
					</div>
					<div class="foco">
						<div class="label">Outros:</div>
					  	<html:textarea styleClass="campo" name="form" style="width:415px; height:50px;" 
					  		property="outros" cols="45" rows="2"></html:textarea>
					</div>
				</div>
	
			    
			    <div class="final_formulario">
			    	<html:img src="${contexto}/WebContent/img/salvar.png" width="43" height="43" 
			    		onclick="javascript:document.forms[1].submit();"/>					    	
			    	<html:img src="${contexto}/WebContent/img/voltar.png" width="54" height="43" alt="voltar" 
			    		onclick="javascript:voltar();"/>
			    </div>
			</html:form>
		</div>
	</tiles:put>
</tiles:insert>
