package com.icon.agromwinda.UI.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.icon.agromwinda.R;

public class AjouActivite extends AppCompatActivity {
    private Button btnret;
    private Button btnnext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmente_form_save_activity);

        Button btnnext = (Button)findViewById(R.id.btnnext);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AjouActivite.this,ActivityAdressePhysiqueActivite.class));
            }
        });

        Button btnret = (Button)findViewById(R.id.btnret);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AjouActivite.this, DetailSubscriberActivity.class));
            }
        });



    }
}
