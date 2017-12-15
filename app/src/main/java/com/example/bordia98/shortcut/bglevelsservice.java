package com.example.bordia98.shortcut;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class bglevelsservice extends Service {
    MediaPlayer play;
    public bglevelsservice() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        play=MediaPlayer.create(this,R.raw.bglevels);
        play.setLooping(true);
        play.setVolume(50,100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        play.start();
        return 1;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        play.stop();
        play.release();
    }
    
    public void onStop() {
        play.stop();

    }
    public void onPause() {
        play.stop();
    }



    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
