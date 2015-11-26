package com.example.nj.myapplication.SM_Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nj.myapplication.R;

public class SM_Activity_6 extends AppCompatActivity {
    ImageButton buttons[];
    ImageButton back,next;
    TextView noti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sm_activity_6);
        Toolbar toolbar = (Toolbar) findViewById(R.id.sm_6_toolbar);
        setTitle("");
        setSupportActionBar(toolbar);

        back=(ImageButton)findViewById(R.id.sm_6_back);
        back.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_btn_left), 80, 80, false));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next=(ImageButton)findViewById(R.id.sm_6_next);
        next.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_btn_right), 80, 80, false));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SM_Activity_6.this, SM_Activity_8.class));
            }
        });


        buttons=new ImageButton[5];
        buttons[0]=(ImageButton)findViewById(R.id.sm_6_button1);
        buttons[0].setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_6_box_1), 250, 100, false));
        buttons[1]=(ImageButton)findViewById(R.id.sm_6_button2);
        buttons[1].setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_6_box_2), 250, 100, false));
        buttons[2]=(ImageButton)findViewById(R.id.sm_6_button3);
        buttons[2].setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_6_box_3), 250, 100, false));
        buttons[3]=(ImageButton)findViewById(R.id.sm_6_button4);
        buttons[3].setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_6_box_4), 250, 100, false));
        buttons[4]=(ImageButton)findViewById(R.id.sm_6_button5);
        buttons[4].setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_6_box_5), 250, 100, false));


        noti=(TextView)findViewById(R.id.sm_6_notiText);
        buttons[0].setOnClickListener(new View.OnClickListener() {
            Boolean bol = false;

            @Override
            public void onClick(View view) {
                if (bol) {
                    bol=false;
                    noti.post(new Runnable() {
                        @Override
                        public void run() {
                            noti.setText("");
                        }
                    });
                    startActivity(new Intent(SM_Activity_6.this, SM_Activity_7.class).putExtra("choose", 0));
                } else {
                    noti.post(new Runnable() {
                        @Override
                        public void run() {
                            noti.setText("*한번 더 탭하면 선택됩니다.*");
                        }
                    });
                    bol = true;
                }
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            Boolean bol=false;
            @Override
            public void onClick(View view) {
                if(bol){
                    bol=false;
                    noti.post(new Runnable() {
                        @Override
                        public void run() {
                            noti.setText("");
                        }
                    });
                    startActivity(new Intent(SM_Activity_6.this,SM_Activity_7.class).putExtra("choose",1));
                }
                else{
                    noti.post(new Runnable() {
                        @Override
                        public void run() {
                            noti.setText("*한번 더 탭하면 선택됩니다.*");
                        }
                    });
                    bol=true;
                }
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            Boolean bol = false;

            @Override
            public void onClick(View view) {
                if (bol) {
                    bol=false;
                    noti.post(new Runnable() {
                        @Override
                        public void run() {
                            noti.setText("");
                        }
                    });
                    startActivity(new Intent(SM_Activity_6.this, SM_Activity_7.class).putExtra("choose", 2));
                } else {
                    noti.post(new Runnable() {
                        @Override
                        public void run() {
                            noti.setText("*한번 더 탭하면 선택됩니다.*");
                        }
                    });
                    bol = true;
                }
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            Boolean bol = false;

            @Override
            public void onClick(View view) {
                if (bol) {
                    bol=false;
                    noti.post(new Runnable() {
                        @Override
                        public void run() {
                            noti.setText("");
                        }
                    });
                    startActivity(new Intent(SM_Activity_6.this, SM_Activity_7.class).putExtra("choose", 3));
                } else {
                    noti.post(new Runnable() {
                        @Override
                        public void run() {
                            noti.setText("*한번 더 탭하면 선택됩니다.*");
                        }
                    });
                    bol = true;
                }
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            Boolean bol = false;

            @Override
            public void onClick(View view) {
                if (bol) {
                    bol=false;
                    noti.post(new Runnable() {
                        @Override
                        public void run() {
                            noti.setText("");
                        }
                    });
                    startActivity(new Intent(SM_Activity_6.this, SM_Activity_7.class).putExtra("choose", 4));
                } else {
                    noti.post(new Runnable() {
                        @Override
                        public void run() {
                            noti.setText("*한번 더 탭하면 선택됩니다.*");
                        }
                    });
                    bol = true;
                }
            }
        });


    }
    @Override
    protected void onDestroy() {
        for (int i=0;i<5;i++){
            Destory(buttons[i]);
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
}
