package com.ramenstudios.react;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ResultsPage extends ActionBarActivity {

    private int countResult;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);
        resultText = (TextView) findViewById(R.id.result_count_text);

        countResult = getIntent().getIntExtra("numClicks", 0);

        resultText.setText("Your score is: " + countResult);




    }

}
