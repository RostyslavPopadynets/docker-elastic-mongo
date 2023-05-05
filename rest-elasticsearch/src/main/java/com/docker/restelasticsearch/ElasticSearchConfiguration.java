package com.docker.restelasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfiguration {
  @Value("${elastic.hostname}") String hostname;

  @Bean
  public RestClient getRestClient() {
    return RestClient.builder(
        new HttpHost(hostname, 9200)).build();
  }

  @Bean
  public  ElasticsearchTransport getElasticsearchTransport() {
    return new RestClientTransport(getRestClient(), new JacksonJsonpMapper());
  }

  @Bean
  public ElasticsearchClient getElasticsearchClient(){
    return new ElasticsearchClient(getElasticsearchTransport());
  }

}
