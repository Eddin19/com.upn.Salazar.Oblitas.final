package com.example.comupnsalazaroblitasfinal.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comupnsalazaroblitasfinal.clases.Duelista;

import java.util.List;

public class DuelistaAdapter extends RecyclerView.Adapter{
    private List<Duelista> items;
    private Context context;

    public DuelistaAdapter(List<Duelista> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
