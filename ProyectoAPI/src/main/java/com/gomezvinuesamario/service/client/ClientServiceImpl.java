package com.gomezvinuesamario.service.client;

import com.gomezvinuesamario.domain.Client;
import com.gomezvinuesamario.domain.Room;
import com.gomezvinuesamario.repository.client.ClientRepository;
import com.gomezvinuesamario.repository.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Client saveClient(Client client) {
        Room room = roomRepository.getRoom(client.getRoom().getRoomId());

        if (Objects.nonNull(room)) {
            client.setRoom(room);
            return clientRepository.saveClient(client);
        } else {
            return null;
        }

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

        return clientRepository.updateClient(client);
    }

    @Override
    public Client deleteClient(String cardID) {

        return clientRepository.deleteClient(cardID);
    }
}
