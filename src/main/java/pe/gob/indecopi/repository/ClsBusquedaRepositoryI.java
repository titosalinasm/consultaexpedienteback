package pe.gob.indecopi.repository;

import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroConsCertBean;
import pe.gob.indecopi.util.ClsResultDAO;

public interface ClsBusquedaRepositoryI {
	public ClsResultDAO doBuscarCertificado(ClsFiltroConsCertBean objFiltro);
}
