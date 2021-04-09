package com.dileep.secondproject.AlarmManager;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.dileep.secondproject.MaterialUI.HomeActivity;
import com.dileep.secondproject.R;

import static com.dileep.secondproject.AlarmManager.AlarmScreen.CHANNEL_ID;

public class BroadCastRecieverCustome extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

//        Toast.makeText(context, "Alaram triggered", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(context, HomeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent1, 0);

        Intent intent2 = new Intent(context, AlarmScreen.class);
        PendingIntent pendingIntent2 = PendingIntent.getActivity(context, 0, intent2, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("This is testing Notification")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("This is testing Notification..."))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.notification_icon,"Open",pendingIntent2);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());
    }
}
