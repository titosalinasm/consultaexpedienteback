package pe.gob.indecopi.util;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="path-file")
public class ClsConfigFilePath implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5579995624678365202L;
	
	private String vcUsuario;
	private String vcClave;
	private String vcRutacmis;
    private String vcLinkDescarga;
    private String vcRutaLogo;
    
	
	public ClsConfigFilePath() {
		// TODO Auto-generated constructor stub
	}

	
	public String getVcRutaLogo() {
		return vcRutaLogo;
	}
	public void setVcRutaLogo(String vcRutaLogo) {
		this.vcRutaLogo = vcRutaLogo;
	}
	public String getVcLinkDescarga() {
		return vcLinkDescarga;
	}
	public void setVcLinkDescarga(String vcLinkDescarga) {
		this.vcLinkDescarga = vcLinkDescarga;
	}
	public String getVcUsuario() {
		return vcUsuario;
	}

	public void setVcUsuario(String vcUsuario) {
		this.vcUsuario = vcUsuario;
	}

	public String getVcClave() {
		return vcClave;
	}

	public void setVcClave(String vcClave) {
		this.vcClave = vcClave;
	}

	public String getVcRutacmis() {
		return vcRutacmis;
	}

	public void setVcRutacmis(String vcRutacmis) {
		this.vcRutacmis = vcRutacmis;
	}

}
