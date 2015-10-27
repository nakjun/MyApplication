package com.example.nj.myapplication.DP_Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nj.myapplication.R;

public class DPRateActivity extends Activity {

    ImageView img[] = new ImageView[5];
    Intent intent,getintent;
    int i;

    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dprate);

        init_imgView();
        intent = new Intent(DPRateActivity.this, DPWhere.class);
        getintent = getIntent();

        Toast.makeText(getApplicationContext(), "status"+str, Toast.LENGTH_SHORT).show();

        img[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("star_rate", 0 + "");
                Toast.makeText(getApplicationContext(), "You Select" + 1 + "stars", Toast.LENGTH_SHORT).show();
                startActivity(intent);

                finish();
            }
        });
        img[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("star_rate", 1 + "");
                Toast.makeText(getApplicationContext(), "You Select" + 2 + "stars", Toast.LENGTH_SHORT).show();
                startActivity(intent);

                finish();
            }
        });
        img[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("star_rate", 2 + "");
                intent.putExtra("status",str);
                Toast.makeText(getApplicationContext(), "You Select" + 3 + "stars", Toast.LENGTH_SHORT).show();
                startActivity(intent);

                finish();
            }
        });
        img[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("star_rate", 3 + "");

                Toast.makeText(getApplicationContext(), "You Select" + 4 + "stars", Toast.LENGTH_SHORT).show();
                startActivity(intent);

                finish();
            }
        });
        img[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("star_rate", 4 + "");

                Toast.makeText(getApplicationContext(), "You Select" + 5 + "stars", Toast.LENGTH_SHORT).show();
                startActivity(intent);

                finish();
            }
        });
    }

    void init_imgView() {
        img[0] = (ImageView) findViewById(R.id.image_veryrow_sel);
        img[1] = (ImageView) findViewById(R.id.image_row_sel);
        img[2] = (ImageView) findViewById(R.id.image_middle_sel);
        img[3] = (ImageView) findViewById(R.id.image_high_sel);
        img[4] = (ImageView) findViewById(R.id.image_veryhigh_sel);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dprate, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        for(int j = 0;j<5;j++){
            Destory(img[i]);
        }
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
