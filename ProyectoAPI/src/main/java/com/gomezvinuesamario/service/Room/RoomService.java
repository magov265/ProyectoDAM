package com.gomezvinuesamario.service.Room;

import com.gomezvinuesamario.domain.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
    Room saveRoom(Room room);

    Room getRoom(String roomNumber);

    List<Room> getAllRooms();

    Room updateRoom(Room room);

    Room deleteRoom(String roomId);
}
