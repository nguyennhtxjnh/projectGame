package com.example.quangchien.smartkid;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import pl.droidsonroids.gif.GifImageView;

public class ArrangeActivity extends AppCompatActivity {
    ImageView gau1, gau2, gau3, gau4, gaua, gaub, gauc, gaud, st1, st2, st3, st4, sta, stb, stc, std;
    GifImageView cho, mew;
    boolean flag1, flag2, flag3, flag4, flag5, flag6, flag7, flag8;

//    private  Integer image1[]  = {R.};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_arrange);

        gau1 = (ImageView) findViewById(R.id.img1);
        gaua = (ImageView) findViewById(R.id.img11);
        gau2 = (ImageView) findViewById(R.id.img2);
        gaub = (ImageView) findViewById(R.id.img22);
        gau3 = (ImageView) findViewById(R.id.img3);
        gauc = (ImageView) findViewById(R.id.img55);
        gau4 = (ImageView) findViewById(R.id.img4);
        gaud = (ImageView) findViewById(R.id.img66);

        cho = (GifImageView) findViewById(R.id.imgCho);
        mew = (GifImageView) findViewById(R.id.imgMew);

        st1 = (ImageView) findViewById(R.id.sutu1);
        sta = (ImageView) findViewById(R.id.img33);
        st2 = (ImageView) findViewById(R.id.sutu2);
        stb = (ImageView) findViewById(R.id.img44);
        st3 = (ImageView) findViewById(R.id.sutu3);
        stc = (ImageView) findViewById(R.id.img77);
        st4 = (ImageView) findViewById(R.id.sutu4);
        std = (ImageView) findViewById(R.id.img88);

        gaua.setOnDragListener(onDragListener);
        gaub.setOnDragListener(onDragListener);
        gauc.setOnDragListener(onDragListener);
        gaud.setOnDragListener(onDragListener);
        sta.setOnDragListener(onDragListener);
        stb.setOnDragListener(onDragListener);
        stc.setOnDragListener(onDragListener);
        std.setOnDragListener(onDragListener);


        gau1.setOnTouchListener(onTouchListener);
        gau2.setOnTouchListener(onTouchListener);
        gau3.setOnTouchListener(onTouchListener);
        gau4.setOnTouchListener(onTouchListener);
        st1.setOnTouchListener(onTouchListener);
        st2.setOnTouchListener(onTouchListener);
        st3.setOnTouchListener(onTouchListener);
        st4.setOnTouchListener(onTouchListener);

    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ClipData clipData = ClipData.newPlainText("", "");
            View.DragShadowBuilder builder = new View.DragShadowBuilder(view);
            view.startDrag(clipData, builder, view, 0);
//            view.setVisibility(View.INVISIBLE);
            return true;
        }
    };

    View.OnDragListener onDragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, 0, 0);
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:

//                    ImageView btn= (ImageView) event.getLocalState();
//                    if(v instanceof LinearLayout){
//                        btn.setVisibility(View.VISIBLE);
//                    }
//
//                    v.setVisibility(View.VISIBLE);
                    if (view.getId() == R.id.img1 && v.getId() == R.id.img11) {
                        flag1 = true;
                        final ImageView gif = findViewById(R.id.img11);
                        gif.setImageResource(R.drawable.a1);
                        gaua.setLayoutParams(lp);
                        gau1.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.img2 && v.getId() == R.id.img55) {
                        flag2 = true;
                        final ImageView img = findViewById(R.id.img55);
                        img.setImageResource(R.drawable.a2);
                        gaub.setLayoutParams(lp);
                        gau2.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.img3 && v.getId() == R.id.img66) {
                        flag3 = true;
                        final ImageView img = findViewById(R.id.img66);
                        img.setImageResource(R.drawable.a3);
                        gauc.setLayoutParams(lp);
                        gau3.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.img4 && v.getId() == R.id.img22) {
                        flag4 = true;
                        final ImageView img = findViewById(R.id.img22);
                        img.setImageResource(R.drawable.a4);
                        gaud.setLayoutParams(lp);
                        gau4.setVisibility(View.INVISIBLE);
                    }
//                    else if(flag1 == 1 && flag2 == 1 && flag3 == 1 && flag4 == 1){
//                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                        lp.setMargins(0, 0, 0, 0);
//                        gaua.setLayoutParams(lp);
//                        gaub.setLayoutParams(lp);
//                        gauc.setLayoutParams(lp);
//                        gaud.setLayoutParams(lp);
// }
                    else if (view.getId() == R.id.sutu1 && v.getId() == R.id.img88) {
                        flag5 = true;
                        final ImageView img = findViewById(R.id.img88);
                        img.setImageResource(R.drawable.mew1);
                        sta.setLayoutParams(lp);
                        st1.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.sutu2 && v.getId() == R.id.img33) {
                        flag6 = true;
                        final ImageView img = findViewById(R.id.img33);
                        img.setImageResource(R.drawable.mew2);
                        stb.setLayoutParams(lp);
                        st2.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.sutu3 && v.getId() == R.id.img44) {
                        flag7 = true;
                        final ImageView img = findViewById(R.id.img44);
                        img.setImageResource(R.drawable.mew3);
                        stc.setLayoutParams(lp);
                        st3.setVisibility(View.INVISIBLE);

                    } else if (view.getId() == R.id.sutu4 && v.getId() == R.id.img77) {
                        flag8 = true;
                        final ImageView img = findViewById(R.id.img77);
                        img.setImageResource(R.drawable.mew4);
                        std.setLayoutParams(lp);
                        st4.setVisibility(View.INVISIBLE);
                    }
//                    batHinh();
                    break;


            }


            if (flag1 == true && flag2 == true && flag3 == true && flag4 == true) {
                gaua.setVisibility(View.INVISIBLE);
                gaub.setVisibility(View.INVISIBLE);
                gauc.setVisibility(View.INVISIBLE);
                gaud.setVisibility(View.INVISIBLE);
                cho.setVisibility(View.VISIBLE);
            }
            if (flag5 == true && flag6 == true && flag7 == true && flag8 == true) {
                sta.setVisibility(View.INVISIBLE);
                stb.setVisibility(View.INVISIBLE);
                stc.setVisibility(View.INVISIBLE);
                std.setVisibility(View.INVISIBLE);
                mew.setVisibility(View.VISIBLE);
            }
            return true;
        }

//void batHinh(){
//            for (int i=0;i<8;i++){
//                if (fl[i]==false) {
//                    ImageView img = findViewById(anh[i]);
//                    img.setVisibility(View.VISIBLE);
//                }
//            }
//        }
    };
}
