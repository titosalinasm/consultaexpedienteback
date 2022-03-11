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
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroConsCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsFiltroExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaCertBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsRespuestaExpRelBean;
import pe.gob.indecopi.bean.consultaexpediente.ClsTipoSolicitudBean;
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
									new  SqlOutParameter("POUT_CUR_CERTIFICADO", OracleTypes.CURSOR ,
									new RowMapper<ClsRespuestaCertBean>() {

										@Override
										public ClsRespuestaCertBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsRespuestaCertBean objRespuesta=new ClsRespuestaCertBean();
											objRespuesta.setVcNroCertificado(rs.getString("NRO_CERTIFICADO"));
											objRespuesta.setVcDenominacion(rs.getString("DENOMINACION"));
											objRespuesta.setVcTipoSolicitud(rs.getString("TIPO_SOLICITUD"));
											objRespuesta.setVcTipoSigno(rs.getString("TIPO_PRESENTACION"));
											objRespuesta.setVcClases(rs.getString("VC_CLASES"));
											objRespuesta.setVcTitulares(rs.getString("VC_TITULARES"));
											objRespuesta.setVcEstado(rs.getString("VC_ESTADO"));
											objRespuesta.setVcDescEstado(rs.getString("VC_DESC_ESTADO"));
											objRespuesta.setVcCertOrigenDiv(rs.getString("VC_CERT_ORI_DIV"));
											objRespuesta.setVcCertRelDiv(rs.getString("VC_CER_REL_DIV"));
											objRespuesta.setNuFlagPeriodoRen(rs.getInt("NU_PER_RENOVACION"));
											objRespuesta.setNuAnioRegistro(rs.getInt("ANIO_REGISTRO"));
											objRespuesta.setVcLogo(rs.getString("VC_LOGO"));
											
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
	public ClsResultDAO doExpedienteRel(ClsFiltroExpRelBean objFiltro) {
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_USR_EXPCONS)
									.withCatalogName(ClsConstantes.PKG_CONSULTA_EXPEDIENTE)
									.withProcedureName(ClsConstantes.SP_LST_EXPEDIENTE_RELA)
									.declareParameters(
									new  SqlOutParameter("POUT_CUR_EXPEDIENTE", OracleTypes.CURSOR ,
									new RowMapper<ClsRespuestaExpRelBean>() {

										@Override
										public ClsRespuestaExpRelBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsRespuestaExpRelBean objRespuesta=new ClsRespuestaExpRelBean();
											objRespuesta.setVcIdExpediente(rs.getString("ID_EXPEDIENTE"));
											objRespuesta.setNuAnioExpediente(rs.getInt("ANIO_EXPEDIENTE"));
											objRespuesta.setVcTipoExpediente(rs.getString("TIPO_EXPEDIENTE"));
											objRespuesta.setVcFechaPresentacion(rs.getString("FECHA_PRESENTACION"));
											objRespuesta.setVcClase(rs.getString("ID_CLASE"));
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
	
}
