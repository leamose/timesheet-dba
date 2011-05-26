package br.com.dba.timesheet.web.filtros;

public interface ConstantesLogin {

    /**
     * Constante que define o atributo na sessão que indica se o usuário está ou não logado.
     */
    static final String AUTENTICACAO = "br.com.br.timesheet.action.login.att";

    /**
     * Constante que define o atributo que especifica que o usuário está logado.
     */
    static final String AUTENTICACAO_OK = "%autenticado%";

    /**
     * Constante que define o atributo que especifica que o usuário não está logado.
     */
    static final String AUTENTICACAO_NOT_OK = "%nao_autenticado%";
    
    
   
}
