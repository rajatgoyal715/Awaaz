package com.rajatgoyal.awaaz;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by mukul goyal on 6/18/2016.
 */
public class SpeechtoText extends AppCompatActivity {

    private final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView input;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        input = (TextView)findViewById(R.id.edit);
    }

    public void click(View v){
        Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_prompt));

        try{
            startActivityForResult(i, REQ_CODE_SPEECH_INPUT);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),getString(R.string.speech_not_supported),Toast.LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        switch(requestCode){
            case REQ_CODE_SPEECH_INPUT: {
                if(resultCode == RESULT_OK && null != data){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    input.setText(result.get(0));
                    input.setVisibility(View.VISIBLE);
                }
                break;
            }
        }
    }
}
