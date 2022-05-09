package pe.gob.indecopi.result;

import java.io.Serializable;

import pe.gob.indecopi.bean.chatbot.ClsRespuestaRenovacionBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsRenovacionChaBotResult extends ClsErrorResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7480680070588799132L;
	
private ClsRespuestaRenovacionBean objRespuesta;

public ClsRenovacionChaBotResult() {
	this.setObjRespuesta(new ClsRespuestaRenovacionBean());
}



public ClsRespuestaRenovacionBean getObjRespuesta() {
	return objRespuesta;
}

public void setObjRespuesta(ClsRespuestaRenovacionBean objRespuesta) {
	this.objRespuesta = objRespuesta;
}



}
