package pe.gob.indecopi.repository;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import oracle.jdbc.OracleTypes;
import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.chatbot.ClsRespuestaRenovacionBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsDetalleExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroConsCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroDetalleExpBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroLemaBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsLemaBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsLogoFiltroBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpedienteBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsSeguimientoBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsTipoSolicitudBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsTitularesBean;
import pe.gob.indecopi.param.ClsConstantes;
import pe.gob.indecopi.util.ClsResultDAO;
import pe.gob.indecopi.util.ClsUtil;

@Repository
@Transactional
public class ClsBusquedaRepository implements Serializable, ClsBusquedaRepositoryI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3789470206482678434L;
	private static Logger logger = LoggerFactory.getLogger(ClsBusquedaRepository.class);
	private SimpleJdbcCall simpleJdbcCall;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//DataSouser incio multiple
	  @Autowired
	  private DataSource dataSource;
	  
	  @PostConstruct
	  private void init()
	  {
	    this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	  }
	//DataSouser fin multiple
	
	@Autowired
	private ClsResultDAO objResultDAO;
	
	@Override
	public ClsResultDAO doBuscarCertificado(ClsFiltroConsCertBean objFiltro) {
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_USR_EXPCONS)
									.withCatalogName(ClsConstantes.PKG_CONSULTA_EXPEDIENTE)
									.withProcedureName(ClsConstantes.SP_LST_CONSUL_POR_CERTIFICADO)
									.declareParameters(
									new  SqlParameter("PIN_VC_CERTIFICADO", OracleTypes.VARCHAR ,"VARCHAR2"),
									new  SqlParameter("PIN_VC_TIPO_SOLICITUD", OracleTypes.VARCHAR ,"VARCHAR2"),
									new  SqlOutParameter("POUT_CUR_CERTIFICADO", OracleTypes.CURSOR ,
									new RowMapper<ClsRespuestaCertBean>() {

										@Override
										public ClsRespuestaCertBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsRespuestaCertBean objRespuesta=new ClsRespuestaCertBean();
											//objRespuesta.setNuIdRegistro(rs.getInt("ID_REGISTRO"));
											objRespuesta.setNuAnioRegistro(rs.getInt("ANIO_REGISTRO"));
											//objRespuesta.setVcIdAreaRegistro(rs.getString("ID_AREA_REGISTRO"));
											//objRespuesta.setVcLogo(rs.getString("VC_LOGO"));
											
											objRespuesta.setVcNroCertificado(rs.getString("NRO_CERTIFICADO"));
											objRespuesta.setVcDenominacion(rs.getString("DENOMINACION"));
											objRespuesta.setVcTipoSolicitud(rs.getString("TIPO_SOLICITUD"));
											objRespuesta.setVcTipoSigno(rs.getString("TIPO_PRESENTACION"));
											objRespuesta.setVcClases(rs.getString("VC_CLASES"));
											objRespuesta.setVcTitulares(rs.getString("VC_TITULARES"));
											objRespuesta.setVcEstado(rs.getString("VC_ESTADO"));
											objRespuesta.setVcDescEstado(rs.getString("VC_DESC_ESTADO"));
											objRespuesta.setVcDivRecla(rs.getString("VC_DIVICION_RECLA"));
											objRespuesta.setNuFlagPeriodoRen(rs.getInt("NU_PER_RENOVACION"));
											objRespuesta.setVcIdTipoSolicitud(rs.getString("VC_ID_TIPO_SOL"));
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			
			Map<String, Object> inParamMap = new HashMap();

			inParamMap.put("PIN_VC_CERTIFICADO", objFiltro.getVcNroCertificado());
			inParamMap.put("PIN_VC_TIPO_SOLICITUD", objFiltro.getVcTipoSolicitud());
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_CERTIFICADO", out.get("POUT_CUR_CERTIFICADO"));
			objResultDAO.put("POUT_NU_ERROR", out.get("POUT_NU_ERROR"));
			objResultDAO.put("POUT_VC_ERROR", out.get("POUT_VC_ERROR"));
											    		
			
		}catch(Exception e) {
			System.out.println(e);
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		
		return objResultDAO;
	}
	
	@Override
	public ClsResultDAO doLemaAsociado(ClsFiltroLemaBean objFiltro) {
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_USR_EXPCONS)
									.withCatalogName(ClsConstantes.PKG_CONSULTA_EXPEDIENTE)
									.withProcedureName(ClsConstantes.SP_LST_LEMAS)
									.declareParameters(
											new  SqlParameter("PIN_VC_NRO_CERTIFICADO", OracleTypes.VARCHAR ,"VARCHAR2"),
											new  SqlParameter("PIN_NU_ANIO_REGISTRO", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_CUR_LEMAS", OracleTypes.CURSOR ,
									new RowMapper<ClsLemaBean>() {
										@Override
										public ClsLemaBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsLemaBean objRespuesta=new ClsLemaBean();
											objRespuesta.setVcIdClase(rs.getString("ID_CLASE"));
											objRespuesta.setVcNroCertificado(rs.getString("NRO_CERTIFICADO"));
											objRespuesta.setVcFechaExpiracion(rs.getString("FECHA_EXPIRACION"));
											objRespuesta.setVcFrase(rs.getString("FRASE"));
											objRespuesta.setVcVigencia(rs.getString("vigencia"));
											return objRespuesta;
										}
									})
									);
			
			Map<String, Object> inParamMap = new HashMap();
			
			inParamMap.put("PIN_VC_NRO_CERTIFICADO", objFiltro.getVcNroCertificado());
			inParamMap.put("PIN_NU_ANIO_REGISTRO", objFiltro.getNuAnioRegistro());
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_LEMAS", out.get("POUT_CUR_LEMAS"));
											    		
			
		}catch(Exception e) {
			System.out.println(e);
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		
		return objResultDAO;
	}
	
	@Override
	public ClsResultDAO doLogo(ClsLogoFiltroBean objFiltro) {
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_USR_EXPCONS)
									.withCatalogName(ClsConstantes.PKG_CONSULTA_EXPEDIENTE)
									.withProcedureName(ClsConstantes.SP_GET_FORM_RUTA_IMA)
									.declareParameters(
									new  SqlOutParameter("POUT_VC_LOGO", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			
			Map<String, Object> inParamMap = new HashMap();
			inParamMap.put("PIN_VC_NRO_CERTIFICADO", objFiltro.getVcNroCertificado());
			inParamMap.put("PIN_NU_ANIO_REGISTRO", objFiltro.getNuAnioRegistro());
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_VC_LOGO", out.get("POUT_VC_LOGO"));
											    		
			
		}catch(Exception e) {
			System.out.println(e);
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		
		return objResultDAO;
	}
	
	@Override
	public ClsResultDAO doExpedienteRel(ClsFiltroExpRelBean objFiltro) {
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_USR_EXPCONS)
									.withCatalogName(ClsConstantes.PKG_CONSULTA_EXPEDIENTE)
									.withProcedureName(ClsConstantes.SP_LST_EXPEDIENTE_RELA)
									.declareParameters(
											new  SqlParameter("PIN_VC_CERTIFICADO", OracleTypes.VARCHAR ,"VARCHAR2"),
											new  SqlParameter("PIN_NU_ANIO", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_CUR_EXPEDIENTE", OracleTypes.CURSOR ,
									new RowMapper<ClsRespuestaExpedienteBean>() {

										@Override
										public ClsRespuestaExpedienteBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsRespuestaExpedienteBean objRespuesta=new ClsRespuestaExpedienteBean();
											objRespuesta.setVcIdExpediente(rs.getString("ID_EXPEDIENTE"));
											objRespuesta.setNuAnioExpediente(rs.getInt("ANIO_EXPEDIENTE"));
											objRespuesta.setVcIdAreaExpediente(rs.getString("ID_AREA"));
											objRespuesta.setVcTipoExpediente(rs.getString("TIPO_EXPEDIENTE"));
											objRespuesta.setVcIdTipoExpediente(rs.getString("ID_TIPO_EXPEDIENTE"));
											objRespuesta.setVcFechaPresentacion(rs.getString("FECHA_PRESENTACION"));
											objRespuesta.setVcClase(rs.getString("ID_CLASE"));
											objRespuesta.setVcMarca(rs.getString("VC_MARCA"));
											objRespuesta.setNuProcedimiento(rs.getInt("NU_PROCEDIMIENTO"));
											objRespuesta.setVcProcedimiento(rs.getString("VC_PROCEDIMIENTO"));
											//objRespuesta.setNuEstado(rs.getInt("NU_ESTADO"));
											//objRespuesta.setVcSentidoResolucion((rs.getString("VC_SENTIDO")));
											logger.info("VC_ESTADO_EXPEDIENTE: "+rs.getString("VC_ESTADO_EXPEDIENTE"));
											if(rs.getString("VC_ESTADO_EXPEDIENTE")!=null) {
											objRespuesta.setVcLogoHito((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[0]);
											objRespuesta.setVcLogoEstado((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[1]);
											objRespuesta.setVcLink((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[2]);
											objRespuesta.setVcDescEstado((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[3]);
											objRespuesta.setVcFechaPublicacion((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[4]);
											objRespuesta.setVcSentidoResolucion((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[5]);
											}
											
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			
			Map<String, Object> inParamMap = new HashMap();

			inParamMap.put("PIN_VC_CERTIFICADO", objFiltro.getVcNroCertificado());
			inParamMap.put("PIN_NU_ANIO", objFiltro.getNuAnioRegistro());
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_EXPEDIENTE", out.get("POUT_CUR_EXPEDIENTE"));
			objResultDAO.put("POUT_NU_ERROR", out.get("POUT_NU_ERROR"));
			objResultDAO.put("POUT_VC_ERROR", out.get("POUT_VC_ERROR"));
											    		
			
		}catch(Exception e) {
			System.out.println(e);
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		
		return objResultDAO;
	}
	
	@Override
	public ClsResultDAO doBuscarExpediente(ClsFiltroExpedienteBean objFiltro) {
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_USR_EXPCONS)
									.withCatalogName(ClsConstantes.PKG_CONSULTA_EXPEDIENTE)
									.withProcedureName(ClsConstantes.SP_LST_CONSUL_POR_EXPEDIENTE)
									.declareParameters(
									new  SqlParameter("PIN_VC_EXPEDIENTE", OracleTypes.VARCHAR ,"VARCHAR2"),
									new  SqlParameter("PIN_NU_ANIO_EXPEDIENTE", OracleTypes.NUMBER ,"NUMBER"),	
									new  SqlOutParameter("POUT_CUR_EXPEDIENTE", OracleTypes.CURSOR ,
									new RowMapper<ClsRespuestaExpedienteBean>() {

										@Override
										public ClsRespuestaExpedienteBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsRespuestaExpedienteBean objRespuesta=new ClsRespuestaExpedienteBean();
											objRespuesta.setVcIdExpediente(rs.getString("ID_EXPEDIENTE"));
											objRespuesta.setNuAnioExpediente(rs.getInt("ANIO_EXPEDIENTE"));
											objRespuesta.setVcIdAreaExpediente(rs.getString("ID_AREA"));
											objRespuesta.setVcTipoExpediente(rs.getString("TIPO_EXPEDIENTE"));
											objRespuesta.setVcIdTipoExpediente(rs.getString("ID_TIPO_EXPEDIENTE"));
											objRespuesta.setVcFechaPresentacion(rs.getString("FECHA_PRESENTACION"));
											objRespuesta.setVcClase(rs.getString("ID_CLASE"));
											objRespuesta.setVcMarca(rs.getString("VC_MARCA"));
											objRespuesta.setNuProcedimiento(rs.getInt("NU_PROCEDIMIENTO"));
											objRespuesta.setVcProcedimiento(rs.getString("VC_PROCEDIMIENTO"));
											//objRespuesta.setNuEstado(rs.getInt("NU_ESTADO"));
											//objRespuesta.setVcSentidoResolucion((rs.getString("VC_SENTIDO")));
											logger.info("VC_ESTADO_EXPEDIENTE: "+rs.getString("VC_ESTADO_EXPEDIENTE"));
											if(rs.getString("VC_ESTADO_EXPEDIENTE")!=null) {
											objRespuesta.setVcLogoHito((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[0]);
											objRespuesta.setVcLogoEstado((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[1]);
											objRespuesta.setVcLink((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[2]);
											objRespuesta.setVcDescEstado((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[3]);
											objRespuesta.setVcFechaPublicacion((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[4]);
											objRespuesta.setVcSentidoResolucion((rs.getString("VC_ESTADO_EXPEDIENTE")).split("=")[5]);
											}
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			
			Map<String, Object> inParamMap = new HashMap();
			inParamMap.put("PIN_VC_EXPEDIENTE", objFiltro.getVcNroExpediente());
			inParamMap.put("PIN_NU_ANIO_EXPEDIENTE", objFiltro.getNuAnioExpediente());
			logger.info("EXPEDIENTE: "+objFiltro.getVcNroExpediente());
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_EXPEDIENTE", out.get("POUT_CUR_EXPEDIENTE"));
			objResultDAO.put("POUT_NU_ERROR", out.get("POUT_NU_ERROR"));
			objResultDAO.put("POUT_VC_ERROR", out.get("POUT_VC_ERROR"));
											    		
			
		}catch(Exception e) {
			System.out.println(e);
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		
		return objResultDAO;
	}

	@Override
	public ClsResultDAO doBuscarExpedienteDetalle(ClsFiltroDetalleExpBean objFiltro) {
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_USR_EXPCONS)
									.withCatalogName(ClsConstantes.PKG_CONSULTA_EXPEDIENTE)
									.withProcedureName(ClsConstantes.SP_LST_DETALLE_EXPEDIENTE)
									.declareParameters(
											new  SqlParameter("PIN_VC_ID_EXPEDIENTE", OracleTypes.VARCHAR ,"VARCHAR2"),
											new  SqlParameter("PIN_NU_ANIO_EXPEDIENTE", OracleTypes.NUMBER ,"NUMBER"),
											new  SqlParameter("PIN_VC_ID_AREA", OracleTypes.VARCHAR ,"VARCHAR2"),
											new  SqlParameter("PIN_VC_ID_TIPO_EXP", OracleTypes.VARCHAR ,"VARCHAR2"),
									new  SqlOutParameter("POUT_CUR_DATOS_EXP", OracleTypes.CURSOR ,
									new RowMapper<ClsDetalleExpedienteBean>() {

										@Override
										public ClsDetalleExpedienteBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsDetalleExpedienteBean objRespuesta=new ClsDetalleExpedienteBean();
											objRespuesta.setNuAnioExpediente(rs.getInt("NU_ANIO_EXPEDIENTE"));
											objRespuesta.setVcIdAreaExpediente(rs.getString("VC_ID_AREA_EXPEDIENTE"));
											objRespuesta.setVcIdExpediente(rs.getString("VC_ID_EXPEDIENTE"));
											objRespuesta.setVcIdTipoExpediente(rs.getString("VC_ID_TIPO_EXPEDIENTE"));
											objRespuesta.setVcIdTipExpediente(rs.getString("ID_TIPO_EXPEDIENTE"));
											objRespuesta.setVcFechPresentacion(rs.getString("VC_FECH_PRESENTACION"));
											objRespuesta.setVcHoraPresentacion(rs.getString("VC_HORA_PRESENTACION"));
											objRespuesta.setVcLugar(rs.getString("VC_LUGAR"));
											objRespuesta.setVcProd(rs.getString("VC_PROD"));
											objRespuesta.setVcFechaAcumulacion(rs.getString("VC_FECHAACUMULACION"));
											objRespuesta.setVcTipoAcumulacion(rs.getString("VC_TIPOACUMULACION"));
											objRespuesta.setVcAcumuladoA(rs.getString("VC_ACUMULADOA"));
											objRespuesta.setVcTipoActo(rs.getString("TIPO_ACTO_MODIFICATORIO"));
											
											objRespuesta.setVcTipoSolicitud(rs.getString("VC_TIPOSOLICITUD"));
											objRespuesta.setVcFechaSolicitud(rs.getString("VC_FECHASOLICITUD"));
											objRespuesta.setVcFechaRegistro(rs.getString("VC_FECHAREGISTRO"));
											objRespuesta.setVcNroCertificado(rs.getString("VC_NROCERTIFICADO"));
											objRespuesta.setVcFechaPublicacion(rs.getString("VC_FECHAPUBLICACION"));
											objRespuesta.setVcFechaVencimiento(rs.getString("VC_FECHAVENCIMIENTO"));
											objRespuesta.setVcTipoPresentacion(rs.getString("VC_TIPOPRESENTACION"));
											objRespuesta.setVcClaseNiza(rs.getString("VC_CLASENIZA"));
											objRespuesta.setVcDenominacion(rs.getString("VC_DENOMINACION"));
											objRespuesta.setVcProductos(rs.getString("VC_PRODUCTOS"));
											
											objRespuesta.setVcFechaConclusion(rs.getString("VC_FECHACONCLUSION"));
											objRespuesta.setVcFormaConclusion(rs.getString("VC_FORMACONCLUSION"));
											objRespuesta.setVcTipoFormaConclusion(rs.getString("VC_TIPOFORMACONCLUSION"));
											objRespuesta.setVcNroResolucion(rs.getString("VC_NRORESOLUCION"));
											
											
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_CUR_TITULARES", OracleTypes.CURSOR ,
											new RowMapper<ClsTitularesBean>() {

												@Override
												public ClsTitularesBean mapRow(ResultSet rs, int rowNum)
														throws SQLException {
													ClsTitularesBean objRespuesta=new ClsTitularesBean();
													objRespuesta.setVcIdPersona(rs.getString("ID_PERSONA"));
													objRespuesta.setVcIdRepresentado(rs.getString("ID_REPRESENTADO"));
													objRespuesta.setVcTipoPersona(rs.getString("VC_TIPO_PERSONA"));
													objRespuesta.setVcPersona(rs.getString("VC_PERSONA"));
													objRespuesta.setVcTipoDocumento(rs.getString("VC_TIPO_DOCUMENTO"));
													objRespuesta.setVcDocumento(rs.getString("VC_DOCUMENTO"));
													objRespuesta.setVcDomicilioProcesal(rs.getString("VC_DOMICILIO_PROCESAL"));
													objRespuesta.setVcDomicilioPersonal(rs.getString("VC_DOMICILIO_PERSONAL"));
													
													
													return objRespuesta;
												}
											}),
									new  SqlOutParameter("POUT_CUR_SEGUIMIENTO", OracleTypes.CURSOR ,
											new RowMapper<ClsSeguimientoBean>() {

												@Override
												public ClsSeguimientoBean mapRow(ResultSet rs, int rowNum)
														throws SQLException {
													ClsSeguimientoBean objRespuesta=new ClsSeguimientoBean();
													objRespuesta.setVcFechaSeguimiento(rs.getString("VC_FECHA_ACCION"));
													objRespuesta.setVcSeguimiento(rs.getString("VC_ACCION"));
													objRespuesta.setVcInformativo(rs.getString("VC_INFORMATIVO"));
													
													return objRespuesta;
												}
											}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			
			Map<String, Object> inParamMap = new HashMap();
			

			
			inParamMap.put("PIN_VC_ID_EXPEDIENTE", objFiltro.getVcIdExpediente());
			inParamMap.put("PIN_NU_ANIO_EXPEDIENTE", objFiltro.getNuAnioExpediente());
			inParamMap.put("PIN_VC_ID_AREA", objFiltro.getVcIdAreaExpediente());
			inParamMap.put("PIN_VC_ID_TIPO_EXP", objFiltro.getVcIdTipoExpediente());
			
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_DATOS_EXP", out.get("POUT_CUR_DATOS_EXP"));
			objResultDAO.put("POUT_CUR_TITULARES", out.get("POUT_CUR_TITULARES"));
			objResultDAO.put("POUT_CUR_SEGUIMIENTO", out.get("POUT_CUR_SEGUIMIENTO"));
			
			objResultDAO.put("POUT_NU_ERROR", out.get("POUT_NU_ERROR"));
			objResultDAO.put("POUT_VC_ERROR", out.get("POUT_VC_ERROR"));
											    		
			
		}catch(Exception e) {
			System.out.println(e);
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		
		return objResultDAO;
	}
	
}
