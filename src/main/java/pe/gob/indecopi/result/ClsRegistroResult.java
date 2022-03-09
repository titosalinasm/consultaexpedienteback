package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.chatbot.ClsRespuestaRegistroBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsRegistroResult extends ClsErrorResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2256779790488974813L;
	
	private List<ClsRespuestaRegistroBean> lstExpediente;
	
	public ClsRegistroResult() {
		this.setLstExpediente(new ArrayList<ClsRespuestaRegistroBean>());
	}

	public List<ClsRespuestaRegistroBean> getLstExpediente() {
		return lstExpediente;
	}

	public void setLstExpediente(List<ClsRespuestaRegistroBean> lstExpediente) {
		this.lstExpediente = lstExpediente;
	}
		
		

}
