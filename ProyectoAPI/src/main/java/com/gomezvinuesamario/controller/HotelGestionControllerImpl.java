package com.gomezvinuesamario.controller;

import com.gomezvinuesamario.controller.request.ClientRequest;
import com.gomezvinuesamario.controller.response.ClientResponse;
import com.gomezvinuesamario.controller.response.RoomResponse;
import com.gomezvinuesamario.domain.Client;
import com.gomezvinuesamario.domain.Room;
import com.gomezvinuesamario.mappers.ClientMapper;
import com.gomezvinuesamario.mappers.RoomMapper;
import com.gomezvinuesamario.service.Room.RoomService;
import com.gomezvinuesamario.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("gestion")
public class HotelGestionControllerImpl implements HotelGestionController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private RoomService roomService;


    // Clients
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
        return ResponseEntity.ok(clientService.getClient(cardId));
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

    // Rooms

    @Override
    @PostMapping("/saveRoom")
    public ResponseEntity<RoomResponse> saveRoom(Room room) {
        return ResponseEntity.ok(roomMapper.roomToRoomResponse(roomService.saveRoom(room)));
    }

    @Override
    @GetMapping("/getAllRooms")
    public ResponseEntity<List<RoomResponse>> getAllRooms() {
        return ResponseEntity.ok(roomMapper.roomListToRoomResponseList(roomService.getAllRooms()));
    }

    @Override
    @GetMapping("/getAllRoomsByAvailability")
    public ResponseEntity<List<RoomResponse>> getAllRoomsByAvailability(Boolean isAvailable) {
        return ResponseEntity.ok(roomMapper.roomListToRoomResponseList(roomService.getAllRoomsByAvailability(isAvailable)));
    }

    @Override
    @GetMapping("/getRoomByRoomId")
    public ResponseEntity<RoomResponse> getRoomByRoomId(String roomId) {
        return ResponseEntity.ok(roomMapper.roomToRoomResponse(roomService.getRoom(roomId)));
    }

    @Override
    @DeleteMapping("/deleteRoom")
    public ResponseEntity<RoomResponse> deleteRoom(String roomId) {
        return ResponseEntity.ok(roomMapper.roomToRoomResponse(roomService.deleteRoom(roomId)));
    }

    @Override
    @PutMapping("/updateRoom")
    public ResponseEntity<RoomResponse> updateRoom(Room room) {
        return ResponseEntity.ok(roomMapper.roomToRoomResponse(roomService.updateRoom(room)));
    }

}
