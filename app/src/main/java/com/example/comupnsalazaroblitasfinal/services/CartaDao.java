package com.example.comupnsalazaroblitasfinal.services;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.comupnsalazaroblitasfinal.clases.Carta;

import java.util.List;

@Dao
public interface CartaDao {
    @Query("SELECT * FROM cartas WHERE duelistaId = :duelistaId")
    List<Carta> getCartasByDuelistaId(long duelistaId);

    @Insert
    void insertCarta(Carta carta);
}
