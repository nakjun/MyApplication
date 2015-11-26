package com.example.nj.myapplication.DP_Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nj.myapplication.R;

import java.util.Random;

public class DPSelectActivity extends Activity {
    ImageView img;
    Intent i;

    TextView t[]=new TextView[6];

    public static int status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpselect);

        i = new Intent(DPSelectActivity.this, DPRateActivity.class);
        status = 0;

        set_onclick_status();

        img = (ImageView)findViewById(R.id.image_dpdescript);
    }

    void set_onclick_status()
    {
        t[0]=(TextView)findViewById(R.id.TextView_red);
        t[1]=(TextView)findViewById(R.id.TextView_yellow);
        t[2]=(TextView)findViewById(R.id.TextView_green);
        t[3]=(TextView)findViewById(R.id.TextView_sky);
        t[4]=(TextView)findViewById(R.id.TextView_blue);
        t[5]=(TextView)findViewById(R.id.TextView_pink);

        t[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 0;
                startActivity(i);
                finish();
            }
        });
        t[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 1;
                startActivity(i);
                finish();
            }
        });

        t[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 2;
                startActivity(i);
                finish();
            }
        });
        t[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 3;
                startActivity(i);
                finish();
            }
        });
        t[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 4;
                startActivity(i);
                finish();
            }
        });
        t[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 5;
                startActivity(i);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dpselect, menu);
        return true;
    }

    @Override
    protected void onDestroy() {

        Destory(img);

        super.onDestroy();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
