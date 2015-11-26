package com.example.nj.myapplication.YN_Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nj.myapplication.R;

public class SplashActivity2 extends Activity {

    Intent intent;
    TextView result_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        intent = getIntent();
        int yes_count = intent.getIntExtra("YesCount",0);
        int no_count = intent.getIntExtra("NoCount",0);

        result_text = (TextView)findViewById(R.id.textView_result);
        result_text.setText("YES를 "+yes_count+"개 선택하셨습니다.\n" +
                "더 많은 YES를 선택하고 싶다면 다음 장으로 이동해주세요");

        RelativeLayout relative = (RelativeLayout)findViewById(R.id.Re);
        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity2.this,MentActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_activity1, menu);
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
