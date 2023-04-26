package com.gomezvinuesamario.repository.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(value = "Room")
public class RoomDocument {

    @Id
    private String id; // auto-generated ID

    private String clientId;
    private Date reservationStart;
    private Date reservationEnd;

    @Indexed(unique = true)
    private String roomNumber;

}
