package com.example.comupnsalazaroblitasfinal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comupnsalazaroblitasfinal.R;
import com.example.comupnsalazaroblitasfinal.clases.Duelista;

import java.util.List;

public class DuelistaAdapter extends RecyclerView.Adapter<DuelistaAdapter.DuelistaViewHolder>{
    private List<Duelista> items;
    private Context context;

    public DuelistaAdapter(List<Duelista> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public DuelistaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dualista_adapter, parent, false);
        DuelistaViewHolder viewHolder = new DuelistaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DuelistaViewHolder holder, int position) {
        Duelista item = items.get(position);
        View view = holder.itemView;

        // Obtiene la referencia del TextView para mostrar el nombre del Duelista
        TextView tvNombre = view.findViewById(R.id.tvNombre);

        // Establece el nombre del Duelista en el TextView
        tvNombre.setText(item.getNombre());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class DuelistaViewHolder extends RecyclerView.ViewHolder {

        public DuelistaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public void actualizarLista(List<Duelista> nuevaLista) {
        items.clear();
        items.addAll(nuevaLista);
        notifyDataSetChanged();
    }
}
