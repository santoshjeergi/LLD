package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
public @Data  class Screen extends BaseModel{

    private String name;

    //th->s (1:m)
    @ManyToOne
    private Theater theater;

    //sc->seat(1:m)
    @OneToMany(mappedBy = "screen")
    private List<Seat> seatList;

}
