package com.example.nj.myapplication.DP_Activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.nj.myapplication.R;

public class DP_PercentOfWeek extends Activity {

    ImageView backImage,backImage2;
    Bitmap back_color,crop_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dp__percent_of_week);

        backImage = (ImageView)findViewById(R.id.imageView_color1);
        backImage2 = (ImageView)findViewById(R.id.imageView_color2);

        back_color = Bitmap.createBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.dp_background_red));

        crop_image = cropCenterBitmap(back_color, back_color.getWidth(), back_color.getHeight()/(DPRateActivity.rates*20));
//주석!
        backImage.setImageBitmap(crop_image);
        backImage2.setImageBitmap(crop_image);
     //   backImage.setImageBitmap(back_color);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dp__percent_of_week, menu);
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

    public Bitmap cropCenterBitmap(Bitmap src, int w, int h) {
        if(src == null)
            return null;

        int width = src.getWidth();
        int height = src.getHeight();

        if(width < w && height < h)
            return src;

        int x = 0;
        int y = 0;

        if(width > w)
        {
            x = (width - w)/2;
        }
        if(height > h) {
            y = (height - h)/2;
        }

        int cw = w; // crop width
        int ch = h; // crop height

        if(w > width)
            cw = width;

        if(h > height)
            ch = height;

        return Bitmap.createBitmap(src, x, y, cw, ch);
    }
}
