package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsLogoFiltroBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8821704935030636202L;
	
	private String vcNroCertificado;
	private Integer nuAnioRegistro;
	
	public String getVcNroCertificado() {
		return vcNroCertificado;
	}
	public void setVcNroCertificado(String vcNroCertificado) {
		this.vcNroCertificado = vcNroCertificado;
	}
	public Integer getNuAnioRegistro() {
		return nuAnioRegistro;
	}
	public void setNuAnioRegistro(Integer nuAnioRegistro) {
		this.nuAnioRegistro = nuAnioRegistro;
	}
	
	

}
