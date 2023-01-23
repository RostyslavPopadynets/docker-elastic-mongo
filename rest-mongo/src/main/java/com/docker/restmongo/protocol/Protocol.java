package com.docker.restmongo.protocol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Protocol {

  @Id
  private String id;

  private String name;

  private String author;

  private String version;

  public static class ProtocolBuilder {
    public Protocol fromDto(ProtocolDto protocolDto) {
      return Protocol.builder()
          .id(protocolDto.getId())
          .name(protocolDto.getName())
          .author(protocolDto.getAuthor())
          .version(protocolDto.getVersion())
          .build();
    }
  }
}
