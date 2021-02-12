package testing;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // tell Spring this is a Config file
@ComponentScan("ex_1")// tell Spring where to look for Components
@ComponentScan("ex_2")
public class SpringConfig {

}
