package com.formation.model;

import java.util.Date;

public class Fruit {
    // Attributs
    private long id;
    private String name;
    private Date expirationDate;

    // Un constructeur
    public Fruit(long id, String name, Date expirationDate) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
