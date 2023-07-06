package com.example.comupnsalazaroblitasfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.comupnsalazaroblitasfinal.clases.Duelista;
import com.example.comupnsalazaroblitasfinal.services.DuelistaService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarDuelistaActivity extends AppCompatActivity {

    private DuelistaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_duelista);

        RecyclerView rvLista = findViewById(R.id.rvListaDuelista);
        rvLista.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://6477a0a19233e82dd53bf49a.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DuelistaService service = retrofit.create(DuelistaService.class);
        Call<List<Duelista>> call = service.getAllDuelista();


        call.enqueue(new Callback<List<Duelista>>() {
            @Override
            public void onResponse(Call<List<Duelista>> call, Response<List<Duelista>> response) {
                Log.i("AM_APP", String.valueOf(response.code()));

                if (response.isSuccessful()) {
                    List<Duelista> duelistas = response.body();

                    Log.i("AM_APP", String.valueOf(duelistas.size()));
                    Log.i("AM_APP", new Gson().toJson(duelistas));

                    adapter = new DuelistaAdapter(duelistas, ListarDuelistaActivity.this);
                    rvLista.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Duelista>> call, Throwable t) {
                // Maneja el error de acuerdo a tus necesidades
            }
        });


    }
}