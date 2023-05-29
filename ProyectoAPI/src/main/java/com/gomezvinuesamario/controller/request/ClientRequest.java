package com.gomezvinuesamario.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    private String name;
    private String lastname; // We consider lastname are together
    private String phone;
    private String cardId;
    private Date birthday;

    private String roomId;
}
