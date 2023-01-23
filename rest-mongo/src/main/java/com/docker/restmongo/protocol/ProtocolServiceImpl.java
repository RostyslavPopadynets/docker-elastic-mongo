package com.docker.restmongo.protocol;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProtocolServiceImpl implements ProtocolService {

  private static final String BASE_URL = "http://localhost:8091/protocols";

  private final ProtocolRepository repository;
  private final RestTemplate restTemplate;

  @Override
  public ProtocolDto create(ProtocolDto protocolDto) {
    Protocol protocolToSave = Protocol.builder().fromDto(protocolDto);
    Protocol savedProtocol = repository.save(protocolToSave);
    restTemplate.postForObject(BASE_URL + "/createOrUpdateDocument", savedProtocol, String.class);
    return ProtocolDto.builder().fromEntity(savedProtocol);
  }

  @Override
  public ProtocolDto findById(String id) {
    Protocol protocolFromElastic = restTemplate.getForObject(BASE_URL + "/getDocument/" + id, Protocol.class);
    if (Objects.isNull(protocolFromElastic)) {
      throw new NullPointerException();
    }
    return ProtocolDto.builder().fromEntity(protocolFromElastic);
  }

}
