package com.example.comupnsalazaroblitasfinal.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.comupnsalazaroblitasfinal.clases.Carta;
import com.example.comupnsalazaroblitasfinal.clases.Duelista;
import com.example.comupnsalazaroblitasfinal.services.CartaRepository;
import com.example.comupnsalazaroblitasfinal.services.DuelistaRepository;

@Database(entities = {Duelista.class, Carta.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

        public abstract DuelistaRepository duelistaRepository();
        public abstract CartaRepository cartaRepository();

        public static AppDatabase getInstance(Context context){
            return Room.databaseBuilder(context,AppDatabase.class, "VideojuegosFinal")
                    .allowMainThreadQueries()
                    .build();
        }
}
