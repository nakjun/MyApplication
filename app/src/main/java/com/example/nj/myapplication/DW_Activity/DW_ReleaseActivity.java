package com.example.nj.myapplication.DW_Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.*;
import android.widget.ImageView;

import com.example.nj.myapplication.R;

import java.util.ArrayList;

public class DW_ReleaseActivity extends AppCompatActivity {
    ArrayList<Bitmap> cenImgBitmap;
    ImageView cenImg;
    MediaPlayer player;
    static int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw__release);
        Toolbar toolbar = (Toolbar) findViewById(R.id.dw_release_toolbar);
        setTitle("");
        int id = R.drawable.dw_release_human_1;
        cenImgBitmap = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Bitmap temp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), id++),433, 1000, false);
            cenImgBitmap.add(temp);



        }
        cenImg = (ImageView) findViewById(R.id.dw_release_cenImg);
        final int timings[] = {48000, 67000, 69000, 81000, 74000, 92000, 97000, 40000};
        Thread timer = new Thread(new Runnable() {
            @Override
            synchronized public void run() {
                int soundInitialIndex=R.raw.dw_release_1;
                player = MediaPlayer.create(getApplicationContext(), R.raw.dw_release_ready);
                player.start();
                try {
                    wait(14000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 8; i++) {
                    player=MediaPlayer.create(getApplicationContext(), soundInitialIndex++);
                    player.start();
                    if(i<6) {

                        cenImg.post(new Runnable() {
                            @Override
                            public void run() {
                                cenImg.setImageBitmap(cenImgBitmap.get(index++));
                            }
                        });
                    }
                    if(i==0) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
                            anim.setDuration(2000);
                            cenImg.startAnimation(anim);
                        }
                    });


                    }
                    try {
                        wait(timings[i]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                startActivity(new Intent(DW_ReleaseActivity.this,DW_EndActivity.class));


            }
        });
        timer.start();
    }

}
