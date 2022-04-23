package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsFiltroDetalleExpBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9140605679015388057L;
	
	private String vcIdExpediente;
	private Integer nuAnioExpediente;
	private String vcIdAreaExpediente;
	private String vcIdTipoExpediente;
	
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
	public String getVcIdAreaExpediente() {
		return vcIdAreaExpediente;
	}
	public void setVcIdAreaExpediente(String vcIdAreaExpediente) {
		this.vcIdAreaExpediente = vcIdAreaExpediente;
	}
	public String getVcIdTipoExpediente() {
		return vcIdTipoExpediente;
	}
	public void setVcIdTipoExpediente(String vcIdTipoExpediente) {
		this.vcIdTipoExpediente = vcIdTipoExpediente;
	}
	
	

}
