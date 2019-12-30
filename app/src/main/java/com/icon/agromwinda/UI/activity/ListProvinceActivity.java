package com.icon.agromwinda.UI.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.dialog.WaitingDialog;

import java.util.List;

public class ListProvinceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_province);

        new ListProvinces().execute();

    }

    public class ListProvinces extends AsyncTask<Void, Void, String> {

        private WaitingDialog waitingDialog = new WaitingDialog(ListProvinceActivity.this);

        @Override
        protected void onPreExecute() {
            waitingDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {

            List<Province> provinces = new Dao(ListProvinceActivity.this).getProvinces();

            for(Province p:provinces){
                Log.d("ProvinceResult",p.getNom());
            }

            return null;
        }
    }
}
