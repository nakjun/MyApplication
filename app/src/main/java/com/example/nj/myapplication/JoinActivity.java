package com.example.nj.myapplication;

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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class JoinActivity extends Activity {
    DatePicker datePicker;
    EditText edit[];
    String ID, PW, NAME, GENDER, NICKNAME, ADDRESS, BIRTH;
    Button btn_submit;
    ArrayList<ListItem> listitem = new ArrayList<ListItem>();
    ListItem ITEM;
    phpDown task_down;
    phpInsert task_insert;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        btn_submit = (Button)findViewById(R.id.btn_submit_joindata);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                get_edit();
                get_date();

                if(flag) {
                    task_insert = new phpInsert();
                    task_insert.execute("http://220.69.209.170/psycho/insert.php?id=" + ID + "&pw=" + PW + "&name=" + NAME + "&gender=" + GENDER + "&nick=" + NICKNAME + "&birth=" + BIRTH);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_join, menu);
        return true;
    }

    void get_addr()
    {
        //ADDRESS =
    }

    void get_date()
    {
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        BIRTH = String.format("%4d%02d%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth());

        datePicker.init(datePicker.getYear(),
                datePicker.getMonth(),
                datePicker.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                        // TODO Auto-generated method stub
                        BIRTH = String.format("%4d %02d %02d", year, monthOfYear + 1, dayOfMonth);
                       // Log.d("date", BIRTH);
                        //Toast.makeText(JoinActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    void get_edit()
    {
        EditText ed = (EditText)findViewById(R.id.editText_inputID);
        EditText ed1 = (EditText)findViewById(R.id.editText_inputPW);
        EditText ed2 = (EditText)findViewById(R.id.editText_inputNAME);
        EditText ed3 = (EditText)findViewById(R.id.editText_inputGENDER);
        EditText ed4 = (EditText)findViewById(R.id.editText_inputNICK);
        ID = ed.getText().toString();
        PW = ed1.getText().toString();
        NAME = ed2.getText().toString();
        GENDER = ed3.getText().toString();
        NICKNAME = ed4.getText().toString();
        if(ID.equals("")||PW.equals("")||NAME.equals("")||GENDER.equals("")||NICKNAME.equals("")) {
            Toast.makeText(getApplicationContext(), "모든 정보를 입력해주세요", Toast.LENGTH_SHORT).show();
            flag=true;
        }
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
    private class phpInsert extends AsyncTask<String, Integer,String>{

        @Override
        protected String doInBackground(String... urls) {
            StringBuilder resultText = new StringBuilder();
            try{
                // 연결 url 설정
                Log.d("url",urls[0]);
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
                            resultText.append(line);
                        }
                        br.close();
                    }
                    conn.disconnect();
                }
            } catch(Exception ex){
                ex.printStackTrace();
            }
            return resultText.toString();

        }

        protected void onPostExecute(String str){
            String compare= "-1";
            if(str.equals(compare)){
                Toast.makeText(getApplicationContext(),"DB Insert Failed.",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"DB Insert Complete.",Toast.LENGTH_SHORT).show();
                finish();
            }
        }

    }
    private class phpDown extends AsyncTask<String, Integer,String>{

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

        /*
        protected void onPostExecute(String str){
            txtView.setText(str);
        }
        */

        protected void onPostExecute(String str){
            String id;

            try{
                JSONObject root = new JSONObject(str);
                JSONArray ja = root.getJSONArray("results"); //get the JSONArray which I made in the php file. the name of JSONArray is "results"

                for(int i=0;i<ja.length();i++){
                    JSONObject jo = ja.getJSONObject(i);
                    id = jo.getString("id");
                    listitem.add(new ListItem(id));
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
           // txtView.setText("id : "+listitem.get(0).getData(0));
        }

    }
    public class ListItem {

        private String[] mData;
        final int columnCnt = 1;

        public ListItem(String[] data){
            mData = data;
        }

        public ListItem(String id){
            mData = new String[columnCnt];
            mData[0] = id;
        }


        public String[] getmData(){
            return mData;
        }

        public String getData(int index){
            return mData[index];
        }
        public void setData(String[] data){
            mData = data;
        }
    }
}
