package com.example.bms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
public class Movie extends BaseModel{

   private String name;
   private String language;
   private int duration;

   @Column(nullable = true)
   private Double rating;

   private String category;

}
