package com.example.nj.myapplication.DP_Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
import com.example.nj.myapplication.MainActivity;
import com.example.nj.myapplication.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class DPmyStatus extends Activity {
    Intent intent,get_intent ;
    String result1,result2;

    ImageView button;

    //TextView

    IDSingletonclass LoginID;
    String get_ID;
    String get_User_name;
    int status;
    int image_id[]={R.drawable.dp_status_anger,R.drawable.dp_status_frustration,R.drawable.dp_status_regret,R.drawable.dp_status_appointment,R.drawable.dp_status_sad};

    TextView text_status;
    TextView description;

    ImageView imgView;

    phpDown task;
    phpUp task2;

    String Status_Name[]={"\n분노\n","\n좌절\n","\n후회\n","\n야속\n","\n슬픔\n","\n기타\n"};
    String Status_rates[]={"아주 낮음(1점)","낮음(2점)","보통(3점)","높음(4점)","아주 높음(5점)"};

    String Status[]={"one","two","three","four","five","six"};
    String Status_rate[]={"one","two","three","four","five"};
    //String Status[]={"분노","좌절","후회","야속","슬픔","기타"};

    String Text[]=new String[5];

    String TEXT1,TEXT2,PLACE,RATES,STAT;

    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpmy_status);

        ID = MainActivity.LoginID.get_ID();

        STAT = Status[DPSelectActivity.status];
        RATES = Status_rates[DPRateActivity.rates-1];
        PLACE=DPWhere.where;
        TEXT1 = DPSixButtonSelect.select[0];
        TEXT2 = DPSixButtonSelect.select[1];

        imgView = (ImageView)findViewById(R.id.imgView_btnDescription);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description.setVisibility(View.VISIBLE);
            }
        });

        for(int i =0;i<6;i++)
        {
            if(DPSelectActivity.status==i)
            {
                STAT = Status_Name[i].replace("\n"," ").trim();
            }
        }

        intent_process();
        button = (ImageView)findViewById(R.id.next_button);

        Log.d("status", DPSelectActivity.status + "");

        init();

        task = new phpDown();
        task.execute("http://220.69.209.170/psycho/search.php?id=" + get_ID);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("GET WHERE", DPWhere.where);

                String LOGTEXT="http://220.69.209.170/psycho/test.php?id=" + ID + "&status=";

                String str1 = STAT.toString();
                String str = RATES.toString();
                String str2 = PLACE.toString();
                String str3 = TEXT1.toString();
                String str4 = TEXT2.toString();
                try {
                    str = URLEncoder.encode(str,"UTF-8");
                    str1 = URLEncoder.encode(str1,"UTF-8");
                    str2 = URLEncoder.encode(str2,"UTF-8");
                    str3 = URLEncoder.encode(str3,"UTF-8");
                    str4 = URLEncoder.encode(str4,"UTF-8");

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                LOGTEXT+= str1 + "&rates=";
                LOGTEXT+= str + "&place=";
                LOGTEXT+= str2 + "&data1=";
                LOGTEXT+= str3 + "&data2=" + str4;

                Log.d("TEXT QUERY",LOGTEXT);

                //Log.d("TEXT QUERY","http://220.69.209.170/psycho/test.php?id=" + ID + "&status=" + Status[DPSelectActivity.status].toString() + "&rates=" + Status_rates[DPRateActivity.rates - 1].toString() + "&place=" + DPWhere.where.toString() + "&data1=" + DPSixButtonSelect.select[0].toString() + "&data2=" + DPSixButtonSelect.select[1].toString());
                task2 = new phpUp();
                task2.execute(LOGTEXT);
                //task2.execute("http://220.69.209.170/psycho/test.php?id=" + ID + "&status="+ STAT + "&rates=" + RATES + "&place=" + PLACE + "&data1=" + TEXT1 + "&data2=" + TEXT2);
                //task2.execute("http://220.69.209.170/psycho/test.php?id=" + ID + "&status="+ "TEST@" + "&rates=" + "TEST@@" + "&place=" + "TEST###" + "&data1=" + "TESTTEST" + "&data2=" + "TESTTEST");
            }
        });

    }

    void setting_description_text() {
        Text[0] = "오늘 많이 힘든 날이었군요. 때때로 누구나 자신의 감정을 감당하기 힘들 때가 있답니다. 누군가에게 이런 나의 마음을 표현해 보는 것이 \n큰 도움이 되기도 해요.\n" +
                "답답하고 힘든 마음을 충분히 누군가에게 털어 놓고 나면,\n한결 기분이 나아진답니다.\n" +
                "부모님, 친구, 선생님 혹은 사이버상담실로\n언제든 도움을 요청해보세요.\n" + get_User_name + "님이 좀 더 힘을 낼 수 있고, 편안한 마음을 가지기를 바랄께요. 화이팅~!";
        Text[1] = "좌절감이 높은 날이네요. 많이 힘든 하루가 되었겠어요~\n" +
                "아무것도 할 수 없을 것 같은 지금 생각은 지금의 생각일 뿐이에요!\n" +
                "내일은 또 다른 상황이… 미래에는 지금보다 더 좋고 멋진 일이 벌어질 거라는 믿음을 가져보아요. \n그 속에서 새로운 나를 발견하고 발전해나간다는 걸 잊지 말고요!\n" +
                "늪에 빠지면 온몸의 힘을 빼고 시간을 버는 게 우선이란 거 우리 알고 있지요? 늪에서 오래 살아남는 게 중요하니까요!" +
                "지금의 좌절의 늪.. 늪에서는 허우적거리면 거릴수록 수렁 속으로 빠져들게 되요." +
                "두렵고 불안하지만, \n오늘 하루를 묵묵히 살아내는 것이 중요해요! 힘을 내요. 파이팅!!";
        Text[2] = "후회로 가득한 날이었나요? 사람은 누구나 실수를 한답니다^^\n" + "모든 상황에서 항상 후회를 하는 것은 아닐 것 같은데, 특히 어떤 상황일 때, \n어떤 행동을 한 뒤 후회를 하는지 생각해보았으면 좋겠어요.\n" + "특정 상황, 특정 행동에서 내가 충동적이구나, 혹은 조금 성급하구나 라는 것을 알게 되면\n앞으로 그 상황이 다시 닥쳤을 때 어떻게 하면 좋을지 구체적인 방법을 생각할 수 있게 됩니다.";
        Text[3] = "모든 일들이 야속하게 느껴지는 하루를 보냈군요! 모든 게 원망스럽고 서운하겠어요.\n"+"서운하고 속상한 마음을 누군가와 나누면 분명 자신의 감정이 나아지는 것을 발견할 수 있을 거에요.\n"+"감정은 자주 표현할수록 버텨나갈 힘과 지혜를 갖게 해준답니다.\n"+"한편으로 스스로 너그러운 마음으로, 화나고 서운하고 슬픈 마음을 풀어주길 바래요.\n"+get_User_name+"님이 혼자라 느껴지고 도움을 원한다면 언제든 사이버상담실에 들어주세요~";
        Text[4] = "슬픈 일이 많아 혼자 많이 속상해하고 있나요?\n"+"슬픔을 혼자 간직하다 보면 더욱 슬퍼지고 힘들어지는 경우가 많아요.\n"+"충분히 자신의 감정을 표현하는 것이 필요합니다. 이런 나의 마음을 나눠 줄 좋은 사람들을 만나는 것이 중요합니다.\n"+get_User_name+"님의 마음을 잘 이해해줄 친구와 가족들에게 속상하고 슬픈 이야기를 함께 나눈다면\n이 시기를 잘 이겨나갈 수 있는 큰 힘이 될 거에요. 힘내세요!";
    }


    void init(){
        //status = DPSelectActivity.status;

        get_ID = MainActivity.LoginID.get_ID();

        text_status = (TextView)findViewById(R.id.TextView_Status);
        description = (TextView)findViewById(R.id.textView_DP_DESCRIPTION);



        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(DPmyStatus.this,DP_PercentOfWeek.class));
                //finish();
            }
        });

    }

    void set_display()
    {
        text_status.setBackgroundResource(image_id[DPSelectActivity.status]);
        text_status.setText(Status_Name[DPSelectActivity.status] + Status_rates[DPRateActivity.rates-1]);
        description.setText(Text[DPSelectActivity.status]);
    }


    void intent_process()
    {
        get_intent = getIntent();
        result1 = get_intent.getStringExtra("select1");
        result2 = get_intent.getStringExtra("select2");

        //Toast.makeText(DPmyStatus.this, result1, Toast.LENGTH_SHORT).show();
        //Toast.makeText(DPmyStatus.this, result2, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dpmy_status, menu);
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

    private class phpDown extends AsyncTask<String, Integer,String> {

        @Override
        protected String doInBackground(String... urls) {
            StringBuilder jsonHtml = new StringBuilder();
            try{
                // 연결 url 설정
                URL url = new URL(urls[0]);
                // 커넥션 객체 생성
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                // 연결되었으면.
                if(conn != null){
                    conn.setConnectTimeout(10000);
                    conn.setUseCaches(false);
                    // 연결되었음 코드가 리턴되면.
                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        for(;;){
                            // 웹상에 보여지는 텍스트를 라인단위로 읽어 저장.
                            String line = br.readLine();
                            if(line == null) break;
                            // 저장된 텍스트 라인을 jsonHtml에 붙여넣음
                            jsonHtml.append(line + "\n");
                        }
                        br.close();
                    }
                    conn.disconnect();
                }
            } catch(Exception ex){
                ex.printStackTrace();
            }
            return jsonHtml.toString();
        }


        protected void onPostExecute(String str){

            Log.d("userName", str);

            if(str.equals("n"))
            {

            }
            else
            {
                get_User_name = str.trim();
                setting_description_text();
                set_display();
            }
        }

    }
    private class phpUp extends AsyncTask<String, Integer,String> {

        @Override
        protected String doInBackground(String... urls) {
            StringBuilder jsonHtml = new StringBuilder();
            try{
                // 연결 url 설정
                URL url = new URL(urls[0]);
                // 커넥션 객체 생성
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                // 연결되었으면.
                if(conn != null){
                    conn.setConnectTimeout(10000);
                    conn.setUseCaches(false);
                    // 연결되었음 코드가 리턴되면.
                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        for(;;){
                            // 웹상에 보여지는 텍스트를 라인단위로 읽어 저장.
                            String line = br.readLine();
                            if(line == null) break;
                            // 저장된 텍스트 라인을 jsonHtml에 붙여넣음
                            jsonHtml.append(line + "\n");
                        }
                        br.close();
                    }
                    conn.disconnect();
                }
            } catch(Exception ex){
                ex.printStackTrace();
            }
            return jsonHtml.toString();
        }


        protected void onPostExecute(String str) {
            Log.d("UPLOAD RETURN DATA",str);
        }

    }
}


