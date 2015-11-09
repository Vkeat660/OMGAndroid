package com.keating.vivian.omgandroid.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.keating.vivian.omgandroid.R;

import java.util.List;


/**
 * Created by Rainbow on 11/9/15.
 */
public class MainListAdapter extends BaseAdapter {

    private final List<String> imageNames;

    public MainListAdapter(List<String> imageNames) {
        this.imageNames = imageNames;
    }


    @Override
    public int getCount() {
        return imageNames.size();
    }

    @Override
    public Object getItem(int position) {
        return imageNames.get(position);
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

        TextView imageTextView = (TextView) convertView.findViewById(R.id.text);
        String imageName = imageNames.get(position);
        imageTextView.setText(imageName);

        return convertView;
    }
}
