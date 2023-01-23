package com.docker.restmongo.protocol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProtocolDto {
  private String id;
  private String name;
  private String author;
  private String version;

  public static class ProtocolDtoBuilder {
    public ProtocolDto fromEntity(Protocol protocol) {
      return ProtocolDto.builder()
          .id(protocol.getId())
          .name(protocol.getName())
          .author(protocol.getAuthor())
          .version(protocol.getVersion())
          .build();
    }
  }
}
