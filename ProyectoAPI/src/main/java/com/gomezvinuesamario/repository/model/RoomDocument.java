package com.gomezvinuesamario.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(value = "Room")
@NoArgsConstructor
@AllArgsConstructor
public class RoomDocument {

    @Id
    private String roomId; // auto-generated ID

    private String roomNumber;

    private Boolean available;

}
