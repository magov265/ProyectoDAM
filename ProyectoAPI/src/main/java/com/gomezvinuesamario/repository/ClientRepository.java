package com.gomezvinuesamario.repository;

import com.gomezvinuesamario.domain.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientRepository {

    Client saveClient(Client client);

    Client getClient(String cardID);

    List<Client> getAllClients();

    Client updateClient(Client client);

    Client deleteClient(Client client);

}
