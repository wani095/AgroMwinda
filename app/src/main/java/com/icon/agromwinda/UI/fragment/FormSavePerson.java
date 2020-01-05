package com.icon.agromwinda.UI.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.icon.agromwinda.R;
import com.icon.agromwinda.UI.activity.AccueilApp;
import com.icon.agromwinda.UI.activity.MainActivity;
import com.icon.agromwinda.UI.dialog.MessageDialog;
import com.icon.agromwinda.Utilities.AppUtility;
import com.icon.agromwinda.Utilities.ValueDataException;

import org.json.JSONException;
import org.json.JSONObject;

public class FormSavePerson extends Fragment {

    private View view;

    private EditText txNom, txPostnom, txPrenom,txNom_op,txCooperative;
    private Spinner spSexe, spEtude, spAge;
    private Button btnNext;
    private Button btnRet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_form_save_person, container, false);
        bindUI();
        init();
        bindEvents();
        return view;
    }

    public void bindUI() {
        txNom = view.findViewById(R.id.txNom);
        txPostnom = view.findViewById(R.id.txPostnom);
        txPrenom = view.findViewById(R.id.txPrenom);


        spSexe = view.findViewById(R.id.spSexe);
        spEtude = view.findViewById(R.id.spEtude);
        spAge = view.findViewById(R.id.spAge);
        txNom_op=view.findViewById(R.id.txNom_op);
        txCooperative=view.findViewById(R.id.txNom_cooperative);

        btnNext = view.findViewById(R.id.btnNext);
        btnRet = view.findViewById(R.id.btnRet);
    }

    public void init() {

    }

    public void bindEvents() {


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    AppUtility.controlValue(txNom.getText().toString(), "Veuillez Renseigner le nom svp");
                    AppUtility.controlValue(txPrenom.getText().toString(), "Veuillez Renseigner le postnom svp");

                    if(spSexe.getSelectedItem().toString().equals("---")){
                        AppUtility.controlValue(spSexe.getSelectedItem().toString(), "Veuillez Renseigner le Sexe svp");
                    }

                    if(spEtude.getSelectedItem().toString().equals("Aucune")){
                        AppUtility.controlValue("", "Veuillez Renseigner le niveau d'étude");
                    }

                    AppUtility.controlValue(spAge.getSelectedItem().toString(), "Veuillez Renseigner l'âge svp");
                    AppUtility.controlValue(txNom_op.getText().toString(), "Veuillez Renseigner l'Organisation Paysanne svp");
                    AppUtility.controlValue(txCooperative.getText().toString(), "Veuillez Renseigner la cooperative svp");



                    JSONObject json = new JSONObject();
                    json.put("firstname", txNom.getText().toString());
                    json.put("lastname", txPostnom.getText().toString());
                    json.put("name", txPrenom.getText().toString());
                    json.put("sexe", spSexe.getSelectedItem().toString());
                    json.put("leve_of_study", spEtude.getSelectedItem().toString());
                    json.put("age", spAge.getSelectedItem().toString());
                    json.put("peasant_organization",txNom_op.getText().toString());
                    json.put("cooperative",txCooperative.getText().toString());


                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_content, FormSavePersonNext1.newInstance(json.toString()));
                    transaction.addToBackStack(null);
                    transaction.commit();

                } catch (ValueDataException e) {
                    MessageDialog.getDialog(getContext()).createDialog(e.getMessage()).show();
                } catch (JSONException e) {

                }
            }
        });

        btnRet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
