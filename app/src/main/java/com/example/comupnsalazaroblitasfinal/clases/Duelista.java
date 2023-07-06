package com.example.comupnsalazaroblitasfinal.clases;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "duelistas")
public class Duelista {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nombre;
    @Ignore
    private List<Carta> cartas;

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
