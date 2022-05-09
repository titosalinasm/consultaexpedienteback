package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsFiltroExpAlfrascoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4415556469482908817L;
	
	private String vcIdExpediente;
	private Integer nuAnioExpediente;
	private String vcAreaExpediente;
	
	
	public String getVcIdExpediente() {
		return vcIdExpediente;
	}
	public void setVcIdExpediente(String vcIdExpediente) {
		this.vcIdExpediente = vcIdExpediente;
	}
	public Integer getNuAnioExpediente() {
		return nuAnioExpediente;
	}
	public void setNuAnioExpediente(Integer nuAnioExpediente) {
		this.nuAnioExpediente = nuAnioExpediente;
	}
	public String getVcAreaExpediente() {
		return vcAreaExpediente;
	}
	public void setVcAreaExpediente(String vcAreaExpediente) {
		this.vcAreaExpediente = vcAreaExpediente;
	}
	
	

}
