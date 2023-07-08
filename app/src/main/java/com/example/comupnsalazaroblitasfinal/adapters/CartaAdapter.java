package com.example.comupnsalazaroblitasfinal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comupnsalazaroblitasfinal.R;
import com.example.comupnsalazaroblitasfinal.clases.Carta;

import java.util.List;

public class CartaAdapter extends RecyclerView.Adapter{
    private List<Carta> items;

    public CartaAdapter(List<Carta> items){
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_carta,parent,false);
        NameViewHolder viewHolder = new NameViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Carta item = items.get(position);
        View view = holder.itemView;
        TextView tvNombreDetallesCart = view.findViewById(R.id.tvNombreDetallesCart);
        TextView tvAtaqueDetallesCart = view.findViewById(R.id.tvAtaqueDetallesCart);
        TextView tvDefenzaDetallesMov = view.findViewById(R.id.tvDefenzaDetallesMov);
        TextView tvLatitudDetCart = view.findViewById(R.id.tvLatitudDetCart);
        TextView tvLongitudDetCart = view.findViewById(R.id.tvLongitudDetCart);
        ImageView ivImagenItemCart = view.findViewById(R.id.ivImagenItemCart);
        tvNombreDetallesCart.setText(item.nameCarta);
        tvAtaqueDetallesCart.setText(String.valueOf(item.puntosAtaque));
        tvDefenzaDetallesMov.setText(String.valueOf(item.puntosDefenza));
        tvLatitudDetCart.setText(item.latitud);
        tvLongitudDetCart.setText(item.longitud);
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
