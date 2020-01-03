package com.icon.agromwinda.UI.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.icon.agromwinda.Data.model.Town;
import com.icon.agromwinda.Data.repository.Controller;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
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

    public class ListVilles extends AsyncTask<Void, Void, List<Town>> {

        List<Town> towns = null;
        private WaitingDialog waitingDialog = new WaitingDialog(ListVilleActivity.this);

        @Override
        protected void onPreExecute() {
            waitingDialog.show();
        }

        @Override
        protected List<Town> doInBackground(Void... voids) {

            Controller.initDB(ListVilleActivity.this);
            towns = new Dao(ListVilleActivity.this).getTowns();
            return towns;
        }

        @Override
        protected void onPostExecute(List<Town> towns) {

            if (towns != null) {
                waitingDialog.hide();
                ListVilleAdapter listVilleAdapter=new ListVilleAdapter(ListVilleActivity.this, towns,ListVilleActivity.this);
                listVilleAdapter.notifyDataSetChanged();

                recycle_view_ville = findViewById(R.id.recycle_view_ville);
                recycle_view_ville.setLayoutManager(new LinearLayoutManager(ListVilleActivity.this));
                recycle_view_ville.setHasFixedSize(true);
                recycle_view_ville.setAdapter(listVilleAdapter);
            }
        }
    }
}

