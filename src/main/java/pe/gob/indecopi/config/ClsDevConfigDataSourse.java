package pe.gob.indecopi.config;

import java.io.Serializable;

import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Profile({"dev"})
@Configuration
@EnableTransactionManagement
public class ClsDevConfigDataSourse implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	  private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	  @Value("${spring.datasource.usr_expcons.jndi-name}")
	  private String jndiName;
	  
	  
	  
	  @Primary
	  @Bean(destroyMethod="")
	  public DataSource dataSource()
	  {
	    DataSource dataSource = null;
	    JndiTemplate jndi = new JndiTemplate();
	    try
	    {
	      this.LOGGER.info("### jndiName " + this.jndiName);
	      dataSource = (DataSource)jndi.lookup(this.jndiName, DataSource.class);
	      this.LOGGER.info("### dataSource " + dataSource);
	    }
	    catch (NamingException e)
	    {
	      this.LOGGER.error(e.getMessage());
	    }
	    return dataSource;
	  }
	  
	  @Primary
	  @Bean(name={"transactionManager"})
	  public PlatformTransactionManager transactionManager(DataSource dataSource)
	  {
	    return new DataSourceTransactionManager(dataSource);
	  }
	 	  

}
