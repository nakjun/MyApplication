package com.example.nj.myapplication.YN_Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nj.myapplication.HubActivity;
import com.example.nj.myapplication.IDSingletonclass;
import com.example.nj.myapplication.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class YN_WEEKLYDATA extends Activity {

    Calendar cal;
    String dayz[]={"","","","","","",""};
    public static Bitmap bitmap[];
    public static ImageView imgView[];
    public static char num[]={'1','2','3','4','5','6','7'};
    int img_view_ID[]={R.id.img_mon,R.id.img_tue,R.id.img_wed,R.id.img_thu,R.id.img_fri,R.id.img_sat,R.id.img_sun};
    int img_name[]={R.drawable.yn_actiivity_tr,R.drawable.yn_activity_movie,R.drawable.yn_actiivity_tv,R.drawable.yn_actiivity_cleaning,R.drawable.yn_activity_playing,R.drawable.yn_acitivity_game,R.drawable.yn_activity_reading,R.drawable.yn_activity_food,R.drawable.yn_activity_inst,R.drawable.yn_activity_sing,R.drawable.yn_actiivity_shopping,R.drawable.yn_actiivity_daily};
    public static boolean img_setup[];
    boolean available[];
    public static int index=0;
    public ArrayList<Integer> index_list;
    phpDown task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yn__weeklydat);

        init();

        img_setup=new boolean[7];

        cal= Calendar.getInstance();

        int daynum = cal.get(Calendar.DAY_OF_WEEK);
        Log.d("DAYNUM",daynum+"");
        int todayposition = cal.get(Calendar.DATE);
        Log.d("TODAYPOSITION",todayposition+"");
        int limit=0;
        cal.add(Calendar.DATE, 0 - (daynum - 2));
        for (int i = 0; i < 7; i++) {
            dayz[i]=((cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH));
            if (cal.get(Calendar.DATE) == todayposition) {
                limit = i;
            }
            cal.add(Calendar.DATE, 1);
        }
        Log.d("LIMIT",limit+"");

        String temp=getDayofWeek(cal.get(Calendar.DATE));
        available = new boolean[7];
        //************dummy dummy dummy dummy
        for (int i = 0; i < 7; i++) {
            if(i==limit)
                available[i] = true;
            else{
                available[i]=false;
            }
            Log.d("DAYZ",dayz[i]);
        }

        task = new phpDown();
        task.execute("http://220.69.209.170/psycho/yn_search_week.php?id="+"test"+"&day1="+dayz[0]+"&day2="+dayz[1]+"&day3="+dayz[2]+"&day4="+dayz[3]+"&day5="+dayz[4]+"&day6="+dayz[5]+"&day7="+dayz[6]);

        for(int i=0;i<7;i++)
        {
            if(img_setup[i]){
            }
        }

    }
    void init()
    {
        index_list = new ArrayList<>();

        imgView = new ImageView[7];
        bitmap = new Bitmap[12];
        for(int i=0;i<7;i++)
        {
            imgView[i] = (ImageView)findViewById(img_view_ID[i]);
        }
        for(int i=0;i<12;i++)
        {
            bitmap[i]=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getResources(),img_name[i]), 300, 167, false);
        }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yn__weeklydat, menu);
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

    class phpDown extends AsyncTask<String, Integer,String> {
        Bitmap centerImageBitmap,btnBitmap;

        @Override
        protected String doInBackground(String... urls) {
            StringBuilder jsonHtml = new StringBuilder();
            try {
                // 연결 url 설정
                URL url = new URL(urls[0]);
                // 커넥션 객체 생성
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                // 연결되었으면.
                if (conn != null) {
                    conn.setConnectTimeout(10000);
                    conn.setUseCaches(false);
                    // 연결되었음 코드가 리턴되면.
                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        for (; ; ) {
                            // 웹상에 보여지는 텍스트를 라인단위로 읽어 저장.
                            String line = br.readLine();
                            if (line == null) break;
                            // 저장된 텍스트 라인을 jsonHtml에 붙여넣음
                            jsonHtml.append(line + "\n");
                        }
                        br.close();
                    }
                    conn.disconnect();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return jsonHtml.toString();
        }
        protected void onPostExecute(String str){
            String data[]=str.split(" ");

            Log.d("DATA SPLIT LENGTH",data.length+"");

            for(int i=0;i<data.length;i++) {
                Log.d("DATA "+i+" FULL STATUS",data[i]);
                Log.d("DATA "+i+" LENGTH", data[i].length() + "");
            }

            for(int i=0;i<data.length;i++)
            {
                for(int j=0;j<7;j++) {
                    if (data[i].length() > 2) {
                        if (data[i].charAt(data[i].length() - 1) == YN_WEEKLYDATA.num[j] ||data[i].charAt(data[i].length() - 2) == YN_WEEKLYDATA.num[j]) {
                            YN_WEEKLYDATA.img_setup[j] = true;
                            index= Integer.parseInt(data[i].charAt(0) + "");
                            YN_WEEKLYDATA.imgView[j].setImageBitmap(YN_WEEKLYDATA.bitmap[index]);
                            YN_WEEKLYDATA.imgView[i].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ImageView clicked = (ImageView) findViewById(R.id.img_clickedImage);
                                    clicked.setVisibility(View.VISIBLE);
                                    //clicked.setImageBitmap(this);
                                    Log.d("THIS", this.toString());

                                    ImageView click_back = (ImageView) findViewById(R.id.img_clickedBackground);
                                    click_back.setVisibility(View.VISIBLE);
                                    TextView t1 = (TextView) findViewById(R.id.tView_With);
                                    TextView t2 = (TextView) findViewById(R.id.tView_When);
                                    TextView t3 = (TextView) findViewById(R.id.tView_Where);

                                    t1.setVisibility(View.VISIBLE);
                                    t2.setVisibility(View.VISIBLE);
                                    t3.setVisibility(View.VISIBLE);
                                }
                            });
                        }
                    }
                }
            }
        }
    }

}

