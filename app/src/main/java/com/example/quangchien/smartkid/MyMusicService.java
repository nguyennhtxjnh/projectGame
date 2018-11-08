package com.example.quangchien.smartkid;


import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyMusicService extends Service {
    MediaPlayer mp_object;
    public MyMusicService() {


    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp_object.isPlaying()){
        mp_object.stop();}
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp_object = MediaPlayer.create(getApplicationContext(),R.raw.nen);
    }

    @SuppressLint("WrongConstant")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!mp_object.isPlaying()){
        mp_object.start();}
        return 0;
    }

}
