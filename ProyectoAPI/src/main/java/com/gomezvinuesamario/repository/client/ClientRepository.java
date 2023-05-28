package com.gomezvinuesamario.repository.client;

import com.gomezvinuesamario.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClientRepository {

    Client saveClient(Client client);

    Client getClient(String cardID);

    List<Client> getAllClients();

    Client updateClient(Client client);

    Client deleteClient(String cardID);

}
