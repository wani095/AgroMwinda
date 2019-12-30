package com.icon.agromwinda.UI.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Personne;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Ville;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.activity.ListCommuneActivity;
import com.icon.agromwinda.UI.activity.ListProvinceActivity;
import com.icon.agromwinda.UI.activity.ListVilleActivity;
import com.icon.agromwinda.UI.dialog.MessageDialog;
import com.icon.agromwinda.UI.dialog.WaitingDialog;
import com.icon.agromwinda.Utilities.AppUtility;
import com.icon.agromwinda.Utilities.ValueDataException;

import org.json.JSONException;
import org.json.JSONObject;

public class FormSavePersonNext1 extends Fragment {

    private View view;
    private EditText txPhone, txEmail, txAdm, txQuatier, txAvenue, txDomicile;
    private TextView spCommune, spVille, spProvince;
    private Button btnValider;
    private Province province;
    private Ville ville;
    private Commune commune;


    public static FormSavePersonNext1 newInstance(String json) {
        Bundle args = new Bundle();
        args.putString("data", json);
        FormSavePersonNext1 fragment = new FormSavePersonNext1();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_form_save_person_next1, container, false);
        bindUI();
        init();
        bindEvents();
        return view;
    }

    public void bindUI() {

        txPhone = view.findViewById(R.id.txPhone);
        txEmail = view.findViewById(R.id.txEmail);
        txAdm = view.findViewById(R.id.txAdm);
        txQuatier = view.findViewById(R.id.txQuartier);
        txAvenue = view.findViewById(R.id.txAvenue);
        txDomicile = view.findViewById(R.id.txDomicile);

        spCommune = view.findViewById(R.id.spCommune);
        spProvince = view.findViewById(R.id.spProvince);
        spVille = view.findViewById(R.id.spVille);

        btnValider = view.findViewById(R.id.btnValider);
    }

    public void init() {
    }

    public void bindEvents() {

        spProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListProvinceActivity.class);
                startActivityForResult(intent, 7);
            }
        });

        spVille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListVilleActivity.class);
                startActivityForResult(intent, 8);
            }
        });

        spCommune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListCommuneActivity.class);
                startActivityForResult(intent, 9);
            }
        });

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    AppUtility.controlValue(txPhone.getText().toString(), "Veuillez entrer le numero de téléphone svp");
                    AppUtility.controlValue(txAdm.getText().toString(), "Veuillez entrer le nom de l'agent multiplicateur svp");
                    AppUtility.controlValue(txQuatier.getText().toString(), "Veuillez entrer le quartier svp");
                    AppUtility.controlValue(txAvenue.getText().toString(), "Veuillez entrer l'avenue svp");
                    AppUtility.controlValue(txDomicile.getText().toString(), "Veuillez entrer la domicile svp");
                    AppUtility.controlValue(spProvince.getText().toString(), "Veuillez séléctionner la province svp");
                    AppUtility.controlValue(spVille.getText().toString(), "Veuillez séléctionner la ville svp");
                    AppUtility.controlValue(spCommune.getText().toString(), "Veuillez séléctionner la commune svp");

                    JSONObject json = new JSONObject(getArguments().getString("data"));
                    json.put("phone", txPhone.getText().toString());
                    json.put("adm", txAdm.getText().toString());
                    json.put("quartier", txQuatier.getText().toString());
                    json.put("avenue", txAvenue.getText().toString());
                    json.put("domicile", txDomicile.getText().toString());
                    json.put("province", spProvince.getText().toString());
                    json.put("ville", spVille.getText().toString());
                    json.put("commune", spCommune.getText().toString());

                    new SavePersonne(json.toString()).execute();


                } catch (ValueDataException e) {
                    MessageDialog.getDialog(getContext()).createDialog(e.getMessage()).show();
                } catch (JSONException e) {

                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if(requestCode==7 && resultCode==77 && data!=null){
                province=new Gson().fromJson(data.getExtras().get("data").toString(),new TypeToken<Province>(){}.getType());
                spProvince.setText(province.getNom());
            }
    }


    public class SavePersonne extends AsyncTask<Void, Void, String> {

        private String data;

        private WaitingDialog waitingDialog = new WaitingDialog(getContext());

        public SavePersonne(String data) {
            this.data = data;
        }

        @Override
        protected void onPreExecute() {
            waitingDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {

            return null;
        }
    }



    public class ListVilles extends AsyncTask<Void, Void, String> {

        private WaitingDialog waitingDialog = new WaitingDialog(getContext());

        @Override
        protected void onPreExecute() {
            waitingDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {

            return null;
        }
    }
}
