package com.icon.agromwinda.UI.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Ville;
import com.icon.agromwinda.Data.repository.Controller;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.Adapter.ListProvinceAdapter;
import com.icon.agromwinda.UI.Adapter.ListVilleAdapter;
import com.icon.agromwinda.UI.dialog.WaitingDialog;

import java.util.List;

public class ListVilleActivity extends AppCompatActivity {

    private RecyclerView recycle_view_ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ville);
        bindUI();
        init();
    }

    public void bindUI() {

    }

    public void init() {
        setContentView(R.layout.activity_list_ville);
        new ListVilles().execute();
    }

    public void bindEvents() {

    }

    public class ListVilles extends AsyncTask<Void, Void, List<Ville>> {

        List<Ville> villes = null;
        private WaitingDialog waitingDialog = new WaitingDialog(ListVilleActivity.this);

        @Override
        protected void onPreExecute() {
            waitingDialog.show();
        }

        @Override
        protected List<Ville> doInBackground(Void... voids) {

            Controller.initDB(ListVilleActivity.this);
            villes = new Dao(ListVilleActivity.this).getVilles();
            return villes;
        }

        @Override
        protected void onPostExecute(List<Ville> villes) {

            if (villes != null) {
                waitingDialog.hide();
                ListVilleAdapter listVilleAdapter=new ListVilleAdapter(ListVilleActivity.this,villes,ListVilleActivity.this);
                listVilleAdapter.notifyDataSetChanged();

                recycle_view_ville = findViewById(R.id.recycle_view_ville);
                recycle_view_ville.setLayoutManager(new LinearLayoutManager(ListVilleActivity.this));
                recycle_view_ville.setHasFixedSize(true);
                recycle_view_ville.setAdapter(listVilleAdapter);
            }
        }
    }
}

