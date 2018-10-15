package com.example.quangchien.smartkid;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class FeedAnimalActivity extends AppCompatActivity {
    GestureDetector gestureDetector;
    int khoangCach = 100;
    int vanToc = 100;
    int flag = 0;
    Handler handler = new Handler();
    int thucAnList[] = {R.drawable.feedanimal_banh, R.drawable.feedanimal_banhtroinuoc, R.drawable.feedanimal_banhtn,
            R.drawable.feedanimal_banhtn2, R.drawable.feedanimal_banhngot, R.drawable.feedanimal_banhngot2,
            R.drawable.feedanimal_banhngot3, R.drawable.feedanimal_banhngot4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);



        setContentView(R.layout.activity_feed_animal);
        LinearLayout ln1 = findViewById(R.id.feedanimal_layout_ponywish);
        ln1.setVisibility(View.INVISIBLE);
        ImageView imageView = findViewById(R.id.feedanimal_thucan);
        gestureDetector = new GestureDetector(this, new MyGeture());
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    class MyGeture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //trái sang phải
            if (e2.getX() - e1.getX() > khoangCach && Math.abs(velocityX) > vanToc) {
                if (flag >= (thucAnList.length / 2)) {
                    final ImageView image= findViewById(R.id.feedanimal_thucan);
                    image.setVisibility(View.INVISIBLE);
                    final GifImageView im = findViewById(R.id.feedanimal_pony);
                    im.setImageResource(R.drawable.feedanimal_pony_eating);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            im.setImageResource(R.drawable.feedanimal_pony);
                            image.setVisibility(View.VISIBLE);
                            doiAnh();
                        }
                    }, 2000);


                }
//                 im.setImageResource(R.drawable.pikachu1);

            }
            //Phải sang trái
            if (e1.getX() - e2.getX() > khoangCach && Math.abs(velocityX) > vanToc) {
                if (flag < (thucAnList.length / 2)) {
                    final GifImageView im = findViewById(R.id.feedanimal_pikachu);
                    im.setImageResource(R.drawable.feedanimal_pikachu_eating);
                    final ImageView image= findViewById(R.id.feedanimal_thucan);
                    image.setVisibility(View.INVISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            im.setImageResource(R.drawable.feedanimal_pikachu);
                            image.setVisibility(View.VISIBLE);
                            doiAnh();
                        }
                    }, 2000);
//                 im.setImageResource(R.drawable.pony);
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        void doiAnh() {
            ImageView anh = findViewById(R.id.feedanimal_thucan);
            Random rd = new Random();
            int num = rd.nextInt(thucAnList.length);

            anh.setImageResource(thucAnList[num]);
            flag = num;
            if (flag < (thucAnList.length / 2)) {
                LinearLayout ln = findViewById(R.id.feedanimal_layout_pikachuwish);
                ln.setVisibility(View.VISIBLE);
                ImageView img = findViewById(R.id.feedanimal_img_pikachuwish);
                img.setImageResource(thucAnList[flag]);
                LinearLayout ln1 = findViewById(R.id.feedanimal_layout_ponywish);
                ln1.setVisibility(View.INVISIBLE);
            } else {
                LinearLayout ln = findViewById(R.id.feedanimal_layout_pikachuwish);
                ln.setVisibility(View.INVISIBLE);

                LinearLayout ln1 = findViewById(R.id.feedanimal_layout_ponywish);
                ln1.setVisibility(View.VISIBLE);
                ImageView img = findViewById(R.id.feedanimal_img_ponywish);
                img.setImageResource(thucAnList[flag]);
            }

        }
    }

    public void ClickToFinish(View view) {
        finish();
    }
}
