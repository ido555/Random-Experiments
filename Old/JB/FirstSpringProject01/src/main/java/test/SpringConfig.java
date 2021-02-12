package test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // tell Spring this is a Config file
@ComponentScan("beans") // tell Spring where to look for Components
public class SpringConfig {

}
