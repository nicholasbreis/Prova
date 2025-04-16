package com.example.projeto_prova;

public class Tarefa {
    private String titulo;
    private String descricao;
    private String data;

    public Tarefa(String titulo, String descricao, String data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }
}
