package com.gomezvinuesamario.service.client;

import com.gomezvinuesamario.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {

    Client saveClient(Client client);

    Client getClient(String cardID);

    List<Client> getAllClients();

    Client updateClient(Client client);

    Client deleteClient(Client client);

}
