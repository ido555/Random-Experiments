package beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("beans")
@PropertySource({"classpath:appilcation.properties", "classpath:web.properties"})
// {} static array init
// file:c://aa//config.config
public class SpringConfig {
	//env turns app.properties into a hashMap -- keys and values
//	private Environment environment;
	
//	public void readData() {
//		//environment.getProperty("user");
//		ConnectionPool pool = new ConnectionPool()
//	}
}
