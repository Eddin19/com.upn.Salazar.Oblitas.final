package com.example.comupnsalazaroblitasfinal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comupnsalazaroblitasfinal.clases.Carta;
import com.example.comupnsalazaroblitasfinal.clases.Duelista;
import com.example.comupnsalazaroblitasfinal.db.AppDatabase;
import com.example.comupnsalazaroblitasfinal.services.CartaRepository;
import com.example.comupnsalazaroblitasfinal.services.CartaService;
import com.example.comupnsalazaroblitasfinal.services.DuelistaRepository;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DuelistaDetallesActivity extends AppCompatActivity {

    TextView tvNroDetalles;
    TextView tvNameDetalles;
    Button btDetalleRegistrarDue;
    Button btListarDue;
    Retrofit mRetrofit;
    String urlImage = "";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duelista_detalles);
        mRetrofit = RetrofitBuilder.build();
        tvNroDetalles  = findViewById(R.id.tvNroDetalles);
        tvNameDetalles = findViewById(R.id.tvNameDetalles);
        btDetalleRegistrarDue  = findViewById(R.id.btDetalleRegistrarDue);
        btListarDue     = findViewById(R.id.btListarDue);
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        DuelistaRepository repositoryD = db.duelistaRepository();
        CartaRepository repositoryC = db.cartaRepository();
        int idObtener;
        idObtener = getIntent().getIntExtra("id",0);
        Duelista duelista = repositoryD.searchDuelistaID(idObtener);
        tvNroDetalles.setText(String.valueOf(duelista.id));
        tvNameDetalles.setText(duelista.nameDuelista);
        btDetalleRegistrarDue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CartasRegistrarActivity.class);
                intent.putExtra("id", idObtener);
                Log.i("APP_MAIN: id", String.valueOf(idObtener));
                startActivity(intent);
            }
        });
        btListarDue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CartaListActivity.class);
                intent.putExtra("id2", idObtener);
                Log.i("APP_MAIN: id2", String.valueOf(idObtener));
                startActivity(intent);
            }
        });
        CartaService serviceM = mRetrofit.create(CartaService.class);
        if (isNetworkConnected()) {
                    List<Carta> SinSincroCarta = repositoryC.searchCarta(false);
                    for (Carta carta : SinSincroCarta) {
                        carta.sincronizadoCartas = true;
                        repositoryC.updateCartas(carta);
                        SincronizacionCarta(serviceM,carta);
                    }
                    List<Carta> EliminarDBMovimiento = repositoryC.getAllCarta();
                    downloadingMockAPICarta(serviceM,repositoryC,EliminarDBMovimiento);
                }else {
                }
   }
    private void SincronizacionCarta(CartaService cartaService, Carta carta) {
        Call<Carta> call = cartaService.create(carta);
        call.enqueue(new Callback<Carta>() {
            @Override
            public void onResponse(Call<Carta> call, Response<Carta> response) {
                if(response.isSuccessful()){
                    Carta data = response.body();
                    Log.i("MAIN_APP: MovMockAPI", new Gson().toJson(data));
                }
            }
            @Override
            public void onFailure(Call<Carta> call, Throwable t) {
            }
        });
    }
    private void downloadingMockAPICarta(CartaService cartaService, CartaRepository cartaRepository, List<Carta> eliminarDBCarta) {
        cartaRepository.deleteList(eliminarDBCarta);
        Call<List<Carta>> call = cartaService.getAllUser();
        call.enqueue(new Callback<List<Carta>>() {
            @Override
            public void onResponse(Call<List<Carta>> call, Response<List<Carta>> response) {
                List<Carta> data = response.body();
                for (Carta carta : data) {
                    cartaRepository.createCarta(carta);
                }
            }
            @Override
            public void onFailure(Call<List<Carta>> call, Throwable t) {
            }
        });
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}