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
import com.icon.agromwinda.Data.model.Territoire;
import com.icon.agromwinda.R;

import org.json.JSONObject;

import java.util.List;

public class ListTerritoireAdapter extends RecyclerView.Adapter<ListTerritoireAdapter.TerritoireViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    private List<Territoire> territoires;
    private Activity activity;

    public ListTerritoireAdapter(Context context, List<Territoire> territoires, Activity activity){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.territoires = territoires;
        this.activity=activity;
    }



    @NonNull
    @Override
    public TerritoireViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_territoire, viewGroup, false);
        return new TerritoireViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TerritoireViewHolder territoireViewHolder,final int i) {
        territoireViewHolder.txNom_territoire.setText(territoires.get(i).getNom());

        territoireViewHolder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("data",new Gson().toJson(territoires.get(i)));
                activity.setResult(82,intent);
                activity.finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return territoires.size();
    }

    public class TerritoireViewHolder extends RecyclerView.ViewHolder{

        LinearLayout row;
        TextView txNom_territoire;

        public TerritoireViewHolder(@NonNull View itemView) {
            super(itemView);
            txNom_territoire=itemView.findViewById(R.id.txNom_territoire);
            row=itemView.findViewById(R.id.row_territoire);
        }
    }
}
