package com.kma.ais_dekanat.model;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class TestUser {
    @Id
    private int id;
    private String name;
}
