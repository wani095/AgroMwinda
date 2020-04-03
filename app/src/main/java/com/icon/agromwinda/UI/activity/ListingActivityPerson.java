package com.icon.agromwinda.UI.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.icon.agromwinda.Data.model.Activity;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.Adapter.ListingPersonAdapter;


import java.util.ArrayList;
import java.util.List;

public class ListingActivityPerson extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_person);
        bindUI();
    }

    public void bindUI() {
        recyclerView = findViewById(R.id.listingActivity);

    }

    public class LoadActivities extends AsyncTask<Integer, Subscriber,  List<Activity>> {
        private int subscriber_id;

        public LoadActivities(int id) {
            subscriber_id = id;
        }

        @Override
        protected  List<Activity> doInBackground(Integer... integers) { List<Activity> activities=new Dao(ListingActivityPerson.this).getListActivitys(subscriber_id);
            return activities;
        }
        @Override
        protected void onPostExecute(List<Activity> activitys) {
            if (activitys != null) {
                ListingPersonAdapter listingPersonAdapter=new ListingPersonAdapter(ListingActivityPerson.this,activitys,ListingActivityPerson.this);
                listingPersonAdapter.notifyDataSetChanged();

                recyclerView = findViewById(R.id.listingActivity);
                recyclerView.setLayoutManager(new LinearLayoutManager(ListingActivityPerson.this));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(listingPersonAdapter);
            }
        }
    }
}
