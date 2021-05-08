package com.meomundo.webviewcommunicationtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_main );

        webView = findViewById( R.id.mainWebView );

        webView.setWebViewClient( new WebViewClient() );

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled( true );

    }

}