package com.example.quangchien.smartkid;

import android.content.ClipData;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;


import pl.droidsonroids.gif.GifImageView;

public class ApplyActivity extends AppCompatActivity {
    LinearLayout target1;
    GifImageView run, eat,run1,eat1;
    int flag = 0, thutu=0;
    Handler handler = new Handler();

    private Integer[] img1 = {R.drawable.pikachurun2,
            R.drawable.bo1,R.drawable.chuottui1
    };
    private Integer[] img2 = {R.drawable.pikachuan2,R.drawable.khi1,R.drawable.sutu1
    };

    private Integer[] img3 = {R.drawable.pikachuchay,
            R.drawable.bo,R.drawable.chuottui
    };

    private Integer[] img4 = {R.drawable.pikachu,R.drawable.khi,R.drawable.sutu
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_apply );


        run = (GifImageView) findViewById(R.id.img1);
        run1 = (GifImageView) findViewById(R.id.img12);
        eat = (GifImageView) findViewById(R.id.img2);
        eat1 = (GifImageView) findViewById(R.id.img22);
        target1 = (LinearLayout) findViewById(R.id.main);

        run.setOnDragListener(onDragListener);
        eat.setOnDragListener(onDragListener);
        target1.setOnDragListener(drag);


        run1.setOnTouchListener(onTouchListener);
        eat1.setOnTouchListener(onTouchListener);

    }


    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ClipData clipData = ClipData.newPlainText("","");
            View.DragShadowBuilder builder = new View.DragShadowBuilder(view);
            view.startDrag(clipData,builder,view,0);
            if(view.getId() == run1.getId()){
                run1.setVisibility(View.INVISIBLE);
            }
            if(view.getId() == eat1.getId()){
                eat1.setVisibility(View.INVISIBLE);
            }


            return true;
        }
    };

    View.OnDragListener onDragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:

                    run1.setVisibility(View.VISIBLE);
                    eat1.setVisibility(View.VISIBLE);

                    if(view.getId() == R.id.img12 && v.getId() == R.id.img1){
                        final GifImageView im = (GifImageView) findViewById(R.id.img1);
                        im.setImageResource(img3[thutu]);
                        final GifImageView im1 = (GifImageView) findViewById(R.id.img12);
                        im1.setImageResource(R.drawable.anhnull);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                flag++;
                                if(flag == 2){
                                    changeImage();
                                    flag = 0;

                                }
                            }
                        },2000);

                    }else if(view.getId() == R.id.img22 && v.getId() == R.id.img2){

                        final GifImageView im = (GifImageView) findViewById(R.id.img2);
                        im.setImageResource(img4[thutu]);
                        final GifImageView im1 = (GifImageView) findViewById(R.id.img22);
                        im1.setImageResource(R.drawable.anhnull);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                flag++;
                                if(flag == 2){
                                    changeImage();
                                    flag = 0;

                                }
                            }
                        },2000);
                    }
                    break;

            }
            return true;
        }
    };

    public void changeImage(){
        thutu++;
        Intent intent = new Intent();
        try {
//            run1.setVisibility(View.VISIBLE);
//            eat1.setVisibility(View.VISIBLE);
            run.setImageResource(img1[thutu]);
            run1.setImageResource(img3[thutu]);
            eat.setImageResource(img2[thutu]);
            eat1.setImageResource(img4[thutu]);
        }catch ( Exception e ){
            intent = new Intent(this,ObserverActivity.class);
            startActivity(intent);
        }
    }
    View.OnDragListener drag = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int d = dragEvent.getAction();
            final View v = (View) dragEvent.getLocalState();
            switch (d){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    run1.setVisibility(View.VISIBLE);
                    eat1.setVisibility(View.VISIBLE);
                    break;

            }  return true;}
    };
}
