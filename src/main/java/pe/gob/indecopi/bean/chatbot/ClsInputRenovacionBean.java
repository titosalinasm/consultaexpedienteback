package pe.gob.indecopi.bean.chatbot;

import java.io.Serializable;

public class ClsInputRenovacionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -980057454035240035L;
	
	private String vcNroExpediente;
	private String vcNroDocumento;
	private String vcNombresRazonSocial;
	
	public String getVcNroExpediente() {
		return vcNroExpediente;
	}
	public void setVcNroExpediente(String vcNroExpediente) {
		this.vcNroExpediente = vcNroExpediente;
	}
	public String getVcNroDocumento() {
		return vcNroDocumento;
	}
	public void setVcNroDocumento(String vcNroDocumento) {
		this.vcNroDocumento = vcNroDocumento;
	}
	public String getVcNombresRazonSocial() {
		return vcNombresRazonSocial;
	}
	public void setVcNombresRazonSocial(String vcNombresRazonSocial) {
		this.vcNombresRazonSocial = vcNombresRazonSocial;
	}

	
	
	

}
