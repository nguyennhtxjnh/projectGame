package com.example.quangchien.smartkid;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class PickSamePictureActivity extends AppCompatActivity {
    int images[] = {R.drawable.trucxinh_a1, R.drawable.trucxinh_a3, R.drawable.trucxinh_a5, R.drawable.trucxinh_a7, R.drawable.trucxinh_a9, R.drawable.trucxinh_a11, R.drawable.trucxinh_a13, R.drawable.trucxinh_a15};
    int Vitri[] = {R.id.a1, R.id.a2, R.id.a3, R.id.a4, R.id.a5, R.id.a6, R.id.a7, R.id.a8, R.id.a9, R.id.a10, R.id.a11, R.id.a12, R.id.a13, R.id.a14, R.id.a15, R.id.a16};
    int soLuong[] = {2, 2, 2, 2, 2, 2, 2, 2};
    int ketQua[] = {17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17};
    int flag = 17;
    int pre = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_pick_same_picture);
        taoGame ();
    }

    public void taoGame() {
        ImageView img = findViewById (R.id.a1);
        for (int i = 0; i < Vitri.length; i++) {
            img = findViewById (Vitri[i]);
            while (true) {
                Random random = new Random ();
                int a = random.nextInt (8);
                if (soLuong[a] > 0) {
                    ketQua[i] = a;
                    soLuong[a]--;
                    break;
                }
            }
        }

    }

    public void btnClick(View view) {
        Handler handler = new Handler ();
        final ImageView img2 = findViewById (Vitri[Integer.parseInt (view.getTag ().toString ())]);
        if (flag == 17){
            pre = Vitri[Integer.parseInt (view.getTag ().toString ())];
            img2.setImageResource (images[ketQua[Integer.parseInt (view.getTag ().toString ())]]);
            flag = ketQua[Integer.parseInt (view.getTag ().toString ())]; // flag se la 0,1,2, hoac 3
        } else if(pre != Vitri[Integer.parseInt (view.getTag ().toString ())]) {
            img2.setImageResource (images[ketQua[Integer.parseInt (view.getTag ().toString ())]]);
//            img2.setImageResource (pre);
            if (flag == ketQua[Integer.parseInt (view.getTag ().toString ())]) { // neu 2 anh giong nhau

                final ImageView img4 = findViewById (Vitri[Integer.parseInt (view.getTag ().toString ())]);
                handler.postDelayed (new Runnable () {
                    @Override
                    public void run() {
                        ImageView img3 = findViewById (pre);
                        img3.setVisibility (View.INVISIBLE);
                        img4.setVisibility (View.INVISIBLE);
//                        img3.setImageResource (R.drawable.anhnull);
//                        img4.setImageResource (R.drawable.anhnull);
                        flag = 17;
                    }
                }, 1000);


            } else {
                final ImageView img4 = findViewById (Vitri[Integer.parseInt (view.getTag ().toString ())]);
                handler.postDelayed (new Runnable () {
                    @Override
                    public void run() {
                        ImageView img3 = findViewById (pre);
                        img3.setImageResource (R.drawable.trucxinh_a0);
                        img4.setImageResource (R.drawable.trucxinh_a0);
                        //truong hop sai
                        flag = 17;
                    }

                }, 1000);


// Vi tri la ID,


            }

        }
    }
}
