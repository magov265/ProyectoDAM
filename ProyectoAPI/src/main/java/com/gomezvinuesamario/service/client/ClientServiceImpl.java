package com.gomezvinuesamario.service.client;

import com.gomezvinuesamario.controller.exception.custom.NotFoundException;
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
    public Client saveClient(final Client client) {
        final Room room = roomRepository.getRoom(client.getRoom().getRoomId());
        if (Objects.nonNull(room)) {
            if (room.getAvailable()) {
                client.setRoom(room);
                final Client clientResult = clientRepository.saveClient(client);
                if (Objects.nonNull(clientResult)) {
                    room.setAvailable(false);
                    roomRepository.updateRoom(room);
                    clientResult.setRoom(room);
                }
                return clientResult;
            }
        }
        throw new NotFoundException("¡ERROR!. " +
                "Something wrong trying to create the client");

    }

    @Override
    public Client getClient(final String cardId) {
        Client client = clientRepository.getClient(cardId);
        if (Objects.nonNull(client)){
            return client;
        }
        throw new NotFoundException("¡ERROR!. " +
                "The client with card ID : "+cardId+" was not found.");
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

    @Override
    public Client updateClient(final Client client) {
        final Client oldClient = clientRepository.getClient(client.getCardId());
        if (Objects.nonNull(oldClient)) {
            final Room room = roomRepository.getRoom(client.getRoom().getRoomId());
            if (Objects.nonNull(room)) {
                if (room.getAvailable()) {
                    client.setRoom(room);
                    final Client clientUpdated = clientRepository.updateClient(client);
                    if (Objects.nonNull(clientUpdated)) {
                        room.setAvailable(false);
                        roomRepository.updateRoom(room);
                        final Room oldRoom = oldClient.getRoom();
                        oldRoom.setAvailable(true);
                        roomRepository.updateRoom(oldRoom);
                        clientUpdated.setRoom(room);
                    }
                    return clientUpdated;
                }
            }
        }
        throw new RuntimeException();
    }

    @Override
    public Client deleteClient(final String cardId) {
        Client clientDeleted = clientRepository.deleteClient(cardId);
        Room room = clientDeleted.getRoom();
        room.setAvailable(true);
        roomRepository.updateRoom(room);
        clientDeleted.setRoom(room);
        return clientDeleted;

    }
}
