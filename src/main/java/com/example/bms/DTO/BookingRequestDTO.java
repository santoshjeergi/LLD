package com.example.bms.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
public @Data class BookingRequestDTO {

    private List<Long> showSeatLists;
}
