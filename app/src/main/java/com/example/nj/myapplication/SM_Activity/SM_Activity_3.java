package com.example.nj.myapplication.SM_Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.nj.myapplication.R;

import java.util.Calendar;

public class SM_Activity_3 extends AppCompatActivity {
    Calendar cal;
    TextView date;
    TextView feelings[];
    ImageButton btn_prev;
    Bitmap btn_prev_bitmap,btn_next_bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sm_activity_3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.sm_3_toolbar);

        setSupportActionBar(toolbar);
        setTitle("");
        btn_prev=(ImageButton)findViewById(R.id.sm_3_btn_prev);

        btn_prev_bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_btn_left), 80, 80, false);

        btn_prev.setImageBitmap(btn_prev_bitmap);

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        cal=Calendar.getInstance();
        date=(TextView)findViewById(R.id.sm_3_date);
        String temp=getDayofWeek(cal.get(Calendar.DATE));
        date.setText((cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DAY_OF_MONTH)+"일 "+temp+"요일" );

        feelings=new TextView[6];
        int start_id=R.id.sm_3_flower_1;
        feelings[0]=(TextView)findViewById(R.id.sm_3_flower_1);
        feelings[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SM_Activity_3.this,SM_Activity_4.class).putExtra("feeling",0));
            }
        });
        feelings[1]=(TextView)findViewById(R.id.sm_3_flower_2);
        feelings[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SM_Activity_3.this,SM_Activity_4.class).putExtra("feeling",1));
            }
        });
        feelings[2]=(TextView)findViewById(R.id.sm_3_flower_3);
        feelings[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SM_Activity_3.this,SM_Activity_4.class).putExtra("feeling",2));
            }
        });
        feelings[3]=(TextView)findViewById(R.id.sm_3_flower_4);
        feelings[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SM_Activity_3.this,SM_Activity_4.class).putExtra("feeling",3));
            }
        });
        feelings[4]=(TextView)findViewById(R.id.sm_3_flower_5);
        feelings[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SM_Activity_3.this,SM_Activity_4.class).putExtra("feeling",4));
            }
        });
        feelings[5]=(TextView)findViewById(R.id.sm_3_flower_6);
        feelings[5].setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                startActivity(new Intent(SM_Activity_3.this,SM_Activity_4.class).putExtra("feeling",5));
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
}
