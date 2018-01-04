package com.example.bordia98.shortcut;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String soundvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soundvalue=getIntent().getStringExtra("sound");
        if (soundvalue.equals("yes")) {
            Intent i = new Intent(this, bgmusicservice.class);
            startService(i);
        }

        Button level2 = (Button)findViewById(R.id.level2);
        Button level1 = (Button)findViewById(R.id.level1);
        Button level3 = (Button)findViewById(R.id.level3);
        Button level4 = (Button)findViewById(R.id.level4);
        Button level5 = (Button)findViewById(R.id.level5);
        Button level6 = (Button)findViewById(R.id.level6);
        level1.setTranslationX(-1000f);
        level2.setTranslationX(1000f);
        level3.setTranslationX(-1000f);
        level4.setTranslationX(1000f);
        level5.setTranslationX(-1000f);
        level6.setTranslationX(1000f);

        level1.animate().translationX(0f).setDuration(300);
        level2.animate().translationX(0f).setDuration(600);
        level3.animate().translationX(0f).setDuration(900);
        level4.animate().translationX(0f).setDuration(1200);
        level5.animate().translationX(0f).setDuration(1500);
        level6.animate().translationX(0f).setDuration(1800);


        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlevel1();
            }
        });
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlevel2();
            }
        });
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlevel3();

            }
        });
        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlevel4();
            }
        });
        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlevel5();
            }
        });
        level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlevel6();
            }
        });
    }

    private void openlevel6() {
        Intent i = new Intent(this,Level6.class);
        i.putExtra("sound",soundvalue);
        startActivity(i);
    }

    private void openlevel5() {
        Intent i = new Intent(this,Level5.class);
        i.putExtra("sound",soundvalue);
        startActivity(i);
    }

    private void openlevel4() {
        Intent i = new Intent(this,Level4.class);
        i.putExtra("sound",soundvalue);
        startActivity(i);
    }


    private void openlevel3() {
        Intent i = new Intent(this,Level3.class);
        i.putExtra("sound",soundvalue);
        startActivity(i);
    }

    private void openlevel2() {
        Intent i = new Intent(this,Level2.class);
        i.putExtra("sound",soundvalue);
        startActivity(i);
    }


    private void openlevel1() {
        Intent i = new Intent(this,Level1.class);
        i.putExtra("sound",soundvalue);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (soundvalue.equals("yes")) {
            getApplicationContext().stopService(new Intent(this, bgmusicservice.class));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (soundvalue.equals("yes")) {
            getApplicationContext().stopService(new Intent(this, bgmusicservice.class));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (soundvalue.equals("yes")) {
            getApplicationContext().startService(new Intent(this, bgmusicservice.class));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (soundvalue.equals("yes")) {
            getApplicationContext().stopService(new Intent(this, bgmusicservice.class));
        }
    }
}
