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
public class Room {
    private String roomNumber;
    // private TierRoom tier;
    private String clientId;
    private Date reservationStart;
    private Date reservationEnd;
}
