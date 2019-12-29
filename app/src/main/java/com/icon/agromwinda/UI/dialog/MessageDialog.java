package com.icon.agromwinda.UI.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.icon.agromwinda.R;

public class MessageDialog {

    private static MessageDialog instance = null;

    private Dialog dialog;

    private TextView tvMessage;
    private Button btnOk;
    private Context context;


    public static MessageDialog getDialog(@NonNull Context context) {
        if(instance==null)
            instance = new MessageDialog(context);

        return instance;
    }


    private MessageDialog(@NonNull Context context){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_message);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
    }

    public MessageDialog createDialog(String message){
        tvMessage = (TextView) dialog.findViewById(R.id.tvMessage);
        btnOk = (Button) dialog.findViewById(R.id.btnOk)    ;

        bindEvents();

        if(tvMessage!=null)
            tvMessage.setText(message);

        return instance;
    }

    public void show(){
        if(dialog!=null)
            dialog.show();
    }

    private void bindEvents(){
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
