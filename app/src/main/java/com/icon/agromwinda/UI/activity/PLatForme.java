package com.icon.agromwinda.UI.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;


import com.icon.agromwinda.R;

public class PLatForme extends AppCompatActivity {
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plat_forme);
        myDialog =  new  Dialog ( this );
    }
    /**
    public  void  ShowPopup ( View v ) {
        TextView txtclose;
        Button btnFollow;
        myDialog .setContentView ( R.layout.custompopup);
        txtclose = (TextView) myDialog .findViewById (R.id.txtclose);
        txtclose . setText ( " M " );
        btnFollow = ( Button ) myDialog.findViewById (R.id.btnfollow);
        txtclose . setOnClickListener ( nouvelle vue.OnClickListener (){

            public  void  onClick(View v){
                myDialog.rejeter();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(nouveau  ColorDrawable(Color.TRANSPARENT ));
        myDialog.spectacle();
    }
     */
}

