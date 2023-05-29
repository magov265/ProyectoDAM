package com.gomezvinuesamario.mappers;

import com.gomezvinuesamario.controller.request.ClientRequest;
import com.gomezvinuesamario.controller.response.ClientResponse;
import com.gomezvinuesamario.domain.Client;
import com.gomezvinuesamario.repository.model.ClientDocument;

import java.util.List;

public interface ClientMapper {
    Client clientRequestToClient(ClientRequest clientRequest);

    ClientResponse clientToClientResponse(Client client);

    List<ClientResponse> clientListToClientResponseList(List<Client> clientList);

    ClientDocument clientToClientDocument(Client client);

    Client clientDocumentToClient(ClientDocument clientDocument);

    List<Client> clientDocumentListToClientList(List<ClientDocument>clientDocumentList);
}
