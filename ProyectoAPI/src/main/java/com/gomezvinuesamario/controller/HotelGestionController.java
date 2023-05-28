package com.gomezvinuesamario.controller;

import com.gomezvinuesamario.domain.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface HotelGestionController {

    // Client methods
    ResponseEntity<Client> saveClient(@RequestBody Client client);

    ResponseEntity<List<Client>> getAllClients();

    ResponseEntity <Client> getClientByCardId(@RequestParam String cardID);

    ResponseEntity <Client> deleteClient(@RequestParam String cardID);

    ResponseEntity <Client> updateClient(@RequestBody Client client);


    // Room methods

}
