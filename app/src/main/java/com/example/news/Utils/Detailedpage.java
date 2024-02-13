package com.example.news.Utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.news.R;



public class Detailedpage extends AppCompatActivity {
    WebView webView;
    ProgressBar loader;
    TextView tvtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailedpage);



        webView = findViewById(R.id.webview);
        loader = findViewById(R.id.webViewLoader);

        Intent intent = getIntent();
        String url;
        String title;
        url = intent.getStringExtra("url");
        title=intent.getStringExtra("title");
        tvtitle=findViewById(R.id.head);
        tvtitle.setText(title);

        loader.setVisibility(View.VISIBLE);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        if (webView.isShown()){
            loader.setVisibility(View.INVISIBLE);
        }



    }
}