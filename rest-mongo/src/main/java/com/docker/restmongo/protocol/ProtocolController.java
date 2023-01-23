package com.docker.restmongo.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/protocols")
public class ProtocolController {

  private final ProtocolService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProtocolDto create(@RequestBody ProtocolDto protocolDTO) {
    return service.create(protocolDTO);
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProtocolDto findById(@PathVariable String id) {
    return service.findById(id);
  }

}
