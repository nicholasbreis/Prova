package com.example.projeto_prova;

import android.os.Parcel;
import android.os.Parcelable;

public class Tarefa implements Parcelable {
    private String titulo;
    private String descricao;
    private String data;
    private String prioridade;

    public Tarefa(String titulo, String descricao, String data, String prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.prioridade = prioridade;
    }

    protected Tarefa(Parcel in) {
        titulo = in.readString();
        descricao = in.readString();
        data = in.readString();
        prioridade = in.readString();
    }

    public static final Creator<Tarefa> CREATOR = new Creator<Tarefa>() {
        @Override
        public Tarefa createFromParcel(Parcel in) {
            return new Tarefa(in);
        }

        @Override
        public Tarefa[] newArray(int size) {
            return new Tarefa[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getPrioridade() {
        return prioridade;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeString(descricao);
        parcel.writeString(data);
        parcel.writeString(prioridade);
    }
}
