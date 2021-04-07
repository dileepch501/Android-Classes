package com.dileep.secondproject.AlarmManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadCastRecieverCustome extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Alaram triggered", Toast.LENGTH_SHORT).show();
    }
}
