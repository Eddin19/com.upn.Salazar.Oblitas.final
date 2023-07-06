package com.example.comupnsalazaroblitasfinal.services;

import com.example.comupnsalazaroblitasfinal.clases.Duelista;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DuelistaService {
    @GET("duelistas")
    Call<List<Duelista>> getAllDuelista();

    @GET("duelistas/{id}")
    Call<Duelista> findUser(@Path("id") int id);

    @POST("duelistas")
    Call<Duelista> createDuelista(@Body Duelista duelista);
}
