package com.dileep.secondproject.AlarmManager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dileep.secondproject.R;

import java.util.Calendar;

public class AlarmScreen extends AppCompatActivity {

    EditText timesec;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_screen);
        timesec=findViewById(R.id.timesec);
        start=findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setAlarm(10);
            }
        });





    }

    public void setAlarm(int time){


        Intent intentbroadCast= new Intent(this, BroadCastRecieverCustome.class);
        PendingIntent pendingIntent1= PendingIntent.getBroadcast(AlarmScreen.this,101,intentbroadCast,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(time*1000), pendingIntent1);


    }
}