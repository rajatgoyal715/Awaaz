package com.rajatgoyal.awaaz;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

/**
 * Created by mukul goyal on 6/17/2016.
 */
public class TexttoSpeech extends AppCompatActivity{

    TextToSpeech t1;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!= TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });
    }

    public void click(View v){
        EditText edit = (EditText)findViewById(R.id.edit);
        t1.speak(edit.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }
}
