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
    private Spinner spTypeActivity;
    private ScrollView pan_commerce, pan_agriculture, pan_transport;

    private EditText txNomA, txAnCR;
    private Spinner spComer_type, spComer_source, spComer_cappacite;
    private Spinner spTypeAC, spObA, spSourA, spEtendue;
    private Spinner spTran_type, spTran_marque, spTran_annee, spTran_capacite;

    private Button btnnextA;
    long subscriber;

    public long getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(long subscriber) {
        this.subscriber = subscriber;
    }

    public static TypeActivityFragment newInstance(String subscriber) {
        TypeActivityFragment typeActivityFragment = new TypeActivityFragment();

        Bundle bundle = new Bundle();
        bundle.putString("subscriber", subscriber);
        typeActivityFragment.setArguments(bundle);

        return typeActivityFragment;
    }

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
        spTypeActivity = (Spinner) view.findViewById(R.id.spTypeA);

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
                    if (!spTypeActivity.getSelectedItem().toString().equals("Commerce") &&
                            !spTypeActivity.getSelectedItem().toString().equals("Agriculture") &&
                            !spTypeActivity.getSelectedItem().toString().equals("Transport")) {
                        AppUtility.controlValue("", "Veuillez renseigner le type d'activit? svp");
                    }
                    if (spTypeActivity.getSelectedItem().toString().equals("Commerce")) {

                        AppUtility.controlValue(txNomA.getText().toString(), "Veuillez ecrire le nom de l'activit? svp");
                        AppUtility.controlValue(txAnCR.getText().toString(), "Veuillez saisir l'annee de l'activit? svp");

                        AppUtility.controlValue(spComer_type.getSelectedItem().toString(), "Veuillez s?l?ctionner type de commerce svp");
                        AppUtility.controlValue(spComer_source.getSelectedItem().toString(), "Veuillez s?l?ctionner source de commerce svp");
                        AppUtility.controlValue(spComer_cappacite.getSelectedItem().toString(), "Veuillez s?l?ctionner la capacite de commerce svp");

                        JSONObject json = new JSONObject();
                        Log.d("subscriber_id", "" + subscriber);
                        json.put("subscriber_id", subscriber);
                        json.put("name", txNomA.getText().toString());
                        json.put("type_activity", spTypeActivity.getSelectedItem().toString());
                        json.put("created_date", txAnCR.getText().toString());

                        json.put("typeof_sale", spComer_type.getSelectedItem().toString());
                        json.put("sourceof_supply", spComer_source.getSelectedItem().toString());
                        json.put("economic_capacity", spComer_cappacite.getSelectedItem().toString());

                        Log.d("ACTIVITYDETAIL", json.toString());

                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_contenta, FormSaveAdresseActivity.newInstance(json.toString()));
                        transaction.addToBackStack(null);
                        transaction.commit();

                    } else if (spTypeActivity.getSelectedItem().toString().equals("Transport")) {

                        AppUtility.controlValue(txNomA.getText().toString(), " Veullez ecrire le nom de l'activit?");
                        AppUtility.controlValue(txAnCR.getText().toString(), "Veullez saisir l'annee de l'activit?");

                        AppUtility.controlValue(spTran_type.getSelectedItem().toString(), "Veuillez selectionner le type de transport");
                        AppUtility.controlValue(spTran_capacite.getSelectedItem().toString(), "veuillez selectionner la capacite de Transport");
                        AppUtility.controlValue(spTran_annee.getSelectedItem().toString(), "veuillez selectionner l'annee de transport");
                        AppUtility.controlValue(spTran_marque.getSelectedItem().toString(), "veuillez selectionner la maqrque de transport");

                        JSONObject json = new JSONObject();

                        json.put("subscriber_id", subscriber);
                        json.put("name", txNomA.getText().toString());
                        json.put("type_activity", spTypeActivity.getSelectedItem().toString());
                        json.put("created_date", txAnCR.getText().toString());
                        json.put("subscriber_id", subscriber);

                        json.put("vehicule_type", spTran_type.getSelectedItem().toString());
                        json.put("transport_capacity", spTran_capacite.getSelectedItem().toString());
                        json.put("vehicule_marque", spTran_marque.getSelectedItem().toString());
                        json.put("acquisition_year", spTran_annee.getSelectedItem().toString());

                        json.put("typeof_sale", 0);
                        json.put("sourceof_supply", 0);
                        json.put("economic_capacity", 0);

                        json.put("sourceof_supply", 0);
                        json.put("activity_object", 0);
                        json.put("anneeof_agricole", 0);
                        json.put("scope", 0);

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

                        json.put("subscriber_id", subscriber);
                        json.put("name", txNomA.getText().toString());
                        json.put("type_activity", spTypeActivity.getSelectedItem().toString());
                        json.put("created_date", txAnCR.getText().toString());

                        json.put("sourceof_supply", spSourA.getSelectedItem().toString());
                        json.put("activity_object", spObA.getSelectedItem().toString());
                        json.put("anneeof_agricole", txAnCR.getText().toString());
                        json.put("scope", spEtendue.getSelectedItem().toString());

                        json.put("typeof_sale", 0);
                        json.put("sourceof_supply", 0);
                        json.put("economic_capacity", 0);

                        json.put("vehicule_type", 0);
                        json.put("transport_capacity", 0);
                        json.put("vehicule_marque", 0);
                        json.put("acquisition_year", 0);

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

        spTypeActivity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (BuildConfig.DEBUG)
                    Log.d("SelectedACTIVITY", spTypeActivity.getSelectedItem().toString());

                switch (spTypeActivity.getSelectedItem().toString()) {
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
