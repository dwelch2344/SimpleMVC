package co.ntier.training.simplemvc.config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatastoreConfig {
	
	@SuppressWarnings("serial")
	private final Properties hibernateProperties = new Properties() {{
		put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		put("hibernate.hbm2ddl.auto", "update");
		put("hibernate.show_sql", true);
	}};

	@PersistenceContext
	private EntityManager em;
	
	@Bean
	public EntityManager entityManager(){
		return em;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("co.ntier.training.simplemvc.model");
		factory.setJpaProperties(hibernateProperties);
		factory.setPersistenceProvider(new HibernatePersistence());
		return factory;
	}
	
	@Bean
	public DataSource getHsqlDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
		ds.setUrl("jdbc:hsqldb:mem:.");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager mgr = new JpaTransactionManager(emf);
		mgr.afterPropertiesSet();
		return mgr;
	}
}
