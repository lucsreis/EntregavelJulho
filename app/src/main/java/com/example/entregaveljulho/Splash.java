package com.example.entregaveljulho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       new Timer().schedule(new TimerTask() {
           @Override
           public void run() {
            irParaLogin();
           }
       }, 3000);



    }


    private void irParaLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
