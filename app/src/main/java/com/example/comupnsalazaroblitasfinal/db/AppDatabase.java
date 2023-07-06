package com.example.comupnsalazaroblitasfinal.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.comupnsalazaroblitasfinal.services.CartaDao;
import com.example.comupnsalazaroblitasfinal.services.DuelistaDao;

public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract DuelistaDao cuentaDao();
    public abstract CartaDao movimientoDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
