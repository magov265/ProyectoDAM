package com.gomezvinuesamario.repository.client;

import com.gomezvinuesamario.domain.Client;
import com.gomezvinuesamario.mappers.ClientMapper;
import com.gomezvinuesamario.repository.model.ClientDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private MongoClientRepository mongoClientRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Client saveClient(final Client client) {
        //Convertimos el cliente en un cliente document con el mapper
        final ClientDocument clientDocument = clientMapper.clientToClientDocument(client);
        //Nos quedamos con el objeto inserado
        final ClientDocument clienDocumentInsertado = mongoClientRepository.insert(clientDocument);
        //Transformamos y devovlemos el objeto de dominio huesped
        return clientMapper.clientDocumentToClient(clienDocumentInsertado);
    }

    @Override
    public Client getClient(final String cardId) {
        final ClientDocument clientDocument = mongoClientRepository.findClientDocumentByCardIdEquals(cardId);
        if (Objects.nonNull(clientDocument)) {
            return clientMapper.clientDocumentToClient(clientDocument);
        } else {
            return null;
        }
    }

    @Override
    public List<Client> getAllClients() {
        return clientMapper.clientDocumentListToClientList(mongoClientRepository.findAll());
    }

    @Override
    public Client updateClient(final Client client) {
        deleteClient(client.getCardId());
        return clientMapper.clientDocumentToClient(mongoClientRepository.insert(clientMapper.clientToClientDocument(client)));
    }

    @Override
    public Client deleteClient(final String cardId) {
        final ClientDocument clientDocument = mongoClientRepository.deleteClientDocumentByCardIdEquals(cardId);
        if (Objects.nonNull(clientDocument)) {
            return clientMapper.clientDocumentToClient(clientDocument);
        }
        return null;
    }
}
