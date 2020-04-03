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

import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.Adapter.ListingAdapter;
import com.icon.agromwinda.UI.LoginSy.Login;

import java.util.List;

public class ListingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button bntsynchry;
    private Button error;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        bindUI();
        init();
    }


    public void bindUI() {
        recyclerView = findViewById(R.id.listing);
        bntsynchry =findViewById(R.id.btnsynchry);
        error=findViewById(R.id.error);

        bntsynchry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListingActivity.this, Login.class));
            }
        });
        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListingActivity.this, ErrorActivity.class));
            }
        });
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
