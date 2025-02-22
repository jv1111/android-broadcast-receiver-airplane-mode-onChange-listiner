package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final BroadcastReceiver myReceiver = new MyBroadcastReceiver();
    private final BroadcastReceiver planeReceiver = new BroadcastReceiverPlane();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("com.example.CUSTOM_ACTION");
        IntentFilter filterPlane = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            registerReceiver(myReceiver, filter, RECEIVER_EXPORTED); // Fix for API 31+
            registerReceiver(planeReceiver, filterPlane, RECEIVER_EXPORTED);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
        unregisterReceiver(planeReceiver);
    }

    public void btnSendBroadcast(View view) {
        Intent intent = new Intent("com.example.CUSTOM_ACTION");
        sendBroadcast(intent);
    }
}