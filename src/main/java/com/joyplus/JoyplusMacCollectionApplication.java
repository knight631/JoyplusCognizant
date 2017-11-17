package com.joyplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.joyplus.repository.DeviceRepository;


/*@EnableMongoRepositories(
			basePackages = {"com.joyplus.repository"},
			repositoryFactoryBeanClass = DeviceRepository.class
		)*/
@SpringBootApplication
public class JoyplusMacCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoyplusMacCollectionApplication.class, args);
	}
}
