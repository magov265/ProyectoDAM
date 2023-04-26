package com.gomezvinuesamario.repository;

import com.gomezvinuesamario.domain.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoomRepository {

    Room saveRoom(Room room);

    Room getRoom(String roomNumber);

    List<Room> getAllRooms();

    Room updateRoom(Room room);

    Room deleteRoom(Room room);
}
