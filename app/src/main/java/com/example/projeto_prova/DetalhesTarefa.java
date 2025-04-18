package com.example.projeto_prova;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesTarefa extends AppCompatActivity {

    TextView titulo, descricao, data, prioridade;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_tarefa);

        titulo = findViewById(R.id.tituloDetalhe);
        descricao = findViewById(R.id.descricaoDetalhe);
        data = findViewById(R.id.dataDetalhe);
        prioridade = findViewById(R.id.prioridadeDetalhe);

        Tarefa tarefa = getIntent().getParcelableExtra("tarefa");

        if (tarefa != null) {
            titulo.setText("Título: " + tarefa.getTitulo());
            descricao.setText("Descrição: " + tarefa.getDescricao());
            data.setText("Data: " + tarefa.getData());
            prioridade.setText("Prioridade: " + tarefa.getPrioridade());
        }
    }
}
