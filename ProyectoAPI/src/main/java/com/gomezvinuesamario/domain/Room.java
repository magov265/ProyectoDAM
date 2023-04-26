package com.gomezvinuesamario.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Room {
    private String roomNumber;
    // private TierRoom tier;
    private String clientId;
    private Date reservationStart;
    private Date reservationEnd;
}
