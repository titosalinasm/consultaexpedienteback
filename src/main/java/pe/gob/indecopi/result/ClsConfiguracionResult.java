package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.consultaexpediente.ClsTipoSolicitudBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsConfiguracionResult extends ClsErrorResult implements Serializable {

	private static final long serialVersionUID = 2583101027116451231L;
	
	private List<ClsTipoSolicitudBean> lstTipoSolicitud;
	
	public ClsConfiguracionResult() {
		this.setLstTipoSolicitud(new ArrayList<ClsTipoSolicitudBean>());
	}

	public List<ClsTipoSolicitudBean> getLstTipoSolicitud() {
		return lstTipoSolicitud;
	}

	public void setLstTipoSolicitud(List<ClsTipoSolicitudBean> lstTipoSolicitud) {
		this.lstTipoSolicitud = lstTipoSolicitud;
	}



	

}
