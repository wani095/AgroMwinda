package com.icon.agromwinda.UI.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.icon.agromwinda.BuildConfig;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.dialog.MessageDialog;
import com.icon.agromwinda.Utilities.AppUtility;
import com.icon.agromwinda.Utilities.ValueDataException;

import org.json.JSONException;
import org.json.JSONObject;

public class TypeActivityFragment extends Fragment {

    private View view;
    private Spinner spTypeA;
    private ScrollView pan_commerce, pan_agriculture, pan_transport;

    private EditText txNomA, txAnCR;
    private Spinner spComer_type, spComer_source, spComer_cappacite;
    private Spinner spTypeAC, spObA, spSourA, spEtendue;
    private Spinner spTran_type, spTran_marque, spTran_annee, spTran_capacite;

    private Button btnnextA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragmente_form_save_activity, container, false);
        bindUI();
        bindEvents();
        init();
        return view;
    }

    public void bindUI() {
        spTypeA = (Spinner) view.findViewById(R.id.spTypeA);

        pan_agriculture = view.findViewById(R.id.pan_agriculture);
        pan_commerce = view.findViewById(R.id.pan_commerce);
        pan_transport = view.findViewById(R.id.pan_transport);


        txNomA = view.findViewById(R.id.txNomA);
        txAnCR = view.findViewById(R.id.txAnCR);


        spComer_type = view.findViewById(R.id.spComer_type);
        spComer_source = view.findViewById(R.id.spComer_source);
        spComer_cappacite = view.findViewById(R.id.spComer_capacit);

        spTypeAC = view.findViewById(R.id.spTypeAc);
        spObA = view.findViewById(R.id.spObA);
        spSourA = view.findViewById(R.id.spSourA);
        spEtendue = view.findViewById(R.id.spEtendue);

        spTran_type = view.findViewById(R.id.spTran_type);
        spTran_marque = view.findViewById(R.id.spTran_marque);
        spTran_capacite = view.findViewById(R.id.spTran_capacite);
        spTran_annee = view.findViewById(R.id.spTran_annee);


        btnnextA = view.findViewById(R.id.btnnexT);
    }

    public void init() {

    }

    public void bindEvents() {


        btnnextA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if (spTypeA.getSelectedItem().toString().equals("Commerce") == false &&
                            spTypeA.getSelectedItem().toString().equals("Agriculture") == false &&
                            spTypeA.getSelectedItem().toString().equals("Transport") == false) {
                        AppUtility.controlValue("", "Veuillez renseigner le type d'activit? svp");

                    }

                    if (spTypeA.getSelectedItem().toString().equals("Commerce")) {

                        AppUtility.controlValue(txNomA.getText().toString(), "Veuillez ecrire le nom de l'activit? svp");
                        AppUtility.controlValue(txAnCR.getText().toString(), "Veuillez saisir l'annee de l'activit? svp");

                        AppUtility.controlValue(spComer_type.getSelectedItem().toString(), "Veuillez s?l?ctionner type de commerce svp");
                        AppUtility.controlValue(spComer_source.getSelectedItem().toString(), "Veuillez s?l?ctionner source de commerce svp");
                        AppUtility.controlValue(spComer_cappacite.getSelectedItem().toString(), "Veuillez s?l?ctionner la capacite de commerce svp");


                        JSONObject json = new JSONObject();

                        json.put("name", txNomA.getText().toString());
                        json.put("type_activity", spTypeA.getSelectedItem().toString());
                        json.put("created_date", txAnCR.getText().toString());

                        json.put("typeof_sale", spComer_type.getSelectedItem().toString());
                        json.put("sourceof_supply", spComer_source.getSelectedItem().toString());
                        json.put("economic_capacity", spComer_cappacite.getSelectedItem().toString());

                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_contenta, FormSaveAdresseActivity.newInstance(json.toString()));
                        transaction.addToBackStack(null);
                       transaction.commit();

                    } else if (spTypeA.getSelectedItem().toString().equals("Transport")) {

                        AppUtility.controlValue(txNomA.getText().toString(), " Veullez ecrire le nom de l'activit?");
                        AppUtility.controlValue(txAnCR.getText().toString(), "Veullez saisir l'annee de l'activit?");

                        AppUtility.controlValue(spTran_type.getSelectedItem().toString(), "Veuillez selectionner le type de transport");
                        AppUtility.controlValue(spTran_capacite.getSelectedItem().toString(), "veuillez selectionner la capacite de Transport");
                        AppUtility.controlValue(spTran_annee.getSelectedItem().toString(), "veuillez selectionner l'annee de transport");
                        AppUtility.controlValue(spTran_marque.getSelectedItem().toString(), "veuillez selectionner la maqrque de transport");

                        JSONObject json = new JSONObject();


                        json.put("name", txNomA.getText().toString());
                        json.put("type-activity", spTypeA.getSelectedItem().toString());
                        json.put("created_date", txAnCR.getText().toString());

                        json.put("vehicule_type", spTran_type.getSelectedItem().toString());
                        json.put("transport_capacity", spTran_capacite.getSelectedItem().toString());
                        json.put("vehicule_marque", spTran_marque.getSelectedItem().toString());
                        json.put("acquisition_year", spTran_annee.getSelectedItem().toString());

                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_contenta, FormSaveAdresseActivity.newInstance(json.toString()));
                        transaction.addToBackStack(null);
                        transaction.commit();

                    } else {
                        AppUtility.controlValue(txNomA.getText().toString(), "Veuillez ecrire le nom de l'activit? svp");
                        AppUtility.controlValue(txAnCR.getText().toString(), "Veuillez saisir l'annee de l'activit? svp");

                        AppUtility.controlValue(spTypeAC.getSelectedItem().toString(), "Veuillez s?l?ctionner type de commerce svp");
                        AppUtility.controlValue(spObA.getSelectedItem().toString(), "Veuillez s?l?ctionner source de commerce svp");
                        AppUtility.controlValue(spSourA.getSelectedItem().toString(), "Veuillez s?l?ctionner la capacite de commerce svp");
                        AppUtility.controlValue(spEtendue.getSelectedItem().toString(), "Veuillez s?l?ctionner la capacite de commerce svp");

                        JSONObject json = new JSONObject();

                        json.put("name", txNomA.getText().toString());
                        json.put("type_activity", spTypeA.getSelectedItem().toString());
                        json.put("created_date", txAnCR.getText().toString());

                        json.put("sourceof_supply", spSourA.getSelectedItem().toString());
                        json.put("activity_object", spObA.getSelectedItem().toString());
                        json.put("anneeof_agricole", txAnCR.getText().toString());
                        json.put("scope", spEtendue.getSelectedItem().toString());


                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_contenta, FormSaveAdresseActivity.newInstance(json.toString()));
                        transaction.addToBackStack(null);
                        transaction.commit();

                    }


                } catch (ValueDataException e) {
                    MessageDialog.getDialog(getContext()).createDialog(e.getMessage()).show();
                } catch (JSONException e) {

                }
            }
        });


        Log.d("SelectedACTIVITY", "");

        spTypeA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

                    default:
                        pan_agriculture.setVisibility(View.GONE);
                        pan_commerce.setVisibility(View.GONE);
                        pan_transport.setVisibility(View.GONE);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }
}
