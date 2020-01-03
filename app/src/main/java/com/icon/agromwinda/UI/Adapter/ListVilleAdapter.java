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
import com.icon.agromwinda.Data.model.Town;
import com.icon.agromwinda.R;

import java.util.List;

public class ListVilleAdapter extends RecyclerView.Adapter<ListVilleAdapter.VilleViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    private List<Town> towns;
    private Activity activity;

    public ListVilleAdapter(Context context, List<Town> towns, Activity activity){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.towns = towns;
        this.activity=activity;
    }



    @NonNull
    @Override
    public VilleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_ville, viewGroup, false);
        return new VilleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VilleViewHolder villeViewHolder,final int i) {
        villeViewHolder.txNom_ville.setText(towns.get(i).getNom());

        villeViewHolder.rowville.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("data",new Gson().toJson(towns.get(i)));
                activity.setResult(78,intent);
                activity.finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return towns.size();
    }

    public class VilleViewHolder extends RecyclerView.ViewHolder{

        LinearLayout rowville;
        TextView txNom_ville;

        public VilleViewHolder(@NonNull View itemView) {
            super(itemView);
            txNom_ville=itemView.findViewById(R.id.txNom_ville);
            rowville=itemView.findViewById(R.id.rowville);
        }
    }
}
