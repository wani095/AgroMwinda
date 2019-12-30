package com.icon.agromwinda.UI.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.repository.Controller;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.Adapter.ListProvinceAdapter;
import com.icon.agromwinda.UI.dialog.WaitingDialog;

import java.util.List;

public class ListProvinceActivity extends AppCompatActivity {

    private RecyclerView recycle_view_provinces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_province);
        bindUI();
        init();
    }

    public void bindUI() {

    }

    public void init() {
        setContentView(R.layout.activity_list_province);
        new ListProvinces().execute();
    }

    public void bindEvents() {

    }

    public class ListProvinces extends AsyncTask<Void, Void, List<Province>> {

        List<Province> provinces = null;
        private WaitingDialog waitingDialog = new WaitingDialog(ListProvinceActivity.this);

        @Override
        protected void onPreExecute() {
            waitingDialog.show();
        }

        @Override
        protected List<Province> doInBackground(Void... voids) {

            Controller.initDB(ListProvinceActivity.this);
            provinces = new Dao(ListProvinceActivity.this).getProvinces();
            return provinces;
        }

        @Override
        protected void onPostExecute(List<Province> provinces) {

            if (provinces != null) {
                waitingDialog.hide();
                ListProvinceAdapter listProvinceAdapter=new ListProvinceAdapter(ListProvinceActivity.this,provinces,ListProvinceActivity.this);
                listProvinceAdapter.notifyDataSetChanged();

                recycle_view_provinces = findViewById(R.id.recycle_view_provinces);
                recycle_view_provinces.setLayoutManager(new LinearLayoutManager(ListProvinceActivity.this));
                recycle_view_provinces.setHasFixedSize(true);
                recycle_view_provinces.setAdapter(listProvinceAdapter);
            }
        }
    }
}
