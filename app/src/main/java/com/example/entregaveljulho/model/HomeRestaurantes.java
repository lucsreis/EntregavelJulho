package com.example.entregaveljulho.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;


import com.example.entregaveljulho.Perfil;
import com.example.entregaveljulho.PratosRestaurantes;
import com.example.entregaveljulho.R;
import com.example.entregaveljulho.adapter.RestaurantesAdapter;
import com.example.entregaveljulho.interfaces.RestauranteListener;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import android.view.Menu;
import android.widget.ImageView;

public class HomeRestaurantes extends AppCompatActivity implements RestauranteListener {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_restaurantes);


            RecyclerView recyclerView;

            List<Integer> listaRestaurantes = new ArrayList<>();

            listaRestaurantes.add(R.drawable.restaurante1);
            listaRestaurantes.add(R.drawable.restaurante2);
            listaRestaurantes.add(R.drawable.restaurante3);
            listaRestaurantes.add(R.drawable.restaurante2);
            listaRestaurantes.add(R.drawable.restaurante3);


            RestaurantesAdapter restaurantesAdapter = new RestaurantesAdapter(listaRestaurantes);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);


            recyclerView = findViewById(R.id.recycler_id);
            recyclerView.setAdapter(restaurantesAdapter);
            recyclerView.setLayoutManager(linearLayoutManager);




        }



        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return true;



        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();

            if (id == R.id.settings){
                irParaPerfil();

                return true;
            }



            return super.onOptionsItemSelected(item);


        }

        private void irParaPerfil (){

            Intent intent = new Intent(this, Perfil.class);
            startActivity(intent);





        }


    private void irParaPratos (){

        Intent intent = new Intent(this, PratosRestaurantes.class);
        startActivity(intent);





    }





        @Override
        public void onPointerCaptureChanged(boolean hasCapture) {

        }

    @Override
    public void onRestauranteClicado(Integer restaurante) {

    }
}
