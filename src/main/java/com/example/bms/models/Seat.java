package com.example.bms.models;

import jakarta.persistence.*;

@Entity
public class Seat extends BaseModel{

    @Column(name = "seat_number")
    private int number;

    @Enumerated(value = EnumType.STRING)
    private SeatType type;


    private char row;

    private int column;

    //screen-seat 1:m

    @ManyToOne
    private Screen screen;
}
