package com.icon.agromwinda.UI.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Secteur;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.activity.ListProvinceActivity;
import com.icon.agromwinda.UI.activity.ListSecteurActivity;
import com.icon.agromwinda.UI.activity.ListTerritoireActivity;
import com.icon.agromwinda.UI.activity.ListingActivity;
import com.icon.agromwinda.UI.dialog.MessageDialog;
import com.icon.agromwinda.UI.dialog.WaitingDialog;
import com.icon.agromwinda.Utilities.AppUtilities;
import com.icon.agromwinda.Utilities.AppUtility;
import com.icon.agromwinda.Utilities.ValueDataException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class FormSaveRural  extends Fragment {

    private View view;


    private EditText village, groupement, domicile;
    private Spinner spProvince, spSecteur, spTerritoire;
    private Button btnTermine;
    private Button btnRetA;
    private Province province;
    private Secteur secteur;
    private Territoire territoire;


    public static FormSaveRural newInstance(String json) {
        Bundle args = new Bundle();
        args.putString("data", json);
        FormSaveRural fragment = new FormSaveRural();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
      @Override
      public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          view = inflater.inflate(R.layout.flagment_milieu_rural, container, false);
          bindUI();
          init();
          bindEvents();
          return view;
      }



    private void bindUI() {

        spProvince = view.findViewById(R.id.spProvince);
        spTerritoire = view.findViewById(R.id.spTerritoire);
        spSecteur = view.findViewById(R.id.spSecteur);
        village = view.findViewById(R.id.village);
        groupement = view.findViewById(R.id.groupement);
        domicile = view.findViewById(R.id.domicile);



        btnTermine = view.findViewById(R.id.btnTermine);
        btnRetA = view.findViewById(R.id.btnRetA);

    }
    private void init() {
    }


    private void bindEvents() {

        spProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListProvinceActivity.class);
                startActivityForResult(intent, 7);
            }
        });

        spTerritoire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListTerritoireActivity.class);
                startActivityForResult(intent, 8);
            }
        });

        spSecteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListSecteurActivity.class);
                startActivityForResult(intent, 9);
            }
        });


        btnTermine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    AppUtility.controlValue(spProvince.getSelectedItem().toString(),"veuillez selectionné le province");
                    AppUtility.controlValue(village.getText().toString(),"veuillez Ecrire le nom svp");
                    AppUtility.controlValue(groupement.getText().toString(),"veuillez saisir le groupement svp");
                    AppUtility.controlValue(domicile.getText().toString(),"veuillez ecrire le numero svp");
                    AppUtility.controlValue(spSecteur.getSelectedItem().toString(),"veuillez selectionné le secteur svp");
                    AppUtility.controlValue(spTerritoire.getSelectedItem().toString(),"veuillez selectionné le territoires svp");


                    JSONObject json = new JSONObject();
                        json.put("spProvince",spProvince.getSelectedItem().toString());
                        json.put("village",village.getText().toString());
                        json.put("groupement",groupement.getText().toString());
                        json.put("domicile", domicile.getText().toString());
                        json.put("spSecteur",spSecteur.getSelectedItem().toString());
                        json.put("spTerritoire", spTerritoire.getSelectedItem().toString());

                   /* new FormSaveRural().SaveSubscriber(json.toString()).execute();*/




                } catch (ValueDataException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==7 && resultCode==77 && data!=null){
            province=new Gson().fromJson(data.getExtras().get("data").toString(),new TypeToken<Province>(){}.getType());
            /*spProvince.setText(province.getNom());
            spProvince.setTextColor(Color.BLACK);
            spProvince.setTypeface(Typeface.DEFAULT_BOLD);*/
        }else if(requestCode==8 && resultCode==78 && data!=null){
            territoire =new Gson().fromJson(data.getExtras().get("data").toString(),new TypeToken<Territoire>(){}.getType());
           /** spTerritoire.setText(territoire.getNom());
            spTerritoire.setTextColor(Color.BLACK);
            spTerritoire.setTypeface(Typeface.DEFAULT_BOLD);*/
        }else if(requestCode==9 && resultCode==79 && data!=null){
            secteur=new Gson().fromJson(data.getExtras().get("data").toString(),new TypeToken<Secteur>(){}.getType());
           /** spSecteur.setText(secteur.getNom());
            spSecteur.setTextColor(Color.BLACK);
            spSecteur.setTypeface(Typeface.DEFAULT_BOLD);*/
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
            subscriber.setUpdate_at(new Date());
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

}