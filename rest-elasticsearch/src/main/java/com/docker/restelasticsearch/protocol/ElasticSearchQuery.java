package com.docker.restelasticsearch.protocol;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class ElasticSearchQuery {

  private final ElasticsearchClient elasticsearchClient;

  private static final String INDEX_NAME = "protocols";

  public String createOrUpdateProtocol(Protocol protocol) throws IOException {
    IndexResponse response = elasticsearchClient.index(i -> i
        .index(INDEX_NAME)
        .id(protocol.getId())
        .document(protocol)
    );
    if (response.result().name().equals("Created")) {
      return "Protocol has been successfully created.";
    } else if (response.result().name().equals("Updated")) {
      return "Protocol has been successfully updated.";
    }
    return "Error while performing the operation.";
  }

  public Protocol getProtocolById(String protocolId) throws IOException {
    GetResponse<Protocol> response =
        elasticsearchClient.get(g -> g.index(INDEX_NAME).id(protocolId), Protocol.class);
    return response.found() ? response.source() : null;
  }

  public String deleteProtocolById(String productId) throws IOException {
    DeleteRequest request = DeleteRequest.of(d -> d.index(INDEX_NAME).id(productId));

    DeleteResponse deleteResponse = elasticsearchClient.delete(request);
    if (Objects.nonNull(deleteResponse.result()) && !deleteResponse.result().name().equals("NotFound")) {
      return "Protocol with id " + deleteResponse.id() + " has been deleted.";
    }
    return "Protocol with id " + deleteResponse.id() + " does not exist.";
  }

  public List<Protocol> searchAllProtocols() throws IOException {
    SearchRequest searchRequest = SearchRequest.of(s -> s.index(INDEX_NAME));
    SearchResponse<Protocol> searchResponse = elasticsearchClient.search(searchRequest, Protocol.class);
    List<Hit<Protocol>> hits = searchResponse.hits().hits();
    List<Protocol> products = new ArrayList<>();
    hits.forEach(h -> products.add(h.source()));
    return products;
  }
}
