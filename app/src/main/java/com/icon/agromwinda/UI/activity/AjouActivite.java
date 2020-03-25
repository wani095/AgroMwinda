package com.icon.agromwinda.UI.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.fragment.FormSavePerson;
import com.icon.agromwinda.UI.fragment.TypeActivityFragment;

public class AjouActivite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoute_activ);

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.fragment_contenta,new TypeActivityFragment ());
        transaction.commit();

    }
}
