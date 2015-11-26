package com.example.nj.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nj.myapplication.DP_Activity.DpActivity;
import com.example.nj.myapplication.DW_Activity.DW_Activity;
import com.example.nj.myapplication.SM_Activity.SM_Activity;
import com.example.nj.myapplication.YN_Activity.BehaviorActivity;
import com.example.nj.myapplication.YN_Activity.YesNoActivity;

public class HubActivity extends Activity {
    Intent intent;
    String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        intent = getIntent();
        ID = intent.getStringExtra("ID");
        ImageView btn_478 = (ImageView)findViewById(R.id.imgView_dw);
        ImageView btn_yesno = (ImageView)findViewById(R.id.imgView_yn);
        ImageView btn_dp = (ImageView)findViewById(R.id.imgView_dp);
        ImageView btn_sm=(ImageView)findViewById(R.id.imgView_sw);
        btn_478.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HubActivity.this, DW_Activity.class));
            }
        });
        btn_yesno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HubActivity.this, YesNoActivity.class));
            }
        });
        btn_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HubActivity.this, DpActivity.class));
            }
        });
        btn_sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HubActivity.this, SM_Activity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hub, menu);
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
