<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${contexto}/WebContent/css/Geral.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/default.css" rel="stylesheet" type="text/css" />
		<link href="${contexto}/WebContent/css/mac_os_x.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${contexto}/WebContent/css/tooltip.css" media="screen">		
		<title>Documento sem título</title>
	</head></head>

	<body style="background-color:#ece9d8; background-image:none;">
		<div style="width:100%; height:10px; background-color:#00779e;">
			<a href="javascript:parent.resizeFrame('100,*,10')"><img style="float:right;" src="${contexto}/WebContent/img/setasEx.jpg" width="11" height="10" /></a>
		</div>		
		<div class="boxBotoesVertical">
			<img src="${contexto}/WebContent/img/imprimir.png" width="20" height="18" title="imprimir" />
   			<img src="${contexto}/WebContent/img/recurso.png" width="20" height="21" title="recursos" />
		</div>
		
		<!-- INICIO TEXTAREA -->
		<div style="width:340px; margin-bottom: 10px;; float:right; display:table-column;">
			<div class="foco">
			  	<div class="label">Atividade a ser realizada:</div>
				<textarea class="campo" name="textarea" style="width:320px; height:50px;" id="textarea" cols="45" rows="2"></textarea>
			</div>
			<div class="foco">
				<div class="label">Observações:</div>
			  	<textarea class="campo" name="textarea2" style="width:320px; height:50px;" id="textarea2" cols="45" rows="2"></textarea>
			</div>
		</div>
		<!-- FIM TEXTAREA -->	
		
		<div class="foco">
		  	<div class="label">Data Atividade:</div>
		  	<input class="campoLeitura" name="input12" cols="" rows="" style="width:85px;" />
		</div>													
		<div class="foco">
		  	<div class="label">Dia Atividade:</div>
		  	<input class="campoLeitura" name="input12" cols="" rows="" style="width:77px;" />
		</div>															
		<div class="foco">
		  	<div class="label">Início Previsto:</div>
		  	<input class="campoLeitura" name="input3" cols="" rows="" style="width:82px;" />
		</div>									
		<div class="foco">
		  	<div class="label">Termino Previsto:</div>
		  	<input class="campoLeitura" name="input9" cols="" rows="" style="width:99px;" />
		</div>															
		<div class="foco">
		  	<div class="label">OP:</div>
		  	<input class="campoLeitura" name="input2" cols="" rows="" style="width:292px;" />
		</div>							
		<div class="foco">
		<div class="label">Metodologia:</div>
			<input class="campoLeitura" name="input7" cols="" rows="" style="width:80px;" />		  
		</div>											
		<div class="foco">
			<div class="label">Nº Projeto:</div>
		  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:61px;" />
		</div>							
		<div class="foco">
			<div class="label">Produto/Serviço:</div>
		  	<input class="campoLeitura" name="input11" cols="" rows="" style="width:95px;" />
		</div>							
		<div class="foco">
			<div class="label">Dia Avaliação Chefia:</div>
		  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:120px;" />
		</div>							
		<div class="foco">
			<div class="label">Início Avaliação Chefia:</div>
		  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:133px;" />
		</div>							
		<div class="foco">
			<div class="label">Termino Avaliação Chefia:</div>
		  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:148px;" />
		</div>							
		<div class="foco">
			<div class="label">Situação Avaliação Chefia:</div>
		  	<input class="campoLeitura" name="input5" cols="" rows="" style="width:150px;" />
		</div>							
		<div class="foco">
			<div class="label">Observações Chefia:</div>
			<textarea class="campo" name="textarea2" style="width:290px; height:20px;" id="textarea2" cols="45" rows="2"></textarea>
		</div>								
		<div class="foco">
			<div class="label">Observações Chefia Privativas:</div>
			<textarea class="campo" name="textarea2" style="width:309px; height:20px;" id="textarea2" cols="45" rows="2"></textarea>
		</div>		
	</body>
</html>
