package com.example.quangchien.smartkid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class thinkingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_thinking);
    }

    public void ClickToFinish(View view) {
        finish();
    }

    public void ClickToMaze(View view) {
        Intent intent = new Intent(this, MazeActivity.class);
        startActivity(intent);

    }

    public void ClickToFeedAnimal(View view) {
        Intent intent = new Intent(this, FeedAnimalActivity.class);
        startActivity(intent);
    }
}
