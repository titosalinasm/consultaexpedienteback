package pe.gob.indecopi.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.indecopi.bean.chatbot.ClsInputRegistroBean;
import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.chatbot.ClsRespuestaRegistroBean;
import pe.gob.indecopi.result.ClsRenovacionChaBotResult;
import pe.gob.indecopi.service.ClsChatBotServiceI;


@CrossOrigin(origins ="*", allowedHeaders = "*", maxAge = 3600)

@RestController
@RequestMapping({"/chatbot"})
public class ClsChatBotController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4137031170215308077L;

	private static Logger logger = LoggerFactory.getLogger(ClsChatBotController.class);
	
	@Autowired
	private ClsChatBotServiceI objConnchatbot;
	
	@RequestMapping(method = RequestMethod.POST, path = "/chatbotDetalleExpediente", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<?> dochatbotrenovacion(@RequestBody ClsInputRenovacionBean objFiltro) {
			logger.info("doConfiguracion()");
		return ResponseEntity.ok().body(objConnchatbot.dochatbotrenovacion(objFiltro)) ;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/chatbotListarExpedientes", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<?> dochatbotregisotro(@RequestBody ClsInputRegistroBean objFiltro) {
		return ResponseEntity.ok().body(objConnchatbot.doRegistro(objFiltro)) ;
	}

}
