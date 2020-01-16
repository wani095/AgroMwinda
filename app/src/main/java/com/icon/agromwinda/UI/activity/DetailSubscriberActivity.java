package com.icon.agromwinda.UI.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.Adapter.DetailSubscriberAdapter;
import com.icon.agromwinda.UI.dialog.WaitingDialog;

import java.util.ArrayList;
import java.util.List;

public class DetailSubscriberActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_subscriber);
        init();
    }

    public void init() {

        Integer id = (Integer)getIntent().getExtras().get("id");
        new LoadSubcriber(new WaitingDialog(this)).execute(id);
    }

    public class LoadSubcriber extends AsyncTask<Integer, Subscriber, Subscriber> {

        private WaitingDialog dialog;

        private LoadSubcriber(WaitingDialog dialog) {
            this.dialog = dialog;
        }

        @Override
        protected void onPreExecute() {
            dialog.show();
        }


        @Override
        protected Subscriber doInBackground(Integer... id) {

            Subscriber subscriber = new Dao(DetailSubscriberActivity.this).getSubscriber(id[0]);
            return subscriber;
        }

        @Override
        protected void onPostExecute(Subscriber subscriber) {
            dialog.hide();
            if (subscriber != null) {
                List<String[]> attrs = new ArrayList<>();
                attrs.add(new String[]{"Nom",subscriber.getLastname()});
                attrs.add(new String[]{"Prénom",subscriber.getName()});

                DetailSubscriberAdapter subscriberAdapter=new DetailSubscriberAdapter(DetailSubscriberActivity.this,attrs);

                recyclerView = findViewById(R.id.detailsubscriber);
                recyclerView.setLayoutManager(new LinearLayoutManager(DetailSubscriberActivity.this));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(subscriberAdapter);
            }
        }
    }
}
