package com.example.bms.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder

public  @Data class BookingResponseDTO {

    //status
    //seatList
    private String bookingrefId;
    private String theater;
    List<Long> showSeats;
    private String showname;
    private double amount;
    private ResponseStatus status;
}
