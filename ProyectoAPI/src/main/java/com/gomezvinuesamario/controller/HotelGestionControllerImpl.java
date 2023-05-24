package com.gomezvinuesamario.controller;

import com.gomezvinuesamario.domain.Client;
import com.gomezvinuesamario.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("gestion")
public class HotelGestionControllerImpl implements HotelGestionController{

    @Autowired
    private ClientService clientService;


    @Override
    @PostMapping("/saveClient")
    public ResponseEntity<Client> saveClient(Client client) {
        return ResponseEntity.ok(clientService.saveClient(client));
    }

    @Override
    @GetMapping("/getAllClients")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @Override
    @GetMapping("/getClient")
    public ResponseEntity getClientByCardId(final String cardID) {
        Client client = clientService.getClient(cardID);
        if (Objects.isNull(client)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The client with the cardID: " + cardID + " not found, please check if you put your card ID");
        }
        return ResponseEntity.ok(client);
    }
}
