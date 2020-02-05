package com.icon.agromwinda.UI.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.icon.agromwinda.BuildConfig;
import com.icon.agromwinda.R;

public class ActivityAdressePhysiqueActivite extends AppCompatActivity {


    private Spinner spchoixA;
    private ScrollView pan_urbain, pan_rural;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adresse_physique_activite);
        bindUI();
        bindEvents();

    }

    public void bindUI() {
        spchoixA = (Spinner) findViewById(R.id.spchoixA);
        pan_urbain = findViewById(R.id.pan_urbain);
        pan_rural = findViewById(R.id.pan_rural);

    }

    public void bindEvents() {
        Log.d("SelectedACTIVITY", "");

        spchoixA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (BuildConfig.DEBUG)
                    Log.d("SelectedACTIVITY", spchoixA.getSelectedItem().toString());

                switch (spchoixA.getSelectedItem().toString()) {
                    case "Urbain": {
                        pan_rural.setVisibility(View.GONE);
                        pan_urbain.setVisibility(View.VISIBLE);
                        break;
                    }

                    case "Rural": {
                        pan_rural.setVisibility(View.VISIBLE);
                        pan_urbain.setVisibility(View.GONE);
                        break;
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}