package com.icon.agromwinda.UI.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.fragment.TypeActivityFragment;

public class AjouActivite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoute_activ);


        String subscriber_id = getIntent().getExtras().get("subscriber_id").toString();

        Log.d("ADDACTIVITYFOR2", "id2:::" + subscriber_id);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        TypeActivityFragment typeActivityFragment = TypeActivityFragment.newInstance(subscriber_id);
        typeActivityFragment.setSubscriber(Long.parseLong(subscriber_id));
        transaction.add(R.id.fragment_contenta, typeActivityFragment);
        transaction.commit();

    }
}
