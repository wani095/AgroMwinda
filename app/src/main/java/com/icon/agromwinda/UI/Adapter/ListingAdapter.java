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
import com.icon.agromwinda.UI.activity.DetailSubscriberActivity;

import java.util.List;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListingViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    private List<Subscriber> subscribers;
    private Activity activity;
    private RecyclerView recyclerView;

    public ListingAdapter(Context context, List<Subscriber> subscribers, Activity activity){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.subscribers = subscribers;
        this.activity=activity;
    }



    @NonNull
    @Override
    public ListingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_listing, viewGroup, false);
        return new ListingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListingViewHolder ListingViewHolder,final int i) {
        ListingViewHolder.txFullName.setText(subscribers.get(i).getName()+" "+subscribers.get(i).getFirstname()+" "+subscribers.get(i).getLastname()+" "+subscribers.get(i).getPhone_number());

        ListingViewHolder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, DetailSubscriberActivity.class);
                intent.putExtra("id",subscribers.get(i).getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subscribers.size();
    }

    public class ListingViewHolder extends RecyclerView.ViewHolder{

        LinearLayout row;
        TextView txFullName;

        public ListingViewHolder(@NonNull View itemView) {
            super(itemView);
            txFullName=itemView.findViewById(R.id.txFullName);
            row=itemView.findViewById(R.id.row);
        }
    }
}
