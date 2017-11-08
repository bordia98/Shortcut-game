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

        Button level2 = (Button)findViewById(R.id.level2);
        Button level1 = (Button)findViewById(R.id.level1);
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
    }

    private void openlevel2() {
        Intent i = new Intent(this,Level2.class);
        startActivity(i);
    }


    private void openlevel1() {
        Intent i = new Intent(this,Level1.class);
        startActivity(i);
    }
}
