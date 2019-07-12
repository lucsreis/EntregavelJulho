package com.example.entregaveljulho.model;

import android.widget.ImageView;

import java.io.Serializable;

public class Restaurantes implements Serializable {



    private int imagemRestaurante;

    public int getImagemrestaurante() {
        return imagemRestaurante;
    }

    public void setImagemrestaurante(int imagemrestaurante) {
        this.imagemRestaurante = imagemrestaurante;
    }

    public Restaurantes(int imagemRestaurante) {

        this.imagemRestaurante = imagemRestaurante;
    }

}
