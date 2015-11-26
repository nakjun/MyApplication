package com.example.nj.myapplication.SM_Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nj.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SM_Activity_2 extends AppCompatActivity {
    Calendar cal;
    TextView dayz[];
    SimpleDateFormat dateFormat;
    ImageButton imagebtn, tableImageButton[];
    Bitmap btnBitmap, tableBitmapArray[];
    boolean available[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sm_activity_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.sm_2_toolbar);
        toolbar.setTitle("");
        toolbar.setTitleTextAppearance(getApplicationContext(), R.style.TextSize36);
        setSupportActionBar(toolbar);

        String day = "";
        cal = Calendar.getInstance();
        String datetype = new String(cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH) + cal.get(Calendar.DAY_OF_MONTH) + "");
        dateFormat = new SimpleDateFormat(datetype);
        int daynum = cal.get(Calendar.DAY_OF_WEEK);

        dayz = new TextView[7];
        dayz[0] = (TextView) findViewById(R.id.sm_2_table_00);
        dayz[1] = (TextView) findViewById(R.id.sm_2_table_01);
        dayz[2] = (TextView) findViewById(R.id.sm_2_table_02);
        dayz[3] = (TextView) findViewById(R.id.sm_2_table_03);
        dayz[4] = (TextView) findViewById(R.id.sm_2_table_04);
        dayz[5] = (TextView) findViewById(R.id.sm_2_table_05);
        dayz[6] = (TextView) findViewById(R.id.sm_2_table_06);
        int limit=0;
        int todayposition = cal.get(Calendar.DATE);
        cal.add(Calendar.DATE, 0 - (daynum - 2));
        for (int i = 0; i < 7; i++) {
            dayz[i].setText((cal.get(Calendar.MONTH) + 1) + "." + cal.get(Calendar.DAY_OF_MONTH) + "\n(" + getDayofWeek(cal.get(Calendar.DAY_OF_WEEK)) + ")");
            if (cal.get(Calendar.DATE) == todayposition) {
                limit = i;
            }
            cal.add(Calendar.DATE, 1);
        }


        available = new boolean[7];
        //************dummy dummy dummy dummy
        for (int i = 0; i < 7; i++) {
            if(i==limit)
                available[i] = true;
            else{
                available[i]=false;
            }
        }
        //dummy dummy dummy dummy over
        tableBitmapArray = new Bitmap[7];
        for (int i = 0; i < 7; i++) {
            if (i <= limit) {
                if (available[i]) {
                    tableBitmapArray[i] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_2_go_on_finger), 60, 60, false);
                } else {
                    tableBitmapArray[i] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_2_done_footstep), 60, 60, false);
                }
            }
        }
        tableImageButton = new ImageButton[7];
        tableImageButton[0] = (ImageButton) findViewById(R.id.sm_2_table_10);
        tableImageButton[1] = (ImageButton) findViewById(R.id.sm_2_table_11);
        tableImageButton[2] = (ImageButton) findViewById(R.id.sm_2_table_12);
        tableImageButton[3] = (ImageButton) findViewById(R.id.sm_2_table_13);
        tableImageButton[4] = (ImageButton) findViewById(R.id.sm_2_table_14);
        tableImageButton[5] = (ImageButton) findViewById(R.id.sm_2_table_15);
        tableImageButton[6] = (ImageButton) findViewById(R.id.sm_2_table_16);
        for (int i = 0; i < 7; i++) {
            tableImageButton[i].setImageBitmap(tableBitmapArray[i]);
            if (available[i]) {
                tableImageButton[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO startactivity
                        startActivity(new Intent(SM_Activity_2.this, SM_Activity_3.class));
                    }
                });
            }
        }
        btnBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_btn_left), 80, 80, false);
        imagebtn = (ImageButton) findViewById(R.id.sm_2_btn);
        imagebtn.setImageBitmap(btnBitmap);
        imagebtn.setBackgroundResource(R.color.transparent);
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    String getDayofWeek(int n) {
        String day = "";
        switch (n) {
            case 1:
                day = "일";
                break;
            case 2:
                day = "월";
                break;
            case 3:
                day = "화";
                break;
            case 4:
                day = "수";
                break;
            case 5:
                day = "목";
                break;
            case 6:
                day = "금";
                break;
            case 7:
                day = "토";
                break;
        }
        return day;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Destory(imagebtn);
    }

    public void Destory(ImageView iv) {

        Drawable d = iv.getDrawable();
        if (d instanceof Drawable) {
            Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
            bitmap.recycle();
            bitmap = null;
        }

    }
}
