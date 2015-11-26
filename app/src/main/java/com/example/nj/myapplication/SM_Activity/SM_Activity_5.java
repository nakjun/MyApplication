package com.example.nj.myapplication.SM_Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.nj.myapplication.R;

public class SM_Activity_5 extends AppCompatActivity {
    ImageButton back,next;
    EditText textfield;
    ImageView cen_char,bubble;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sm_activity_5);
        setTitle("");
        Toolbar toolbar = (Toolbar) findViewById(R.id.sm_5_toolbar);
        setSupportActionBar(toolbar);

        back=(ImageButton)findViewById(R.id.sm_5_back);
        back.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_btn_left), 80, 80, false));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next=(ImageButton)findViewById(R.id.sm_5_next);
        next.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_btn_right), 80, 80, false));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SM_Activity_5.this,SM_Activity_6.class));
            }
        });
        //startActivity(new Intent(SM_Activity_5.this,SM_Activity_5.class));
        cen_char=(ImageView)findViewById(R.id.sm_5_main_char);
        cen_char.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_5_smurf), 500, 500, false));
        bubble=(ImageView)findViewById(R.id.sm_5_bubble);
        bubble.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_4_bubble), 700, 700, false));
        textfield=(EditText)findViewById(R.id.sm_5_textfield);
        textfield.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() > 200) {
                    editable.delete(200, editable.toString().length());
                }
            }
        });



    }

}
