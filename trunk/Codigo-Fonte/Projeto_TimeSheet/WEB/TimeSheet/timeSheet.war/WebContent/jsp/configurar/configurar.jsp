<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".secundarias">	
	
	<tiles:put name="corpo" type="string"> 
	
		<script>

		<!--
			function salvarConfiguracao() {				
				//if(validarCampos()){
					if(confirm('Confirma a inclusão do registro?')){					
						var form = document.configurarForm;
						form.action = contexto + '/configurar/salvar.do';			
						form.submit();											
					}
				//}
			}

/*
			function validarCampos() {	
				if (document.forms[0].hora_trabalho_inicio.value == ""){
			       alert("Esqueceu de especificar a data da atividade.");
			       document.forms[0].data.focus();
			       return false;
			    }
	
			    if (document.forms[0].dataHoraInicio.value == ""){
				   alert("Esqueceu de especificar a data inicial da atividade.");
				   document.forms[0].dataHoraInicio.focus();
				   return false;
			    }
	
			    if (document.forms[0].dataHoraFim.value == ""){
			       alert("Esqueceu de especificar a data final da atividade.");
			       document.forms[0].dataHoraFim.focus();
			       return false;
			    }
	
			    if (document.forms[0].dataHoraInicio.value == ""){
			       alert("Esqueceu de especificar a hora que a atividade foi iniciada.");
			       document.forms[0].dataHoraInicio.focus();
			       return false;
			    }
	
			    if (document.forms[0].dataHoraFim.value == ""){
				     alert("Esqueceu de especificar a hora que a atividade foi finalizada.");
				     document.forms[0].dataHoraFim.focus();
				     return false;
			    }
				
				return true;
			}  
	**/		
		</script>
		
		<html:form action="/configurar/salvar" method="post">
			
			<div align="center">
				<div class="conteudo">
					<div class="formulario">
					    <div class="titulo-formulario-pesquisa">Configuração</div>
							
							<!-- TABELA DE MENSAGENS DE ERRO DO SISTEMA -->
							<%@include file="/WebContent/jsp/erro/tabelaErros.jsp" %>	
						
					    	<div class="foco" style="width:50%;">
				                <div class="labelDetalhar" style="width:150px;">Hora Trabalho Início:*</div>
				                <div class="input_position">
				                	<html:text styleClass="campo" name="form" property="horaTrabalhoInicio" size="15"/>
				                </div>
				            </div>
					    	<div class="foco">
				                <div class="labelDetalhar" style="width:150px;">Hora Trabalho Fim:*</div>
				                <div class="input_position">
				                	<html:text styleClass="campo" name="form" property="horaTrabalhoFim" size="16"/>
				                </div>
				            </div>
					    	<div class="foco" style="width:50%;">
				                <div class="labelDetalhar" style="width:150px;">Hora Almoco Início:*</div>
								<div class="input_position">			                	
				                	<html:text styleClass="campo" name="form" property="horaAlmocoInicio" size="15"/>
				                </div>
				                	
				            </div>
					    	<div class="foco" >
				                <div class="labelDetalhar" style="width:150px;">Hora Almoco Fim:*</div>
				               	<div class="input_position">	
				               		<html:text styleClass="campo" name="form" property="horaAlmocoFim" size="16"/>
				               	</div>
				            </div>
				            	            
				            <div class="subtitulo" style="width:590px; margin-bottom:1px; margin-top:15px;">Total horas no mês</div>
			
							<table style="width:100%;" class="paneEstatistica" border="0" cellspacing="2" 
								cellpadding="0">
							 	<tr>
								  	<th class="h1">Janeiro</th>
								    <th class="h1">Fevereiro</th>
								    <th class="h1">Março</th>
								    <th class="h1">Abril</th>
								    <th class="h1">Maio</th>
								    <th class="h1">Junho</th>
								    <th class="h1">Julho</th>
								    <th class="h1">Agosto</th>
								    <th class="h1">Setembro</th>
								    <th class="h1">Outubro</th>
								    <th class="h1">Novembro</th>
								    <th class="h1">Dezembro</th>
							  	</tr>
							  	<tr>
									<script>
										for (i=1; i<=12; i++) {									
											document.write("<th><div class='input_position_total'><input type='text' name='totalHoras["+i+"]' size='3' class='campo'></div></th>");
										}
									  </script>
							 	</tr>						  
							</table>
						
					    <div class="final_formulario" style="padding-top: 10px;">
								<html:img src="${contexto}/WebContent/img/salvar.png" width="43" height="43" 
							    	onclick="javascript:salvarConfiguracao();"/>					    	
							    <html:img src="${contexto}/WebContent/img/voltar.png" width="54" height="43" alt="voltar" 
							    	onclick="javascript:voltar();"/>
						</div>									    
					</div>	
				</div>
			</div>						
		</html:form>
	</tiles:put>
</tiles:insert>
