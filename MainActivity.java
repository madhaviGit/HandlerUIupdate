package com.example.madhavi.handleruiupdate;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b1;TextView t1;Handler handler=new Handler();
    Random r=new Random();String numbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        t1=(TextView)findViewById(R.id.tt1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        generate();
                    }
                };
              new Thread(r).start();
            }
        });

    }
    public void generate()
    {
        int num=0;
         num=r.nextInt(100)+1;
            numbers=String.valueOf(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(
                    new Runnable() {
                        @Override
                        public void run() {
                            t1.setText(numbers)  ;
                        }
                    }
            );

    }

   //generate 100 random numbers
    public void generate1()
    {
     int num=0;int ii=10;
        for(int i=0;i<100;i++)
        { num=r.nextInt(100)+1;
        numbers=String.valueOf(num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                      t1.setText(numbers)  ;
                    }
                }
        );
    }}




}
