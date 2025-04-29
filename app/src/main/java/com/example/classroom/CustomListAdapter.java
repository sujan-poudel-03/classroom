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

    /**
     * Returns the total number of items (how many list rows will be shown).
     * @return
     */
    @Override
    public int getCount() {
        return countryNames.length;
    }

    /**
     * Returns the data at a specific position. (Here, just the country name.)
     * @param i
     * @return
     */
    @Override
    public Object getItem(int i) {
        return countryNames[i];
    }

    /**
     * Returns the item's ID. Often used for database operations. Here, it's just the index.
     * @param i
     * @return
     */
    @Override
    public long getItemId(int i) {
        return i;
    }


//    context: Reference to the current state of the application (used to access resources).
//    countryNames: Array of country names (strings).
//    countryFlags: Array of drawable resource IDs (integers) for flags.
//    inflater: Used to convert an XML layout into actual View objects.

    public CustomListAdapter(Context ctx, String[] names, int[] flags) {
        this.context = ctx;
        this.countryNames = names;
        this.countryFlags = flags;
        this.inflater = LayoutInflater.from(ctx);
    }

//    Inflates the custom layout (custom_list_item.xml) for each row.
//    Binds the country name and flag image to the TextView and ImageView.
//    position is the index of the item being created.
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

