package com.gomezvinuesamario.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(value = "Client")
@NoArgsConstructor
@AllArgsConstructor
public class ClientDocument {

    @Id
    private String id; // auto-generated ID

    private String name;
    private String lastname; // We consider lastname are together
    private String phone;

    @Indexed(unique = true)
    private String cardId;
    private Date birthday;

    @DBRef
    private RoomDocument roomAssigned;

}
