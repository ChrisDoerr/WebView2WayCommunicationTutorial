package com.meomundo.webviewcommunicationtutorial;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class WebAppInterface {

    private Context context;

    private MainActivity mainActivity;

    public WebAppInterface( Context context, MainActivity mainActivity ) {

        this.context        = context;
        this.mainActivity   = mainActivity;

    }

    @JavascriptInterface
    // This method will be available from within the WebView's Javascript code.
    public void receiveMessage( String message ) {

        mainActivity.sendResponseToWebView( message );

    }

}
