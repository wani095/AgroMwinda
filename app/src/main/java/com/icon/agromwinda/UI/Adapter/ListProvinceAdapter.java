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
import com.icon.agromwinda.R;

import org.json.JSONObject;

import java.util.List;

public class ListProvinceAdapter extends RecyclerView.Adapter<ListProvinceAdapter.ProvinceViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    private List<Province> provinces;
    private Activity activity;

    public ListProvinceAdapter(Context context,List<Province> provinces,Activity activity){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.provinces = provinces;
        this.activity=activity;
    }



    @NonNull
    @Override
    public ProvinceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_province, viewGroup, false);
        return new ProvinceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProvinceViewHolder provinceViewHolder,final int i) {
        provinceViewHolder.txNom_province.setText(provinces.get(i).getNom());

        provinceViewHolder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent();
                intent.putExtra("data",new Gson().toJson(provinces.get(i)));
                activity.setResult(77,intent);
                activity.finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return provinces.size();
    }

    public class ProvinceViewHolder extends RecyclerView.ViewHolder{

        LinearLayout row;
        TextView txNom_province;

        public ProvinceViewHolder(@NonNull View itemView) {
            super(itemView);
            txNom_province=itemView.findViewById(R.id.txNom_province);
            row=itemView.findViewById(R.id.row);
        }
    }
}
