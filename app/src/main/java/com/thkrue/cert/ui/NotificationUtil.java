package com.thkrue.cert.ui;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.thkrue.cert.DataListActivity;

public class NotificationUtil {

    private static final String CHANNEL_ID = "42";

    public void showNotification(Context c, String title, String text, int drawable) {

        createNotificationChannel(c);//only used on 26+

        NotificationCompat.Builder builder = new NotificationCompat.Builder(c, CHANNEL_ID)
                .setSmallIcon(drawable)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(createPendingIntent(c))
                .setAutoCancel(true);
//                .setStyle(new NotificationCompat.BigTextStyle().bigText(text))


        NotificationManagerCompat.from(c).notify((int) System.currentTimeMillis(), builder.build());
    }

    private PendingIntent createPendingIntent(Context c) {
        return PendingIntent.getActivity(c, 0, new Intent(c, DataListActivity.class), 0);
    }

    private void createNotificationChannel(Context c) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "channel name", importance);
            channel.setDescription("channel desc");
            NotificationManager notificationManager = c.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
