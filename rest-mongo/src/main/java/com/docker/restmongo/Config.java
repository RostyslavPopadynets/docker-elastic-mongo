package com.docker.restmongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class Config {
  @Bean
  public RestTemplate restTemplate(
      @Value("${elastic.base-url}") String baseUrl
  ) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
    return restTemplate;
  }
}
