package com.example.comupnsalazaroblitasfinal.clases;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Duelista {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nombre;

    // Constructor
    public Duelista(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
