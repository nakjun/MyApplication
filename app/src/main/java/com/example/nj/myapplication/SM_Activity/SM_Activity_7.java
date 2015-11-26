package com.example.nj.myapplication.SM_Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
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

public class SM_Activity_7 extends AppCompatActivity {
    ImageButton back;
    ImageView cenImg,title;
    TextView strong,info,noti;
    int chosen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sm_activity_7);
        Toolbar toolbar = (Toolbar) findViewById(R.id.sm_7_toolbar);
        setTitle("");
        setSupportActionBar(toolbar);

        Intent i=getIntent();
        Bundle b=i.getExtras();
        chosen=b.getInt("choose");

        back=(ImageButton)findViewById(R.id.sm_7_back);
        back.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_btn_left), 80, 80, false));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title=(ImageView)findViewById(R.id.sm_7_title);
        cenImg=(ImageView)findViewById(R.id.sm_7_cenImg);
        strong=(TextView)findViewById(R.id.sm_7_strongText);
        noti=(TextView)findViewById(R.id.sm_7_textnoti);
        strong.setPaintFlags(strong.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        noti.setPaintFlags(noti.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        info=(TextView)findViewById(R.id.sm_7_textinfo);
        switch(chosen){
            case 0:
                cenImg.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_7_1), 800, 533, false));
                title.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_6_box_1), 250, 100, false));
                strong.setText("어떤 상황에 대해 '모'아니면 '도'로 판단하는 것");
                info.setText("예) 나를 칭찬하는 사람들은 모두 다 나를 좋아하는 것이고,\n 비판하는 사람들은 모두 다 나를 싫어하는 것이다.");
                break;
            case 1:
                cenImg.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_7_2), 500, 500, false));
                title.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_6_box_2), 250, 100, false));
                strong.setText("몇 가지에 근거해서 모든 상황에 적용하는 것");
                info.setText("예) 때로는 일등이 아닌 다른 등수가 더 값질 수도 있지만,\n일등을 더 우선시해주는 몇 가지 상황으로 인한 인지적 오류\n\n예) 몇 몇의 친구가 자신을 따돌리는 경험을 한다면\n-이 세상 사람들은 모두 나를 좋아하지 않을거야");
                break;
            case 2:
                cenImg.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_7_3), 500, 500, false));
                title.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_6_box_3), 250, 100, false));
                strong.setText("상황을 실제보다 더 크게 혹은 작게 생각하는 것");
                info.setText("예) (짝사랑하는 사람이 웃어주는 경우) 저 애는 나한테 웃는 것이 아니야.\n\n 예) 내가 마음만 먹으면 성적을 얼마든지 올릴 수 있어!(확대)");
                break;
            case 3:
                cenImg.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_7_4), 500, 500, false));
                title.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_6_box_4), 250, 100, false));
                strong.setText("근거 없이 특정 상황을 자신과 관련시키는 것");
                info.setText("예) 상사의 이유없는 화난 표정에도 내가 맘에 들지 않기\n때문에 화났을 거야 라고 생각하는 경우.\n\n 예) 내가 무엇을 잘못했기 때문에 어머니의 기분이 좋지 \n않을거야.");
                break;
            case 4:
                cenImg.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_7_5), 500, 500, false));
                title.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sm_6_box_5), 250, 100, false));
                strong.setText("어떤 상황을 실제보다 더 위험하게 인식하는 것");
                info.setText("예) 예능인이라는 생각 때문에 사람들을 웃기지 못하면 영원히\n웃기지 못하는 것이며, 결국 나는 몰락할 것이라는 생각\n\n 예) 세상에 곧 종말이 닥칠 것이라는 불안함 속에서 살아가게 되는 것");
                break;
        }
        noti.setText("*뒤로 가서 선택합니다*");

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Destory(cenImg);
        Destory(title);
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
