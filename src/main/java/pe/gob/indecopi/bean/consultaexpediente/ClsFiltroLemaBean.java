package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsFiltroLemaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6351370199089565281L;
	
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
