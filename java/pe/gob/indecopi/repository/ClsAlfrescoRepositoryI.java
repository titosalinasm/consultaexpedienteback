package pe.gob.indecopi.repository;

import org.apache.chemistry.opencmis.client.api.Session;

import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpedienteBean;
import pe.gob.indecopi.util.ClsResultDAO;

public interface ClsAlfrescoRepositoryI {
	public String doPreparaConsultaNormal(ClsRespuestaExpedienteBean objFiltro, Session session);
}
