package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.consultaexpediente.ClsLemaBean;

public class ClsLemaResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8049506394781084016L;
	
	private List<ClsLemaBean> lstLema;
	
	public ClsLemaResult() {
		this.setLstLema(new ArrayList<ClsLemaBean>());
	}

	public List<ClsLemaBean> getLstLema() {
		return lstLema;
	}

	public void setLstLema(List<ClsLemaBean> lstLema) {
		this.lstLema = lstLema;
	}
	
	
	

}
