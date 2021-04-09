package com.dileep.secondproject.AlarmManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dileep.secondproject.MaterialUI.HomeActivity;
import com.dileep.secondproject.R;

import java.util.Calendar;

public class AlarmScreen extends AppCompatActivity {

    EditText timesec;
    Button start;
    public static String CHANNEL_ID="channel_1";
    public static String CHANNEL_NAME="Alarm notification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_screen);
        timesec=findViewById(R.id.timesec);
        start=findViewById(R.id.start);
        createNotificationChannel();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time=Integer.parseInt(timesec.getText().toString());
                setAlarm(time);
                // Create an explicit intent for an Activity in your app
                /*Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                Intent intent2 = new Intent(getApplicationContext(), AlarmScreen.class);
                PendingIntent pendingIntent2 = PendingIntent.getActivity(getApplicationContext(), 0, intent2, 0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("My notification")
                        .setContentText("This is testing Notification")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("This is testing Notification..."))
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setContentIntent(pendingIntent)
                        .addAction(R.drawable.notification_icon,"Open",pendingIntent2);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());

// notificationId is a unique int for each notification that you must define
                notificationManager.notify(1, builder.build());*/
            }
        });





    }

    public void setAlarm(int time){


        Intent intentbroadCast= new Intent(this, BroadCastRecieverCustome.class);
        PendingIntent pendingIntent1= PendingIntent.getBroadcast(AlarmScreen.this,101,intentbroadCast,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(time*1000), pendingIntent1);


    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            channel.setDescription("This is Alarm Notifications");
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}