package com.example.how.sqllitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.sql.SQLData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn,btn2,bt3;
    private EditText et1,et2,et3;
    private  MyDBHelper myDBHelper;
    private MyAdapter adapter;
    private Cursor c;
    private int rowcount;
    private int AppVerstion=1;
    private List<UserData> userDataList= new ArrayList<UserData>();
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewid();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               clear();


            }
        });
    }
    public void findviewid(){
        btn = (Button)findViewById(R.id.bt);
        btn2 = (Button)findViewById(R.id.bt2);
        bt3 = (Button)findViewById(R.id.bt3);
        et1 = (EditText)findViewById(R.id.te1);
        et2 = (EditText)findViewById(R.id.te2);
        et3 = (EditText)findViewById(R.id.te3);
        myDBHelper = new MyDBHelper(this,"expense.sqlite",null,AppVerstion);
        listView = (ListView)findViewById(R.id.ListView01);
    }
    public void add(){
        String str1 = et1.getText().toString();
        String str2 = et2.getText().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        String str;
        Date date = new Date(System.currentTimeMillis());
        str = simpleDateFormat.format(date);

        ContentValues contentValues = new ContentValues();
        contentValues.put("str1",str1);
        contentValues.put("info",str2);
        contentValues.put("cDate",str);
        long id = myDBHelper.getWritableDatabase().insert("main.exp",null,contentValues);
        Log.d("ADD",id+"");

    }

    public void load(){
         c = myDBHelper.getReadableDatabase().query("main.exp",null,null,null,null,null,"cDate DESC");
         rowcount = c.getCount();
        c.moveToFirst();
        userDataList.clear();
        if (rowcount!=0) {
            for (int i =0;i<c.getCount();i++){
                userDataList.add(new UserData(c.getString(0),c.getString(1),c.getString(2)));
                c.moveToNext();
            }
        }


        adapter = new MyAdapter(this,userDataList);
        listView.setAdapter(adapter);

        Log.d("Count", String.valueOf(rowcount));


    }
    public void clear(){
        String where ="info = ?";
        String[] wherev={"1"};
        myDBHelper.getWritableDatabase().delete("main.exp",where,wherev);
        load();
    }


}
