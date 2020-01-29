package com.icon.agromwinda.UI.activity;

import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.icon.agromwinda.R;

public class ActivityAdressePhysiqueActivite extends AppCompatActivity {

/**
    private Spinner sp;
    private  Button btngo;
    String list_typeAct[] ={"Commerce","Agriculture", "Transport"};
    ArrayAdapter<String> adapter;
 */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adresse_physique_activite);
/**
        sp= (Spinner)findViewById(R.id.spchoix);
        Button btngo = (Button)findViewById(R.id.btngo);

        adapter= new ArrayAdapter<String>(this,android.R.layout.activity_list_item, list_typeAct);

        View display_data = (TextView) findViewById(R.id.txtaffi);
        
        sp.setAdapter(adapter);

        sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                }

            }
        });
        
        */




    }
}
