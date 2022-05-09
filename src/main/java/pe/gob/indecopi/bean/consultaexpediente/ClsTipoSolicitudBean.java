package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsTipoSolicitudBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6573654281043084572L;
	
	private String vcCodigoSolicitud;
	private String vcDescSolicitud;
	
	public String getVcCodigoSolicitud() {
		return vcCodigoSolicitud;
	}
	public void setVcCodigoSolicitud(String vcCodigoSolicitud) {
		this.vcCodigoSolicitud = vcCodigoSolicitud;
	}
	public String getVcDescSolicitud() {
		return vcDescSolicitud;
	}
	public void setVcDescSolicitud(String vcDescSolicitud) {
		this.vcDescSolicitud = vcDescSolicitud;
	}
	
	

}
