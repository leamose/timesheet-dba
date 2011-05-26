package br.com.dba.timesheet.web.filtros;

public interface ConstantesLogin {

    /**
     * Constante que define o atributo na sess�o que indica se o usu�rio est� ou n�o logado.
     */
    static final String AUTENTICACAO = "br.com.br.timesheet.action.login.att";

    /**
     * Constante que define o atributo que especifica que o usu�rio est� logado.
     */
    static final String AUTENTICACAO_OK = "%autenticado%";

    /**
     * Constante que define o atributo que especifica que o usu�rio n�o est� logado.
     */
    static final String AUTENTICACAO_NOT_OK = "%nao_autenticado%";
    
    
   
}
