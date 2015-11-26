package com.example.nj.myapplication.SM_Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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

public class SM_Activity_8 extends AppCompatActivity {
    ImageView box,pic;
    ImageButton back,next;
    EditText textfield;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sm_activity_8);
        Toolbar toolbar = (Toolbar) findViewById(R.id.sm_8_toolbar);
        setTitle("");
        setSupportActionBar(toolbar);


        box=(ImageView)findViewById(R.id.sm_8_box);
        box.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_8_box), 600, 400, false));
        pic=(ImageView)findViewById(R.id.sm_8_pic);
        pic.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_8_pic), 500, 500, false));


        back=(ImageButton)findViewById(R.id.sm_8_back);
        back.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_btn_left), 80, 80, false));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next=(ImageButton)findViewById(R.id.sm_8_next);
        next.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_btn_right), 80, 80, false));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(SM_Activity_6.this, SM_Activity_8.class));
            }
        });
        textfield=(EditText)findViewById(R.id.sm_8_textfield);
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
    @Override
    protected void onDestroy() {
        Destory(box);
        Destory(pic);
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
}
