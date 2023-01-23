package com.docker.restmongo.protocol;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolRepository extends MongoRepository<Protocol, String> {
}
