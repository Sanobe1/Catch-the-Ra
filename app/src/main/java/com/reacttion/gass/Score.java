package com.reacttion.gass;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


    public class Score extends AppCompatActivity {

        TextView textView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_score);

            textView = findViewById(R.id.totalScore);
            Intent intent = getIntent();
            textView.setText("Total Score:\n\n"+intent.getIntExtra("scoreData",0));
        }

        public void playAgain(View view){
            Intent intent = new Intent(Score.this, MainActivity.class);
            finish();
            startActivity(intent);
        }
    }
