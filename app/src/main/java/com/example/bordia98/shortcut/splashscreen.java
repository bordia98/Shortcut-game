package com.example.bordia98.shortcut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreenoriginal);

        Thread th = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(5000);
                    Intent i = new Intent(getApplicationContext(),Homepage.class);
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
