package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClsDetalleExpedienteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1338428810060794817L;
	
	//Datos del expediente
	private String nuAnioExpediente;
	private String vcIdAreaExpediente;
	private String vcIdExpediente;
	private String vcIdTipoExpediente;
	private String vcFechPresentacion;
	private String vcHoraPresentacion;
	private String vcLugar;
	private String vcProd;
	private String vcFechaAcumulacion;
	private String vcTipoAcumulacion;
	private String vcAcumuladoA;
	//Datos la marca
	private String vcTipoSolicitud;
	private String vcFechaSolicitud;
	private String vcFechaRegistro;
	private String vcNroCertificado;
	private String vcFechaPublicacion;
	private String vcFechaVencimiento;
	private String vcTipoPresentacion;
	private String vcClaseNiza;
	private String vcDenominacion;
	private String vcProductos;
	//CONCLUSION DEL EXPEDIENTE
	private String vcFechaConclusion;
	private String vcFormaConclusion;
	private String vcTipoFormaConclusion;
	private String vcNroResolucion;
	



	public String getNuAnioExpediente() {
		return nuAnioExpediente;
	}
	public void setNuAnioExpediente(String nuAnioExpediente) {
		this.nuAnioExpediente = nuAnioExpediente;
	}
	public String getVcIdAreaExpediente() {
		return vcIdAreaExpediente;
	}
	public void setVcIdAreaExpediente(String vcIdAreaExpediente) {
		this.vcIdAreaExpediente = vcIdAreaExpediente;
	}
	public String getVcIdExpediente() {
		return vcIdExpediente;
	}
	public void setVcIdExpediente(String vcIdExpediente) {
		this.vcIdExpediente = vcIdExpediente;
	}
	public String getVcIdTipoExpediente() {
		return vcIdTipoExpediente;
	}
	public void setVcIdTipoExpediente(String vcIdTipoExpediente) {
		this.vcIdTipoExpediente = vcIdTipoExpediente;
	}
	public String getVcFechPresentacion() {
		return vcFechPresentacion;
	}
	public void setVcFechPresentacion(String vcFechPresentacion) {
		this.vcFechPresentacion = vcFechPresentacion;
	}
	public String getVcHoraPresentacion() {
		return vcHoraPresentacion;
	}
	public void setVcHoraPresentacion(String vcHoraPresentacion) {
		this.vcHoraPresentacion = vcHoraPresentacion;
	}
	public String getVcLugar() {
		return vcLugar;
	}
	public void setVcLugar(String vcLugar) {
		this.vcLugar = vcLugar;
	}
	public String getVcProd() {
		return vcProd;
	}
	public void setVcProd(String vcProd) {
		this.vcProd = vcProd;
	}
	public String getVcFechaAcumulacion() {
		return vcFechaAcumulacion;
	}
	public void setVcFechaAcumulacion(String vcFechaAcumulacion) {
		this.vcFechaAcumulacion = vcFechaAcumulacion;
	}
	public String getVcTipoAcumulacion() {
		return vcTipoAcumulacion;
	}
	public void setVcTipoAcumulacion(String vcTipoAcumulacion) {
		this.vcTipoAcumulacion = vcTipoAcumulacion;
	}
	public String getVcAcumuladoA() {
		return vcAcumuladoA;
	}
	public void setVcAcumuladoA(String vcAcumuladoA) {
		this.vcAcumuladoA = vcAcumuladoA;
	}
	public String getVcTipoSolicitud() {
		return vcTipoSolicitud;
	}
	public void setVcTipoSolicitud(String vcTipoSolicitud) {
		this.vcTipoSolicitud = vcTipoSolicitud;
	}
	public String getVcFechaSolicitud() {
		return vcFechaSolicitud;
	}
	public void setVcFechaSolicitud(String vcFechaSolicitud) {
		this.vcFechaSolicitud = vcFechaSolicitud;
	}
	public String getVcFechaRegistro() {
		return vcFechaRegistro;
	}
	public void setVcFechaRegistro(String vcFechaRegistro) {
		this.vcFechaRegistro = vcFechaRegistro;
	}
	public String getVcNroCertificado() {
		return vcNroCertificado;
	}
	public void setVcNroCertificado(String vcNroCertificado) {
		this.vcNroCertificado = vcNroCertificado;
	}
	public String getVcFechaPublicacion() {
		return vcFechaPublicacion;
	}
	public void setVcFechaPublicacion(String vcFechaPublicacion) {
		this.vcFechaPublicacion = vcFechaPublicacion;
	}
	public String getVcFechaVencimiento() {
		return vcFechaVencimiento;
	}
	public void setVcFechaVencimiento(String vcFechaVencimiento) {
		this.vcFechaVencimiento = vcFechaVencimiento;
	}
	public String getVcTipoPresentacion() {
		return vcTipoPresentacion;
	}
	public void setVcTipoPresentacion(String vcTipoPresentacion) {
		this.vcTipoPresentacion = vcTipoPresentacion;
	}
	public String getVcClaseNiza() {
		return vcClaseNiza;
	}
	public void setVcClaseNiza(String vcClaseNiza) {
		this.vcClaseNiza = vcClaseNiza;
	}
	public String getVcDenominacion() {
		return vcDenominacion;
	}
	public void setVcDenominacion(String vcDenominacion) {
		this.vcDenominacion = vcDenominacion;
	}
	public String getVcProductos() {
		return vcProductos;
	}
	public void setVcProductos(String vcProductos) {
		this.vcProductos = vcProductos;
	}
	public String getVcFechaConclusion() {
		return vcFechaConclusion;
	}
	public void setVcFechaConclusion(String vcFechaConclusion) {
		this.vcFechaConclusion = vcFechaConclusion;
	}
	public String getVcFormaConclusion() {
		return vcFormaConclusion;
	}
	public void setVcFormaConclusion(String vcFormaConclusion) {
		this.vcFormaConclusion = vcFormaConclusion;
	}
	public String getVcTipoFormaConclusion() {
		return vcTipoFormaConclusion;
	}
	public void setVcTipoFormaConclusion(String vcTipoFormaConclusion) {
		this.vcTipoFormaConclusion = vcTipoFormaConclusion;
	}
	public String getVcNroResolucion() {
		return vcNroResolucion;
	}
	public void setVcNroResolucion(String vcNroResolucion) {
		this.vcNroResolucion = vcNroResolucion;
	}
	
	
	

}
