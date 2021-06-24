package com.example.firstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class broad extends BroadcastReceiver {
    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        mp=MediaPlayer.create(context,R.raw.s);
        mp.start();
    }
}
