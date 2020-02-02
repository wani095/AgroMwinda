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

public class AjouActivite extends AppCompatActivity {
    private Button btnret;
    private Button btnnext;
    private Spinner spTypeA;
    private ScrollView pan_commerce, pan_agriculture, pan_transport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmente_form_save_activity);
        bindUI();
        bindEvents();

    }

    public void bindUI() {
        spTypeA = (Spinner) findViewById(R.id.spTypeA);
        pan_agriculture = findViewById(R.id.pan_agriculture);
        pan_commerce = findViewById(R.id.pan_commerce);
        pan_transport = findViewById(R.id.pan_transport);
    }

    public void bindEvents() {
        Log.d("SelectedACTIVITY", "");

        spTypeA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (BuildConfig.DEBUG)
                    Log.d("SelectedACTIVITY", spTypeA.getSelectedItem().toString());

                switch (spTypeA.getSelectedItem().toString()) {
                    case "Commerce": {
                        pan_agriculture.setVisibility(View.GONE);
                        pan_transport.setVisibility(View.GONE);
                        pan_commerce.setVisibility(View.VISIBLE);
                        break;
                    }

                    case "Agriculture": {
                        pan_agriculture.setVisibility(View.VISIBLE);
                        pan_transport.setVisibility(View.GONE);
                        pan_commerce.setVisibility(View.GONE);
                        break;
                    }

                    case "Transport": {
                        pan_agriculture.setVisibility(View.GONE);
                        pan_transport.setVisibility(View.VISIBLE);
                        pan_commerce.setVisibility(View.GONE);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btnnext = (Button) findViewById(R.id.btnnext);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AjouActivite.this, ActivityAdressePhysiqueActivite.class));
            }
        });

        Button btnret = (Button) findViewById(R.id.btnret);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AjouActivite.this, DetailSubscriberActivity.class));
            }
        });
    }
}
