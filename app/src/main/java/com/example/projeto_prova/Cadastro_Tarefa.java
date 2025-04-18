package com.example.projeto_prova;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastro_Tarefa extends AppCompatActivity {

    EditText cadastrarTarefa, descricao, data, prioridade;
    Button salvar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_tarefa);


        ScrollView scrollView = findViewById(R.id.scrollView);
        ViewCompat.setOnApplyWindowInsetsListener(scrollView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        cadastrarTarefa = findViewById(R.id.editTarefa);
        descricao = findViewById(R.id.editDescricao);
        data = findViewById(R.id.editData);
        prioridade = findViewById(R.id.editPrioridade);
        salvar = findViewById(R.id.btnSalvar);


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tarefaStr = cadastrarTarefa.getText().toString();
                String descricaoStr = descricao.getText().toString();
                String dataStr = data.getText().toString();
                String prioridadeStr = prioridade.getText().toString();


                Tarefa novaTarefa = new Tarefa(tarefaStr, descricaoStr, dataStr, prioridadeStr);

                ArmazenarTarefa.listaTarefas.add(novaTarefa);

                Intent intent = new Intent(Cadastro_Tarefa.this, Lista_Tarefas.class);
                startActivity(intent);
            }
        });
    }

    // Método para voltar ao menu principal
    public void TelaPrincipal(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
