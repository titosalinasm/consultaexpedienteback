package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaCertBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsCertificadoResult extends ClsErrorResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2602235648348868418L;
	
	private List<ClsRespuestaCertBean> lstCertificado;
	
	public ClsCertificadoResult() {
		this.setLstCertificado(new ArrayList<ClsRespuestaCertBean>());
	}

	public List<ClsRespuestaCertBean> getLstCertificado() {
		return lstCertificado;
	}

	public void setLstCertificado(List<ClsRespuestaCertBean> lstCertificado) {
		this.lstCertificado = lstCertificado;
	}
	
	
	
	

}
