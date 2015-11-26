package com.example.nj.myapplication.DW_Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nj.myapplication.R;
import com.example.nj.myapplication.Util;

public class DW_BreatheActivity3 extends Activity {
    TextView topTextView,botTextView;
    ImageView centerImage;
    ImageButton backImage;
    Bitmap centerImageBitmap,backImageBitmap;
    Thread timer;
    MediaPlayer narration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw__breathe3);
        Util.setGlobalFont(this, getWindow().getDecorView());

        Toolbar toolbar = (Toolbar) findViewById(R.id.dw_breathe_3_toolbar);
        toolbar.setTitle("");

        backImageBitmap=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.common_back_button), 100, 100, false);
        backImage =(ImageButton)findViewById(R.id.dw_sec_back4);
        backImage.setImageBitmap(backImageBitmap);
        backImage.setBackgroundResource(R.color.transparent);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        topTextView=(TextView)findViewById(R.id.dw_breathe3_topText);
        topTextView.setTextSize(32);
        topTextView.setText(R.string.dw_breathe_title);

        botTextView=(TextView)findViewById(R.id. dw_breathe3_botText);
        botTextView.setTextSize(32);
        botTextView.setText(R.string.dw_8sec);

        centerImage=(ImageView)findViewById(R.id.dw_breathe3_image);
        centerImageBitmap=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dw_breathe_8sec), 900,1000, false);
        centerImage.setImageBitmap(centerImageBitmap);
        narration= MediaPlayer.create(getApplicationContext(), R.raw.dw_narration_6);
        narration.start();
        timer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(8500);
                    }
                    narration.pause();
                    startActivity(new Intent(DW_BreatheActivity3.this, DW_RealBreatheActivity.class));
                    centerImageBitmap.recycle();
                    backImageBitmap.recycle();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timer.start();
    }
    @Override
    protected void onResume() {
        super.onResume();
        narration.seekTo(0);
        narration.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        narration.pause();
        timer.interrupt();

        Destory(centerImage);
        Destory(backImage);
    }

    public void Destory(ImageView iv) {
        Drawable d = iv.getDrawable();
        if(d instanceof Drawable)
        {
            Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }
    }
}
