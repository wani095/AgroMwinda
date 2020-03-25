package com.icon.agromwinda.UI.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.icon.agromwinda.Data.model.Activity;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.Adapter.DetailActivityAdapter;
import com.icon.agromwinda.UI.Adapter.DetailSubscriberAdapter;
import com.icon.agromwinda.UI.dialog.WaitingDialog;

import java.util.ArrayList;
import java.util.List;


public class DetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);
        init();

    }

    public void init() {

        Integer id = (Integer)getIntent().getExtras().get("id");
        new LoadActivity(new WaitingDialog(this)).execute(id);
    }

    public class LoadActivity extends AsyncTask<Integer,  Activity, Activity> {

        private WaitingDialog dialog;

        private LoadActivity(WaitingDialog dialog) {
            this.dialog = dialog;
        }

        @Override
        public void onPreExecute() {
            dialog.show();
        }

        @Override
        protected Activity doInBackground(Integer... id) {

                Activity activity = new Dao(DetailActivity.this).getActivity(id[0]);
            return activity;
        }

        @Override
        protected void onPostExecute(Activity activity) {
            dialog.hide();
            if (activity != null) {
                List<String[]> attrs = new ArrayList<>();
                attrs.add(new String[]{"ID :", String.valueOf(activity.getId())});
                attrs.add(new String[]{"Nom :", activity.getName()});

                DetailActivityAdapter activityAdapter=new DetailActivityAdapter(DetailActivity.this,attrs);

                recyclerView = findViewById(R.id.detailactivity);
                recyclerView.setLayoutManager(new LinearLayoutManager(DetailActivity.this));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(activityAdapter);
            }
        }
    }

    class LoadActivities extends AsyncTask<Integer, Activity, Activity>{

        @Override
        protected Activity doInBackground(Integer... integers) {
            return null;
        }
    }
}
