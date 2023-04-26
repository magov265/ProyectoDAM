package com.gomezvinuesamario.repository;

import com.gomezvinuesamario.domain.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepositoryImpl implements RoomRepository{


    // Falta implementar el @Mapper

    private MongoRoomRepository mongoRoomRepository;

    @Override
    public Room saveRoom(Room room) {
        return null;
    }

    @Override
    public Room getRoom(String roomNumber) {
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }

    @Override
    public Room updateRoom(Room room) {
        return null;
    }

    @Override
    public Room deleteRoom(Room room) {
        return null;
    }
}
