package com.example.nj.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.nj.myapplication.DW_Activity.DW_Activity;
import com.example.nj.myapplication.YN_Activity.YesNoActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {
    Button btn_login, btn_join, btn_find;
    phpDown task;
    String ID, PW;
    EditText ed_id, ed_pw;
    TextInputLayout Til_id, Til_pw;
    RelativeLayout rel;
    public static IDSingletonclass LoginID;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Util.setGlobalFont(this,getWindow().getDecorView());

        init();

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_join = (Button) findViewById(R.id.btn_join);
        btn_find = (Button) findViewById(R.id.btn_find);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ID = ed_id.getText().toString();
                PW = ed_pw.getText().toString();

                task = new phpDown();
                task.execute("http://220.69.209.170/psycho/login.php?id=" + ID + "&pw=" + PW);
            }
        });
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, JoinActivity.class);
                startActivity(i);
            }
        });
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HubActivity.class);
                startActivity(i);
            }
        });
    }

    void init() {

        ed_id = (EditText)findViewById(R.id.editText_ID);
        ed_pw = (EditText)findViewById(R.id.editText_PW);
        Til_id=(TextInputLayout)findViewById(R.id.Til_id);
        Til_id.setHint("아이디");
        Til_pw=(TextInputLayout)findViewById(R.id.Til_pw);
        Til_pw.setHint("패스워드");
        ed_id.clearFocus();
        rel=(RelativeLayout)findViewById(R.id.MainActivityRelativeLayout);
        rel.requestFocus();
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

            if(str.equals("s"))
            {
                i = new Intent(MainActivity.this, HubActivity.class);
                LoginID = new IDSingletonclass(ID);
                startActivity(i);
            }
            else
            {
                if(str.charAt(0)=='s')
                {
                    i = new Intent(MainActivity.this, HubActivity.class);
                    LoginID = new IDSingletonclass(ID);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_SHORT).show();
                }
            }

            /*
            if(str.charAt(0)=='s') {
                startActivity(new Intent(MainActivity.this, HubActivity.class));
            }
            else
                Toast.makeText(getApplicationContext(),"Login Fail",Toast.LENGTH_SHORT).show();*/
        }

    }
}
