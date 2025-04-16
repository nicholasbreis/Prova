package com.example.projeto_prova;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Lista_Tarefas extends AppCompatActivity {

    RecyclerView rv_lista;
    List<String> listaTarefas = new ArrayList<>();
    TarefaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_tarefas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rv_lista = findViewById(R.id.recyclerView);

        String titulotarefa = getIntent().getStringExtra("Tarefa");
        String descricao = getIntent().getStringExtra("Descrição");
        String data = getIntent().getStringExtra("Data");

        Tarefa tarefa = new Tarefa(titulotarefa, descricao, data);
        List<Tarefa> listaTarefas = new ArrayList<>();
        listaTarefas.add(tarefa);


        adapter = new TarefaAdapter(listaTarefas);
        rv_lista.setLayoutManager(new LinearLayoutManager(this));
        rv_lista.setAdapter(adapter);
    }
}