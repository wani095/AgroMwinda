package com.icon.agromwinda.UI.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.Adapter.ListingAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        bindUI();
        init();
    }


    public void bindUI() {
        recyclerView = findViewById(R.id.listing);
    }

    public void init() {
        new GetSubscriber().execute();
    }


    public class GetSubscriber extends AsyncTask<Void, Void, List<Subscriber>> {

        @Override
        protected List<Subscriber> doInBackground(Void... voids) {

            Dao dao = new Dao(ListingActivity.this);
            List<Subscriber> subscribers = (List<Subscriber>) dao.getSubscribers();

            return subscribers;
        }

        @Override
        protected void onPostExecute(List<Subscriber> subscribers) {
            if (subscribers != null) {
                ListingAdapter listingAdapter=new ListingAdapter(ListingActivity.this,subscribers,ListingActivity.this);
                listingAdapter.notifyDataSetChanged();

                recyclerView = findViewById(R.id.listing);
                recyclerView.setLayoutManager(new LinearLayoutManager(ListingActivity.this));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(listingAdapter);
            }
        }
    }
}
