package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "bmsuser")
@NoArgsConstructor
public @Data class User {

    @Id
            @GeneratedValue(strategy =  GenerationType.AUTO)

    private long id;

    String name;
    String email;

    public User(String name, String email) {
        this.email = email;
        this.name = name;
    }
}
