package com.example.classroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridAdapter extends BaseAdapter {

    Context context;
    String[] fruitNames;
    int[] fruitImages;
    LayoutInflater layoutInflater;

    public CustomGridAdapter(Context ctx, String[] fruits, int[] images){
        this.context = ctx;
        this.fruitNames = fruits;
        this.fruitImages = images;
        this.layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount(){
        return fruitNames.length;
    }

    @Override
    public Object getItem(int i){
        return fruitNames[i];
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        view = layoutInflater.inflate(R.layout.custom_grid_item, null);
        ImageView imageView = view.findViewById(R.id.fruit_image);
        TextView textView = view.findViewById(R.id.fruit_name);

        imageView.setImageResource(fruitImages[position]);
        textView.setText(fruitNames[position]);

        return view;

    }


}
