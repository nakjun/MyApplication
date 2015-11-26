package com.example.nj.myapplication.YN_Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.nj.myapplication.R;

public class YN_boardActivity extends Activity {

    String TYPE[][] = new String[6][2];
    int index1,index2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yn_board);

        index1=YNActionAcitivity.index;
        index2=YNActionAcitivity.index2;

        init();

        TextView tView = (TextView)findViewById(R.id.textView);
        tView.setText(TYPE[index1][index2]);
    }

    void init()
    {
        TYPE[0][0]="TRIP";
        TYPE[0][1]="MOVIE";
        TYPE[1][0]="TV";
        TYPE[1][1]="CLEAN";
        TYPE[2][0]="PLAYING";
        TYPE[2][1]="GAME";
        TYPE[3][0]="READING";
        TYPE[3][1]="FOOD";
        TYPE[4][0]="INST";
        TYPE[4][1]="SING";
        TYPE[5][0]="SHOPPING";
        TYPE[5][1]="DIARY";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yn_board, menu);
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
