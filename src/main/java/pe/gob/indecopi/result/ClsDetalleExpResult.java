package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.consultaexpediente.ClsDetalleExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsSeguimientoBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsTitularesBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsDetalleExpResult extends ClsErrorResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 128689372194206151L;
	
	private ClsDetalleExpedienteBean objDatoExpediente;
	private List<ClsTitularesBean> lstTitulares;
	private List<ClsSeguimientoBean> lstSeguimiento;
	
	public ClsDetalleExpResult() {
		this.setObjDatoExpediente(new ClsDetalleExpedienteBean());
		this.setLstTitulares(new ArrayList<ClsTitularesBean>());
		this.setLstSeguimiento(new ArrayList<ClsSeguimientoBean>());
	}
	
	public ClsDetalleExpedienteBean getObjDatoExpediente() {
		return objDatoExpediente;
	}
	public void setObjDatoExpediente(ClsDetalleExpedienteBean objDatoExpediente) {
		this.objDatoExpediente = objDatoExpediente;
	}
	public List<ClsTitularesBean> getLstTitulares() {
		return lstTitulares;
	}
	public void setLstTitulares(List<ClsTitularesBean> lstTitulares) {
		this.lstTitulares = lstTitulares;
	}
	public List<ClsSeguimientoBean> getLstSeguimiento() {
		return lstSeguimiento;
	}
	public void setLstSeguimiento(List<ClsSeguimientoBean> lstSeguimiento) {
		this.lstSeguimiento = lstSeguimiento;
	}
	
	
	

}
