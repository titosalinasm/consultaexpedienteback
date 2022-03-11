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

import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroConsCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpRelBean;
import pe.gob.indecopi.service.ClsBusquedaServiceI;
import pe.gob.indecopi.service.ClsConfiguracionServiceI;


@CrossOrigin(origins ="*", allowedHeaders = "*", maxAge = 3600)

@RestController
@RequestMapping({"/busqueda"})
public class ClsBusquedaController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4137031170215308077L;

	private static Logger logger = LoggerFactory.getLogger(ClsBusquedaController.class);
	
	@Autowired
	private ClsBusquedaServiceI objConnService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/certificado", consumes = "application/json",  produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstCertificado(@RequestBody ClsFiltroConsCertBean objFiltro ) {
			logger.info("doLstCertificado()");
		return ResponseEntity.ok().body(objConnService.doLstCertificado(objFiltro));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/exprelacionado", consumes = "application/json",  produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstExpRelacionado(@RequestBody ClsFiltroExpRelBean objFiltro ) {
			logger.info("doLstCertificado()");
		return ResponseEntity.ok().body(objConnService.doLstExpRelacionado(objFiltro));
	}

}
