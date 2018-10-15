package com.example.quangchien.smartkid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class thinkingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

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
