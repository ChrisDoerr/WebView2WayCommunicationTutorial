package com.meomundo.webviewcommunicationtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

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

    public void sendResponseToWebView( String response ) {

            try {

                // Execute javascript function in the WebView
                // The important part is that is has to run in the UI Thread!!!
                runOnUiThread( () -> webView.loadUrl( "javascript:receiveResponse('" + response + "');" ) );

            } catch ( Exception ex ) {

                Log.d( TAG, ex.toString() );

            }

            // Also show a native message/toast to demonstrate that the app (code) is active besides the WebView.
            Toast.makeText( webView.getContext(), "I got your message, thanks!", Toast.LENGTH_LONG ).show();

        }

    }

}