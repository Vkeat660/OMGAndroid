package com.keating.vivian.omgandroid.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.keating.vivian.omgandroid.R;

import java.util.List;

/**
 * Created by Rainbow on 11/9/15.
 */
public class MainListAdapter extends BaseAdapter {

    private final int[] images;

    public MainListAdapter(int[] images) { this.images = images; }

    @Override
    public int getCount() {
        return images.length + 1;
    }

    @Override
    public Object getItem(int position) {
        return images[position - 1];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0 : 1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);

        if (convertView == null) {
            if (type == 0) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_row, parent, false);
            } else {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
            }
            convertView.setMinimumHeight(parent.getMeasuredHeight());
        }

        if(type == 1){

            ImageView imageView = (ImageView)  convertView.findViewById(R.id.image);
            int imageName = images[position - 1];
            imageView.getLayoutParams().height = parent.getMeasuredHeight();
            imageView.getLayoutParams().width = parent.getMeasuredWidth();

            Glide.with(parent.getContext())
                    .load(imageName)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);

        }

        return convertView;
    }
}
