package com.gomezvinuesamario.service.Room;

import com.gomezvinuesamario.domain.Room;
import com.gomezvinuesamario.repository.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.saveRoom(room);
    }

    @Override
    public Room getRoom(String roomNumber) {
        return roomRepository.getRoom(roomNumber);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepository.updateRoom(room);
    }

    @Override
    public Room deleteRoom(String roomId) {
        return roomRepository.deleteRoom(roomId);
    }

    @Override
    public List<Room> getAllRoomsByAvailability(Boolean isAvailable) {
        return roomRepository.getAllRoomsByAvailability(isAvailable);
    }
}
