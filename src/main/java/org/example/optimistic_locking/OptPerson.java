package org.example.optimistic_locking;


import jakarta.persistence.*;

@Entity
public class OptPerson {

    @Version
    private int version;

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public OptPerson(String name) {
        this.name = name;
    }

    public OptPerson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

