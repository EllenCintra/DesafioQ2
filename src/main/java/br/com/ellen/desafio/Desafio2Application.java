package br.com.ellen.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Desafio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafio2Application.class, args);
	}

}
