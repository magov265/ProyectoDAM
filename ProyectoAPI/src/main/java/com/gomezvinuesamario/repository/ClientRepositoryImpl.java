package com.gomezvinuesamario.repository;

import com.gomezvinuesamario.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    // Falta implementar el @Mapper

    private MongoClientRepository mongoClientRepository;

    @Override
    public Client saveClient(Client client) {
        //mongoClientRepository.insert();
        return null;
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
