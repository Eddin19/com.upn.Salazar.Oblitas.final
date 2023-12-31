package com.example.comupnsalazaroblitasfinal.services;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.comupnsalazaroblitasfinal.clases.Carta;

import java.util.List;

@Dao
public interface CartaDao {
    @Query("SELECT * FROM cartas")
    List<Carta> getAllCarta();

    @Query("SELECT * FROM cartas WHERE sincronizadoCartas = :searchSincro")
    List<Carta> searchCarta(boolean searchSincro);

    @Query("SELECT * FROM cartas WHERE duelistaID = :id")
    List<Carta> searchCartaID(int id);

    @Insert
    void createCarta(Carta carta);

    @Insert
    void AgregarListaCartas(List<Carta> cartas);

    @Update
    void updateCartas(Carta carta);
}
