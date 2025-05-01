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

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        FruitModel fruitModel = fruitList.get(position);
        holder.fruit_image.setImageResource(fruitModel.getImage());
        holder.fruit_name.setText(fruitModel.getName());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Cliced : " + fruitModel.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount(){
        return fruitList.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {

        TextView fruit_name;
        ImageView fruit_image;

        public FruitViewHolder(@NonNull View itemView) {
         super(itemView);
            fruit_name = itemView.findViewById(R.id.fruit_name);
            fruit_image = itemView.findViewById(R.id.fruit_image);
        }

    }

}
