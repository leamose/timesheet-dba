<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".mainLayout">	
	<tiles:put name="corpo" type="string"> 
	
		<script type="text/javascript">
			jQuery().ready(function() {
			    jQuery(".simple").splitter();
			});
		</script>		
	
		<div id="simplediv2" class="menupop">
		    <ul>
		    	<li><a href="#" onclick="javascript:detalharAtividade();">Detalhar atividade</a></li>
				<li><a href="#" onclick="javascript:alterarAtividade();">Alterar atividade</a></li>
				<li><a href="#" onclick="javascript:excluirAtividade();">Excluir atividade</a></li>
				<li><a href="#" onclick="javascript:aprovarAtividade();">Aprovar atividade</a></li>
				<li><a href="#" onclick="javascript:reprovarAtividade();">Reprovar atividade</a></li>
		    </ul>
		</div>
	
		<!-- MIOLO -->
		<div id="miolo" style="background-color:#fff; background-image:none;height:92%;">
			<div class="botoesJanela">			
				<!-- DATA DO CALENDARIO -->
				<form action="">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td width="150px;">&nbsp;</td>
							<th valign="middle">DATA DA ATIVIDADE:&nbsp; </th>
							<td valign="middle">
								<input onclick="ds_sh(this);" name="date" readonly="readonly" style="cursor: text" size="8"/>
							</td>
							<td>	
								<html:img src="${contexto}/WebContent/img/consultar.jpg" title="aprovado" onclick="javascript:consultarAtividade();"/>
							</td>
						</tr>
					</table>	
							
				</form>
				
			</div>					
			<html:form action="/atividade/inicio.do">
				<display:table name="${form.listaAtividades}" style="width:100%;" class="lista" id="tabela" 
					length="100" pagesize="30" requestURI="/atividade/inicio.do" cellspacing="0"
					 htmlId="resultado">
					<display:column>
						<html:img  src="${contexto}/WebContent/img/aprov_mao.gif" title="aprovado"/>
						<span class="h1"><a href="#" class="link" rel="simplediv2">
							<img src="${contexto}/WebContent/img/setaPop.png"/></a></span>
						<!--
							<html:img src="${contexto}/WebContent/img/reprov_mao.gif" title="aprovado"/>
							<html:img src="${contexto}/WebContent/img/aguardando_aprov.gif" title="aprovado"/>
						-->
					</display:column>						
					<display:column property="data" title="Data"/>
					<display:column property="inicioPrevisto" title="Início Previsto"/>
					<display:column property="terminoPrevisto" title="Fim Previsto"/>
					<display:column property="horasDiarias" title="Horas"/>
					<display:column property="saldoDiario" title="Saldo"/>						
					<display:column property="numeroProjeto" title="No. Projeto"/>
					<display:column property="descricaoAtividade" title="Atividade" />	
					<display:column property="ultimaAtividade" title="Ultima atividade"/>
				</display:table>
				
				<div style="float:left; padding-right: 15px;padding-top: 30px; ">
					<table align="center">
					 <tr>
					   <td><font face="tahoma,arial,  helvetica" size="2">
					   		<img src="${contexto}/WebContent/img/aprov_mao.gif">Aprovado</font></td>
					   <td>&nbsp;</td>
					   <td><font face="tahoma,arial,  helvetica" size="2">
					   		<img src="${contexto}/WebContent/img/reprov_mao.gif">Reprovado</font></td> 
					   <td>&nbsp;</td>
					   <td><font face=" tahoma,arial, helvetica" size="2">
					   		<img src="${contexto}/WebContent/img/aguardando_aprov.gif">Aguardando Aprovação</font></td>
					
					 </tr>
					</table>
				</div>
					
				
				<div style="float:right; padding-right: 25px; padding-top: 30px;padding-bottom:10px">Aceitar Todos :  <html:checkbox name="form" property="observacao"/></div>
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
