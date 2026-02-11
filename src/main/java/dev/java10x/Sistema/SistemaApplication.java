package dev.java10x.Sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;
@SpringBootApplication

public class SistemaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);


	}

}
