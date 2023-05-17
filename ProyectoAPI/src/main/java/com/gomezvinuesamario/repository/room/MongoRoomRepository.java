package com.gomezvinuesamario.repository.room;

import com.gomezvinuesamario.repository.model.RoomDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRoomRepository  extends MongoRepository<RoomDocument, String> {
}
