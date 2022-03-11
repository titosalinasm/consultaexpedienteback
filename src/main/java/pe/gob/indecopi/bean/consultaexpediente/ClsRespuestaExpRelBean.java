package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsRespuestaExpRelBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2439737388355179381L;
	
	private String vcIdExpediente;
	private Integer nuAnioExpediente;
	private String vcTipoExpediente;
	private String vcFechaPresentacion;
	private String vcClase;
	
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
	public String getVcTipoExpediente() {
		return vcTipoExpediente;
	}
	public void setVcTipoExpediente(String vcTipoExpediente) {
		this.vcTipoExpediente = vcTipoExpediente;
	}
	public String getVcFechaPresentacion() {
		return vcFechaPresentacion;
	}
	public void setVcFechaPresentacion(String vcFechaPresentacion) {
		this.vcFechaPresentacion = vcFechaPresentacion;
	}
	public String getVcClase() {
		return vcClase;
	}
	public void setVcClase(String vcClase) {
		this.vcClase = vcClase;
	}
	
	

}
