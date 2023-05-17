package com.gomezvinuesamario.repository.client;

import com.gomezvinuesamario.domain.Client;
import com.gomezvinuesamario.repository.model.ClientDocument;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return modelMapper.map(clientDocumentInsertado,Client.class);
    }

    @Override
    public Client getClient(String cardID) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }

    @Override
    public Client deleteClient(Client client) {
        return null;
    }
}
