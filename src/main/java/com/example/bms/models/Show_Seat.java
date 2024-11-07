package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
public @Data class Show_Seat extends BaseModel{

    @ManyToOne //ss->show(1 :1)
    private Show show;

    //ss->seat m ->1
    @ManyToOne
    private Seat seat;

    private int price;


    private SeatStatus seatStatus;
}
