package com.gomezvinuesamario.repository.room;

import com.gomezvinuesamario.domain.Employee;
import com.gomezvinuesamario.domain.Room;
import com.gomezvinuesamario.repository.model.EmployeeDocument;
import com.gomezvinuesamario.repository.model.RoomDocument;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepositoryImpl implements RoomRepository{



    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private MongoRoomRepository mongoRoomRepository;

    @Override
    public Room saveRoom(Room room) {
        return modelMapper.map(mongoRoomRepository.insert(modelMapper.map(room, RoomDocument.class)), Room.class);
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
