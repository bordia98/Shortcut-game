package com.example.bordia98.shortcut;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    Button b0;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    int x;
    int dis=0;
    int a[];
    int[][] g;
    CountDownTimer co;
    @Override
    protected void onStart() {
        super.onStart();
        Random random=new Random();
        x=0;
        a=new int[8];
        for(int i=0;i<8;i++){
            a[i]=random.nextInt(20);
        }
        TextView tv1=(TextView)findViewById(R.id.t1);
        TextView tv2=(TextView)findViewById(R.id.t2);
        TextView tv3=(TextView)findViewById(R.id.t3);
        TextView tv4=(TextView)findViewById(R.id.t4);
        TextView tv5=(TextView)findViewById(R.id.t5);
        TextView tv6=(TextView)findViewById(R.id.t6);
        TextView tv7=(TextView)findViewById(R.id.t7);
        TextView tv8=(TextView)findViewById(R.id.t8);
        tv1.setText(a[0]+"");
        tv2.setText(a[1]+"");
        tv3.setText(a[2]+"");
        tv4.setText(a[3]+"");
        tv5.setText(a[4]+"");
        tv6.setText(a[5]+"");
        tv7.setText(a[6]+"");
        tv8.setText(a[7]+"");

        g=new int[6][6];
        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
                g[i][j]=-1;
        g[0][1]=g[1][0]=a[0];
        g[1][2]=g[2][1]=a[1];
        g[2][3]=g[3][2]=a[2];
        g[3][4]=g[4][3]=a[3];
        g[4][5]=g[5][4]=a[4];
        g[0][5]=g[5][0]=a[5];
        g[0][2]=g[2][0]=a[6];
        g[5][1]=g[1][5]=a[7];

        DijsktraAlgorithm djk=new DijsktraAlgorithm(g,6);
        dis=djk.dijkstra(g,0,3);
        final TextView tf = (TextView)findViewById(R.id.textView4);

        co = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tf.setText(millisUntilFinished/1000 +":00");
            }

            @Override
            public void onFinish() {
                tf.setText("0:00");
                callcheck();
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        onStart();



        b0=(Button)findViewById(R.id.b0);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b0clicked();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1clicked();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2clicked();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3clicked();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4clicked();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5clicked();
            }
        });

        final Button nextlevel=(Button)findViewById(R.id.nextlevel);
        final Button check=(Button)findViewById(R.id.check);
        nextlevel.setEnabled(false);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callcheck();
            }

        });

        Button restart = (Button)findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b0.setBackgroundResource(android.R.drawable.btn_default);
                b0.setEnabled(true);
                b1.setBackgroundResource(android.R.drawable.btn_default);
                b1.setEnabled(true);
                b2.setBackgroundResource(android.R.drawable.btn_default);
                b2.setEnabled(true);
                b3.setBackgroundResource(android.R.drawable.btn_default);
                b3.setEnabled(true);
                b4.setBackgroundResource(android.R.drawable.btn_default);
                b4.setEnabled(true);
                b5.setBackgroundResource(android.R.drawable.btn_default);
                b5.setEnabled(true);
                check.setEnabled(true);
                nextlevel.setEnabled(false);
                TextView res =(TextView)findViewById(R.id.result);
                res.setText("");
                x=0;
                onStart();
            }
        });

        nextlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }

    private void callcheck() {
        TextView res = (TextView) findViewById(R.id.result);
        Button nextlevel = (Button)findViewById(R.id.nextlevel);
        Button check = (Button)findViewById(R.id.check);
        int t=usershortest();
        if (t!=-1) {
            if (t == dis) {
                res.setText("You Win");
                nextlevel.setEnabled(true);
            } else if (t != dis) {
                res.setText("You Lose");
            }
        }
        else{
            res.setText("This is not a correct route");
        }
        check.setEnabled(false);
        if(co!=null){
            co.cancel();
            co=null;
        }
    }
    private void next() {
        Intent in = new Intent(this,Level3.class);
        startActivity(in);
    }

    private void b5clicked() {
        b5.setBackgroundColor(Color.RED);
        b5.setEnabled(false);
    }

    private void b4clicked() {
        b4.setBackgroundColor(Color.RED);
        b4.setEnabled(false);
    }

    private void b3clicked() {
        b3.setBackgroundColor(Color.RED);
        b3.setEnabled(false);

    }

    private void b2clicked() {
        b2.setBackgroundColor(Color.RED);
        b2.setEnabled(false);
            }

    private void b1clicked() {
        b1.setBackgroundColor(Color.RED);
        b1.setEnabled(false);

    }

    private void b0clicked() {
        b0.setBackgroundColor(Color.RED);
        b0.setEnabled(false);
    }

    public int usershortest(){
        if(b0.isEnabled()==false && b1.isEnabled()==false&&b5.isEnabled()==true && b3.isEnabled()==false &&b2.isEnabled()==false&&b4.isEnabled()==true)
            x=a[0]+a[1]+a[2];
        else if(b0.isEnabled()==false&&b5.isEnabled()==false&&b1.isEnabled()==false && b3.isEnabled()==false&&b2.isEnabled()==false&&b4.isEnabled()==true)
            x=a[1]+a[2]+a[5]+a[7];
        else if(b0.isEnabled()==false&&b5.isEnabled()==false&&b1.isEnabled()==true && b3.isEnabled()==false&&b4.isEnabled()==false&&b2.isEnabled()==true)
            x=a[5]+a[4]+a[3];
        else if(b0.isEnabled()==false && b2.isEnabled()==false &&b1.isEnabled()==true&&b3.isEnabled()==false&&b5.isEnabled()==true && b4.isEnabled()==true)
            x=a[6]+a[2];
        else
            return  -1;
        return x;
    }

}
