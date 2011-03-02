<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<tiles:insert definition=".popUp">	
	<tiles:put name="corpo" type="string">
		
		<div class="formulario">  			
				<html:form action="/funcionario/retornoConsultar" method="post">
			            <display:table name="${listaFuncionarios}" class="lista" 
			            	id="tabela" pagesize="10" requestURI="/atividade/inicio.do" 
			            	cellspacing="0" style="width:98%;margin-left: 5px " >												
							<display:column property="nome" title="Nome" style="width:30%;"/>
							<display:column property="cargo" title="Cargo" style="width:30%;"/>
							<display:column property="hora_trabalho_inicio" title="Hora Trabalho Inicio"/>
							<display:column property="hora_trabalho_fim" title="Hora Trabalho Fim"/>
							<display:column property="hora_almoco_inicio" title="Hora Almoco Inicio"/>						
							<display:column property="hora_almoco_fim" title="Hora Almoco Fim"/>
							<display:column property="chefe" title="Chefe" />	
							<display:column property="ferias" title="Férias"/>
						</display:table>					
			        
				</html:form>
				
				<div class="botoesMeioPopUp" style="margin-top:20px;">
					<img src="${contexto}/WebContent/img//pesquisar.jpg" width="128" height="20" alt="selecionar" />					
				</div>			
		</div>
	</tiles:put>
</tiles:insert>
