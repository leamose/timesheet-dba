package br.com.dba.timesheet.web.form;

import org.apache.struts.validator.ValidatorForm;

public class ConfigurarForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
    private Integer hora_trabalho_inicio;
    private Integer hora_trabalho_fim;
    private Integer hora_almoco_inicio;
    private Integer hora_almoco_fim;
    private Integer mininoAlmoco;
    private Integer totalHorasMes;
    /**
     * @return the hora_trabalho_inicio
     */
    public Integer getHora_trabalho_inicio() {
        return hora_trabalho_inicio;
    }
    /**
     * @param hora_trabalho_inicio the hora_trabalho_inicio to set
     */
    public void setHora_trabalho_inicio(Integer hora_trabalho_inicio) {
        this.hora_trabalho_inicio = hora_trabalho_inicio;
    }
    /**
     * @return the hora_trabalho_fim
     */
    public Integer getHora_trabalho_fim() {
        return hora_trabalho_fim;
    }
    /**
     * @param hora_trabalho_fim the hora_trabalho_fim to set
     */
    public void setHora_trabalho_fim(Integer hora_trabalho_fim) {
        this.hora_trabalho_fim = hora_trabalho_fim;
    }
    /**
     * @return the hora_almoco_inicio
     */
    public Integer getHora_almoco_inicio() {
        return hora_almoco_inicio;
    }
    /**
     * @param hora_almoco_inicio the hora_almoco_inicio to set
     */
    public void setHora_almoco_inicio(Integer hora_almoco_inicio) {
        this.hora_almoco_inicio = hora_almoco_inicio;
    }
    /**
     * @return the hora_almoco_fim
     */
    public Integer getHora_almoco_fim() {
        return hora_almoco_fim;
    }
    /**
     * @param hora_almoco_fim the hora_almoco_fim to set
     */
    public void setHora_almoco_fim(Integer hora_almoco_fim) {
        this.hora_almoco_fim = hora_almoco_fim;
    }
    /**
     * @return the mininoAlmoco
     */
    public Integer getMininoAlmoco() {
        return mininoAlmoco;
    }
    /**
     * @param mininoAlmoco the mininoAlmoco to set
     */
    public void setMininoAlmoco(Integer mininoAlmoco) {
        this.mininoAlmoco = mininoAlmoco;
    }
    /**
     * @return the totalHorasMes
     */
    public Integer getTotalHorasMes() {
        return totalHorasMes;
    }
    /**
     * @param totalHorasMes the totalHorasMes to set
     */
    public void setTotalHorasMes(Integer totalHorasMes) {
        this.totalHorasMes = totalHorasMes;
    }
    
}
