package com.icon.agromwinda.UI.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.activity.DetailActivity;
import com.icon.agromwinda.UI.activity.DetailSubscriberActivity;

import java.util.List;

public class ListingPersonAdapter extends RecyclerView.Adapter<ListingPersonAdapter.ListingPersonViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    private List<com.icon.agromwinda.Data.model.Activity> activitys;
    private Activity activity;


    public ListingPersonAdapter(Context context, List<com.icon.agromwinda.Data.model.Activity> activitys, Activity activity){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.activitys = activitys;
        this.activity=activity;

    }

    @NonNull
    @Override
    public ListingPersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_listing_activity, viewGroup, false);
        return new ListingPersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListingPersonViewHolder PersonViewHolder, final int i) {
        PersonViewHolder.txFullNameActivity.setText(activitys.get(i).getName()+" "+activitys.get(i).getType_activity());


        PersonViewHolder.row_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, DetailActivity.class);
                intent.putExtra("id",activitys.get(i).getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return activitys.size();

    }


    public class ListingPersonViewHolder extends RecyclerView.ViewHolder{

        LinearLayout row_activity;
        TextView txFullNameActivity;

        public ListingPersonViewHolder(@NonNull View itemView) {
            super(itemView);
            txFullNameActivity=itemView.findViewById(R.id.txFullNameActivity);
            row_activity=itemView.findViewById(R.id.row_activity);
        }
    }
}
