package pe.gob.indecopi.service;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.chatbot.ClsRespuestaRenovacionBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsDetalleExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroConsCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroDetalleExpBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpAlfrascoBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroLemaBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsLemaBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsLogoFiltroBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsResolucionBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsSeguimientoBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsTipoSolicitudBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsTitularesBean;
import pe.gob.indecopi.controller.ClsBusquedaController;
import pe.gob.indecopi.repository.ClsBusquedaRepositoryI;
import pe.gob.indecopi.repository.ClsChatBotRepositoryI;
import pe.gob.indecopi.repository.ClsConfiguracionRepositoryI;
import pe.gob.indecopi.result.ClsCertificadoResult;
import pe.gob.indecopi.result.ClsConfiguracionResult;
import pe.gob.indecopi.result.ClsDetalleExpResult;
import pe.gob.indecopi.result.ClsExpRelResult;
import pe.gob.indecopi.result.ClsExpedienteResult;
import pe.gob.indecopi.result.ClsLemaResult;
import pe.gob.indecopi.result.ClsLogoResult;
import pe.gob.indecopi.result.ClsRenovacionChaBotResult;
import pe.gob.indecopi.util.ClsConfigFilePath;
import pe.gob.indecopi.util.ClsResultDAO;


@Service
public class ClsBusquedaService implements Serializable, ClsBusquedaServiceI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1945914613806716575L;
	
	
	private static Logger logger = LoggerFactory.getLogger(ClsBusquedaService.class);
	
	@Autowired
	private ClsBusquedaRepositoryI objConn;

	@Autowired
	private ClsResultDAO objResultDAO;
	
	@Autowired
	private ClsCMISServiceI objConnCMIS;
	
	@Autowired
	private ClsConfigFilePath configAlfr;
	
	
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
			//logger.info(e);
		}
		
		return objResult;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ClsLemaResult doLemaComercial(ClsFiltroLemaBean objFiltro) {

		ClsLemaResult objResult=new ClsLemaResult();
		try {

			objResultDAO=objConn.doLemaAsociado(objFiltro);
			
			objResult.setLstLema((List<ClsLemaBean>)objResultDAO.get("POUT_CUR_LEMAS"));
			


		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			//logger.info(e);
		}
		
		return objResult;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ClsLogoResult doLogo(ClsLogoFiltroBean objFiltro) {

		ClsLogoResult objResult=new ClsLogoResult();
		try {

			objResultDAO=objConn.doLogo(objFiltro);
			
			objResult.setVcNomLogo(objResultDAO.get("POUT_VC_LOGO")+"");
			
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			//logger.info(e);
		}
		
		return objResult;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ClsExpedienteResult doLstExpRelacionado(ClsFiltroExpRelBean objFiltro) {
		//logger.info("doConsultaTerminos(filro) => "+objFiltroTerminos.getVcUsuario());

		ClsExpedienteResult objResult=new ClsExpedienteResult();
		try {

			objResultDAO=objConn.doExpedienteRel(objFiltro);
			
			objResult.setLstExpediente((List<ClsRespuestaExpedienteBean>)objResultDAO.get("POUT_CUR_EXPEDIENTE"));
			
			for(int i=0; i<objResult.getLstExpediente().size(); i++) {
				
				ClsRespuestaExpedienteBean objExpediente=objResult.getLstExpediente().get(i);
				ClsFiltroExpAlfrascoBean objAlfresco= new ClsFiltroExpAlfrascoBean();
				
				objAlfresco.setVcIdExpediente(objExpediente.getVcIdExpediente());
				objAlfresco.setNuAnioExpediente(objExpediente.getNuAnioExpediente());
				objAlfresco.setVcAreaExpediente(objExpediente.getVcIdAreaExpediente());
				
				objResult.getLstExpediente().get(i).setLstResolucion(objConnCMIS.doConsultaCMIS(objAlfresco));
				
			}
			
			objResult.setNuError(new Long(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+"")));
			objResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));


		}catch(Exception e) {
			e.printStackTrace();
			//logger.info(e);
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
			
			logger.info(objResult.getLstExpediente().size()+"");
			
			for(int i=0; i<objResult.getLstExpediente().size(); i++) {
				
				ClsRespuestaExpedienteBean objExpediente=objResult.getLstExpediente().get(i);
				ClsFiltroExpAlfrascoBean objAlfresco= new ClsFiltroExpAlfrascoBean();
				
				objAlfresco.setVcIdExpediente(objExpediente.getVcIdExpediente());
				objAlfresco.setNuAnioExpediente(objExpediente.getNuAnioExpediente());
				objAlfresco.setVcAreaExpediente(objExpediente.getVcIdAreaExpediente());
				
				objResult.getLstExpediente().get(i).setLstResolucion(objConnCMIS.doConsultaCMIS(objAlfresco));
				
			}
			
			objResult.setNuError(new Long(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+"")));
			objResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));


		}catch(Exception e) {
			e.printStackTrace();
			//logger.info(e);
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
			//logger.info(e);
		}
		
		return objResult;
		
	}
	
	@Override
	public Resource getlogo(String nombreFoto) {
		Resource recurso=null;
		try {
		String string = nombreFoto;

		String[] parts = string.split("_");
		String ruta = "";
		
		for (int i=0;i<parts.length-1;i++) {
			ruta = ruta+parts[i]+"/";
		}  
		logger.info("Ruta logo: "+ruta);
		Path rutaArchivo = getPath(ruta,parts[parts.length-1]);
		 recurso = new UrlResource(rutaArchivo.toUri());
		if(!recurso.exists() && !recurso.isReadable()) {
			recurso = new ClassPathResource("no-usuario.png");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return recurso;
	}	
	
	@Override
	public Path getPath(String ruta,String nombreFoto) {
		
		return Paths.get(configAlfr.getVcRutaLogo()+ruta).resolve(nombreFoto).toAbsolutePath();
	}
	
	

}
