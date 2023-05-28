package com.gomezvinuesamario.repository.client;

import com.gomezvinuesamario.domain.Client;
import com.gomezvinuesamario.repository.model.ClientDocument;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ClientRepositoryImpl implements ClientRepository {


    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private MongoClientRepository mongoClientRepository;

    @Override
    public Client saveClient(Client client) {

        // Convertimos el cliente en un cliente document con el mapper
        ClientDocument clientDocument = modelMapper.map(client, ClientDocument.class);

        // Nos quedamos con el objeto insertado
        ClientDocument clientDocumentInsertado = mongoClientRepository.insert(clientDocument);

        // Transformamos y devolvemos el objeto de dominio Cliente
        return modelMapper.map(clientDocumentInsertado, Client.class);
    }

    @Override
    public Client getClient(final String cardId) {
        ClientDocument clientDocument = mongoClientRepository.findClientDocumentByCardIdEquals(cardId);
        if (Objects.nonNull(clientDocument)) {
            return modelMapper.map(clientDocument, Client.class);
        } else {
            return null;
        }
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clientsDomain = new ArrayList<>();
        for (ClientDocument clientDocument : mongoClientRepository.findAll()) {
            clientsDomain.add(modelMapper.map(clientDocument, Client.class));
        }
        return clientsDomain;
    }

    @Override
    public Client updateClient(Client client) {

        if (Objects.nonNull(getClient(client.getCardId()))) {
            return modelMapper.map(mongoClientRepository.save(modelMapper.map(client, ClientDocument.class)), Client.class);
        }

        return null;
    }

    @Override
    public Client deleteClient(String cardID) {

        ClientDocument clientDocument = mongoClientRepository.deleteClientDocumentByCardIdEquals(cardID);

        if (Objects.nonNull(clientDocument)) {
            return modelMapper.map(clientDocument, Client.class);
        }
        return null;
    }
}
