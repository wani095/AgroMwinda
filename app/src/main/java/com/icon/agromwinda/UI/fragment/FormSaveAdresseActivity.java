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

public class FormSaveAdresseActivity extends Fragment {

    private View view;
    private Spinner spchoixA;
    private ScrollView pan_rural, pan_urbain;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_adresse_physique_activite, container, false);
        bindUI();
        bindEvents();
        return view;
    }

    public void bindUI() {
        spchoixA = (Spinner) view.findViewById(R.id.spchoixA);
        pan_urbain = view.findViewById(R.id.pan_urbain);
        pan_rural = view.findViewById(R.id.pan_rural);

    }

    public void bindEvents() {
        Log.d("SelectedACTIVITY","");

        spchoixA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (BuildConfig.DEBUG)
                    Log.d("SelectedACTIVITY", spchoixA.getSelectedItem().toString());

                switch (spchoixA.getSelectedItem().toString()) {
                    case "Urbain": {
                        pan_rural.setVisibility(View.GONE);
                        pan_urbain.setVisibility(View.VISIBLE);
                        break;
                    }

                    case "Rural": {
                        pan_rural.setVisibility(View.VISIBLE);
                        pan_urbain.setVisibility(View.GONE);
                        break;
                    }

                }
            }
        });
    }
}
