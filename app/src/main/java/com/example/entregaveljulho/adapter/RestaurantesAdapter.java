package com.example.entregaveljulho.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.entregaveljulho.interfaces.RestauranteListener;
import com.example.entregaveljulho.PratosRestaurantes;
import com.example.entregaveljulho.R;
import com.example.entregaveljulho.model.HomeRestaurantes;
import com.example.entregaveljulho.model.Restaurantes;

import java.util.ArrayList;
import java.util.List;

public class RestaurantesAdapter extends RecyclerView.Adapter<RestaurantesAdapter.ViewHolder>  {
    private List<Integer> listaRestaurantes;
    private RestauranteListener restauranteListener;


    public RestaurantesAdapter(List listaRestaurantes) {
        this.listaRestaurantes = listaRestaurantes;
        this.restauranteListener = restauranteListener;
    }






    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurante_componente,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        
           final Integer restaurante = listaRestaurantes.get(i);

            viewHolder.setupRestaurantes(restaurante);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



    }



    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }







    public  class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView restaurantesImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            restaurantesImageView =itemView.findViewById(R.id.restauranteImageView);

        }




        public void setupRestaurantes(Integer restaurante) {

            restaurantesImageView.setImageResource(restaurante);
    }
    }



    }



