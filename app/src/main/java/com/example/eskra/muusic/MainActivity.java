package com.example.eskra.muusic;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Context;
import android.util.Log;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter iFilter =  new IntentFilter();
        iFilter.addAction("com.android.music.metachanged");
        iFilter.addAction("com.miui.player.metachanged");
        iFilter.addAction("com.htc.music.metachanged");
        iFilter.addAction("com.nullsoft.winamp.metachanged");
        iFilter.addAction("com.real.IMP.metachanged");

        registerReceiver(myReceiver , iFilter);
    }

    BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String cmd = intent.getStringExtra("command");
            Log.d("mIntReceiver.onReceive ", action + " / " + cmd);
            String artist = intent.getStringExtra("artist");
            String album = intent.getStringExtra("album");
            String track = intent.getStringExtra("track");
            Log.d("Music", artist + ":" + album + ":" + track);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
