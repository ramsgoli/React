package com.ramenstudios.react;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;


public class GamePageVersion2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page_version2);

        GridLayout gL = (GridLayout) findViewById(R.id.gridlayout_layout);

    }


}
