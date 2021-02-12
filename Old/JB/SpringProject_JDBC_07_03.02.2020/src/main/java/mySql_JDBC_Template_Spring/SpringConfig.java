package mySql_JDBC_Template_Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("mySql_JDBC_Template_Spring")
@PropertySource("classpath:application.properties")
public class SpringConfig {
	@Autowired
	private Environment env;

	@Bean("jt")
	public JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(env.getProperty("db1_url"),
				env.getProperty("db1_user"), env.getProperty("db1_pass"));
		dataSource.setDriverClassName(env.getProperty("db1_driver"));
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		return jt;
	}
}
