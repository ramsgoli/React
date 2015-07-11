package com.ramenstudios.react;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class CountdownPage extends ActionBarActivity {

    private String myTag = "Ram's Tag";
    private String ActivityName = "Countdown Page";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(myTag, "onCreate was called from " + ActivityName);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_page);
        myTimer.start();

    }

    private CountDownTimer myTimer = new CountDownTimer(6000, 500) {
        public void onTick(long millisUntilFinished) {

            if (millisUntilFinished < 1000) {
                onFinish();
                cancel();

            }
            else {
                final TextView countdownText = (TextView) findViewById(R.id.countdown_text);
                countdownText.setTextSize(50);
                countdownText.setGravity(Gravity.CENTER);
                countdownText.setTextColor(Color.parseColor("#36000000"));
                countdownText.setText("" + millisUntilFinished / 1000);
            }
        }

        public void onFinish() {
            Intent intent = new Intent(getApplicationContext(), GamePage.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(myTag, "onDestroy was called from " + ActivityName);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(myTag, "onStop was called from " + ActivityName);
    }

    @Override
    protected void onPause() {
        super.onPause();
        myTimer.cancel();
        Log.i(myTag, "onPause was called from " + ActivityName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(myTag, "onResume was called from " + ActivityName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(myTag, "onStart was called from " + ActivityName);
    }




}
