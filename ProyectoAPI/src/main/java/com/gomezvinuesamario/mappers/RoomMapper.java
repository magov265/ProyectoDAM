package com.gomezvinuesamario.mappers;

import com.gomezvinuesamario.controller.response.RoomResponse;
import com.gomezvinuesamario.domain.Room;
import com.gomezvinuesamario.repository.model.RoomDocument;

import java.util.List;

public interface RoomMapper {

    RoomDocument roomToRoomDocument(Room room);

    Room roomDocumentToRoom(RoomDocument roomDocument);

    RoomResponse roomToRoomResponse(Room room);

    List<Room> roomDocumentListToRoomList(List<RoomDocument> roomDocuments);

    List<RoomResponse> roomListToRoomResponseList(List<Room> roomList);
}