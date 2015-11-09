package com.keating.vivian.omgandroid.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.keating.vivian.omgandroid.R;

import java.util.List;


/**
 * Created by Rainbow on 11/9/15.
 */
public class MainListAdapter extends BaseAdapter {

    private final int[] images = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five
    };

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        }

        convertView.setMinimumHeight(parent.getMeasuredHeight());
        ImageView imageView = (ImageView)  convertView.findViewById(R.id.image);
        int imageName = images[position];
        imageView.setImageResource(imageName);
        imageView.getLayoutParams().height = parent.getMeasuredHeight();
        imageView.getLayoutParams().width  = parent.getMeasuredWidth();
        //imageView.setMinimumHeight(parent.getMeasuredHeight());

        return convertView;
    }
}
