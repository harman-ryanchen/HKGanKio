package com.example.ryan.hkgankio.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.example.ryan.hkgankio.R;
import com.example.ryan.hkgankio.view.notification.NotificationActivity;

/**
 * Created by studio02 on 5/18/16.
 */
public class PollingService extends Service {
    public static final String ACTION = "com.example.ryan.hkgankio.service.PollingService";

    private Notification mNotification;
    private NotificationManager mManager;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onStart(Intent intent, int startId) {
        new PollingThread().start();
    }

    /**
     * Send a sample notification using the NotificationCompat API.
     */
    public void sendNotification() {


        /** Create an intent that will be fired when the user clicks the notification.
         * The intent needs to be packaged into a {@link android.app.PendingIntent} so that the
         * notification service can fire it on our behalf.
         */
        Intent intent = new Intent(this,
                NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        // BEGIN_INCLUDE (build_notification)
        /**
         * Use NotificationCompat.Builder to set up our notification.
         */
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        /** Set the icon that will appear in the notification bar. This icon also appears
         * in the lower right hand corner of the notification itself.
         *
         * Important note: although you can use any drawable as the small icon, Android
         * design guidelines state that the icon should be simple and monochrome. Full-color
         * bitmaps or busy images don't render well on smaller screens and can end up
         * confusing the user.
         */
        builder.setSmallIcon(R.drawable.ic_launcher);

        // Set the intent that will fire when the user taps the notification.
        builder.setContentIntent(pendingIntent);

        // Set the notification to auto-cancel. This means that the notification will disappear
        // after the user taps it, rather than remaining until it's explicitly dismissed.
        builder.setAutoCancel(true);

        /**
         *Build the notification's appearance.
         * Set the large icon, which appears on the left of the notification. In this
         * sample we'll set the large icon to be the same as our app icon. The app icon is a
         * reasonable default if you don't have anything more compelling to use as an icon.
         */
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

        /**
         * Set the text of the notification. This sample sets the three most commononly used
         * text areas:
         * 1. The content title, which appears in large type at the top of the notification
         * 2. The content text, which appears in smaller text below the title
         * 3. The subtext, which appears under the text on newer devices. Devices running
         *    versions of Android prior to 4.2 will ignore this field, so don't use it for
         *    anything vital!
         */
        builder.setContentTitle("BasicNotifications Sample");
        builder.setContentText("Time to learn about notifications!");
        builder.setSubText("Tap to view documentation about notifications.");

        // END_INCLUDE (build_notification)


        /**
         * Send the notification. This will immediately display the notification icon in the
         * notification bar.
         */
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());

    }

    /**
     * Polling thread
     * 模拟向Server轮询的异步线程
     *
     * @Author Ryan
     * @Create 2013-7-13 上午10:18:34
     */
    int count = 0;

    class PollingThread extends Thread {
        @Override
        public void run() {
            System.out.println("Polling...");
//            count++;
            //当计数能被5整除时弹出通知
            sendNotification();
//            if (count % 5 == 0) {
//                System.out.println("New message!");
//            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service:onDestroy");
    }

}
