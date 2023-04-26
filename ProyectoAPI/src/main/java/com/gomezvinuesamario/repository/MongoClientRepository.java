package com.gomezvinuesamario.repository;

import com.gomezvinuesamario.repository.model.ClientDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoClientRepository extends MongoRepository<ClientDocument, String> {

}
