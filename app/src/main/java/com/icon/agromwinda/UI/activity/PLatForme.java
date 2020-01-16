package com.icon.agromwinda.UI.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.icon.agromwinda.R;

public class PLatForme extends AppCompatActivity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plat_forme);
        WebView webView =(WebView)findViewById(R.id.webview);
        webView.loadUrl("https://agromwinda.com");
        webView.setWebViewClient(new WebViewClient());
    }
}
