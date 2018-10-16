package com.example.quangchien.smartkid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ObserverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
    }
    public void clickToApply(View view) {
        Intent intent = new Intent(this,ApplyActivity.class);
        startActivity(intent);
    }

    public void clickToArrange(View view) {
        Intent intent = new Intent(this,ArrangeActivity.class);
        startActivity(intent);
    }
}
