package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsTitularesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -133789313866014798L;
	
	private String vcTipoPersona;
	private String vcPersona;
	private String vcTipoDocumento;
	private String vcDocumento;
	private String vcDomicilioProcesal;
	private String vcDomicilioPersonal;
	
	public String getVcTipoPersona() {
		return vcTipoPersona;
	}
	public void setVcTipoPersona(String vcTipoPersona) {
		this.vcTipoPersona = vcTipoPersona;
	}
	public String getVcPersona() {
		return vcPersona;
	}
	public void setVcPersona(String vcPersona) {
		this.vcPersona = vcPersona;
	}
	public String getVcTipoDocumento() {
		return vcTipoDocumento;
	}
	public void setVcTipoDocumento(String vcTipoDocumento) {
		this.vcTipoDocumento = vcTipoDocumento;
	}
	public String getVcDocumento() {
		return vcDocumento;
	}
	public void setVcDocumento(String vcDocumento) {
		this.vcDocumento = vcDocumento;
	}
	public String getVcDomicilioProcesal() {
		return vcDomicilioProcesal;
	}
	public void setVcDomicilioProcesal(String vcDomicilioProcesal) {
		this.vcDomicilioProcesal = vcDomicilioProcesal;
	}
	public String getVcDomicilioPersonal() {
		return vcDomicilioPersonal;
	}
	public void setVcDomicilioPersonal(String vcDomicilioPersonal) {
		this.vcDomicilioPersonal = vcDomicilioPersonal;
	}
	

}
