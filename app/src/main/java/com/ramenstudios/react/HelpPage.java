package com.ramenstudios.react;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class HelpPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);

        TextView nextInstruction = (TextView) findViewById(R.id.help_page_display_instruct_text);
        nextInstruction.setText("Welcome to the help page");
    }


}
