package tec.utpl.store.project.service

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProjectApplication.class, args);
	}

}
