package com.example.bordia98.shortcut;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Scores extends AppCompatActivity {

    databasehelper myDb;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        myDb = new databasehelper(this);
        textView = (TextView) findViewById(R.id.Resultid);
        Cursor res= myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if(res != null && res.getCount()>0){
            while(res.moveToNext()){
                stringBuffer.append(res.getString(0)+"\n");
                stringBuffer.append("Name " +res.getString(1)+"\n");
                stringBuffer.append("Time "+res.getString(2)+"\n");
                textView.setText(stringBuffer.toString());
            }
        }
    }
}
