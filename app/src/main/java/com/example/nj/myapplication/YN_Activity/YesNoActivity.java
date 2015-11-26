package com.example.nj.myapplication.YN_Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.nj.myapplication.R;

public class YesNoActivity extends Activity {

    ImageButton imgYes,imgNo;
    TextView tView;
    String text[]={"대화 할 때 상대방의 눈을 바라본다.","나는 편안하고 바른 자세로 상대방의 대화에 집중한다.","적절한 목소리 톤과 빠르기로 말하고 상대방이 내 말을 쉽게 이해한다.","말하기 전에 생각한다.","상대방의 말을 끊지 않고 끝까지 경청한다.","상대방을 비난하는 말을 자주 한다.","상대방이 이야기 할 때 다른 행동을 한다.","나와 '다름'을 인정하며 상대방을 존중하며 대화한다.","대화하는 시간을 소중하게 생각한다.","상대방을 칭찬한다."};
    int index=1;
    int max;
    int yes_count=0,no_count=0;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_no);

        max = text.length;
        imgYes = (ImageButton)findViewById(R.id.imageButton_YES);
        imgNo = (ImageButton)findViewById(R.id.imageButton_NO);

        tView = (TextView)findViewById(R.id.textView);


        imgYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < max) {
                    tView.setText(text[index]);
                    index++;
                    yes_count++;
                    Log.d("counted", "yes count : " + yes_count);
                } else {
                    yes_count++;
                    i = new Intent(YesNoActivity.this, SplashActivity2.class);
                    i.putExtra("YesCount", yes_count);
                    startActivity(i);
                    finish();
                }
            }
        });
        imgNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < max) {
                    tView.setText(text[index]);
                    index++;
                    no_count++;
                    Log.d("counted", "no count : " + no_count);
                } else {
                    no_count++;
                    i = new Intent(YesNoActivity.this, SplashActivity2.class);
                    i.putExtra("YesCount", yes_count);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
