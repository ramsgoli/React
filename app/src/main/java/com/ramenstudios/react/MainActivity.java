package com.ramenstudios.react;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    private String myTag = "Ram's Tag";
    private String ActivityName = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(myTag, "onCreate was called from " + ActivityName);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView reactLogo = (TextView) findViewById(R.id.react_logo_main);
        TextView playButton = (TextView) findViewById(R.id.main_play_text_button);
        TextView helpButton = (TextView) findViewById(R.id.help_button);


        animatePlayButton(playButton);
        animatePlayButton(helpButton);

    }

    private void animatePlayButton(TextView animatedPlayButton) {
        AlphaAnimation PlayButtonAnimation = new AlphaAnimation(0.0f, 1.0f);
        PlayButtonAnimation.setDuration(3000);
        PlayButtonAnimation.setRepeatMode(Animation.REVERSE);
        animatedPlayButton.startAnimation(PlayButtonAnimation);
    }



    public void playButtonClick(View view) {
        /*
        intent set to gamepage, instead of countdown
         */
        Intent intent = new Intent(this, CountdownPage.class);
        startActivity(intent);
    }


    public void helpButtonClick(View view) {
        Intent intent = new Intent(this, HelpPage.class);
        startActivity(intent);
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
