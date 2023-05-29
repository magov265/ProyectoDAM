package com.gomezvinuesamario.controller;

import com.gomezvinuesamario.controller.request.ClientRequest;
import com.gomezvinuesamario.controller.response.ClientResponse;
import com.gomezvinuesamario.domain.Client;
import com.gomezvinuesamario.mappers.ClientMapper;
import com.gomezvinuesamario.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("gestion")
public class HotelGestionControllerImpl implements HotelGestionController{

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;


    @Override
    @PostMapping("/saveClient")
    public ResponseEntity<ClientResponse> saveClient(final ClientRequest client) {
        return ResponseEntity.ok(clientMapper.clientToClientResponse(
                clientService.saveClient(clientMapper.clientRequestToClient(client))));
    }

    @Override
    @GetMapping("/getAllClients")
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        return ResponseEntity.ok(clientMapper.clientListToClientResponseList(clientService.getAllClients()));
    }

    @Override
    @GetMapping("/getClient")
    public ResponseEntity getClientByCardId(final String cardId) {
        Client client = clientService.getClient(cardId);
        if (Objects.isNull(client)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The client with the cardID: " + cardId + " not found, please check if you put your card ID");
        }
        return ResponseEntity.ok(client);
    }

    @Override
    @DeleteMapping("/deleteClient")
    public ResponseEntity<ClientResponse> deleteClient(final String cardId) {
        return ResponseEntity.ok(clientMapper.clientToClientResponse(clientService.deleteClient(cardId)));
    }

    @Override
    @PutMapping("/updateClient")
    public ResponseEntity<ClientResponse> updateClient(final ClientRequest client) {
        return ResponseEntity.ok(clientMapper.clientToClientResponse(clientService.updateClient(clientMapper.clientRequestToClient(client))));
    }
}
