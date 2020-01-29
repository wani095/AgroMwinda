package com.icon.agromwinda.Splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.icon.agromwinda.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread chrono = new Thread() {
            @Override
            public void run(){
                try {
                    sleep(2000);

                } catch (InterruptedException e){

                    e.printStackTrace();

                } finally {
                    Intent i = new Intent(".ACCUEILAPP");
                    startActivity(i);

                }
            }
        };
        chrono.start();

    }
    @Override
    protected void onPause (){
        super.onPause();
        finish();
    }
}
