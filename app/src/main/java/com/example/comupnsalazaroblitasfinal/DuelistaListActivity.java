package com.example.comupnsalazaroblitasfinal;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comupnsalazaroblitasfinal.adapters.DuelistaAdapter;
import com.example.comupnsalazaroblitasfinal.clases.Duelista;
import com.example.comupnsalazaroblitasfinal.db.AppDatabase;
import com.example.comupnsalazaroblitasfinal.services.DuelistaRepository;
import com.google.gson.Gson;

import java.util.List;
public class DuelistaListActivity extends AppCompatActivity {
    RecyclerView rvListaDuelista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelista_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvListaDuelista = findViewById(R.id.rvListaDuelista);
        rvListaDuelista.setLayoutManager(layoutManager);
        LoadingDBCuenta();
    }
    private void LoadingDBCuenta() {
        AppDatabase db = AppDatabase.getInstance(this);
        DuelistaRepository repository = db.duelistaRepository();
        List<Duelista> mdataDuelista = repository.getAllDuelista();
        DuelistaAdapter mAdapter = new DuelistaAdapter(mdataDuelista);
        rvListaDuelista.setAdapter(mAdapter);
        Log.i("MAIN_APP: DB", new Gson().toJson(mdataDuelista));
    }
}