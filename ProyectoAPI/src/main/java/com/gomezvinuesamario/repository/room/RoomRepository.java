package com.gomezvinuesamario.repository.room;

import com.gomezvinuesamario.domain.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoomRepository {

    Room saveRoom(Room room);

    Room getRoom(String roomId);

    List<Room> getAllRooms();

    Room updateRoom(Room room);

    Room deleteRoom(String roomId);

    List<Room> getAllRoomsByAvailability(Boolean isAvailable);
}
