package com.example.comupnsalazaroblitasfinal.services;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.comupnsalazaroblitasfinal.clases.Duelista;

import java.util.List;

public interface DuelistaDao {
    @Insert
    void insert(Duelista duelista);

    @Query("SELECT * FROM duelistas")
    List<Duelista> getAllDuelistas();
}
