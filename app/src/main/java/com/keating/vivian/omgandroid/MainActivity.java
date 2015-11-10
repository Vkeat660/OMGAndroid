package com.keating.vivian.omgandroid;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.keating.vivian.omgandroid.adapters.MainListAdapter;

public class MainActivity extends Activity {

    private ListView listView;
    private MainListAdapter mainListAdapter;

    DisplayMetrics metrics;
    int width = 0;
    int height = 0;

    private final int[] images = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five
    };

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

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        height = metrics.heightPixels;
        width = metrics.widthPixels;

        for(int image : images) {
            Glide.with(this)
                    .load(image)
                    .override(width, height)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .preload();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        mainListAdapter = new MainListAdapter(images);
        listView.setAdapter(mainListAdapter);

    }



}
