package com.example.umar.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver broad = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
       int lev = intent.getIntExtra("level",0);
            //ProgressBar pb = findViewById(R.id.progress);
           // pb.setProgress(lev);
            TextView tv = findViewById(R.id.tvShow);
            tv.setText("Battery level "+Integer.toString(lev)+"%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(broad,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }
}
