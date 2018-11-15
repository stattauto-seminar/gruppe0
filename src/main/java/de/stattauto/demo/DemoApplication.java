package de.stattauto.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import de.stattauto.demo.entity.Kunde;
import de.stattauto.demo.repository.KundenRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(KundenRepository repo) {
		return args -> {
			repo.save(new Kunde("Hans", "Müller", "1"));
			repo.save(new Kunde("Anna", "Schmitz", "2"));
		};
	}
	
	
	
}
