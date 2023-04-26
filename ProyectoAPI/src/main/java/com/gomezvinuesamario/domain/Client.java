package com.gomezvinuesamario.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Client {
    private String name;
    private String lastname; // We consider lastname are together
    private String phone;
    private String cardId;
    private Date birthday;

}