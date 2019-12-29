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
import android.widget.TextView;

import com.icon.agromwinda.R;
import com.icon.agromwinda.Utilities.BasicCallback;


public class SuccessDialog extends Dialog {

    private Context context;
    private TextView btnClose;
    private BasicCallback callback;

    public SuccessDialog(@NonNull Context context, BasicCallback callback) {
        super(context);

        this.context = context;
        this.callback=callback;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_success);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        bindView();
        bindEvents();
    }


    private void bindView() {
        btnClose = findViewById(R.id.btnClose);
    }

    private void bindEvents() {
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                callback.onSucced(null);
            }
        });
    }
}
