package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Theater extends BaseModel{

    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "region_id") //Not clear??/
    private Region region;

}
