package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EntityScan(basePackages = "com.example.beans")
//@EnableJpaRepositories("com.example.repos")
@SpringBootApplication
@EnableSwagger2
public class AngularServer16052020Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AngularServer16052020Application.class, args);

	}

}
