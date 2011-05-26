<!-- TABELA COM OS HORARIOS, SALDO DIARIO e CARGA HORARIA -->
 <div style="position:absolute; bottom:0px; margin:0 auto;width: 100%;">
	<%@include file="/WebContent/jsp/util/reguaHorasAtividades.jsp"%>
	
	<!-- SITUACAO DAS ATIVIDADES -->
	<div style="float:left; padding-top: 1%;">
		<table align="center">
		 <tr>
		   <td><font face="tahoma,arial,  helvetica" size="2">
		   		<img src="${contexto}/WebContent/img/aprov_mao.gif"/>Aprovado</font></td>
		   <td>&nbsp;</td>
		   <td><font face="tahoma,arial,  helvetica" size="2">
		   		<img src="${contexto}/WebContent/img/reprov_mao.gif"/>Reprovado</font></td> 
		   <td>&nbsp;</td>
		   <td><font face=" tahoma,arial, helvetica" size="2">
		   		<img src="${contexto}/WebContent/img/aguardando_aprov.gif"/>Aguardando Aprovação</font></td>
		
		 </tr>
		</table>
	</div>
</div>
