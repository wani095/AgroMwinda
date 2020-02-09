package com.icon.agromwinda.UI.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.model.Town;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.activity.ListCommuneActivity;
import com.icon.agromwinda.UI.activity.ListProvinceActivity;
import com.icon.agromwinda.UI.activity.ListVilleActivity;
import com.icon.agromwinda.UI.activity.ListingActivity;
import com.icon.agromwinda.UI.dialog.MessageDialog;
import com.icon.agromwinda.UI.dialog.WaitingDialog;
import com.icon.agromwinda.Utilities.AppUtility;
import com.icon.agromwinda.Utilities.ValueDataException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class FormSavePersonNext1 extends Fragment {

    private View view;
    private EditText txPhone, txEmail, txAdm, txQuatier, txAvenue, txDomicile;
    private TextView spCommune, spVille, spProvince;
    private Spinner tvTypePerso;
    private LinearLayout ll_person_rural;
    private LinearLayout ll_person_urbain;
    private Button btnValider;
    private Province province;
    private Town town;
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

        btnValider = view.findViewById(R.id.btnTermine);

        tvTypePerso=view.findViewById(R.id.tvTypePerso);
        ll_person_rural=view.findViewById(R.id.ll_person_rural);
        ll_person_urbain=view.findViewById(R.id.ll_person_urbain);
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

        tvTypePerso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (tvTypePerso.getSelectedItem().toString()){
                    case "Personne Urbaine":
                        ll_person_rural.setVisibility(View.GONE);
                        ll_person_urbain.setVisibility(View.VISIBLE);
                        break;
                    case "Personne Rural":
                        ll_person_rural.setVisibility(View.VISIBLE);
                        ll_person_urbain.setVisibility(View.GONE);
                        break;
                        default:
                            ll_person_rural.setVisibility(View.GONE);
                            ll_person_urbain.setVisibility(View.GONE);
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    AppUtility.controlValue(txPhone.getText().toString(), "Veuillez entrer le numero de téléphone svp");
                    AppUtility.controlValue(txAdm.getText().toString(), "Veuillez entrer le nom de l'agent multiplicateur svp");

                    if(tvTypePerso.getSelectedItem().toString().equals("Personne Urbaine")==false &&
                            tvTypePerso.getSelectedItem().toString().equals("Personne Rural")==false){
                        AppUtility.controlValue("", "Veuillez renseigner le type de personne svp");

                    }

                    if(tvTypePerso.getSelectedItem().toString().equals("Personne Urbaine")){

                        AppUtility.controlValue(txQuatier.getText().toString(), "Veuillez entrer le quartier svp");
                        AppUtility.controlValue(txAvenue.getText().toString(), "Veuillez entrer l'avenue svp");
                        AppUtility.controlValue(txDomicile.getText().toString(), "Veuillez entrer la domicile svp");
                        AppUtility.controlValue(spProvince.getText().toString(), "Veuillez séléctionner la province svp");
                        AppUtility.controlValue(spVille.getText().toString(), "Veuillez séléctionner la town svp");
                        AppUtility.controlValue(spCommune.getText().toString(), "Veuillez séléctionner la commune svp");

                        JSONObject json = new JSONObject(getArguments().getString("data"));
                        json.put("phone_number", txPhone.getText().toString());
                        json.put("email",txEmail.getText().toString());
                        json.put("multiplier_agent", txAdm.getText().toString());
                        json.put("quarter", txQuatier.getText().toString());
                        json.put("avenue", txAvenue.getText().toString());
                        json.put("home", txDomicile.getText().toString());
                        json.put("province_id", province.getId());
                        json.put("town_id", town.getId());
                        json.put("groupment_id", commune.getId());

                        new SaveSubscriber(json.toString()).execute();

                    }else{
                        AppUtility.controlValue(txQuatier.getText().toString(), "Veuillez entrer le quartier svp");
                        AppUtility.controlValue(txAvenue.getText().toString(), "Veuillez entrer l'avenue svp");
                        AppUtility.controlValue(txDomicile.getText().toString(), "Veuillez entrer la domicile svp");
                        AppUtility.controlValue(spProvince.getText().toString(), "Veuillez séléctionner la province svp");
                        AppUtility.controlValue(spVille.getText().toString(), "Veuillez séléctionner la town svp");
                        AppUtility.controlValue(spCommune.getText().toString(), "Veuillez séléctionner la commune svp");
                    }






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
                spProvince.setTextColor(Color.BLACK);
                spProvince.setTypeface(Typeface.DEFAULT_BOLD);
            }else if(requestCode==8 && resultCode==78 && data!=null){
                town =new Gson().fromJson(data.getExtras().get("data").toString(),new TypeToken<Town>(){}.getType());
                spVille.setText(town.getNom());
                spVille.setTextColor(Color.BLACK);
                spVille.setTypeface(Typeface.DEFAULT_BOLD);
            }else if(requestCode==9 && resultCode==79 && data!=null){
                commune=new Gson().fromJson(data.getExtras().get("data").toString(),new TypeToken<Commune>(){}.getType());
                spCommune.setText(commune.getNom());
                spCommune.setTextColor(Color.BLACK);
                spCommune.setTypeface(Typeface.DEFAULT_BOLD);
            }
    }


    public class SaveSubscriber extends AsyncTask<Void, Void, Long> {

        private String data;

        private WaitingDialog waitingDialog = new WaitingDialog(getContext());

        public SaveSubscriber(String data) {
            this.data = data;
        }

        @Override
        protected void onPreExecute() {
            waitingDialog.show();
        }

        @Override
        protected Long doInBackground(Void... voids) {
            Log.d("DATASUBSCRIBER",data);
            Subscriber subscriber=new Gson().fromJson(data,new TypeToken<Subscriber>(){}.getType());
            subscriber.setCreated_at(new Date());
            Dao dao=new Dao(getContext());
            long rep=dao.saveSubscriber(subscriber);
            

            return rep;
        }

        @Override
        protected void onPostExecute(Long rep) {
            waitingDialog.hide();
            if (rep>0){
                MessageDialog.getDialog(getActivity()).createDialog("Votre Operation est un succès").show();
                Intent intent=new Intent(getActivity(), ListingActivity.class);
                getActivity().startActivity(intent);
            }else {
                MessageDialog.getDialog(getActivity()).createDialog("Echec d'enregistrement").show();
            }

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
