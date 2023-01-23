package com.docker.restelasticsearch.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/protocols")
public class ProtocolController {

  private final ElasticSearchQuery elasticSearchQuery;

  @PostMapping("/createOrUpdateDocument")
  public ResponseEntity<Object> createOrUpdateDocument(@RequestBody Protocol product) throws IOException {
    String response = elasticSearchQuery.createOrUpdateDocument(product);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/getDocument")
  public ResponseEntity<Object> getDocumentById(@RequestParam String productId) throws IOException {
    Protocol product =  elasticSearchQuery.getDocumentById(productId);
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @DeleteMapping("/deleteDocument")
  public ResponseEntity<Object> deleteDocumentById(@RequestParam String productId) throws IOException {
    String response =  elasticSearchQuery.deleteDocumentById(productId);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/searchDocument")
  public ResponseEntity<Object> searchAllDocument() throws IOException {
    List<Protocol> products = elasticSearchQuery.searchAllDocuments();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }
}
