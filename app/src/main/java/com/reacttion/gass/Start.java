package com.reacttion.gass;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Start extends AppCompatActivity implements View.OnClickListener {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start);

        Button startButton = (Button) findViewById(R.id.btn1);
        startButton.setOnClickListener(this);

        Button policyButton = (Button) findViewById(R.id.btn2);
        startButton.setOnClickListener(this);

        Button exitButton = (Button) findViewById(R.id.btn3);
        exitButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1: {
                startActivity( new Intent(this, Splash.class));
            }
            break;

            case R.id.btn2: {
                startActivity( new Intent(this, Policy.class));
            }
            break;

            case R.id.btn3: {
                finish();
            }
            break;

            default:
                break;
        }
    }
}
