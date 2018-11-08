package com.example.quangchien.smartkid;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class VictoryActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(VictoryActivity.this, R.raw.gioi);
        mediaPlayer.start();
        setContentView(R.layout.activity_victory);
    }

    public void clickToFinish(View view) {
            Intent intent1 = this.getIntent();
            this.setResult(RESULT_OK, intent1);
            mediaPlayer.stop();
           Intent intent = new Intent(VictoryActivity.this,MyMusicService.class);

            startService(intent);

            finish();
    }

}
