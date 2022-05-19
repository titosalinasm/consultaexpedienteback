package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsLemaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8199213878454644443L;

	private String vcIdClase;
	private String vcNroCertificado;
	private String vcFechaExpiracion;
	private String vcFrase;
	private String vcVigencia;
	
	
	public String getVcIdClase() {
		return vcIdClase;
	}
	public void setVcIdClase(String vcIdClase) {
		this.vcIdClase = vcIdClase;
	}
	public String getVcNroCertificado() {
		return vcNroCertificado;
	}
	public void setVcNroCertificado(String vcNroCertificado) {
		this.vcNroCertificado = vcNroCertificado;
	}
	public String getVcFechaExpiracion() {
		return vcFechaExpiracion;
	}
	public void setVcFechaExpiracion(String vcFechaExpiracion) {
		this.vcFechaExpiracion = vcFechaExpiracion;
	}
	public String getVcFrase() {
		return vcFrase;
	}
	public void setVcFrase(String vcFrase) {
		this.vcFrase = vcFrase;
	}
	public String getVcVigencia() {
		return vcVigencia;
	}
	public void setVcVigencia(String vcVigencia) {
		this.vcVigencia = vcVigencia;
	}
	
	
	
}
