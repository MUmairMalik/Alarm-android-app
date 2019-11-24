package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.Button_set_alarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timePicker=findViewById(R.id.timePicker);
                Calendar calendar=Calendar.getInstance();
                if(Build.VERSION.SDK_INT>=23) {
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timePicker.getHour(),
                            timePicker.getMinute(),
                            0
                    );
                }
                else
                {
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timePicker.getCurrentHour(),
                            timePicker.getCurrentMinute(),
                            0
                    );

                }
                setAlarm(calendar.getTimeInMillis());



            }
        });

        findViewById(R.id.Button_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timePicker=findViewById(R.id.timePicker);
                Calendar calendar=Calendar.getInstance();
                if(Build.VERSION.SDK_INT>=23) {
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timePicker.getHour(),
                            timePicker.getMinute(),
                            0
                    );
                }
                else
                {
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timePicker.getCurrentHour(),
                            timePicker.getCurrentMinute(),
                            0
                    );

                }
                CancelAlarm(calendar.getTimeInMillis());



            }
        });

    }

    public void setAlarm(long alarm) {
        final AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(this,Alarming.class);
        final PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,alarm,AlarmManager.INTERVAL_DAY,pendingIntent);

        Toast.makeText(this,"Alarm is set",Toast.LENGTH_SHORT).show();


    }



    public void CancelAlarm(long alarm) {
        final AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(this,Alarming.class);
        final PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(this,"Alarm is cancelled",Toast.LENGTH_SHORT).show();


    }

}
