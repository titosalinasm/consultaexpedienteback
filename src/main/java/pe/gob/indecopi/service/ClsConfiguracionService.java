package pe.gob.indecopi.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.chatbot.ClsRespuestaRenovacionBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsTipoSolicitudBean;
import pe.gob.indecopi.repository.ClsChatBotRepositoryI;
import pe.gob.indecopi.repository.ClsConfiguracionRepositoryI;
import pe.gob.indecopi.result.ClsConfiguracionResult;
import pe.gob.indecopi.result.ClsRenovacionChaBotResult;
import pe.gob.indecopi.util.ClsResultDAO;

@Service
public class ClsConfiguracionService implements Serializable, ClsConfiguracionServiceI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1945914613806716575L;
	
	
	public Logger logger = Logger.getLogger(ClsConfiguracionService.class);
	
	@Autowired
	private ClsConfiguracionRepositoryI objConConfiguracion;

	@Autowired
	private ClsResultDAO objResultDAO;
	
	
	@Override
	public ClsConfiguracionResult doConfiguracion() {
		//logger.info("doConsultaTerminos(filro) => "+objFiltroTerminos.getVcUsuario());

		ClsConfiguracionResult objConfigResult=new ClsConfiguracionResult();
		try {

			objResultDAO=objConConfiguracion.doConfiguracion();
			
			objConfigResult.setLstTipoSolicitud((List<ClsTipoSolicitudBean>)objResultDAO.get("PIN_CUR_TIPO_SOLICITUD"));
			
			objConfigResult.setNuError(new Long(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+"")));
			objConfigResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));


		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			logger.info(e);
		}
		
		return objConfigResult;
		
	}

}
