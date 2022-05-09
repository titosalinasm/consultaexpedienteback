package pe.gob.indecopi.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.OperationContext;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.OperationContextImpl;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpAlfrascoBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsResolucionBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpedienteBean;
import pe.gob.indecopi.repository.ClsAlfrescoRepository;
import pe.gob.indecopi.repository.ClsAlfrescoRepositoryI;

import pe.gob.indecopi.util.ClsConfigFilePath;
import pe.gob.indecopi.util.ClsUtil;

@Service
public class ClsCMISService implements ClsCMISServiceI, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1474243327713120046L;

	@Autowired
	private ClsAlfrescoRepositoryI connAlfresco;
	
	@Autowired
	private ClsConfigFilePath configAlfr;
	
	private static Logger logger = LoggerFactory.getLogger(ClsCMISService.class);

	public Session dosession() {
		
	//System.out.println(configAlfr.getVcRutacmis());
	Session session;
    SessionFactory sessionFactory = SessionFactoryImpl.newInstance();
    Map<String, String> parameter = new HashMap<String, String>();
    parameter.put(SessionParameter.USER, configAlfr.getVcUsuario());
    parameter.put(SessionParameter.PASSWORD, configAlfr.getVcClave());
    parameter.put(SessionParameter.ATOMPUB_URL, configAlfr.getVcRutacmis());
    parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
    Repository repository =sessionFactory.getRepositories(parameter).get(0);
  //  logger.debug("Conexión-->" + repository.getName());
    session = repository.createSession();
   
    return session;
    
	}
	 
	@Override
	public List<ClsResolucionBean> doConsultaCMIS(ClsFiltroExpAlfrascoBean objFiltro) {
		List<ClsResolucionBean> lstResolucion=new ArrayList<ClsResolucionBean>();
		
		Session session= dosession();
		ClsRespuestaExpedienteBean objDatos=new ClsRespuestaExpedienteBean();
		OperationContext oc = new OperationContextImpl();
	     
	     objDatos.setVcIdExpediente(objFiltro.getVcIdExpediente());
	     objDatos.setNuAnioExpediente(objFiltro.getNuAnioExpediente());
	     objDatos.setVcIdAreaExpediente(objFiltro.getVcAreaExpediente());

		String query=connAlfresco.doPreparaConsultaNormal(objDatos, session);
		
        ItemIterable<QueryResult> results = session.query(query, false, oc);
        
        logger.info("Consoltando expediente: "+objFiltro.getVcIdExpediente()+"-"+objFiltro.getNuAnioExpediente());
        
        for (QueryResult result : results) {
        	ClsResolucionBean objResolucion=new ClsResolucionBean();
        	objResolucion.setVcExpedienteResol(ClsUtil.PropertyValue(result, "indecopicm:expedientes").replace("¬",""));
        	objResolucion.setVcNroResol(ClsUtil.PropertyValue(result, "indecopicm:numero"));
        	objResolucion.setVcAnioResol(ClsUtil.PropertyValue(result, "indecopicm:anio"));
        	objResolucion.setVcMateria(ClsUtil.PropertyValue(result, "indecopicm:materiasumilla"));
        	objResolucion.setVcSeries(ClsUtil.PropertyValue(result, "cmis:versionSeriesId"));
        	objResolucion.setVcLinkDescarga(configAlfr.getVcLinkDescarga()+ClsUtil.PropertyValue(result, "cmis:versionSeriesId"));
        	
        	lstResolucion.add(objResolucion);

        }
		
		return lstResolucion;
	}
	
}
