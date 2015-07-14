package br.comar.ricardo.stuff.concurrentjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
@SpringBootApplication
@ImportResource("spring-context.xml")
public class ConcurrentJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrentJobApplication.class, args);
	}
}
