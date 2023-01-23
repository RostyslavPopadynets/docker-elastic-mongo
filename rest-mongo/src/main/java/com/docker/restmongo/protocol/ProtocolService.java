package com.docker.restmongo.protocol;

public interface ProtocolService {

  ProtocolDto create(ProtocolDto protocol);

  ProtocolDto findById(String id);

}
