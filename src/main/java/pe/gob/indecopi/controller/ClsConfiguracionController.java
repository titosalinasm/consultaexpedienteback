package pe.gob.indecopi.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.indecopi.service.ClsConfiguracionServiceI;


@CrossOrigin(origins ="*", allowedHeaders = "*", maxAge = 3600)

@RestController
@RequestMapping({"/config"})
public class ClsConfiguracionController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4137031170215308077L;

	private static Logger logger = LoggerFactory.getLogger(ClsConfiguracionController.class);
	
	@Autowired
	private ClsConfiguracionServiceI objConConfig;
	
	@RequestMapping(method = RequestMethod.GET, path = "/general", produces = "application/json")
	public @ResponseBody ResponseEntity<?> doConfiguracion() {
			logger.info("doConfiguracion()");
		return ResponseEntity.ok().body(objConConfig.doConfiguracion());
	}

}
