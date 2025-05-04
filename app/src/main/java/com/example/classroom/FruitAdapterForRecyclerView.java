package com.example.classroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter class for binding fruit data to a RecyclerView
public class FruitAdapterForRecyclerView extends RecyclerView.Adapter<FruitAdapterForRecyclerView.FruitViewHolder> {

    Context context;    // Activity context
    List<FruitModel> fruitList;  // Data source: List of FruitModel items

    // Constructor to initialize context and fruit list
    public FruitAdapterForRecyclerView(Context context, List<FruitModel> fruitList){
        this.context = context;
        this.fruitList = fruitList;
    }

    // Called only when a new ViewHolder is needed (i.e., not recycled)
    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        // Inflate the layout for a single grid item
        View view = LayoutInflater.from(context).inflate(R.layout.custom_grid_item, parent, false);
        // Return a new ViewHolder that wraps the inflated view
        return new FruitViewHolder(view);
    }

    // Called to bind data to an existing ViewHolder at a specific position
    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        // Get the fruit item at the current position
        FruitModel fruitModel = fruitList.get(position);
        // Set image and name from model into the item view
        holder.fruit_image.setImageResource(fruitModel.getImage());
        holder.fruit_name.setText(fruitModel.getName());

        // Add a click listener to each item view
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Cliced : " + fruitModel.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    // Returns the total number of items in the data set
    @Override
    public int getItemCount(){
        return fruitList.size();
    }

    // ViewHolder class that holds references to the views inside each item layout
    public static class FruitViewHolder extends RecyclerView.ViewHolder {

        TextView fruit_name;
        ImageView fruit_image;
        public FruitViewHolder(@NonNull View itemView) {
         super(itemView);
        // Initialize view references using IDs from the layout file
        TextView fruit_name = itemView.findViewById(R.id.fruit_name);
        ImageView fruit_image = itemView.findViewById(R.id.fruit_image);

        }

    }

}
