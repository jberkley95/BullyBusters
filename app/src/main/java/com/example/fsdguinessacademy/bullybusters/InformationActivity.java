package com.example.fsdguinessacademy.bullybusters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://eschooltoday.com/bullying/what-is-bullying-for-kids.html");
    }
}
