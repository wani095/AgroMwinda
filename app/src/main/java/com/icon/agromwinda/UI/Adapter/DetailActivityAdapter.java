package com.icon.agromwinda.UI.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icon.agromwinda.R;

import java.util.List;
import java.util.zip.Inflater;

public class DetailActivityAdapter extends RecyclerView.Adapter<DetailActivityAdapter.DetailHolder> {

    private List<String[]> infos;
    private Context context;
    private LayoutInflater inflater;

    public DetailActivityAdapter(Context context, List<String[]> infos) {
        this.context = context;
        this.infos = infos;
        this.inflater= LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.row_detail_activity,viewGroup,false);
        return new DetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder detailHolder, int i) {
        detailHolder.atributA.setText(infos.get(i)[0]);
        detailHolder.valueA.setText(infos.get(i)[1]);
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    public class DetailHolder extends RecyclerView.ViewHolder {

        TextView atributA, valueA;

        public DetailHolder(@NonNull View itemView) {
            super(itemView);

            atributA = itemView.findViewById(R.id.atributA);
            valueA = itemView.findViewById(R.id.valueA);
        }
    }
}
