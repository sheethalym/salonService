package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.capgemini.salon.controller","com.capgemini.salon.Service","com.capgemini.salon.dao"} )
@EnableJpaRepositories("com.capgemini.salon.dao")
@EntityScan("com.capgemini.salon.entity")
public class MyOnlineServiceSalonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyOnlineServiceSalonApplication.class, args);
	}

}
