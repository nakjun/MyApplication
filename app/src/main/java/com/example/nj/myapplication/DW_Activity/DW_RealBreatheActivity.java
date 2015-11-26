package com.example.nj.myapplication.DW_Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.nj.myapplication.R;

public class DW_RealBreatheActivity extends AppCompatActivity {
    ImageView cenImg;
    Thread changerThread;
    Bitmap one,two,three;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw_real_breathe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.dw_real_breathe_toolbar);
        toolbar.setTitle("");

        cenImg=(ImageView)findViewById(R.id.dw_real_breathe_cenImg);
        one=(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dw_breathe_4sec), 900, 1000, false));
        two=(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dw_breathe_7sec), 900, 1000, false));
        three=(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dw_breathe_8sec), 900, 1000, false));


        changerThread=new Thread(new Runnable() {
            @Override
            synchronized public void run() {
                player= MediaPlayer.create(getApplicationContext(), R.raw.dw_narration_breathe_intro);
                player.start();

                try {
                    wait(11500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=0;i<3;i++){
                    cenImg.post(new Runnable() {
                        @Override
                        public void run() {
                            cenImg.setImageBitmap(one);
                        }
                    });

                    player= MediaPlayer.create(getApplicationContext(), R.raw.dw_narration_breathe_4sec);
                    player.start();
                    try {
                        wait(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cenImg.post(new Runnable() {
                        @Override
                        public void run() {
                            cenImg.setImageBitmap(two);
                        }
                    });
                    player= MediaPlayer.create(getApplicationContext(), R.raw.dw_narration_breathe_7sec);
                    player.start();
                    try {
                        wait(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cenImg.post(new Runnable() {
                        @Override
                        public void run() {
                            cenImg.setImageBitmap(three);
                        }
                    });
                    player= MediaPlayer.create(getApplicationContext(), R.raw.dw_narration_breathe_8sec);
                    player.start();
                    try {
                        wait(8000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                startActivity(new Intent(DW_RealBreatheActivity.this, DW_ReleaseActivity.class));
            }
        });
        changerThread.start();

    }

}
