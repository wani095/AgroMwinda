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

public class ListingActivityPerson extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_person);
        bindUI();
        init();
    }


    public void bindUI() {
        recyclerView = findViewById(R.id.listing);
    }

    public void init() {
        new GetActivity().execute();
    }


    public class GetActivity extends AsyncTask<Void, Void, List<Activity>> {

        @Override
        protected List<Activity> doInBackground(Void... voids) {

            Dao dao = new Dao(ListingActivityPerson.this);
            List<Activity> activitys = (List<Activity>) dao.getActivitys();

            return activitys;
        }

        @Override
        protected void onPostExecute(List<Subscriber> subscribers) {
            if (subscribers != null) {
                ListingAdapter listingAdapter=new ListingAdapter(ListingActivity.this,subscribers,ListingActivity.this);
                listingAdapter.notifyDataSetChanged();

                recyclerView = findViewById(R.id.listing);
                recyclerView.setLayoutManager(new LinearLayoutManager(ListingActivity.this));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(listingAdapterPerson);
            }
        }
    }
}
