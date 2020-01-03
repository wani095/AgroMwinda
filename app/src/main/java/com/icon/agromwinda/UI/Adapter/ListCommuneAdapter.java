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
import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.R;

import org.json.JSONObject;

import java.util.List;

public class ListCommuneAdapter extends RecyclerView.Adapter<ListCommuneAdapter.CommuneViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    private List<Commune> communes;
    private Activity activity;

    public ListCommuneAdapter(Context context, List<Commune> communes, Activity activity){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.communes = communes;
        this.activity=activity;
    }



    @NonNull
    @Override
    public CommuneViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_commune, viewGroup, false);
        return new CommuneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CommuneViewHolder communeViewHolder,final int i) {
        communeViewHolder.txNom_commune.setText(communes.get(i).getNom());

        communeViewHolder.rowcommune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("data",new Gson().toJson(communes.get(i)));
                activity.setResult(79,intent);
                activity.finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return communes.size();
    }

    public class CommuneViewHolder extends RecyclerView.ViewHolder{

        LinearLayout rowcommune;
        TextView txNom_commune;

        public CommuneViewHolder(@NonNull View itemView) {
            super(itemView);
            txNom_commune=itemView.findViewById(R.id.txNom_commune);
            rowcommune=itemView.findViewById(R.id.rowcommune);
        }
    }
}
