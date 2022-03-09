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
	private String vcRutaArchivoJson;
	
	public ClsConfigFilePath() {
		// TODO Auto-generated constructor stub
	}

	public String getVcRutaArchivoJson() {
		return vcRutaArchivoJson;
	}

	public void setVcRutaArchivoJson(String vcRutaArchivoJson) {
		this.vcRutaArchivoJson = vcRutaArchivoJson;
	}



}
