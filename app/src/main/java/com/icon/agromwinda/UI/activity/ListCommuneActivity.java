package com.icon.agromwinda.UI.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.repository.Controller;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.Adapter.ListCommuneAdapter;
import com.icon.agromwinda.UI.Adapter.ListProvinceAdapter;
import com.icon.agromwinda.UI.dialog.WaitingDialog;

import java.util.List;

public class ListCommuneActivity extends AppCompatActivity {

    private RecyclerView recycle_view_communes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_commune);
        bindUI();
        init();
    }

    public void bindUI() {

    }

    public void init() {
        setContentView(R.layout.activity_list_commune);
        new ListCommunes().execute();
    }

    public void bindEvents() {

    }

    public class ListCommunes extends AsyncTask<Void, Void, List<Commune>> {

        List<Commune> communes = null;
        private WaitingDialog waitingDialog = new WaitingDialog(ListCommuneActivity.this);

        @Override
        protected void onPreExecute() {
            waitingDialog.show();
        }

        @Override
        protected List<Commune> doInBackground(Void... voids) {

            Controller.initDB(ListCommuneActivity.this);
            communes = new Dao(ListCommuneActivity.this).getCommunes();
            return communes;
        }

        @Override
        protected void onPostExecute(List<Commune> communes) {

            if (communes != null) {
                waitingDialog.hide();
                ListCommuneAdapter listCommuneAdapter=new ListCommuneAdapter(ListCommuneActivity.this,communes,ListCommuneActivity.this);
                listCommuneAdapter.notifyDataSetChanged();

                recycle_view_communes = findViewById(R.id.recycle_view_commune);
                recycle_view_communes.setLayoutManager(new LinearLayoutManager(ListCommuneActivity.this));
                recycle_view_communes.setHasFixedSize(true);
                recycle_view_communes.setAdapter(listCommuneAdapter);
            }
        }
    }
}
