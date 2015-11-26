package com.example.nj.myapplication.DW_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.nj.myapplication.HubActivity;
import com.example.nj.myapplication.R;

public class DW_EndActivity extends AppCompatActivity {
    Button loop,finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw__end);
        Toolbar toolbar = (Toolbar) findViewById(R.id.dw_end_toolbar);
        setSupportActionBar(toolbar);

        loop=(Button)findViewById(R.id.dw_end_loop);
        loop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DW_EndActivity.this,DW_RealBreatheActivity.class));
            }
        });
        finish=(Button)findViewById(R.id.dw_end_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DW_EndActivity.this,HubActivity.class));
            }
        });


    }

}
