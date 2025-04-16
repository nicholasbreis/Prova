package com.example.projeto_prova;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastro_Tarefa extends AppCompatActivity {

    EditText cadastrarTarefa, descricao, data;
    Button salvar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_tarefa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cadastrarTarefa = findViewById(R.id.editTarefa);
        descricao = findViewById(R.id.editDescricao);
        data = findViewById(R.id.editData);
        salvar = findViewById(R.id.btnSalvar);


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tarefaStr = cadastrarTarefa.getText().toString();
                String descricaoStr = descricao.getText().toString();
                String dataStr = data.getText().toString();
                Intent intent = new Intent(Cadastro_Tarefa.this, Lista_Tarefas.class);
                intent.putExtra("Tarefa",tarefaStr);
                intent.putExtra("Descrição",descricaoStr);
                intent.putExtra("Data",dataStr);
                startActivity(intent);
            }


        });
    }
    public void TelaPrincipal(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}