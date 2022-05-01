package pe.gob.indecopi.repository;

import java.io.Serializable;

import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpedienteBean;
import pe.gob.indecopi.util.ClsConfigFilePath;
import pe.gob.indecopi.util.ClsResultDAO;

@Repository
public class ClsAlfrescoRepository implements ClsAlfrescoRepositoryI, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1189135245979992213L;
	
	@Autowired
	private ClsResultDAO objResultDAO;
	
	@Autowired
	private ClsConfigFilePath configAlfr;
	private static Logger logger = LoggerFactory.getLogger(ClsAlfrescoRepository.class);
	
	@Override
	public String doPreparaConsultaNormal(ClsRespuestaExpedienteBean objFiltro, Session session) {
		logger.info("doPreparaConsultaNormal()");
	    String result = "";
	try {	
	
	    String qSelect = "SELECT F.indecopicm:numero as numero, F.indecopicm:anio as anio, F.indecopicm:siglas as siglas, F.indecopicm:expedientes as expedientes, F.indecopicm:materiasumilla as materiasumilla, F.indecopicm:partes as partes,F.indecopicm:fecha, cmis:versionSeriesId as fecha FROM indecopicm:documentoResolucion F ";
	    
	    String qWhereBase = " WHERE ";
	    String qWhere = "";
	      
	      String validaciones = "";
	      
	      validaciones = validaciones + "  F.indecopicm:expedientes = '" + "000000".substring(objFiltro.getVcIdExpediente().length()) + objFiltro.getVcIdExpediente() + "-" + objFiltro.getNuAnioExpediente()+"/DSD¬'";
	      validaciones = validaciones + " OR F.indecopicm:expedientes = '" + "000000".substring(objFiltro.getVcIdExpediente().length()) + objFiltro.getVcIdExpediente() + "-" + objFiltro.getNuAnioExpediente()+"/CSD¬'";
	      validaciones = validaciones + " OR F.indecopicm:expedientes = '" + "000000".substring(objFiltro.getVcIdExpediente().length()) + objFiltro.getVcIdExpediente() + "-" + objFiltro.getNuAnioExpediente()+"/OSD¬'";
	      
	     // validaciones = validaciones+" AND F.indecopicm:siglas= '"+"DSD'";
	      
	      String vcOrderBy = " ORDER BY F.indecopicm:numero ASC ";
	      
	      result = qSelect  + qWhereBase + qWhere;
	      
	      result = result  + validaciones + vcOrderBy;
	 
	      
	      System.out.println(result);

	     // System.out.println("pausa");
	      
//	    }
		
	}catch(Exception e) {
		e.printStackTrace();
		return result;
	}
	
		return result;
	}
	
	
    public String vcWhereFolder(String ruta, Session session) {
        try {
            Folder folder = (Folder) session.getObjectByPath(ruta);
            if (folder != null)
                return " IN_TREE('" + folder.getId() + "') ";
            else
        return null;

        } catch (Exception e) {
            return null;
    }


    }

}
