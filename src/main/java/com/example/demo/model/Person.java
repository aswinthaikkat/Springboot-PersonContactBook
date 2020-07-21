/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 *
 * @author aswin
 */
public class Person {
    private String name;
    private UUID id;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

   
    public Person( @JsonProperty("id") UUID id,
            @JsonProperty("name") String name) {
        this.name = name;
        this.id = id;
    }
    
    
}
