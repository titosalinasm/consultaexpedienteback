package pe.gob.indecopi.controller;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroConsCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroDetalleExpBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpAlfrascoBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroLemaBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsLogoFiltroBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpedienteBean;
import pe.gob.indecopi.service.ClsBusquedaServiceI;
import pe.gob.indecopi.service.ClsCMISService;
import pe.gob.indecopi.service.ClsCMISServiceI;
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
	
	@Autowired
	private ClsCMISServiceI connCemis;
	
	@RequestMapping(method = RequestMethod.POST, path = "/certificado", consumes = "application/json",  produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstCertificado(@RequestBody ClsFiltroConsCertBean objFiltro ) {
			logger.info("doLstCertificado()");
		return ResponseEntity.ok().body(objConnService.doLstCertificado(objFiltro));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/exprelacionado", consumes = "application/json",  produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstExpRelacionado(@RequestBody ClsFiltroExpRelBean objFiltro ) {
			logger.info("doLstExpRelacionado()");
		return ResponseEntity.ok().body(objConnService.doLstExpRelacionado(objFiltro));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/expediente", consumes = "application/json",  produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstExpediente(@RequestBody ClsFiltroExpedienteBean objFiltro ) {
			logger.info("doLstExpediente()");
		return ResponseEntity.ok().body(objConnService.doBuscarExpediente(objFiltro));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/detalleexpediente", consumes = "application/json",  produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstExpedienteDetalle(@RequestBody ClsFiltroDetalleExpBean objFiltro ) {
			logger.info("doLstExpedienteDetalle()");
		return ResponseEntity.ok().body(objConnService.doBuscarDetalleExpediente(objFiltro));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/pruebacemis", consumes = "application/json",  produces = "application/json")
	public @ResponseBody ResponseEntity<?> dopruebacmis(@RequestBody ClsFiltroExpAlfrascoBean objFiltro ) {
			logger.info("dopruebacmis()");
		return ResponseEntity.ok().body(connCemis.doConsultaCMIS(objFiltro));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/lema", consumes = "application/json",  produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLemaComercial(@RequestBody ClsFiltroLemaBean objFiltro ) {
			logger.info("doLemaComercial()");
		return ResponseEntity.ok().body(objConnService.doLemaComercial(objFiltro));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/nombrelogo", consumes = "application/json",  produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLogo(@RequestBody ClsLogoFiltroBean objFiltro ) {
			logger.info("doLogo()");
		return ResponseEntity.ok().body(objConnService.doLogo(objFiltro));
	}
	
	@GetMapping("/FileSystem/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> getFoto(@PathVariable String nombreFoto) {

		Resource recurso = null;
		
		try {
			//LOG.info("getlogo>>" + nombreFoto);
			recurso = objConnService.getlogo(nombreFoto);
			
		} catch (Exception e ) {
			e.printStackTrace();
		//	LOG.info("catch: :/");
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}

}
