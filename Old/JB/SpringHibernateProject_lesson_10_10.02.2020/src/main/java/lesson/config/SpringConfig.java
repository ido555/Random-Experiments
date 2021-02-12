package lesson.config;

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
@ComponentScan("lesson")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement // allow Spring to use HibernateTransactionManager transactionManager
public class SpringConfig {
	@Autowired
	private Environment env; // Spring gets an instance using dependency injection

	@Bean
	public DataSource getDataSource() {
		String url = env.getRequiredProperty("db.url");
		String username = env.getRequiredProperty("db.username");
		String password = env.getRequiredProperty("db.password");
		String driver = env.getRequiredProperty("db.driver");
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getLocalSessionFactory() {
		// LocalSessionFactoryBean takes JDBCtemplate makes it work with Spring?
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setPackagesToScan("lesson");
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		factory.setHibernateProperties(hibernateProperties);
		return factory;
	}

	@Bean
	@Autowired // get instance of getLocalSessionFactoryBean
	public HibernateTransactionManager transactionManager(SessionFactory getLocalSessionFactoryBean) {
		HibernateTransactionManager tManager = new HibernateTransactionManager();
		tManager.setSessionFactory(getLocalSessionFactoryBean);
		return tManager;
		// transaction - try to do a bunch of stuff if one thing fails revert all changes and stop.
	}
}
