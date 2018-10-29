package com.example.quangchien.smartkid;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class ObserverActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mediaPlayer = MediaPlayer.create(ObserverActivity.this,R.raw.nen);
        mediaPlayer.start();
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_observer);
    }
    public void clickToApply(View view) {
        Intent intent = new Intent(this,ApplyActivity.class);
        startActivity(intent);
        if(mediaPlayer!= null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void clickToArrange(View view) {
        Intent intent = new Intent(this,ArrangeActivity.class);
        startActivity(intent);
        if(mediaPlayer!= null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void ClickToHome(View view) {
        finish();
        if(mediaPlayer!= null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }

    }
}
