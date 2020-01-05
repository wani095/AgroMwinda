package com.icon.agromwinda.UI.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.icon.agromwinda.R;

public class AccueilApp extends AppCompatActivity {

    private Button btajout, btnList;
    private Button bntplat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_app);

        Button btajout =(Button)findViewById(R.id.btajout);

        btajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(AccueilApp.this, MainActivity.class));
            }
        });

        Button btnlist = (Button)findViewById(R.id.btnList);

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccueilApp.this, ListingActivity.class));
            }
        });

        Button bntplat =(Button)findViewById(R.id.btnplat);

        bntplat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccueilApp.this, PLatForme.class));
            }
        });
    }
}
