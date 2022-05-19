package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;

public class ClsRespuestaCertBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2920726740380938023L;
	
	private Integer nuIdRegistro;
	private Integer nuAnioRegistro;
	private String vcIdAreaRegistro;
	private String vcLogo;
	private String vcNroCertificado;
	private String vcDenominacion;
	private String vcTipoSolicitud;
	private String vcTipoSigno;
	private String vcClases;
	private String vcTitulares;
	private String vcEstado;
	private String vcDescEstado;
	private String vcDivRecla;
	private Integer nuFlagPeriodoRen;
	private String vcIdTipoSolicitud;
	
	public String getVcIdAreaRegistro() {
		return vcIdAreaRegistro;
	}
	public void setVcIdAreaRegistro(String vcIdAreaRegistro) {
		this.vcIdAreaRegistro = vcIdAreaRegistro;
	}
	public Integer getNuIdRegistro() {
		return nuIdRegistro;
	}
	public void setNuIdRegistro(Integer nuIdRegistro) {
		this.nuIdRegistro = nuIdRegistro;
	}
	public String getVcDivRecla() {
		return vcDivRecla;
	}
	public void setVcDivRecla(String vcDivRecla) {
		this.vcDivRecla = vcDivRecla;
	}
	public String getVcIdTipoSolicitud() {
		return vcIdTipoSolicitud;
	}
	public void setVcIdTipoSolicitud(String vcIdTipoSolicitud) {
		this.vcIdTipoSolicitud = vcIdTipoSolicitud;
	}
	public String getVcLogo() {
		return vcLogo;
	}
	public void setVcLogo(String vcLogo) {
		this.vcLogo = vcLogo;
	}
	public Integer getNuAnioRegistro() {
		return nuAnioRegistro;
	}
	public void setNuAnioRegistro(Integer nuAnioRegistro) {
		this.nuAnioRegistro = nuAnioRegistro;
	}
	public String getVcNroCertificado() {
		return vcNroCertificado;
	}
	public void setVcNroCertificado(String vcNroCertificado) {
		this.vcNroCertificado = vcNroCertificado;
	}
	public String getVcDenominacion() {
		return vcDenominacion;
	}
	public void setVcDenominacion(String vcDenominacion) {
		this.vcDenominacion = vcDenominacion;
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
	public String getVcClases() {
		return vcClases;
	}
	public void setVcClases(String vcClases) {
		this.vcClases = vcClases;
	}
	public String getVcTitulares() {
		return vcTitulares;
	}
	public void setVcTitulares(String vcTitulares) {
		this.vcTitulares = vcTitulares;
	}
	public String getVcEstado() {
		return vcEstado;
	}
	public void setVcEstado(String vcEstado) {
		this.vcEstado = vcEstado;
	}
	public String getVcDescEstado() {
		return vcDescEstado;
	}
	public void setVcDescEstado(String vcDescEstado) {
		this.vcDescEstado = vcDescEstado;
	}
	public Integer getNuFlagPeriodoRen() {
		return nuFlagPeriodoRen;
	}
	public void setNuFlagPeriodoRen(Integer nuFlagPeriodoRen) {
		this.nuFlagPeriodoRen = nuFlagPeriodoRen;
	}
	
	

}
