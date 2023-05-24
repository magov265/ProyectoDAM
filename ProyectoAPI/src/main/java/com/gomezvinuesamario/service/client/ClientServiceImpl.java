package com.gomezvinuesamario.service.client;

import com.gomezvinuesamario.domain.Client;
import com.gomezvinuesamario.repository.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return clientRepository.saveClient(client);
    }

    @Override
    public Client getClient(String cardID) {
        return clientRepository.getClient(cardID);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
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
