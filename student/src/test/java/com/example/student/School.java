package com.example.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
public class School {
    private static Integer nextId = 1;
    private static volatile Integer volatileId= 1;
    private Integer id = 1;
    private String name;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNextId() {
        return nextId;
    }
    public Integer getVolatileId(){
        return volatileId;
    }

    public School(){
        nextId++;
        volatileId++;
    }
}
