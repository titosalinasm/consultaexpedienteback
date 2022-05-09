package pe.gob.indecopi.bean.chatbot;

import java.io.Serializable;

public class ClsRespuestaRegistroBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2436227323494538022L;
	
	private String vcExpediente;
	private String vcTipoSolicitud;
	private String vcTipoSigno;
	private String vcSegundoNivel;
	
	public String getVcExpediente() {
		return vcExpediente;
	}
	public void setVcExpediente(String vcExpediente) {
		this.vcExpediente = vcExpediente;
	}
	public String getVcTipoSolicitud() {
		return vcTipoSolicitud;
	}
	public void setVcTipoSolicitud(String vcTipoSolicitud) {
		this.vcTipoSolicitud = vcTipoSolicitud;
	}
	public String getVcTipoSigno() {
		return vcTipoSigno;
	}
	public void setVcTipoSigno(String vcTipoSigno) {
		this.vcTipoSigno = vcTipoSigno;
	}
	
	public String getVcSegundoNivel() {
		return vcSegundoNivel;
	}
	public void setVcSegundoNivel(String vcSegundoNivel) {
		this.vcSegundoNivel = vcSegundoNivel;
	}

	
	

}
