package com.icon.agromwinda.UI.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.fragment.FormSavePerson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.fragment_content,new FormSavePerson());
        transaction.commit();
    }
}
