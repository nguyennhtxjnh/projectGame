package com.example.quangchien.smartkid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.nen);
        mediaPlayer.start();
        setContentView(R.layout.activity_chosse_style);

    }

//    public void ClickToFinish(View view) {
//        finish();
//    }

    public void clickToThinking(View view) {
        Intent intent = new Intent(this, thinkingActivity.class);
        startActivity(intent);
        if(mediaPlayer!= null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }



    }

    public void clickToObserver(View view) {
        Intent intent = new Intent(this,ObserverActivity.class);
        startActivity(intent);
        if(mediaPlayer!= null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }

    }

    public void clickToPractice(View view) {
        Intent intent = new Intent(this,PracticeActivity.class);
        startActivity(intent);
        if(mediaPlayer!= null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
}
