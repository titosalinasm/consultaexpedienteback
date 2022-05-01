package pe.gob.indecopi.service;

import pe.gob.indecopi.bean.chatbot.ClsInputRegistroBean;
import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.chatbot.ClsRespuestaRegistroBean;
import pe.gob.indecopi.result.ClsRegistroResult;
import pe.gob.indecopi.result.ClsRenovacionChaBotResult;

public interface ClsChatBotServiceI {
	public ClsRenovacionChaBotResult dochatbotrenovacion(ClsInputRenovacionBean objFiltro);
	public ClsRegistroResult doRegistro(ClsInputRegistroBean objFiltro);
}
