package com.example.quangchien.smartkid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class DifferentActivity extends AppCompatActivity {
    GridView gvImg;
    private static int INPUT = 1;
    int thutu = 0;
    int [] img1 = {
            R.drawable.sutu,R.drawable.ap_gau, R.drawable.khi, R.drawable.diff_voi, R.drawable.apply_chimcanhcut,
            R.drawable.apply_meo, R.drawable.apply_cho,R.drawable.diff_khicon,R.drawable.diff_vet,R.drawable.diff_thocon,
            R.drawable.diff_khicon,R.drawable.diff_heo,R.drawable.apply_huucaoco,R.drawable.apply_nai,R.drawable.apply_ngua,
            R.drawable.diff_chocon
    };
    int [] img2 = {
            R.drawable.khi,R.drawable.gautruc, R.drawable.chuottui,R.drawable.diff_voi1,R.drawable.diff_chimcanhcut
            ,R.drawable.diff_meo1, R.drawable.dff_cho, R.drawable.diff_khicon1,R.drawable.diff_vet1,R.drawable.diff_thocon1,
           R.drawable.diff_khicon1,R.drawable.diff_heo1,R.drawable.diff_huu1,R.drawable.diff_nai1, R.drawable.dff_ngua,
            R.drawable.diff_chocon1
    };
    int[] img = {1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different);

        changeImage();

        gvImg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                try {
                    if(img[i] == img2[thutu]){
                        thutu++;
                        changeImage();

                    }
                }catch (Exception e){
                    finish();
                }

            }
        });


    }

    public void changeImage(){

        if(thutu <= img1.length){
            for(int i = 0; i<= 35;i++){
                img[i] = img1[thutu];
            }
            Random r = new Random();
            int n = r.nextInt(35);

            img[n] = img2[thutu];

            gvImg = findViewById(R.id.gvImg);
            final GridViewAdapter gridViewAdapter = new GridViewAdapter(this,img);
            gvImg.setAdapter(gridViewAdapter);
        }else{
            Intent intent = new Intent(this,VictoryActivity.class);
            startActivityForResult(intent,INPUT);
            finish();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INPUT) {
            if (resultCode == RESULT_OK) {
                finish();
            }
        }
    }

    public void clickToHome(View view) {
        finish();
    }
}
