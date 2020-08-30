package proj.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("proj")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement // allow Spring to use HibernateTransactionManager transactionManager()
// required for Transactions
/* DI - Dependency Injection */
public class SpringConfig {
	/* REMINDERS */
	/*
	 * Annotating a class with the @Configuration indicates that the class can be
	 * used by the Spring IoC container as a source of bean definitions. 
	 * The @Bean annotation tells Spring that a method annotated with @Bean will return an
	 * object that should be registered as a bean in the Spring application context
	 */
	
	/* A Java Bean is simply a Java class that adheres to certain coding conventions */
	
	/*
	 * A Spring bean is basically an object managed by Spring. More specifically, it
	 * is an object that is instantiated, configured and otherwise managed by a Spring Framework container
	 */
	@Autowired
	private Environment env; // Spring gets an instance using DI(Reflections)

	@Bean // Spring bean not Java bean
	public DataSource getDataSource() {
		String url = env.getRequiredProperty("db.url");
		String username = env.getRequiredProperty("db.username");
		String password = env.getRequiredProperty("db.password");
		String driver = env.getRequiredProperty("db.driver");
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}

	@Bean("LocalSesh") // Spring bean not Java bean
	public LocalSessionFactoryBean getLocalSessionFactory() {
		// handles connections and executes SQL commands like JDBCTemplate
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setPackagesToScan("proj");
		Properties hibernateProperties = new Properties(); // create XML file with Hibernate Properties
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update"); // define Hibernate behavior
		// create - first existing table(s) then do stuff - DATA LOSS POSSIBLE
		// update - create new tables and columns where they dont already exists - NO DATA LOSS
		// create-drop - same as create but after its finished deletes everything - DATA LOSS GUARNTEED
		// validate - validates...

		// give our current instance(LocalSession) of Hibernate the properties
		factory.setHibernateProperties(hibernateProperties);
		return factory;
	}

	@Bean // Spring bean not Java bean
	@Autowired // get instance of getLocalSessionFactoryBean() using DI(Reflections)
	public HibernateTransactionManager transactionManager(SessionFactory LocalSesh) {
		HibernateTransactionManager tManager = new HibernateTransactionManager();
		tManager.setSessionFactory(LocalSesh);
		return tManager; // object returned needs to be handled by Spring
		// transaction - try to do a bunch of stuff if one thing fails revert all changes.
	}

}
