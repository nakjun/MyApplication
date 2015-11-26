package com.example.nj.myapplication.DP_Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nj.myapplication.R;
import com.example.nj.myapplication.Util;

public class DPWhere extends Activity {

    ImageView img1,img2,img3;
    Intent intent,get_intent;
    String str;

    public static String where;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpwhere);
        Util.setGlobalFont(this,getWindow().getDecorView());
        img1 = (ImageView)findViewById(R.id.imageView_academy);
        img2 = (ImageView)findViewById(R.id.imageView_school);
        img3 = (ImageView)findViewById(R.id.imageView_home);

        intent = new Intent(DPWhere.this,DPSixButtonSelect.class);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                where = "academy";
                startActivity(intent);
                finish();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                where = "school";
                startActivity(intent);
                finish();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                where = "home";
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    protected void onDestroy() {

        Destory(img1);
        Destory(img2);
        Destory(img3);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dpwhere, menu);
        return true;
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
