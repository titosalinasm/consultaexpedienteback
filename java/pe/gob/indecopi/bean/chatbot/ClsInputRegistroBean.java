package pe.gob.indecopi.bean.chatbot;

import java.io.Serializable;

public class ClsInputRegistroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4735365363051607689L;
	private String vcNroDoc;
	private String vcNombresRazonSocial;
	private Integer nuAnio;
	
	public String getVcNroDoc() {
		return vcNroDoc;
	}
	public void setVcNroDoc(String vcNroDoc) {
		this.vcNroDoc = vcNroDoc;
	}
	public String getVcNombresRazonSocial() {
		return vcNombresRazonSocial;
	}
	public void setVcNombresRazonSocial(String vcNombresRazonSocial) {
		this.vcNombresRazonSocial = vcNombresRazonSocial;
	}
	public Integer getNuAnio() {
		return nuAnio;
	}
	public void setNuAnio(Integer nuAnio) {
		this.nuAnio = nuAnio;
	}
	
	

}
