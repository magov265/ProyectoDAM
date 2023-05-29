package com.gomezvinuesamario.repository.room;

import com.gomezvinuesamario.domain.Room;
import com.gomezvinuesamario.mappers.RoomMapper;
import com.gomezvinuesamario.repository.model.RoomDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

    @Autowired
    private MongoRoomRepository mongoRoomRepository;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Room saveRoom(final Room room) {
        return roomMapper.roomDocumentToRoom(mongoRoomRepository.insert(roomMapper.roomToRoomDocument(room)));
    }

    @Override
    public Room getRoom(final String roomId) {
        RoomDocument roomDocument = mongoRoomRepository.getRoomDocumentByRoomIdEquals(roomId);
        if (Objects.nonNull(roomDocument)){
            return roomMapper.roomDocumentToRoom(roomDocument);
        }else{
            return null;
        }
    }

    @Override
    public List<Room> getAllRooms() {
        return roomMapper.roomDocumentListToRoomList(mongoRoomRepository.findAll());
    }

    @Override
    public Room updateRoom(final Room room) {
        if (Objects.nonNull(getRoom(room.getRoomId()))){
            return roomMapper.roomDocumentToRoom(mongoRoomRepository.save(roomMapper.roomToRoomDocument(room)));
        }else {
            return null;
        }
    }

    @Override
    public Room deleteRoom(final String roomId) {
        RoomDocument roomDocument = mongoRoomRepository.deleteRoomDocumentByRoomIdEquals(roomId);
        if (Objects.nonNull(roomDocument)){
            return roomMapper.roomDocumentToRoom(roomDocument);
        }
        return null;
    }


}