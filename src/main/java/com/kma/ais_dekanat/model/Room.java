package com.kma.ais_dekanat.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Room {
    private Integer roomId;
    private String name;
    private Set<FinalTest> finalTests;

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "room")
    public Set<FinalTest> getFinalTests() {
        return finalTests;
    }

    public void setFinalTests(Set<FinalTest> finalTests) {
        this.finalTests = finalTests;
    }
}
