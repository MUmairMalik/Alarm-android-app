package com.example.assignment4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.provider.Settings;
import android.widget.Toast;

public class Alarming extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MediaPlayer mp=MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mp.start();

        //?????


      //  Intent t=new Intent();
        //DialogActivity da=new DialogActivity();
        //da.alertScreen();
    }


}
