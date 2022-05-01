package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsSeguimientoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4527173470554118038L;
	
	private String vcFechaSeguimiento;
	private String vcSeguimiento;
	
	public String getVcFechaSeguimiento() {
		return vcFechaSeguimiento;
	}
	public void setVcFechaSeguimiento(String vcFechaSeguimiento) {
		this.vcFechaSeguimiento = vcFechaSeguimiento;
	}
	public String getVcSeguimiento() {
		return vcSeguimiento;
	}
	public void setVcSeguimiento(String vcSeguimiento) {
		this.vcSeguimiento = vcSeguimiento;
	}

	
}
