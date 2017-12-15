package com.example.bordia98.shortcut;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class bgmusicservice extends Service {
    MediaPlayer player;
    public bgmusicservice() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(this,R.raw.bgmusic1);
        player.setLooping(true);
        player.setVolume(50,100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return 1;
    }

    @Override
    public void onStart(Intent intent, int startId) {

    }

    public void onStop() {
        player.stop();

    }
    public void onPause() {
        player.stop();
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
