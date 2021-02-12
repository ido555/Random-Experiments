package targil_1_and_2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("targil_1_and_2")
@PropertySource("classpath:config.settings")

public class SpringConfig {

}
