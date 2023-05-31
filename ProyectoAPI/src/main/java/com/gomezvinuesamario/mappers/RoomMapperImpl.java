package com.gomezvinuesamario.mappers;

import com.gomezvinuesamario.controller.response.RoomResponse;
import com.gomezvinuesamario.domain.Room;
import com.gomezvinuesamario.repository.model.RoomDocument;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomDocument roomToRoomDocument(final Room room) {
        return RoomDocument.builder()
                .roomId(room.getRoomId())
                .available(room.getAvailable())
                .roomNumber(room.getRoomNumber())
                .build();
    }

    @Override
    public Room roomDocumentToRoom(final RoomDocument roomDocument) {
        return Room.builder()
                .roomId(roomDocument.getRoomId())
                .roomNumber(roomDocument.getRoomNumber())
                .available(roomDocument.getAvailable())

                .build();
    }

    @Override
    public RoomResponse roomToRoomResponse(final Room room) {
        return RoomResponse.builder()
                .roomNumber(room.getRoomNumber())
                .roomId(room.getRoomId())
                .available(room.getAvailable())
                .build();
    }

    @Override
    public List<Room> roomDocumentListToRoomList(List<RoomDocument> roomDocuments) {
        List<Room> roomList = new ArrayList<>();

        for (RoomDocument roomDocument : roomDocuments) {
            roomList.add(roomDocumentToRoom(roomDocument));
        }

        return roomList;
    }

    @Override
    public List<RoomResponse> roomListToRoomResponseList(List<Room> roomList) {
        List<RoomResponse> roomResponseList = new ArrayList<>();
        for (Room room : roomList) {
            roomResponseList.add(roomToRoomResponse(room));
        }

        return roomResponseList;
    }
}
