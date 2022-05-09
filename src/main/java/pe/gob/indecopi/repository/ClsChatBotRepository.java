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
import pe.gob.indecopi.bean.chatbot.ClsInputRegistroBean;
import pe.gob.indecopi.bean.chatbot.ClsInputRenovacionBean;
import pe.gob.indecopi.bean.chatbot.ClsRespuestaRegistroBean;
import pe.gob.indecopi.bean.chatbot.ClsRespuestaRenovacionBean;
import pe.gob.indecopi.param.ClsConstantes;
import pe.gob.indecopi.util.ClsResultDAO;
import pe.gob.indecopi.util.ClsUtil;

@Repository
@Transactional
public class ClsChatBotRepository implements Serializable, ClsChatBotRepositoryI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3789470206482678434L;
	private static Logger logger = LoggerFactory.getLogger(ClsChatBotRepository.class);
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
	public ClsResultDAO dochatbotrenobacion(ClsInputRenovacionBean objFiltro) {
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_USR_EXPCONS)
									.withCatalogName(ClsConstantes.PKG_CHATBOT)
									.withProcedureName(ClsConstantes.SP_GET_RENO_MARCAS)
									.declareParameters(
									new  SqlOutParameter("POUT_CUR_RENOVACION", OracleTypes.CURSOR ,
									new RowMapper<ClsRespuestaRenovacionBean>() {

										@Override
										public ClsRespuestaRenovacionBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsRespuestaRenovacionBean objRespuesta=new ClsRespuestaRenovacionBean();
											objRespuesta.setVcTexto1(rs.getString("VC_TEXTO1"));
											objRespuesta.setVcTexto2(rs.getString("VC_TEXTO2"));
								
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			//param
			Map<String, Object> inParamMap = new HashMap();
			inParamMap.put("PIN_VC_EXPEDIENTE", objFiltro.getVcNroExpediente());
			inParamMap.put("PIN_VC_DOC_IDENTIDAD", objFiltro.getVcNroDocumento());
			inParamMap.put("PIN_VC_NOMBRES", objFiltro.getVcNombresRazonSocial());
			logger.info(objFiltro.getVcNroDocumento());
			
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_RENOVACION", out.get("POUT_CUR_RENOVACION"));
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
	public ClsResultDAO dochatbotmarcas(ClsInputRegistroBean objFiltro) {
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_USR_EXPCONS)
									.withCatalogName(ClsConstantes.PKG_CHATBOT)
									.withProcedureName(ClsConstantes.SP_GET_REG_MARCAS)
									.declareParameters(
									new  SqlOutParameter("POUT_CUR_REG", OracleTypes.CURSOR ,
									new RowMapper<ClsRespuestaRegistroBean>() {

										@Override
										public ClsRespuestaRegistroBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsRespuestaRegistroBean objRespuesta=new ClsRespuestaRegistroBean();
											objRespuesta.setVcExpediente(rs.getString("VC_EXPEDIENTE"));
											objRespuesta.setVcTipoSolicitud(rs.getString("VC_TIPO_SOLICITUD"));
											objRespuesta.setVcTipoSigno(rs.getString("VC_TIPO_SIGNO"));
											objRespuesta.setVcSegundoNivel(rs.getString("vc_segundo_nivel"));
								
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			//param
			Map<String, Object> inParamMap = new HashMap();
			inParamMap.put("PIN_VC_NRO_DOC", objFiltro.getVcNroDoc());
			inParamMap.put("PIN_VC_NOMBRE", objFiltro.getVcNombresRazonSocial());
			inParamMap.put("PIN_NU_ANIO", objFiltro.getNuAnio());
			
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_REG", out.get("POUT_CUR_REG"));
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
