package com.keating.vivian.omgandroid;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.keating.vivian.omgandroid.adapters.MainListAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {


    private int[] imageNames;
    private ListView listView;
    private MainListAdapter mainListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        listView = (ListView) findViewById(R.id.list_view);

    }

    @Override
    protected void onResume() {
        super.onResume();

        mainListAdapter = new MainListAdapter();
        listView.setAdapter(mainListAdapter);

    }



}
