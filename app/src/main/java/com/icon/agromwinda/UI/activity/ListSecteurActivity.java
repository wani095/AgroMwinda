package com.icon.agromwinda.UI.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Secteur;
import com.icon.agromwinda.Data.repository.Controller;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.Adapter.ListProvinceAdapter;
import com.icon.agromwinda.UI.Adapter.ListSecteurAdapter;
import com.icon.agromwinda.UI.dialog.WaitingDialog;

import java.util.List;

public class ListSecteurActivity extends AppCompatActivity {

    private RecyclerView recycle_view_secteurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_secteur);
        bindUI();
        init();
    }

    public void bindUI() {

    }

    public void init() {
        setContentView(R.layout.activity_list_secteur);
        new ListSecteurs().execute();
    }

    public void bindEvents() {

    }

    public class ListSecteurs extends AsyncTask<Void, Void, List<Secteur>> {

        List<Secteur> secteurs = null;
        private WaitingDialog waitingDialog = new WaitingDialog(ListSecteurActivity.this);

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected List<Secteur> doInBackground(Void... voids) {

            Controller.initDB(ListSecteurActivity.this);
            secteurs = new Dao(ListSecteurActivity.this).getSecteurs();
            return secteurs;
        }

        @Override
        protected void onPostExecute(List<Secteur> secteurs) {

            if (secteurs != null) {
                ListSecteurAdapter listSecteurAdapter=new ListSecteurAdapter(ListSecteurActivity.this,secteurs,ListSecteurActivity.this);
                listSecteurAdapter.notifyDataSetChanged();

                recycle_view_secteurs = findViewById(R.id.recycle_view_secteurs);
                recycle_view_secteurs.setLayoutManager(new LinearLayoutManager(ListSecteurActivity.this));
                recycle_view_secteurs.setHasFixedSize(true);
                recycle_view_secteurs.setAdapter(listSecteurAdapter);
            }
        }
    }
}
