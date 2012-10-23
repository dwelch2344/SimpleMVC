package co.ntier.training.simplemvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
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

	@Bean
	public LocalContainerEntityManagerFactoryBean emf(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("co.ntier.training.simplemvc.model");
		factory.setJpaProperties(hibernateProperties());
		factory.setPersistenceProvider(new HibernatePersistence());
		return factory;
	}
	
//	@Bean
//	public EntityManager em(EntityManagerFactory emf) {
//		return emf.createEntityManager();
//	}
//
//	@Bean
//	public EntityManagerFactory emf(DataSource dataSource) {
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		factory.setDataSource(dataSource);
//		factory.setPackagesToScan("co.ntier.training.simplemvc.model");
//		factory.setJpaProperties(hibernateProperties());
//		factory.setPersistenceProvider(new HibernatePersistence());
//
//		factory.afterPropertiesSet();
//		return factory.getObject();
//	}

	// @Bean
	// public SessionFactory localSessionFactoryBean(DataSource datasource) {
	// LocalSessionFactoryBuilder factory = new
	// LocalSessionFactoryBuilder(datasource);
	// factory.scanPackages("co.ntier.training.simplemvc.model");
	// factory.setProperties(hibernateProperties());
	// return factory.buildSessionFactory();
	// }

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
	
	final Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;

			{
				put("hibernate.connection.url", "jdbc:hsqldb:mem:.");
				put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
				put("hibernate.hbm2ddl.auto", "update");
				put("hibernate.show_sql", true);
				put("hibernate.connection.pool_size", 2);
				put("hibernate.connection.provider_class",
						"org.hibernate.connection.DriverManagerConnectionProvider");
			}
		};
	}
}
