package com.example.bordia98.shortcut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.ToggleButton;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        Button play= (Button)findViewById(R.id.playit);
        Button help = (Button)findViewById(R.id.help);
        final Switch t = (Switch) findViewById(R.id.mus);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),helppage.class);
                startActivity(i);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread th = new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try{
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            if (t.isChecked())
                            {
                                Log.d("x", "sound is onn");
                                i.putExtra("sound","yes");
                            } else
                            {
                                Log.d("X", "sound is off");
                                i.putExtra("sound","no");
                            }
                            startActivity(i);
                        }
                        catch (Exception e) {
                            System.out.print("Error");
                        }
                    }
                };

                th.start();
            }

            });




    }
}
