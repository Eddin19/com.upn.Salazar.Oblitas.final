package com.example.comupnsalazaroblitasfinal.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comupnsalazaroblitasfinal.DuelistaDetallesActivity;
import com.example.comupnsalazaroblitasfinal.R;
import com.example.comupnsalazaroblitasfinal.clases.Duelista;
import java.util.List;

public class DuelistaAdapter extends RecyclerView.Adapter {
    private List<Duelista> items;
    public DuelistaAdapter(List<Duelista> items){
        this.items = items;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_duelista,parent,false);
        NameViewHolder viewHolder = new NameViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Duelista item = items.get(position);
        View view = holder.itemView;
        TextView tvDuelistaListar = view.findViewById(R.id.tvDuelistaListar);
        tvDuelistaListar.setText(item.nameDuelista);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DuelistaDetallesActivity.class);
                intent.putExtra("id",item.id);
                v.getContext().startActivity(intent);
                Log.d("APP_MAIN: IDDuelista", String.valueOf(item.id));
            }
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public class NameViewHolder extends RecyclerView.ViewHolder {
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
