package com.example.bordia98.shortcut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreenoriginal);

        Thread th = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(5000);
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }catch (Exception e){
                    System.out.print(e);
                }
            }
        };

        th.start();
    }
}
