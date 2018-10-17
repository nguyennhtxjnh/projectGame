package com.example.quangchien.smartkid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] backGround = {R.drawable.animalbg, R.drawable.familybg, R.drawable.schoolbg};
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_main);
    }

    public void ClickToMain(View view) {
        switch (flag) {
            case 0:
                Intent intent = new Intent(this, ChosseStyle.class);
                startActivity(intent);
                break;
            default:
                break;
        }


    }


    public void sangPhai(View view) {
        if (flag < (backGround.length - 1)) {
            flag++;
            ImageView img = findViewById(R.id.imStyle);
            img.setImageResource(backGround[flag]);
        }
    }

    public void sangTrai(View view) {
        if (flag > 0) {
            flag--;
            ImageView img = findViewById(R.id.imStyle);
            img.setImageResource(backGround[flag]);
        }
    }
}
