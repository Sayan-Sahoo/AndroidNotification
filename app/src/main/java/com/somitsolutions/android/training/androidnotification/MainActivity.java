package com.somitsolutions.android.training.androidnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends Activity implements OnClickListener{
	Button mButtonCreateNotification;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mButtonCreateNotification = (Button)findViewById(R.id.button1);
	}
	
	public void createNotification(View view) {
	    // Prepare intent which is triggered if the
	    // notification is selected
	    Intent intent = new Intent(this, NotificationReceiverActivity.class);
	    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

	    // Build notification
	    Notification noti = new Notification.Builder(this)
	        .setContentTitle("New mail from " + "som.mukhopadhyay@gmail.com")
	        .setContentText("Subject:Training")
	        .setSmallIcon(R.drawable.ic_launcher)
	        .setContentIntent(pIntent)
	        .build();
	    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	    // hide the notification after its selected
	    noti.flags |= Notification.FLAG_AUTO_CANCEL;

		Random random = new Random();
		int m = random.nextInt(9999 - 1000) + 1000;

	    notificationManager.notify(m, noti);
	  }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		createNotification(v);
	}
	
}
