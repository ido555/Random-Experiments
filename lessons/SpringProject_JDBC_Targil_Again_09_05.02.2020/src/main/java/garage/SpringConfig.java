package garage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("garage")
@PropertySource("classpath:application.properties")
public class SpringConfig {
	@Autowired
	Environment env; // using Env to use an outside file to control complied program parameters

	@Bean("jt")
	public JdbcTemplate getJdbcTemplate() {
		String url = env.getRequiredProperty("db.url");
		String username = env.getRequiredProperty("db.username");
		String password = env.getRequiredProperty("db.password");
		String driver = env.getRequiredProperty("db.driver");
		// so dataSource handles connection to DB and stuff?
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driver);
		return new JdbcTemplate(dataSource);
	}

}
