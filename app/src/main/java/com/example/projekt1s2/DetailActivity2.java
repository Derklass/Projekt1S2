package com.example.projekt1s2;

import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekt1s2.R;

public class DetailActivity2 extends AppCompatActivity {

    private TextView tvTime;
    private Button btnStartStop, btnReset;
    private boolean isRunning = false;
    private int seconds = 0;
    private int minutes = 0;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        tvTime = findViewById(R.id.tvTime);
        btnStartStop = findViewById(R.id.btnStartStop);
        btnReset = findViewById(R.id.btnReset);

        btnStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    private void startTimer() {
        isRunning = true;
        btnStartStop.setText("Stop");
        runnable = new Runnable() {
            @Override
            public void run() {
                seconds++;
                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                }
                tvTime.setText(String.format("%02d:%02d", minutes, seconds));
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    private void stopTimer() {
        isRunning = false;
        btnStartStop.setText("Start");
        handler.removeCallbacks(runnable);
    }

    private void resetTimer() {
        isRunning = false;
        minutes = 0;
        seconds = 0;
        tvTime.setText("00:00");
        btnStartStop.setText("Start");
        handler.removeCallbacks(runnable);
    }
}
