<%@include file="/WebContent/jsp/comum/Global.jspf"%>

<div align="center">
	<span class="msgSucesso">
	    <html:errors />
	</span>
	<span style="color:blue;" class="msgSucesso">
	    <html:messages id="msg" message="true">
	        <br><c:out value="${msg}"/>
	    </html:messages>
	</span>
</div>
