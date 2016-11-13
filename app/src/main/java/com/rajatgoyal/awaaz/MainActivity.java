package com.rajatgoyal.awaaz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "myMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Help.class);
                startActivity(i);
            }
        });

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, MONTHS);

        //ImageView image= (ImageView)findViewById(R.id.image);
        //image.setBackgroundColor(Color.rgb(100,100,50));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    float f = (float)0.7;
    ViewGroup layout;

    public void click1(View v){
        Log.i(TAG,f+"");
        layout = (ViewGroup)findViewById(R.id.layout1);
        layout.setAlpha(1);
        startActivity(new Intent(this, TexttoSpeech.class));
        layout.setAlpha(f);
    }

    public void click2(View v){
        layout = (ViewGroup)findViewById(R.id.layout2);
        layout.setAlpha(1);
        startActivity(new Intent(this, SpeechtoText.class));
        layout.setAlpha(f);
    }

    public void click3(View v){
        layout = (ViewGroup)findViewById(R.id.layout3);
        layout.setAlpha(1);
        startActivity(new Intent(this, Recorder.class));
        layout.setAlpha(f);
    }

    public void click4(View v){
        layout = (ViewGroup)findViewById(R.id.layout4);
        layout.setAlpha(1);
        startActivity(new Intent(this, About.class));
        layout.setAlpha(f);
    }

    public void click5(View v){
        layout = (ViewGroup)findViewById(R.id.layout5);
        layout.setAlpha(1);
        startActivity(new Intent(this, SpeechToSpeech.class));
        layout.setAlpha(f);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_mail) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setData(Uri.parse("mail to:"));
            String to[]={"rajatgoyal715@gmail.com"};

            i.putExtra(Intent.EXTRA_EMAIL,to);
            i.putExtra(Intent.EXTRA_SUBJECT,"AWAAZ FEEDBACK");
            i.setType("message/rfc822");
            Intent chooser=Intent.createChooser(i,"Send Email");
            startActivity(chooser);
            return true;
        } else if(id == R.id.action_about) {
            Intent i= new Intent(this, About.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_text_to_speech) {
            startActivity(new Intent(this,TexttoSpeech.class));
        } else if (id == R.id.nav_speech_to_text) {
            startActivity(new Intent(this,SpeechtoText.class));
        } else if (id == R.id.nav_speech_to_speech) {
            startActivity(new Intent(this, SpeechToSpeech.class));
        } else if (id == R.id.nav_recorder) {
            startActivity(new Intent(this,Recorder.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(this,About.class));
        } else if (id == R.id.nav_share) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra("android.intent.extra.TEXT", "Enjoy AWAAZ app by converting text to speech and speech to text. Just click on the following link to download the app :\n" +
                    "https://play.google.com");
            Intent chooser = Intent.createChooser(i,"Share With");
            startActivity(chooser);
        } else if (id == R.id.nav_send) {
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://play.google.com"));
            Intent chooser = Intent.createChooser(i,"Open With");
            startActivity(chooser);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
