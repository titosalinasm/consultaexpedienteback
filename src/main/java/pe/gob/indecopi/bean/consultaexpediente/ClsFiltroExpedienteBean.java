package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsFiltroExpedienteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6476125530478197035L;
	
	private String vcNroExpediente;
	private Integer nuAnioExpediente;

	

	public Integer getNuAnioExpediente() {
		return nuAnioExpediente;
	}

	public void setNuAnioExpediente(Integer nuAnioExpediente) {
		this.nuAnioExpediente = nuAnioExpediente;
	}

	public String getVcNroExpediente() {
		return vcNroExpediente;
	}

	public void setVcNroExpediente(String vcNroExpediente) {
		this.vcNroExpediente = vcNroExpediente;
	}
	

}
