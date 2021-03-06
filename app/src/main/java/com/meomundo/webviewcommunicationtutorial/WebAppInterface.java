package com.meomundo.webviewcommunicationtutorial;

import android.content.Context;
import android.webkit.JavascriptInterface;

import java.util.Arrays;

public class WebAppInterface {

    private final Context context;

    private final MainActivity mainActivity;

    public WebAppInterface( Context context, MainActivity mainActivity ) {

        this.context        = context;
        this.mainActivity   = mainActivity;

    }

    @JavascriptInterface
    // This method will be available from within the WebView's Javascript code.
    public void receiveMessage( String message ) {

        String processedData = processMessage( message.toLowerCase() );

        mainActivity.sendResponseToWebView( processedData );

    }

    private String processMessage( String message ) {

        char []chars = message.toCharArray();

        Arrays.sort( chars );

        return String.valueOf( chars );

    }

}
