package com.example.quangchien.smartkid;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import pl.droidsonroids.gif.GifImageView;

public class Apply2Activity extends AppCompatActivity {
    MediaPlayer mediaPlayerCach, mediaPlayeryeah;
    private static int INPUT = 1;
    LinearLayout target1,target;
    GifImageView anh1, anh2,anh3,anh4,anh11,anh22,anh33,anh44, congra;
    int flag = 0, thutu=0;
    Handler handler = new Handler();

    private Integer[] img1 = {R.drawable.apply_chimcanhcut1,
            R.drawable.bo1,R.drawable.chuottui1
    };
    private Integer[] img2 = {R.drawable.apply_cho1,R.drawable.khi1,R.drawable.sutu1
    };

    private Integer[] img3 = {R.drawable.gautruc1,
            R.drawable.apply_chuot1,R.drawable.apply_meo1
    };
    private Integer[] img4 = {R.drawable.apply_huucaoco1,R.drawable.apply_nai1,R.drawable.apply_tho1
    };

    private Integer[] img5 = {R.drawable.apply_chimcanhcut,
            R.drawable.bo,R.drawable.chuottui
    };

    private Integer[] img6 = {R.drawable.apply_cho,R.drawable.khi,R.drawable.sutu
    };

    private Integer[] img7 = {R.drawable.gt,
            R.drawable.apply_chuot,R.drawable.apply_meo
    };

    private Integer[] img8 = {R.drawable.apply_huucaoco,R.drawable.apply_nai,R.drawable.apply_tho
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_apply2 );

        mediaPlayerCach = MediaPlayer.create(Apply2Activity.this, R.raw.cach);
        mediaPlayeryeah = MediaPlayer.create(Apply2Activity.this, R.raw.yeah);


        anh1 = (GifImageView) findViewById(R.id.img1);
        anh2 = (GifImageView) findViewById(R.id.img2);
        anh3 = (GifImageView) findViewById(R.id.img3);
        anh4 = (GifImageView) findViewById(R.id.img4);
        anh11 = (GifImageView) findViewById(R.id.img11);
        anh22 = (GifImageView) findViewById(R.id.img22);
        anh33 = (GifImageView) findViewById(R.id.img33);
        anh44 = (GifImageView) findViewById(R.id.img44);
        target1 = (LinearLayout) findViewById(R.id.apply2);
        anh1.setOnTouchListener(onTouchListener);
        anh2.setOnTouchListener(onTouchListener);
        anh3.setOnTouchListener(onTouchListener);
        anh4.setOnTouchListener(onTouchListener);

        anh11.setOnDragListener(onDragListener);
        anh22.setOnDragListener(onDragListener);
        anh33.setOnDragListener(onDragListener);
        anh44.setOnDragListener(onDragListener);
        target1.setOnDragListener(drag);




    }


    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ClipData clipData = ClipData.newPlainText("","");
            View.DragShadowBuilder builder = new View.DragShadowBuilder(view);
            view.startDrag(clipData,builder,view,0);

            if(view.getId() == anh1.getId()){
                anh1.setVisibility(View.INVISIBLE);
            }
            if(view.getId() == anh2.getId()){
                anh2.setVisibility(View.INVISIBLE);
            }
            if(view.getId() == anh3.getId()){
                anh3.setVisibility(View.INVISIBLE);
            }
            if(view.getId() == anh4.getId()){
                anh4.setVisibility(View.INVISIBLE);
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

                    anh1.setVisibility(View.VISIBLE);
                    anh2.setVisibility(View.VISIBLE);
                    anh3.setVisibility(View.VISIBLE);
                    anh4.setVisibility(View.VISIBLE);

                    if(view.getId() == R.id.img1 && v.getId() == R.id.img11){

                        mediaPlayerCach.start();
                        final GifImageView im = (GifImageView) findViewById(R.id.img11);
                        im.setImageResource(img8[thutu]);
                        final GifImageView im1 = (GifImageView) findViewById(R.id.img1);
                        im1.setImageResource(R.drawable.anhnull);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                flag++;
                                if(flag == 4){
                                        mediaPlayeryeah.start();

                                    target = (LinearLayout) findViewById(R.id.imgTarget) ;
                                    target.setVisibility(View.GONE);
                                    congra= (GifImageView) findViewById(R.id.congra);
                                    congra.setVisibility(View.VISIBLE);
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            changeImage();
                                        }
                                    },1500);

                                    flag = 0;

                                }
                            }
                        },2000);

                    }else if(view.getId() == R.id.img2 && v.getId() == R.id.img22){

                        mediaPlayerCach.start();
                        final GifImageView im = (GifImageView) findViewById(R.id.img22);
                        im.setImageResource(img6[thutu]);
                        final GifImageView im1 = (GifImageView) findViewById(R.id.img2);
                        im1.setImageResource(R.drawable.anhnull);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                flag++;
                                if(flag == 4){
                                        mediaPlayeryeah.start();

                                    target = (LinearLayout) findViewById(R.id.imgTarget) ;
                                    target.setVisibility(View.GONE);
                                    congra= (GifImageView) findViewById(R.id.congra);
                                    congra.setVisibility(View.VISIBLE);
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            changeImage();
                                        }
                                    },1500);

                                    flag = 0;

                                }
                            }
                        },2000);

                    }else
                    if(view.getId() == R.id.img3 && v.getId() == R.id.img33){

                        mediaPlayerCach.start();
                        final GifImageView im = (GifImageView) findViewById(R.id.img33);
                        im.setImageResource(img7[thutu]);
                        final GifImageView im1 = (GifImageView) findViewById(R.id.img3);
                        im1.setImageResource(R.drawable.anhnull);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                flag++;
                                if(flag == 4){
                                        mediaPlayeryeah.start();

                                    target = (LinearLayout) findViewById(R.id.imgTarget) ;
                                    target.setVisibility(View.GONE);
                                    congra= (GifImageView) findViewById(R.id.congra);
                                    congra.setVisibility(View.VISIBLE);
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            changeImage();
                                        }
                                    },1500);

                                    flag = 0;

                                }
                            }
                        },2000);


                    }else if(view.getId() == R.id.img4 && v.getId() == R.id.img44){

                        mediaPlayerCach.start();
                        final GifImageView im = (GifImageView) findViewById(R.id.img44);
                        im.setImageResource(img5[thutu]);
                        final GifImageView im1 = (GifImageView) findViewById(R.id.img4);
                        im1.setImageResource(R.drawable.anhnull);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                flag++;
                                if(flag == 4){

                                    mediaPlayeryeah.start();

                                    target = (LinearLayout) findViewById(R.id.imgTarget) ;
                                    target.setVisibility(View.GONE);
                                    congra= (GifImageView) findViewById(R.id.congra);
                                    congra.setVisibility(View.VISIBLE);
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            changeImage();
                                        }
                                    },1500);

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
        if(mediaPlayeryeah.isPlaying()){
            mediaPlayeryeah.pause();
        }
        thutu++;
        target = (LinearLayout) findViewById(R.id.imgTarget) ;
        target.setVisibility(View.VISIBLE);

        congra = (GifImageView) findViewById(R.id.congra);
        congra.setVisibility(View.GONE);

        if(thutu < img1.length) {
            anh1.setImageResource(img8[thutu]);
            anh2.setImageResource(img6[thutu]);
            anh3.setImageResource(img7[thutu]);
            anh4.setImageResource(img5[thutu]);
            anh11.setImageResource(img4[thutu]);
            anh22.setImageResource(img2[thutu]);
            anh33.setImageResource(img3[thutu]);
            anh44.setImageResource(img1[thutu]);
        }else {
            Intent intent = new Intent(this,VictoryActivity.class);
            startActivityForResult(intent,INPUT);
            finish();
//            Intent intent = this.getIntent();
//            this.setResult(RESULT_OK, intent);
//            finish();
        }
    }
    View.OnDragListener drag = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int d = dragEvent.getAction();
            final View v = (View) dragEvent.getLocalState();
            switch (d){
                case DragEvent.ACTION_DRAG_ENTERED:
//                    ImageView btn11= (ImageView) dragEvent.getLocalState();
//                    btn11.setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
//                    ImageView btn12= (ImageView) dragEvent.getLocalState();
//                    btn12.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    anh1.setVisibility(View.VISIBLE);
                    anh2.setVisibility(View.VISIBLE);
                    anh3.setVisibility(View.VISIBLE);
                    anh4.setVisibility(View.VISIBLE);
                    break;

            }  return true;}
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INPUT) {
            if (resultCode == RESULT_OK) {

                finish();

            }
        }
    }
}
