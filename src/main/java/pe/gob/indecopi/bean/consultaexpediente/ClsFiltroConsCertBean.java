package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsFiltroConsCertBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2815325651474773064L;
	
	private String vcNroCertificado;
	private String vcTipoSolicitud;
	
	

	public String getVcTipoSolicitud() {
		return vcTipoSolicitud;
	}
	public void setVcTipoSolicitud(String vcTipoSolicitud) {
		this.vcTipoSolicitud = vcTipoSolicitud;
	}
	public String getVcNroCertificado() {
		return vcNroCertificado;
	}
	public void setVcNroCertificado(String vcNroCertificado) {
		this.vcNroCertificado = vcNroCertificado;
	}
	
	

}
