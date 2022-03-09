package pe.gob.indecopi.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.gob.indecopi.bean.chatbot.ClsInputRegistroBean;
import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.chatbot.ClsRespuestaRegistroBean;
import pe.gob.indecopi.bean.chatbot.ClsRespuestaRenovacionBean;
import pe.gob.indecopi.repository.ClsChatBotRepositoryI;
import pe.gob.indecopi.result.ClsRegistroResult;
import pe.gob.indecopi.result.ClsRenovacionChaBotResult;
import pe.gob.indecopi.util.ClsResultDAO;

@Service
public class ClsChatBotService implements Serializable, ClsChatBotServiceI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1945914613806716575L;
	
	
	public Logger logger = Logger.getLogger(ClsChatBotService.class);
	
	@Autowired
	private ClsChatBotRepositoryI objConnChatBot;

	@Autowired
	private ClsResultDAO objResultDAO;
	
	
	@Override
	public ClsRenovacionChaBotResult dochatbotrenovacion(ClsInputRenovacionBean objFiltro) {
		//logger.info("doConsultaTerminos(filro) => "+objFiltroTerminos.getVcUsuario());

		ClsRenovacionChaBotResult objConfigResult=new ClsRenovacionChaBotResult();
		try {

			objResultDAO=objConnChatBot.dochatbotrenobacion(objFiltro);
			
			List<ClsRespuestaRenovacionBean> objList= (List<ClsRespuestaRenovacionBean>)objResultDAO.get("POUT_CUR_RENOVACION");
			
			for(ClsRespuestaRenovacionBean obj: objList) {
				objConfigResult.setObjRespuesta(obj);
			}
			
			
			
			objConfigResult.setNuError(new Long(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+"")));
			objConfigResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));


		
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			logger.info(e);
		}
		
		return objConfigResult;
		
	}
	
	@Override
	public ClsRegistroResult doRegistro(ClsInputRegistroBean objFiltro) {
		//logger.info("doConsultaTerminos(filro) => "+objFiltroTerminos.getVcUsuario());

		ClsRegistroResult objConfigResult=new ClsRegistroResult();
		try {

			objResultDAO=objConnChatBot.dochatbotmarcas(objFiltro);
			
			objConfigResult.setLstExpediente((List<ClsRespuestaRegistroBean>)objResultDAO.get("POUT_CUR_REG"));
			
			if(objConfigResult.getLstExpediente().size()>0) {
			objConfigResult.setNuError(new Long(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+"")));
			objConfigResult.setVcError("Hemos encontrado los siguientes expedientes:");
			}else {
	
			objConfigResult.setNuError(-1L);
			objConfigResult.setVcError("No se encontraron resultados");
			}


		
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			logger.info(e);
		}
		
		return objConfigResult;
		
	}

}
