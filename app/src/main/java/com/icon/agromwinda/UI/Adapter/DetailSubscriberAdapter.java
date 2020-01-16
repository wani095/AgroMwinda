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

public class DetailSubscriberAdapter extends RecyclerView.Adapter<DetailSubscriberAdapter.DetailHolder> {

    private List<String[]> infos;
    private Context context;
    private LayoutInflater inflater;

    public DetailSubscriberAdapter(Context context, List<String[]> infos) {
        this.context = context;
        this.infos = infos;
        this.inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.row_detail_subscriber,viewGroup,false);
        return new DetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder detailHolder, int i) {
        detailHolder.atribut.setText(infos.get(i)[0]);
        detailHolder.value.setText(infos.get(i)[1]);
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    public class DetailHolder extends RecyclerView.ViewHolder {

        TextView atribut, value;

        public DetailHolder(@NonNull View itemView) {
            super(itemView);

            atribut = itemView.findViewById(R.id.atribut);
            value = itemView.findViewById(R.id.value);


        }
    }
}
