package com.icon.agromwinda.UI.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Secteur;
import com.icon.agromwinda.R;

import org.json.JSONObject;

import java.util.List;

public class ListSecteurAdapter extends RecyclerView.Adapter<ListSecteurAdapter.SecteurViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    private List<Secteur> secteurs;
    private Activity activity;

    public ListSecteurAdapter(Context context,List<Secteur> secteurs,Activity activity){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.secteurs = secteurs;
        this.activity=activity;
    }



    @NonNull
    @Override
    public SecteurViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_secteur, viewGroup, false);
        return new SecteurViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SecteurViewHolder secteurViewHolder,final int i) {
        secteurViewHolder.txNom_secteur.setText(secteurs.get(i).getNom());

        secteurViewHolder.row_secteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();

                Log.d("SECTEURDATA",new Gson().toJson(secteurs.get(i)));

                intent.putExtra("data",new Gson().toJson(secteurs.get(i)));
                activity.setResult(81,intent);
                activity.finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return secteurs.size();
    }

    public class SecteurViewHolder extends RecyclerView.ViewHolder{

        LinearLayout row_secteur;
        TextView txNom_secteur;

        public SecteurViewHolder(@NonNull View itemView) {
            super(itemView);
            txNom_secteur=itemView.findViewById(R.id.txNom_secteur);
            row_secteur=itemView.findViewById(R.id.row_secteur);
        }
    }
}

