package com.icon.agromwinda.UI.fragment;

import android.os.Bundle;
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
import com.icon.agromwinda.UI.dialog.MessageDialog;
import com.icon.agromwinda.Utilities.AppUtility;
import com.icon.agromwinda.Utilities.ValueDataException;

import org.json.JSONException;
import org.json.JSONObject;

public class FormSavePerson extends Fragment {

    private View view;

    private EditText txNom, txPostnom, txPrenom, txNom_op, txNom_cooperative;
    private Spinner spSexe, spEtude, spAge;
    private Button btnNext;

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
        txNom_op = view.findViewById(R.id.txNom_op);
        txNom_cooperative = view.findViewById(R.id.txNom_cooperative);

        spSexe = view.findViewById(R.id.spSexe);
        spEtude = view.findViewById(R.id.spEtude);
        spAge = view.findViewById(R.id.spAge);

        btnNext = view.findViewById(R.id.btnNext);
    }

    public void init() {

    }

    public void bindEvents() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    AppUtility.controlValue(txNom.getText().toString(), "Veuillez entrer le nom svp");
                    AppUtility.controlValue(txPrenom.getText().toString(), "Veuillez entrer le postnom svp");
                    AppUtility.controlValue(spSexe.getSelectedItem().toString(), "Veuillez Selectionner le Sexe svp");
                    AppUtility.controlValue(spEtude.getSelectedItem().toString(), "Veuillez Selectionner le niveau d'étude");
                    AppUtility.controlValue(spAge.getSelectedItem().toString(), "Veuillez Selectionner l'âge svp");
                    AppUtility.controlValue(txNom_op.getText().toString(), "Veuillez entrer Nom de l'OP svp");
                    AppUtility.controlValue(txNom_cooperative.getText().toString(), "Veuillez entrer Nom de la cooperative affiliée svp");

                    JSONObject json = new JSONObject();
                    json.put("nom", txNom.getText().toString());
                    json.put("postnom", txPostnom.getText().toString());
                    json.put("prenom", txPrenom.getText().toString());
                    json.put("sexe", spSexe.getSelectedItem().toString());
                    json.put("niveauEtude", spEtude.getSelectedItem().toString());
                    json.put("age", spAge.getSelectedItem().toString());
                    json.put("nomOp", txNom_op.getText().toString());
                    json.put("nomCooperative", txNom_cooperative.getText().toString());


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
    }
}
