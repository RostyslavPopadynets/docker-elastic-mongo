package com.docker.restelasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfiguration {

  private static final String HOST_NAME = "localhost";
  private static final int PORT = 9200;
  private static final String SCHEMA = "http";

  @Bean
  public RestClient getRestClient() {
    return RestClient.builder(new HttpHost(HOST_NAME, PORT, SCHEMA)).build();
  }

  @Bean
  public  ElasticsearchTransport getElasticsearchTransport() {
    return new RestClientTransport(
        getRestClient(), new JacksonJsonpMapper());
  }

  @Bean
  public ElasticsearchClient getElasticsearchClient(){
    return new ElasticsearchClient(getElasticsearchTransport());
  }

}
