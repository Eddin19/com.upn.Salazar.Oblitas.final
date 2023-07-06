package com.example.comupnsalazaroblitasfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.comupnsalazaroblitasfinal.adapters.DuelistaAdapter;
import com.example.comupnsalazaroblitasfinal.clases.Duelista;

import java.util.ArrayList;
import java.util.List;

public class CrearDuelistaActivity extends AppCompatActivity {

    private DuelistaAdapter adapter;
    private List<Duelista> duelistaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_duelista);

        // Obtén la referencia de los elementos de la vista
        EditText etNombre = findViewById(R.id.etNombre);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        // Inicializa la lista de Duelistas
        duelistaList = new ArrayList<>();

        // Crea una instancia del adaptador DuelistaAdapter
        adapter = new DuelistaAdapter(duelistaList, this);

        // Configura el RecyclerView con el adaptador
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Maneja el clic en el botón Guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el nombre ingresado por el usuario
                String nombre = etNombre.getText().toString();

                // Crea una instancia de Duelista con el nombre ingresado
                Duelista duelista = new Duelista(nombre);

                // Agrega el Duelista a la lista
                duelistaList.add(duelista);

                // Notifica al adaptador que se ha agregado un nuevo Duelista
                adapter.notifyDataSetChanged();
            }
        });
    }
}
