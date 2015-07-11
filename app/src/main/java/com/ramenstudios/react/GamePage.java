package com.ramenstudios.react;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class GamePage extends ActionBarActivity {

    private String myTag = "Ram's Tag";
    private String ActivityName = "GamePage";
    private Random n;
    private RelativeLayout.LayoutParams parms;
    private int count = 0;
    private int x;
    private int y;
    private TextView countDownTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(myTag, "onCreate was called from " + ActivityName);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        final RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.game_page_layout);
        parms = new RelativeLayout.LayoutParams(80, 80);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        final int screenH = dm.heightPixels;
        final int screenW = dm.widthPixels;

        final ImageView dot = new ImageView(this);
        dot.setImageResource(R.drawable.dot);

        countDownTextView = (TextView) findViewById(R.id.GamePage_timer_textView);

        n = new Random();
        x = n.nextInt(((screenW - 200) - 200) + 1) + 200;
        y = n.nextInt(((screenH - 200) - 200) + 1) + 200;

        parms.leftMargin = x;
        parms.topMargin = y;

        Log.i(myTag, "leftMargin: " + parms.leftMargin);
        Log.i(myTag, "TopMargin: " + parms.topMargin);

        myTimer.start();


        rLayout.addView(dot, parms);



        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                rLayout.removeView(dot);


                x = n.nextInt(((screenW - 200) - 200) + 1) + 200;
                y = n.nextInt(((screenH - 200) - 200) + 1) + 200;

                parms.leftMargin = x;
                parms.topMargin = y;
                Log.i(myTag, "leftMargin: " + parms.leftMargin);
                Log.i(myTag, "TopMargin: " + parms.topMargin);

                rLayout.addView(dot, parms);

            }

        });



        }

    private CountDownTimer myTimer = new CountDownTimer(30000, 50) {
        public void onTick(long millisUntilFinished) {

            if (millisUntilFinished < 1000) {
                onFinish();
                cancel();

            }
            else {
                countDownTextView.setText("" + millisUntilFinished / 1000.0);
            }
        }

        public void onFinish() {
            Intent intent = new Intent(getApplicationContext(), ResultsPage.class);
            intent.putExtra("numClicks", count);
            startActivity(intent);
            finish();
        }
    };



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

