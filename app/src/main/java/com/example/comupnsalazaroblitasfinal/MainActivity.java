package com.example.comupnsalazaroblitasfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCrear = this.findViewById(R.id.btnCrearDuelista);
        Button btnContactos = this.findViewById(R.id.btnListarDuelistas);

        btnCrear.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CrearDuelistaActivity.class);
            startActivity(intent);
        });

        btnContactos.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ListarDuelistaActivity.class);
            startActivity(intent);
        });
    }
}