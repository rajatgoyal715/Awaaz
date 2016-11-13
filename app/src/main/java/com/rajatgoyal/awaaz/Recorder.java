package com.rajatgoyal.awaaz;

import android.media.Image;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mukul goyal on 6/18/2016.
 */
public class Recorder extends AppCompatActivity{

    ImageView image1,image2,image3;
    private MediaRecorder myrecorder;
    private String outputFile = null;
    private static boolean flag=false;
    private static final String TAG="myMessage";

    TextView txt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        image1 = (ImageView)findViewById(R.id.image1);
        image2 = (ImageView)findViewById(R.id.image2);
        image3 = (ImageView)findViewById(R.id.image3);
    }

    public void click1(View v){
        txt=(TextView)findViewById(R.id.clock_text);
        txt.setText("changing text");
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";

        myrecorder = new MediaRecorder();
        //myrecorder.reset();
        myrecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myrecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myrecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myrecorder.setOutputFile(outputFile);
        try{
            myrecorder.prepare();
            myrecorder.start();
        }catch(IllegalStateException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        image1.setVisibility(View.INVISIBLE);
        image2.setVisibility(View.VISIBLE);

        flag=true;
        Log.i(TAG,"flag sett to true");

//        Date d= new Date();
//        int h=d.getHours();
//        int m=d.getMinutes();
//        int s=d.getSeconds();
//        startTimer(h, m, s);

        Toast.makeText(getApplicationContext(),"Recording Started",Toast.LENGTH_LONG).show();
    }

    public void click2(View v){

        flag=false;
        Log.i(TAG,"flag sett to false");

        myrecorder.stop();
        myrecorder.release();
        myrecorder = null;

        image2.setVisibility(View.INVISIBLE);
        image3.setVisibility(View.VISIBLE);

        Toast.makeText(getApplicationContext(),"Audio Recorded Successfully",Toast.LENGTH_LONG).show();
    }

    public void click3(View v) throws IllegalArgumentException,SecurityException,IllegalStateException{
        MediaPlayer m = new MediaPlayer();
        try{
            m.setDataSource(outputFile);
        }
        catch(IOException e){
            Toast.makeText(getApplicationContext(),"Please Record First",Toast.LENGTH_LONG).show();
            e.printStackTrace();
            return;
        }
        catch(NullPointerException e){
            Toast.makeText(getApplicationContext(),"Please Record First",Toast.LENGTH_LONG).show();
            return;
        }

        try{
            m.prepare();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        m.start();
        Toast.makeText(getApplicationContext(),"Playing Audio",Toast.LENGTH_LONG).show();

        image1.setVisibility(View.VISIBLE);
        image2.setVisibility(View.VISIBLE);
    }

//    public void startTimer(int h, int m, int s){
//
////        String htime=String.format("##",hours);
////        String mtime=String.format("##",minutes);
////        String stime=String.format("##",seconds);
//
//        MyClass thread = new MyClass(h,m,s);
//        //thread.run();
//        while(flag){
//            txt = (TextView) findViewById(R.id.clock_text);
//            Log.i(TAG,"loop started");
//            Date date = new Date();
//            int h1=date.getHours();
//            int m1=date.getMinutes();
//            int s1=date.getSeconds();
//
//            int htime=h1-h;
//            int mtime=m1-m;
//            int stime=s1-s;
//            if(stime<0){
//                stime+=60;
//                mtime-=1;
//            }
//            if(mtime<0){
//                mtime+=60;
//                htime-=1;
//            }
//            String time = htime+":"+mtime+":"+stime;
//            txt.setText(time);
//            Log.i(TAG, time + "");
//            Log.i(TAG,"Text changed");
//
//            try {
//                Thread.sleep(1000);
//            }catch(Exception e){
//                Log.i(TAG, "Exception in thread method");
//            }
//
//        }
//
//        //String currentDateTimeString = new SimpleDateFormat("HH:mm:ss").format(new Date());
//        //txt.setText(currentDateTimeString);
//    }
}

//class MyClass extends AppCompatActivity implements Runnable{
//
//    private static final String TAG = "myMessage";
//    TextView txt;
//    int h,m,s;
//    MyClass(int hour,int minute,int second){
//        h=hour;
//        m=minute;
//        s=second;
//    }
//    public void run(){
//        txt = (TextView)findViewById(R.id.clock_text);
//        Log.i(TAG,"runnable method started");
//        Date date = new Date();
//        int h1=date.getHours();
//        int m1=date.getMinutes();
//        int s1=date.getSeconds();
//
//        int htime=h1-h;
//        int mtime=m1-m;
//        int stime=s1-s;
//        if(stime<0){
//            stime+=60;
//            mtime-=1;
//        }
//        if(mtime<0){
//            mtime+=60;
//            htime-=1;
//        }
//        String time = htime+":"+mtime+":"+stime;
//        txt.setText(time);
//        Log.i(TAG, time + "");
//        Log.i(TAG,"Text changed");
//
//        try {
//            Thread.sleep(1000);
//        }catch(Exception e){
//            Log.i(TAG, "Exception in thread method");
//        }
//    }
//}
