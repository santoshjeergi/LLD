package com.example.bms.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity

public @Data class Region extends BaseModel{

   private String name;

   private Double lat;

   private Double longitude;

   @OneToMany(mappedBy = "region")
   List<Theater>  theaterList;

}
