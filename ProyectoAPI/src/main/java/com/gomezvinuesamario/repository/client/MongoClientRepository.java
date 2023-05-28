package com.gomezvinuesamario.repository.client;

import com.gomezvinuesamario.repository.model.ClientDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoClientRepository extends MongoRepository<ClientDocument, String> {
    // JPQL Methods

    ClientDocument findClientDocumentByCardIdEquals(String cardId);

    ClientDocument deleteClientDocumentByCardIdEquals(String cardID);

}
