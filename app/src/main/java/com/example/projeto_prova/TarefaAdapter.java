package com.example.projeto_prova;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.ViewHolder> {

    List<Tarefa> tarefas;

    public TarefaAdapter(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tituloView, descricaoView, dataView;
        Button btnDetalhes;

        public ViewHolder(View itemView) {
            super(itemView);
            tituloView = itemView.findViewById(R.id.tituloView);
            descricaoView = itemView.findViewById(R.id.descricaoView);
            dataView = itemView.findViewById(R.id.dataView);
            btnDetalhes = itemView.findViewById(R.id.btnDetalhes);
        }
    }

    @NonNull
    @Override
    public TarefaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarefa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tarefa tarefa = tarefas.get(position);
        holder.tituloView.setText(tarefa.getTitulo());
        holder.descricaoView.setText(tarefa.getDescricao());
        holder.dataView.setText(tarefa.getData());

        holder.btnDetalhes.setOnClickListener(view -> {
            Context context = view.getContext();
            Intent intent = new Intent(context, DetalhesTarefa.class);
            intent.putExtra("tarefa", tarefa);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }
}
