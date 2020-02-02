package com.icon.agromwinda.UI.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.icon.agromwinda.BuildConfig;
import com.icon.agromwinda.R;

public class TypeActivityFragment extends Fragment {

    private View view;
    private Spinner spTypeA;
    private ScrollView pan_commerce, pan_agriculture, pan_transport;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragmente_form_save_activity, container, false);
        bindUI();
        bindEvents();
        return view;
    }

    public void bindUI() {
        spTypeA = (Spinner) view.findViewById(R.id.spTypeA);
        pan_agriculture = view.findViewById(R.id.pan_agriculture);
        pan_commerce = view.findViewById(R.id.pan_commerce);
        pan_transport = view.findViewById(R.id.pan_transport);
    }

    public void bindEvents() {
Log.d("SelectedACTIVITY","");

        spTypeA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (BuildConfig.DEBUG)
                    Log.d("SelectedACTIVITY", spTypeA.getSelectedItem().toString());

                switch (spTypeA.getSelectedItem().toString()) {
                    case "Commerce": {
                        pan_agriculture.setVisibility(View.GONE);
                        pan_transport.setVisibility(View.GONE);
                        pan_commerce.setVisibility(View.VISIBLE);
                        break;
                    }

                    case "Agriculture": {
                        pan_agriculture.setVisibility(View.VISIBLE);
                        pan_transport.setVisibility(View.GONE);
                        pan_commerce.setVisibility(View.GONE);
                        break;
                    }

                    case "Transport": {
                        pan_agriculture.setVisibility(View.GONE);
                        pan_transport.setVisibility(View.VISIBLE);
                        pan_commerce.setVisibility(View.GONE);
                        break;
                    }
                }
            }
        });
    }
}
