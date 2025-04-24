package com.example.classroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {

    Context context;
    String[] countryNames;
    int[] countryFlags;
    LayoutInflater inflater;
    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int i) {
        return countryNames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public CustomListAdapter(Context ctx, String[] names, int[] flags) {
        this.context = ctx;
        this.countryNames = names;
        this.countryFlags = flags;
        this.inflater = LayoutInflater.from(ctx);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.custom_list_item, null);
        TextView name = view.findViewById(R.id.txtCountry);
        ImageView flag = view.findViewById(R.id.imgFlag);

        name.setText(countryNames[position]);
        flag.setImageResource(countryFlags[position]);

        return view;
    }
}
