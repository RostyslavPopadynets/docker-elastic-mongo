package com.docker.restelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class RestElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestElasticsearchApplication.class, args);
	}

}
