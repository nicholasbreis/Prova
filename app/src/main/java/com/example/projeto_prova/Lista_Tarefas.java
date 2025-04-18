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

    private RecyclerView rv_lista;
    private TarefaAdapter adapter;
    private List<Tarefa> listaTarefas;

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

        // aqui vai iniciar o RecyclerView
        rv_lista = findViewById(R.id.recyclerView);
        rv_lista.setLayoutManager(new LinearLayoutManager(this));

        String titulo = getIntent().getStringExtra("Tarefa");
        String descricao = getIntent().getStringExtra("Descrição");
        String data = getIntent().getStringExtra("Data");
        String prioridade = getIntent().getStringExtra("Prioridade"); // novo campo

        // cria a lista e insere a tarefa no item
        listaTarefas = new ArrayList<>();
        Tarefa tarefa = new Tarefa(titulo, descricao, data, prioridade);
        listaTarefas.add(tarefa);

        // aqui a gente cria o Adapter, basicamente ele faz a ponte entre os dados e a interface gráfica. O Adapter "coloca" os dados dentro de cada item da lista.
        adapter = new TarefaAdapter(ArmazenarTarefa.listaTarefas);
        rv_lista.setAdapter(adapter);
    }
}
