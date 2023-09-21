
  package Observer20.Config;
  
  
  
  import java.util.HashMap;

  import javax.persistence.EntityManagerFactory;
  import javax.sql.DataSource;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.beans.factory.annotation.Qualifier;
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.context.annotation.Primary;
  import org.springframework.core.env.Environment;
  import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
  import org.springframework.jdbc.datasource.DriverManagerDataSource;
  import org.springframework.orm.jpa.JpaTransactionManager;
  import org.springframework.orm.jpa.JpaVendorAdapter;
  import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
  import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
  import org.springframework.transaction.PlatformTransactionManager;
  import org.springframework.transaction.annotation.EnableTransactionManagement;

  @Configuration
  @EnableTransactionManagement
  @EnableJpaRepositories(
		  basePackages = {"Observer20.Repo1"},
  
				  entityManagerFactoryRef = "EntityManagerFactory",

  transactionManagerRef = "TransactionManager")
  public class SqlServerDataSourceConfig {
	  @Autowired
	  Environment env;
  
  @Primary
  
  @Bean(name = "sqldatasource")
  
  //@ConfigurationProperties(prefix = "spring.datasource") 
  public DataSource dataSource() 
  {
	  DriverManagerDataSource ds=new DriverManagerDataSource();
	  ds.setUrl(env.getProperty("sql.datasource.url"));
	  ds.setUsername(env.getProperty("sql.datasource.username"));
	  ds.setPassword(env.getProperty("sql.datasource.password"));
	  ds.setDriverClassName(env.getProperty("sql.datasource.driverClassName"));
	 // return DataSourceBuilder.create().build(); 
	  return ds;
	  }
  
  @Primary
  
  //@Bean(name = "DIST_AC_PRE1EntityManagerFactory") 
  @Bean(name = "EntityManagerFactory") 
  
  public LocalContainerEntityManagerFactoryBean entityManager() 
  {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);
		HashMap<String,Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.ddl-auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		bean.setJpaPropertyMap(properties);
		bean.setPackagesToScan("Observer20.Model1");
		return bean;
  }
  @Primary
	//@Bean("DIST_AC_PRE1TransactionManager")
  @Bean("TransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("EntityManagerFactory") EntityManagerFactory entityManagerFactory ) {
		return new JpaTransactionManager(entityManagerFactory);
	}
  }
	
  
  
 