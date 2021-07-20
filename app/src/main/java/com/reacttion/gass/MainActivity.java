package com.reacttion.gass;


import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView count;
    TextView score;
    ImageView ra;
    Runnable runb;
    Handler handler;
    Random random;
    int height;
    int width;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = findViewById(R.id.count);
        score = findViewById(R.id.score);
        ra = findViewById(R.id.ra);
        point = 0;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        random =  new Random();

        new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                count.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                count.setText("Time is Over!");
                Intent intent = new Intent(MainActivity.this, Score.class);
                intent.putExtra("scoreData",point);
                finish();
                startActivity(intent);
            }
        }.start();
        rotateImage();
    }

    public void risePoints(View view){
        point++;
        score.setText("Points: "+point);
    }

    public void rotateImage(){
        handler = new Handler();
        runb = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void run() {
                int rand_R = random.nextInt(180);
                int rand_X = random.nextInt((width-330) - (50) + 70) +50;
                int rand_Y = random.nextInt((height-644) - (200) + 70) +200;
                ra.setX(rand_X);
                ra.setY(rand_Y);
                ra.setRotation(rand_R);
                handler.postDelayed(runb,350);
            }
        };
        handler.post(runb);
    }
}