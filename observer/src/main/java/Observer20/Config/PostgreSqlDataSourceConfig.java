
package Observer20.Config;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


@Configuration
  @EnableTransactionManagement
  @EnableJpaRepositories(
		  basePackages = "Observer20.repository",
  entityManagerFactoryRef = "entityManagerFactory",
  transactionManagerRef = "transactionManager") 
  public class PostgreSqlDataSourceConfig {
	  @Autowired
		Environment env;
	  @Primary
	  @Bean(name = "postgresdatasource")
	  public DataSource dataSource() {
	      DriverManagerDataSource ds = new DriverManagerDataSource();
	      ds.setUrl(env.getProperty("spring.datasource.url"));
	      ds.setUsername(env.getProperty("spring.datasource.username"));
	      ds.setPassword(env.getProperty("spring.datasource.password"));
	     //ds.setDriverClassName(env.getProperty("postgres.datasource.driver-class-name"));
	      ds.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
	      return ds;
	  }
		
		  @Primary
		  @Bean(name= "entityManagerFactory") 
		  public LocalContainerEntityManagerFactoryBean entityManager() {
		  LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean(); 
		  bean.setDataSource(dataSource());
		  HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		  bean.setJpaVendorAdapter(adapter); 
		  HashMap<String,Object> properties = new HashMap<String, Object>(); 
		  properties.put("hibernate.hbm2ddl.auto","update");
		  //properties.put("hibernate.ddl-auto", "update");
		  properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
		  bean.setJpaPropertyMap(properties); bean.setPackagesToScan("Observer20.Model");
		  return bean; }
		 
			 
		@Primary
		@Bean("transactionManager")
		public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory ) {
			return new JpaTransactionManager(entityManagerFactory);
		}
		
}
  
  