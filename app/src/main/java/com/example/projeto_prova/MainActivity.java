package com.example.projeto_prova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastro;
    private Button btnLista;
    private Button btnLink;
    private Button btnAnalise;
    private Button btnSobre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCadastro = findViewById(R.id.btnCadastro);
        btnLista = findViewById(R.id.btnLista);
        btnLink = findViewById(R.id.btnLink);
        btnAnalise = findViewById(R.id.btnAnalise);
        btnSobre = findViewById(R.id.btnSobre);

    }

    public void TelaCadastro(View v) {
        Intent i = new Intent(this, Cadastro_Tarefa.class);
        startActivity(i);
    }

    public void TelaTarefas(View v) {
        Intent i = new Intent(this,Lista_Tarefas.class);
        startActivity(i);
    }

    public void TelaAnalise(View v) {
        Intent i = new Intent(this, Analise_Inteligente.class);
        startActivity(i);
    }

    public void TelaSobre(View v) {
        Intent i = new Intent(this,Sobre.class);
        startActivity(i);
    }

}