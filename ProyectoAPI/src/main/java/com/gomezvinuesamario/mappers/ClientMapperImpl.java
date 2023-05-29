package com.gomezvinuesamario.mappers;

import com.gomezvinuesamario.controller.request.ClientRequest;
import com.gomezvinuesamario.controller.response.ClientResponse;
import com.gomezvinuesamario.controller.response.RoomResponse;
import com.gomezvinuesamario.domain.Client;
import com.gomezvinuesamario.domain.Room;
import com.gomezvinuesamario.repository.model.ClientDocument;
import com.gomezvinuesamario.repository.model.RoomDocument;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapperImpl implements ClientMapper{

    @Override
    public Client clientRequestToClient(ClientRequest clientRequest) {
        return Client.builder()
                .birthday(clientRequest.getBirthday())
                .cardId(clientRequest.getCardId())
                .lastname(clientRequest.getLastname())
                .name(clientRequest.getName())
                .phone(clientRequest.getPhone())
                .room(Room.builder().roomId(clientRequest.getRoomId()).build()).build();
    }

    @Override
    public ClientResponse clientToClientResponse(Client client) {
        return ClientResponse.builder()
                .birthday(client.getBirthday())
                .cardId(client.getCardId())
                .name(client.getName())
                .lastname(client.getLastname())
                .phone(client.getPhone())
                .room(RoomResponse.builder()
                        .roomId(client.getRoom().getRoomId())
                        .available(client.getRoom().getAvailable())
                        .roomNumber(client.getRoom().getRoomNumber())
                        .build())
                .build();
    }

    @Override
    public ClientDocument clientToClientDocument(Client client) {
        return ClientDocument.builder()
                .birthday(client.getBirthday())
                .cardId(client.getCardId())
                .name(client.getName())
                .lastname(client.getLastname())
                .phone(client.getPhone())
                .roomAssigned(RoomDocument.builder()
                        .roomId(client.getRoom().getRoomId())
                        .available(client.getRoom().getAvailable())
                        .roomNumber(client.getRoom().getRoomNumber())
                        .build())
                .build();
    }


    @Override
    public Client clientDocumentToClient(final ClientDocument clientDocument) {
        return Client.builder()
                .birthday(clientDocument.getBirthday())
                .cardId(clientDocument.getCardId())
                .lastname(clientDocument.getLastname())
                .name(clientDocument.getName())
                .phone(clientDocument.getPhone())
                .room(Room.builder()
                        .available(clientDocument.getRoomAssigned().getAvailable())
                        .roomNumber(clientDocument.getRoomAssigned().getRoomNumber())
                        .roomId(clientDocument.getRoomAssigned().getRoomId())
                        .build()).build();

    }

    @Override
    public List<Client> clientDocumentListToClientList(final List<ClientDocument> clientDocumentList) {
        final List<Client> clientList = new ArrayList<>();
        for (final ClientDocument clientDocument : clientDocumentList) {
            clientList.add(clientDocumentToClient(clientDocument));
        }
        return clientList;
    }

    @Override
    public List<ClientResponse> clientListToClientResponseList(final List<Client> clientList) {
        final List<ClientResponse> clientResponseList = new ArrayList<>();
        for (final Client client : clientList) {
            clientResponseList.add(clientToClientResponse(client));
        }
        return clientResponseList;
    }
}
