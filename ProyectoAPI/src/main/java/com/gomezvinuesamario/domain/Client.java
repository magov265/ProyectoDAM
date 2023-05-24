package com.gomezvinuesamario.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String name;
    private String lastname; // We consider lastname are together
    private String phone;
    private String cardId;
    private Date birthday;

}