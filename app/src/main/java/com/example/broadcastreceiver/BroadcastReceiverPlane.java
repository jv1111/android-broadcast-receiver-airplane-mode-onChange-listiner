package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiverPlane extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
            String message = isAirplaneModeOn ? "Airplane Mode Enabled" : "Airplane Mode Disabled";
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
}
