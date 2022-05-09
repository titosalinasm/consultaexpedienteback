package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpRelBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsExpRelResult extends ClsErrorResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1731076552946526055L;
	
	private List<ClsRespuestaExpRelBean> lstExpRelacionado;
	
	public ClsExpRelResult() {
		this.setLstExpRelacionado(new ArrayList<ClsRespuestaExpRelBean>());
	}

	public List<ClsRespuestaExpRelBean> getLstExpRelacionado() {
		return lstExpRelacionado;
	}

	public void setLstExpRelacionado(List<ClsRespuestaExpRelBean> lstExpRelacionado) {
		this.lstExpRelacionado = lstExpRelacionado;
	}
	
	
	
	

}
