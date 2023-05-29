package com.gomezvinuesamario.controller;

import com.gomezvinuesamario.controller.request.ClientRequest;
import com.gomezvinuesamario.controller.response.ClientResponse;
import com.gomezvinuesamario.domain.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface HotelGestionController {

    // Client methods
    ResponseEntity<ClientResponse> saveClient(@RequestBody ClientRequest client);

    ResponseEntity<List<ClientResponse>> getAllClients();

    ResponseEntity <ClientResponse> getClientByCardId(@RequestParam String cardID);

    ResponseEntity <ClientResponse> deleteClient(@RequestParam String cardID);

    ResponseEntity <ClientResponse> updateClient(@RequestBody ClientRequest client);


    // Room methods

}
