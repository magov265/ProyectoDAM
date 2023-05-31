package com.gomezvinuesamario.repository.room;

import com.gomezvinuesamario.repository.model.RoomDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoRoomRepository extends MongoRepository<RoomDocument, String> {

    RoomDocument getRoomDocumentByRoomIdEquals(String roomId);

    RoomDocument deleteRoomDocumentByRoomIdEquals(String roomId);

    List<RoomDocument> getAllByAvailableEquals(Boolean available);
}