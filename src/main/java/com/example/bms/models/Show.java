package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
public @Data class Show extends BaseModel{


    private Date startTime;
    private Date endTime;

    //show->screen(m:1)
    @ManyToOne
    private Screen  screen;

    //show - movie(m:1)
    @ManyToOne
    private Movie movie;

}
