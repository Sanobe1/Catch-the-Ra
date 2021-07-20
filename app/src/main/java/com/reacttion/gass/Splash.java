package com.reacttion.gass;


import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class Splash extends AppCompatActivity {

    private Timer Timer;
    private MyTimerTask MyTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer = new Timer();
        MyTimerTask = new MyTimerTask();
        Timer.schedule(MyTimerTask, 3000);




        YoYo.with(Techniques.RollIn)
                .duration(2000)
                .repeat(0)
                .playOn(findViewById(R.id.catchra));

    }

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            Timer.cancel();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),
                            "Catch Him!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Splash.this,
                            MainActivity.class);
                    startActivity(intent);

                    finish();
                }
            });
        }
    }
}