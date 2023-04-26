package com.gomezvinuesamario.repository.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(value = "Client")
public class ClientDocument {

    @Id
    private String id; // auto-generated ID

    private String name;
    private String lastname; // We consider lastname are together
    private String phone;

    @Indexed(unique = true)
    private String cardId;
    private Date birthday;

}
