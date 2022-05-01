package pe.gob.indecopi.repository;

import pe.gob.indecopi.bean.chatbot.ClsInputRegistroBean;
import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.util.ClsResultDAO;

public interface ClsChatBotRepositoryI {
	public ClsResultDAO dochatbotrenobacion(ClsInputRenovacionBean objFiltro);
	public ClsResultDAO dochatbotmarcas(ClsInputRegistroBean objFiltro) ;
}
