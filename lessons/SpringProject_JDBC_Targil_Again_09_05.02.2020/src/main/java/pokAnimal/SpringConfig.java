package pokAnimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("pokAnimal")
@PropertySource("classpath:application.properties")
//the spring magic powder is - Reflection in Java - modifying classes and interfaces AT RUNTIME
public class SpringConfig {
	// like initializing a part of Spring

	@Autowired // actually gets Environment implementation (polymorphism in the same way it
				// works in inheritance - but for interfaces)
	private Environment env;
	// JdbcTemplate = magic sql thing
	// now we want to use this like a component - returns stuff likes classes

	@Bean // dont confuse with a Java Bean - handled by java
	// this is a Spring Bean - a java bean that is ==completely== handled by Spring
	public JdbcTemplate getJdbcTemplate() {
		String url = env.getRequiredProperty("db.url");
		String username = env.getRequiredProperty("db.username");
		String password = env.getRequiredProperty("db.password");
		String driver = env.getRequiredProperty("db.driver");
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driver);
		return new JdbcTemplate(dataSource); // return - why we want this to be @Bean like @Componet
	}
}
