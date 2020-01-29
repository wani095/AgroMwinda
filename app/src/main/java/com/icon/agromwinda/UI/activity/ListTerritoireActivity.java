package com.icon.agromwinda.UI.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Territoire;
import com.icon.agromwinda.Data.repository.Controller;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.Adapter.ListTerritoireAdapter;
import com.icon.agromwinda.UI.dialog.WaitingDialog;

import java.util.List;

public class ListTerritoireActivity extends AppCompatActivity {

    private RecyclerView recycle_view_territoires;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_territoire);
        bindUI();
        init();
    }

    public void bindUI() {

    }

    public void init() {
        setContentView(R.layout.activity_list_territoire);
        new ListTerritoires().execute();
    }

    public void bindEvents() {

    }

    public class ListTerritoires extends AsyncTask<Void, Void, List<Territoire>> {

        List<Territoire> territoires = null;
        private WaitingDialog waitingDialog = new WaitingDialog(ListTerritoireActivity.this);

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected List<Territoire> doInBackground(Void... voids) {

            Controller.initDB(ListTerritoireActivity.this);
            territoires = new Dao(ListTerritoireActivity.this).getTerritoires();
            return territoires;
        }

        @Override
        protected void onPostExecute(List<Territoire> territoires) {

            if (territoires != null) {
                ListTerritoireAdapter listTerritoireAdapter=new ListTerritoireAdapter(ListTerritoireActivity.this,territoires,ListTerritoireActivity.this);
                listTerritoireAdapter.notifyDataSetChanged();

                recycle_view_territoires = findViewById(R.id.recycle_view_territoires);
                recycle_view_territoires.setLayoutManager(new LinearLayoutManager(ListTerritoireActivity.this));
                recycle_view_territoires.setHasFixedSize(true);
                recycle_view_territoires.setAdapter(listTerritoireAdapter);
            }
        }
    }
}
