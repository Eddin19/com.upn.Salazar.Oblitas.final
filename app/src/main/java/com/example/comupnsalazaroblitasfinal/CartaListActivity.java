package com.example.comupnsalazaroblitasfinal;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comupnsalazaroblitasfinal.adapters.CartaAdapter;
import com.example.comupnsalazaroblitasfinal.clases.Carta;
import com.example.comupnsalazaroblitasfinal.db.AppDatabase;
import com.example.comupnsalazaroblitasfinal.services.CartaRepository;
import com.google.gson.Gson;

import java.util.List;

public class CartaListActivity extends AppCompatActivity {
    RecyclerView rvListaCarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_list);
        int idObtener;
        idObtener = getIntent().getIntExtra("id2",0);
        Log.d("APP_MAIN: idListM", String.valueOf(idObtener));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvListaCarta = findViewById(R.id.rvListaCarta);
        rvListaCarta.setLayoutManager(layoutManager);
        LoadingDBMovimiento(idObtener);
    }

    private void LoadingDBMovimiento(int idObtenido) {
        AppDatabase db = AppDatabase.getInstance(this);
        CartaRepository repository = db.cartaRepository();
        List<Carta> mdataCarta = repository.searchCartaID(idObtenido);
        CartaAdapter mAdapter = new CartaAdapter(mdataCarta);
        rvListaCarta.setAdapter(mAdapter);
        Log.i("MAIN_APP: DBMovi", new Gson().toJson(mdataCarta));

    }
}