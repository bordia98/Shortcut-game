package com.example.bordia98.shortcut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this,bgmusicservice.class);
        startService(i);
        Button level2 = (Button)findViewById(R.id.level2);
        Button level1 = (Button)findViewById(R.id.level1);
        Button level3 = (Button)findViewById(R.id.level3);
        Button level4 = (Button)findViewById(R.id.level4);
        Button level5 = (Button)findViewById(R.id.level5);
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
    }

    private void openlevel5() {
        Intent i = new Intent(this,Level5.class);
        startActivity(i);
    }

    private void openlevel4() {
        Intent i = new Intent(this,Level4.class);
        startActivity(i);
    }


    private void openlevel3() {
        Intent i = new Intent(this,Level3.class);
        startActivity(i);
    }

    private void openlevel2() {
        Intent i = new Intent(this,Level2.class);
        startActivity(i);
    }


    private void openlevel1() {
        Intent i = new Intent(this,Level1.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getApplicationContext().stopService(new Intent(this,bgmusicservice.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        getApplicationContext().stopService(new Intent(this,bgmusicservice.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        getApplicationContext().startService(new Intent(this,bgmusicservice.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        getApplicationContext().stopService(new Intent(this,bgmusicservice.class));
    }
}
