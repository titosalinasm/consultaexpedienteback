package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpedienteBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsExpedienteResult extends ClsErrorResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7618003256292852014L;
	
	private List<ClsRespuestaExpedienteBean> lstExpediente;
	
	public ClsExpedienteResult() {
		this.setLstExpediente(new ArrayList<ClsRespuestaExpedienteBean>());
	}

	public List<ClsRespuestaExpedienteBean> getLstExpediente() {
		return lstExpediente;
	}

	public void setLstExpediente(List<ClsRespuestaExpedienteBean> lstExpediente) {
		this.lstExpediente = lstExpediente;
	}
	
	
	
	
}
