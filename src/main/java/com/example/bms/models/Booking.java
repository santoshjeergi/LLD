package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Builder
public @Data class Booking extends BaseModel{
    //(Booking->show_seat) 1: m

    @OneToMany
    List<Show_Seat> showSeats;

    //Booking->show m -1

    @ManyToOne
    private  Show show;

    private Date BookedAt;

    //Booking->user (m:1)
    @ManyToOne
    private  User user;

    private Double amount;

}
