package pe.gob.indecopi.bean.consultaexpediente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClsRespuestaExpedienteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7114973455738294246L;
	
	private String vcMarca;
	private String vcIdExpediente;
	private Integer nuAnioExpediente;
	private String vcIdAreaExpediente;
	private String vcTipoExpediente;
	private String vcIdTipoExpediente;
	private Integer nuProcedimiento;
	private String vcProcedimiento;
	private String vcFechaPresentacion;
	private String vcClase;
	private Integer nuEstado;
	private String vcLogoHito;
	private String vcLogoEstado;
	private String vcDescEstado;
	private String vcLink;
	private String vcFechaPublicacion;
	private String vcSentidoResolucion;
	
	private List<ClsResolucionBean> lstResolucion;
	
	public ClsRespuestaExpedienteBean() {
		this.setLstResolucion(new ArrayList<ClsResolucionBean>());
	}
	
	public Integer getNuProcedimiento() {
		return nuProcedimiento;
	}

	public void setNuProcedimiento(Integer nuProcedimiento) {
		this.nuProcedimiento = nuProcedimiento;
	}
	
	public List<ClsResolucionBean> getLstResolucion() {
		return lstResolucion;
	}

	public void setLstResolucion(List<ClsResolucionBean> lstResolucion) {
		this.lstResolucion = lstResolucion;
	}

	public String getVcProcedimiento() {
		return vcProcedimiento;
	}
	public void setVcProcedimiento(String vcProcedimiento) {
		this.vcProcedimiento = vcProcedimiento;
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
	public String getVcLink() {
		return vcLink;
	}
	public void setVcLink(String vcLink) {
		this.vcLink = vcLink;
	}
	public String getVcFechaPublicacion() {
		return vcFechaPublicacion;
	}
	public void setVcFechaPublicacion(String vcFechaPublicacion) {
		this.vcFechaPublicacion = vcFechaPublicacion;
	}
	public String getVcSentidoResolucion() {
		return vcSentidoResolucion;
	}
	public void setVcSentidoResolucion(String vcSentidoResolucion) {
		this.vcSentidoResolucion = vcSentidoResolucion;
	}
	public String getVcLogoHito() {
		return vcLogoHito;
	}
	public void setVcLogoHito(String vcLogoHito) {
		this.vcLogoHito = vcLogoHito;
	}
	public String getVcLogoEstado() {
		return vcLogoEstado;
	}
	public void setVcLogoEstado(String vcLogoEstado) {
		this.vcLogoEstado = vcLogoEstado;
	}
	public String getVcDescEstado() {
		return vcDescEstado;
	}
	public void setVcDescEstado(String vcDescEstado) {
		this.vcDescEstado = vcDescEstado;
	}
	public Integer getNuEstado() {
		return nuEstado;
	}
	public void setNuEstado(Integer nuEstado) {
		this.nuEstado = nuEstado;
	}
	public String getVcMarca() {
		return vcMarca;
	}
	public void setVcMarca(String vcMarca) {
		this.vcMarca = vcMarca;
	}
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
	public String getVcTipoExpediente() {
		return vcTipoExpediente;
	}
	public void setVcTipoExpediente(String vcTipoExpediente) {
		this.vcTipoExpediente = vcTipoExpediente;
	}
	public String getVcFechaPresentacion() {
		return vcFechaPresentacion;
	}
	public void setVcFechaPresentacion(String vcFechaPresentacion) {
		this.vcFechaPresentacion = vcFechaPresentacion;
	}
	public String getVcClase() {
		return vcClase;
	}
	public void setVcClase(String vcClase) {
		this.vcClase = vcClase;
	}
	
	

}
