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
import pe.gob.indecopi.bean.consultaexpediente.ClsTipoSolicitudBean;
import pe.gob.indecopi.param.ClsConstantes;
import pe.gob.indecopi.util.ClsResultDAO;
import pe.gob.indecopi.util.ClsUtil;

@Repository
@Transactional
public class ClsConfiguracionRepository implements Serializable, ClsConfiguracionRepositoryI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3789470206482678434L;
	private static Logger logger = LoggerFactory.getLogger(ClsConfiguracionRepository.class);
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
	public ClsResultDAO doConfiguracion() {
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_USR_EXPCONS)
									.withCatalogName(ClsConstantes.PKG_GENERAL)
									.withProcedureName(ClsConstantes.SP_LST_LISTAS_GENERAL)
									.declareParameters(
									new  SqlOutParameter("PIN_CUR_TIPO_SOLICITUD", OracleTypes.CURSOR ,
									new RowMapper<ClsTipoSolicitudBean>() {

										@Override
										public ClsTipoSolicitudBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsTipoSolicitudBean objRespuesta=new ClsTipoSolicitudBean();
											objRespuesta.setVcCodigoSolicitud(rs.getString("VC_COD_LIST"));
											objRespuesta.setVcDescSolicitud(rs.getString("VC_DESC_LIST"));
								
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute();
			
			//response
			objResultDAO.put("PIN_CUR_TIPO_SOLICITUD", out.get("PIN_CUR_TIPO_SOLICITUD"));
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
