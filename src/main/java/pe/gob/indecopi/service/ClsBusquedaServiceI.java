package pe.gob.indecopi.service;

import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroConsCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroDetalleExpBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpedienteBean;
import pe.gob.indecopi.result.ClsCertificadoResult;
import pe.gob.indecopi.result.ClsConfiguracionResult;
import pe.gob.indecopi.result.ClsDetalleExpResult;
import pe.gob.indecopi.result.ClsExpRelResult;
import pe.gob.indecopi.result.ClsExpedienteResult;
import pe.gob.indecopi.result.ClsRenovacionChaBotResult;

public interface ClsBusquedaServiceI {
	public ClsCertificadoResult doLstCertificado(ClsFiltroConsCertBean objFiltro);
	public ClsExpRelResult doLstExpRelacionado(ClsFiltroExpRelBean objFiltro);
	public ClsExpedienteResult doBuscarExpediente(ClsFiltroExpedienteBean objFiltro);
	public ClsDetalleExpResult doBuscarDetalleExpediente(ClsFiltroDetalleExpBean objFiltro);
}
