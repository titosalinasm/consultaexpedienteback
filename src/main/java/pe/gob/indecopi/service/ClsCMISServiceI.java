package pe.gob.indecopi.service;

import java.util.List;

import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpAlfrascoBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsResolucionBean;

public interface ClsCMISServiceI {
	public List<ClsResolucionBean> doConsultaCMIS(ClsFiltroExpAlfrascoBean objFiltro);
}
