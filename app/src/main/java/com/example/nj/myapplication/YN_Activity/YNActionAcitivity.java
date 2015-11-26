package com.example.nj.myapplication.YN_Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nj.myapplication.R;

import java.util.ArrayList;

public class YNActionAcitivity extends Activity {

    ListView listView;
    public static int index=0;
    public static int index2=0;
    public Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ynaction_acitivity);

        intent = new Intent(YNActionAcitivity.this,YN_boardActivity.class);

        listView = (ListView)findViewById(R.id.listView);

        ArrayList<Listviewitem> data = new ArrayList<>();

        Listviewitem one=new Listviewitem(R.drawable.yn_actiivity_tr,R.drawable.yn_activity_movie);
        Listviewitem two=new Listviewitem(R.drawable.yn_actiivity_tv,R.drawable.yn_actiivity_cleaning);
        Listviewitem three=new Listviewitem(R.drawable.yn_activity_playing,R.drawable.yn_acitivity_game);
        Listviewitem four=new Listviewitem(R.drawable.yn_activity_reading,R.drawable.yn_activity_food);
        Listviewitem five=new Listviewitem(R.drawable.yn_activity_inst,R.drawable.yn_activity_sing);
        Listviewitem six=new Listviewitem(R.drawable.yn_actiivity_shopping,R.drawable.yn_actiivity_daily);

        data.add(one);
        data.add(two);
        data.add(three);
        data.add(four);
        data.add(five);
        data.add(six);

        ListviewAdapter adapter=new ListviewAdapter(this,R.layout.listview_item,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.d("VALUE",position+"");
                YNActionAcitivity.index = position;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ynaction_acitivity, menu);
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

    class Listviewitem {
        private int icon,icon2;
        public int getIcon(){return icon;}
        public int getIcon2(){return icon2;}

        public Listviewitem(int icon,int icon2){
            this.icon=icon;
            this.icon2=icon2;
        }
    }

    class ListviewAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private ArrayList<Listviewitem> data;
        private int layout;
        public ListviewAdapter(Context context, int layout, ArrayList<Listviewitem> data){
            this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.data=data;
            this.layout=layout;
        }
        @Override
        public int getCount(){return data.size();}

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position){return position;}
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView==null){
                convertView=inflater.inflate(layout,parent,false);
            }
            final Listviewitem listviewitem=data.get(position);
            ImageView icon=(ImageView)convertView.findViewById(R.id.img_one);
            ImageView icon2=(ImageView)convertView.findViewById(R.id.img_two);
            icon.setImageResource(listviewitem.getIcon());
            icon2.setImageResource(listviewitem.getIcon2());

            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index2 = 0;
                    startActivity(intent);
                    finish();
                }
            });
            icon2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index2 = 1;
                    startActivity(intent);
                    finish();
                }
            });

            return convertView;
        }


    }

}

