package com.rajatgoyal.awaaz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by mukul goyal on 6/18/2016.
 */
public class About extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //WebView browser = (WebView)findViewById(R.id.webview);
    //browser.setWebViewClient(new MyWebViewClient());

    Intent i=null,chooser=null;
    public void click1(View v){
        //browser.loadUrl("https://in.linkedin.com/in/rajat-goyal-807b43b8");
        i = new Intent(android.content.Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://in.linkedin.com/in/rajat-goyal-807b43b8"));
        chooser = Intent.createChooser(i,"View Profile");
        startActivity(chooser);
    }

    public void click2(View v){
        //i = new Intent("android.intent.action.SEND");
        i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra("android.intent.extra.TEXT","please click on the following link to download my app : https://play.google.com");
        chooser = Intent.createChooser(i,"Share With");
        startActivity(chooser);
    }

    public void click3(View v){
        i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mail to:"));
        String to[]={"rajatgoyal715@gmail.com"};

        i.putExtra(Intent.EXTRA_EMAIL,to);
        i.putExtra(Intent.EXTRA_SUBJECT,"AWAAZ FEEDBACK");
        i.setType("message/rfc822");
        chooser=Intent.createChooser(i,"Send Email");
        startActivity(chooser);
    }
}
