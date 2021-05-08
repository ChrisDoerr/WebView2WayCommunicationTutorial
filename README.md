# Android WebView 2-way Communication Tutorial

Should you choose to include a WebView component into your Android app you might also be in need of having a 2-way communication. You might need to exchange data between the WebView's Javascript code and the native Android app code.

## The Premise

When I was researching on that topic I found lots of tutorials on how to send data via Javascript from the WebView to the app.

But literally nothing on how to send data from the app code to Javascript.

The scenario would be, for example, that something happens in the web app that triggers sending data to the app. In the native code you process the data, do what needs to be done, and **then** send a response back to the web app.

## The Issue

It's fairly easy to basically execute a Javascript function right after loading the HTML page for the first time. But not at any time later on.

## The Solution

What I hadn't thought about is where the WebView resides within the running app: The UI thread.

So basically you have to make sure that the response is send from that very UI thread as well!

## The Demo App

Enter a text message and send to the native app code.
There, two things will happen (for the purpose of demonstration):
* A native Toast message will be shown - to make visually clear that the app is still in control of the activity.
* The text message will be processed in a private method. It will break down the message character by character and sort them alphabetically. I know this is stupid...
The app will then call a WebView's Javascript function and pass the processd data along.
In the WebView, this new data will be shown in as plain text to demonstrate that data has been recieved.

## The Tutorial

The step-by-step tutorial will follow. But having this minimal app code already at hand might give an idea of how to approach this topic.

## Authors

* **Chris Doerr** - [meomdundo.com](https://www.meomundo.com)
