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
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.icon.agromwinda.BuildConfig;
import com.icon.agromwinda.Data.model.Activity;
import com.icon.agromwinda.Data.model.Agricole_information;
import com.icon.agromwinda.Data.model.Commune;
import com.icon.agromwinda.Data.model.Province;
import com.icon.agromwinda.Data.model.Secteur;
import com.icon.agromwinda.Data.model.Subscriber;
import com.icon.agromwinda.Data.model.Territoire;
import com.icon.agromwinda.Data.model.Town;
import com.icon.agromwinda.Data.model.Trade_information;
import com.icon.agromwinda.Data.model.Transport_information;
import com.icon.agromwinda.Data.repository.Dao;
import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.activity.DetailSubscriberActivity;
import com.icon.agromwinda.UI.activity.ListCommuneActivity;
import com.icon.agromwinda.UI.activity.ListProvinceActivity;
import com.icon.agromwinda.UI.activity.ListSecteurActivity;
import com.icon.agromwinda.UI.activity.ListTerritoireActivity;
import com.icon.agromwinda.UI.activity.ListVilleActivity;
import com.icon.agromwinda.UI.activity.ListingActivity;
import com.icon.agromwinda.UI.activity.ListingActivityPerson;
import com.icon.agromwinda.UI.dialog.MessageDialog;
import com.icon.agromwinda.UI.dialog.WaitingDialog;
import com.icon.agromwinda.Utilities.AppUtility;
import com.icon.agromwinda.Utilities.ValueDataException;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Date;

public class FormSaveAdresseActivity extends Fragment {

    private View view;
    private Spinner spchoixA;
    private ScrollView pan_rural, pan_urbain;

    private EditText txQuatier, txAvenue, txDomicile;
    private TextView spCommune, spVille, spProvince;
    private Button btnValider;
    private Button btnTermine;
    private Province province;
    private Town town;
    private Commune commune;
    private Territoire territoire;
    private Secteur secteur;
    private EditText txVillage, txGroupement;
    private TextView spProvinc, spTerritoire, spSecteur;
    long idDomain=0;


    public static FormSaveAdresseActivity newInstance(String json) {
        Bundle args = new Bundle();
        args.putString("data", json);
        FormSaveAdresseActivity fragment = new FormSaveAdresseActivity();
        fragment.setArguments(args);
        return fragment;
    }

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

        txQuatier = view.findViewById(R.id.txQuartier);
        txAvenue = view.findViewById(R.id.txAvenue);
        txDomicile = view.findViewById(R.id.txDomicile);
        txVillage = view.findViewById(R.id.txVillage);
        txGroupement = view.findViewById(R.id.txGroupement);

        spCommune = view.findViewById(R.id.spCommune);
        spProvince = view.findViewById(R.id.spProvince);
        spVille = view.findViewById(R.id.spVille);

        spProvinc = view.findViewById(R.id.spProvinc);
        spTerritoire = view.findViewById(R.id.spTerritoire);
        spSecteur = view.findViewById(R.id.spSecteur);

        btnValider = view.findViewById(R.id.btnTermine);

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

        spProvinc.setOnClickListener(new View.OnClickListener() {
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
                startActivityForResult(intent, 10);
            }
        });

        spSecteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListSecteurActivity.class);
                startActivityForResult(intent, 11);
            }
        });


        Log.d("SelectedACTIVITY", "");

        spchoixA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

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
                    default:
                        pan_rural.setVisibility(View.GONE);
                        pan_urbain.setVisibility(View.GONE);
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

                    if (spchoixA.getSelectedItem().toString().equals("Urbain") == false &&
                            spchoixA.getSelectedItem().toString().equals("Rural") == false) {
                        AppUtility.controlValue("", "Veuillez renseigner le type d'ativite svp");
                    }
                    if (spchoixA.getSelectedItem().toString().equals("Urbain")) {
                        AppUtility.controlValue(txQuatier.getText().toString(), "veuillez ecrire votre quartier");
                        AppUtility.controlValue(txAvenue.getText().toString(), "veuillez ecrire votre avenue");

                        AppUtility.controlValue(spProvince.getText().toString(), "Veuillez séléctionner la province svp");
                        AppUtility.controlValue(spVille.getText().toString(), "Veuillez séléctionner la town svp");
                        AppUtility.controlValue(spCommune.getText().toString(), "Veuillez séléctionner la commune svp");

                        JSONObject json = new JSONObject(getArguments().getString("data"));

                        json.put("physical_environment", spchoixA.getSelectedItem().toString());
                        json.put("quarter", txQuatier.getText().toString());
                        json.put("avenue", txAvenue.getText().toString());
                        json.put("home", txDomicile.getText().toString());
                        json.put("province_id", province.getId());
                        json.put("town_id", town.getId());
                        json.put("city_id ", commune.getId());

                        String type_activity=json.getString("type_activity");

                        switch (type_activity){
                            case "Commerce":
                                new saveTradeInformation().execute();
                                json.put("trade_information_id",idDomain) ;
                                break;
                            case "Transport":
                                new saveTransportInformation().execute();
                                json.put("transport_information_id",idDomain);
                                break;
                            case "Agricole":
                                new saveAgricoleInformation().execute();
                                json.put("agricole_information", idDomain);
                                break;
                        }

                        new saveActivity(json.toString()).execute();

                    } else {
                        AppUtility.controlValue(txVillage.getText().toString(), "Veuillez entrer le quartier svp");
                        AppUtility.controlValue(txGroupement.getText().toString(), "Veuillez entrer l'avenue svp");

                        AppUtility.controlValue(spProvinc.getText().toString(), "Veuillez séléctionner la province svp");
                        AppUtility.controlValue(spTerritoire.getText().toString(), "Veuillez séléctionner le territoire svp");
                        AppUtility.controlValue(spSecteur.getText().toString(), "Veuillez séléctionner le secteursvp");

                        JSONObject json = new JSONObject(getArguments().getString("data"));

                        json.put("physical_environment", spchoixA.getSelectedItem().toString());
                        json.put(" village", txVillage.getText().toString());
                        json.put("groupment", txGroupement.getText().toString());
                        json.put("home", txDomicile.getText().toString());
                        json.put("province_id", province.getId());
                        json.put("territory_id", territoire.getId());
                        json.put("secteur_id", secteur.getId());

                        json.put("province_id", 0);
                        json.put("town_id", 0);
                        json.put("city_id ", 0);

                        String type_activity=json.getString("type_activity");

                        switch (type_activity){
                            case "Commerce":
                                new saveTradeInformation().execute();
                                json.put("trade_information_id",idDomain) ;
                                break;
                            case "Transport":
                                new saveTransportInformation().execute();
                                json.put("transport_information_id",idDomain);
                                break;
                            case "Agricole":
                                new saveAgricoleInformation().execute();
                                json.put("agricole_information", idDomain);
                                break;
                        }
                        new saveActivity(json.toString()).execute();
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
        if (requestCode == 7 && resultCode == 77 && data != null) {
            province = new Gson().fromJson(data.getExtras().get("data").toString(), new TypeToken<Province>() {
            }.getType());
            spProvince.setText(province.getNom());
            spProvince.setTextColor(Color.BLACK);
            spProvince.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (requestCode == 8 && resultCode == 78 && data != null) {
            town = new Gson().fromJson(data.getExtras().get("data").toString(), new TypeToken<Town>() {
            }.getType());
            spVille.setText(town.getNom());
            spVille.setTextColor(Color.BLACK);
            spVille.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (requestCode == 9 && resultCode == 79 && data != null) {
            commune = new Gson().fromJson(data.getExtras().get("data").toString(), new TypeToken<Commune>() {
            }.getType());
            spCommune.setText(commune.getNom());
            spCommune.setTextColor(Color.BLACK);
            spCommune.setTypeface(Typeface.DEFAULT_BOLD);
        }

        if (requestCode == 7 && resultCode == 77 && data != null) {
            province = new Gson().fromJson(data.getExtras().get("data").toString(), new TypeToken<Province>() {
            }.getType());
            spProvinc.setText(province.getNom());
            spProvinc.setTextColor(Color.BLACK);
            spProvinc.setTypeface(Typeface.DEFAULT_BOLD);

        } else if (requestCode == 11 && resultCode == 81 && data != null) {
            secteur = new Gson().fromJson(data.getExtras().get("data").toString(), new TypeToken<Secteur>() {
            }.getType());
            spSecteur.setText(secteur.getNom());
            spSecteur.setTextColor(Color.BLACK);
            spSecteur.setTypeface(Typeface.DEFAULT_BOLD);

        } else if (requestCode == 10 && resultCode == 82 && data != null) {
            territoire = new Gson().fromJson(data.getExtras().get("data").toString(), new TypeToken<Territoire>() {
            }.getType());
            spTerritoire.setText(territoire.getNom());
            spTerritoire.setTextColor(Color.BLACK);
            spTerritoire.setTypeface(Typeface.DEFAULT_BOLD);

        }
    }

    public class saveTradeInformation extends AsyncTask<Void, Void, Long> {

        @Override
        protected Long doInBackground(Void... voids) {
            Dao dao=new Dao(getContext());
            Trade_information trade_information=new Trade_information();

           return dao.saveTrade_information(trade_information);
        }
        @Override
        protected void onPostExecute(Long aLong) {
          idDomain=aLong;
        }
    }

    public class saveTransportInformation extends AsyncTask<Void, Void, Long> {
        @Override
        protected Long doInBackground(Void... voids) {
            Dao dao=new Dao(getContext());
            Transport_information transport_information=new Transport_information();
            return dao.saveTransport_infomation(transport_information);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            idDomain=aLong;
        }
    }

    public class saveAgricoleInformation extends AsyncTask<Void, Void, Long> {
        @Override
        protected Long doInBackground(Void... voids) {
            Dao dao=new Dao(getContext());
            Agricole_information agricole_information= new Agricole_information();
            return dao.saveAgricole_infomation(agricole_information);
        }

        @Override
        protected void onPostExecute(Long aLong) {
           idDomain= aLong;
        }
    }

    public class saveActivity extends AsyncTask<Void, Void, Long> {

        private String data;
        WaitingDialog waitingDialog;

        public saveActivity(String data) {
            this.data = data;
            waitingDialog = new WaitingDialog(getContext());
        }
        @Override
        protected void onPreExecute() {
            waitingDialog.show();
        }
        @Override
        protected Long doInBackground(Void... voids) {
            Log.d("DATAACTIVITY", data);
            Activity activity = new Gson().fromJson(data, new TypeToken<Activity>() {
            }.getType());
            activity.setCreated_at(new Date());
            Dao dao = new Dao(getContext());
            long rep = dao.saveActivity(activity);
            Log.d("DATAACTIVITY", "" + rep);
            return rep;
        }

        @Override
        protected void onPostExecute(Long rep) {
            waitingDialog.hide();
            if (rep>0) {
                MessageDialog.getDialog(getContext()).createDialog("Votre Operation est un succès").show();
                Intent intent = new Intent(getActivity(), ListingActivity.class);
                getActivity().startActivity(intent);

            } else {
                MessageDialog.getDialog(getContext()).createDialog("Echec d'enregistrement").show();
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
