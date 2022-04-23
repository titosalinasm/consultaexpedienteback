package pe.gob.indecopi.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.chatbot.ClsRespuestaRenovacionBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsDetalleExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroConsCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroDetalleExpBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsSeguimientoBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsTipoSolicitudBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsTitularesBean;
import pe.gob.indecopi.repository.ClsBusquedaRepositoryI;
import pe.gob.indecopi.repository.ClsChatBotRepositoryI;
import pe.gob.indecopi.repository.ClsConfiguracionRepositoryI;
import pe.gob.indecopi.result.ClsCertificadoResult;
import pe.gob.indecopi.result.ClsConfiguracionResult;
import pe.gob.indecopi.result.ClsDetalleExpResult;
import pe.gob.indecopi.result.ClsExpRelResult;
import pe.gob.indecopi.result.ClsExpedienteResult;
import pe.gob.indecopi.result.ClsRenovacionChaBotResult;
import pe.gob.indecopi.util.ClsResultDAO;

@Service
public class ClsBusquedaService implements Serializable, ClsBusquedaServiceI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1945914613806716575L;
	
	
	public Logger logger = Logger.getLogger(ClsBusquedaService.class);
	
	@Autowired
	private ClsBusquedaRepositoryI objConn;

	@Autowired
	private ClsResultDAO objResultDAO;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public ClsCertificadoResult doLstCertificado(ClsFiltroConsCertBean objFiltro) {
		//logger.info("doConsultaTerminos(filro) => "+objFiltroTerminos.getVcUsuario());

		ClsCertificadoResult objResult=new ClsCertificadoResult();
		try {

			objResultDAO=objConn.doBuscarCertificado(objFiltro);
			
			objResult.setLstCertificado((List<ClsRespuestaCertBean>)objResultDAO.get("POUT_CUR_CERTIFICADO"));
			
			objResult.setNuError(new Long(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+"")));
			objResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));


		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			logger.info(e);
		}
		
		return objResult;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ClsExpRelResult doLstExpRelacionado(ClsFiltroExpRelBean objFiltro) {
		//logger.info("doConsultaTerminos(filro) => "+objFiltroTerminos.getVcUsuario());

		ClsExpRelResult objResult=new ClsExpRelResult();
		try {

			objResultDAO=objConn.doExpedienteRel(objFiltro);
			
			objResult.setLstExpRelacionado((List<ClsRespuestaExpRelBean>)objResultDAO.get("POUT_CUR_EXPEDIENTE"));
			
			objResult.setNuError(new Long(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+"")));
			objResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));


		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			logger.info(e);
		}
		
		return objResult;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ClsExpedienteResult doBuscarExpediente(ClsFiltroExpedienteBean objFiltro) {
		//logger.info("doConsultaTerminos(filro) => "+objFiltroTerminos.getVcUsuario());

		ClsExpedienteResult objResult=new ClsExpedienteResult();
		try {

			objResultDAO=objConn.doBuscarExpediente(objFiltro);
			
			objResult.setLstExpediente((List<ClsRespuestaExpedienteBean>)objResultDAO.get("POUT_CUR_EXPEDIENTE"));
			
			objResult.setNuError(new Long(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+"")));
			objResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));


		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			logger.info(e);
		}
		
		return objResult;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ClsDetalleExpResult doBuscarDetalleExpediente(ClsFiltroDetalleExpBean objFiltro) {

		ClsDetalleExpResult objResult=new ClsDetalleExpResult();
		try {

			objResultDAO=objConn.doBuscarExpedienteDetalle(objFiltro);
			
			objResult.setObjDatoExpediente(((List<ClsDetalleExpedienteBean>)objResultDAO.get("POUT_CUR_DATOS_EXP")).get(0));
			objResult.setLstTitulares((List<ClsTitularesBean>)objResultDAO.get("POUT_CUR_TITULARES"));
			objResult.setLstSeguimiento((List<ClsSeguimientoBean>)objResultDAO.get("POUT_CUR_SEGUIMIENTO"));
			
			objResult.setNuError(new Long(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+"")));
			objResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));


		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			logger.info(e);
		}
		
		return objResult;
		
	}
	
	

}
