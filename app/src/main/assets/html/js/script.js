
const el = {
    form        : document.getElementById( "Demo" ),
    input       : document.getElementById( "Demo-Message-Input" ),
    output      : document.getElementById( "Demo-Response-Output" ),
    response    : document.getElementById( "Demo-Response" )
};

/**
 * Send data FROM the WebView TO the (native) app (code).
 */
function sendMessage() {

    "use strict";

    let input = el.input.value.trim();

    if( input === "" ) {
        return;
    }

    /*
     * "AndroidApp" is the handler to call the native Android code.
     * .receiveMessage() is the method to, well, recieve a message FROM THIS WEBVIEW.
     */
    AndroidApp.receiveMessage( input );

    console.log( "[WebView] A message has been sent to the native app code." );

}

/**
 * Receive data IN the WebView FROM the (native) app (code).
 */
function receiveResponse( data ) {

    "use strict";

    let output = ( "string" === typeof data ? data.trim() : "" );

    if( output === "" ) {

        console.log( "[WebView] No response data reveived!?" );

        return;

    }

    el.output.innerText = output;

    el.response.classList.remove( "hidden" );

}

el.form.addEventListener( "submit", sendMessage );
