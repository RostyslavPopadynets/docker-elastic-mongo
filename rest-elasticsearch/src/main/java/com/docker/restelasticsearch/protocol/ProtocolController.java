package com.docker.restelasticsearch.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/protocols")
public class ProtocolController {

  private final ElasticSearchQuery elasticSearchQuery;

  @PostMapping("/createOrUpdateProtocol")
  public ResponseEntity<String> createOrUpdateProtocol(@RequestBody Protocol protocol) throws IOException {
    String response = elasticSearchQuery.createOrUpdateProtocol(protocol);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/getProtocol/{id}")
  public ResponseEntity<Protocol> getProtocolById(@PathVariable String id) throws IOException {
    Protocol protocol = elasticSearchQuery.getProtocolById(id);
    return new ResponseEntity<>(protocol, HttpStatus.OK);
  }

  @DeleteMapping("/deleteProtocol/{id}")
  public ResponseEntity<String> deleteProtocolById(@PathVariable String id) throws IOException {
    String response = elasticSearchQuery.deleteProtocolById(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/searchProtocols")
  public ResponseEntity<List<Protocol>> searchAllProtocols() throws IOException {
    List<Protocol> products = elasticSearchQuery.searchAllProtocols();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }
}
