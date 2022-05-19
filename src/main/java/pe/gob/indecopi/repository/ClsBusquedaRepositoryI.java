package pe.gob.indecopi.repository;

import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroConsCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroDetalleExpBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroLemaBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsLogoFiltroBean;
import pe.gob.indecopi.util.ClsResultDAO;

public interface ClsBusquedaRepositoryI {
	public ClsResultDAO doBuscarCertificado(ClsFiltroConsCertBean objFiltro);
	public ClsResultDAO doLemaAsociado(ClsFiltroLemaBean objFiltro);
	public ClsResultDAO doLogo(ClsLogoFiltroBean objFiltro);
	public ClsResultDAO doExpedienteRel(ClsFiltroExpRelBean objFiltro);
	public ClsResultDAO doBuscarExpediente(ClsFiltroExpedienteBean objFiltro);
	public ClsResultDAO doBuscarExpedienteDetalle(ClsFiltroDetalleExpBean objFiltro) ;
}
