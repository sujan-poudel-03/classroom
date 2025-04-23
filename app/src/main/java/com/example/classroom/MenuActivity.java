package com.example.classroom;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button popupButton = findViewById(R.id.show_popup_btn);
        popupButton.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(MenuActivity.this, view);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.popup_item_one) {
                    Toast.makeText(this, "Popup Option 1 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.popup_item_two) {
                    Toast.makeText(this, "Popup Option 2 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            });

            popupMenu.show();
        });

        TextView contextText = findViewById(R.id.context_text);
        registerForContextMenu(contextText);

    }

    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    // method to handle menu item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();

        if(id == R.id.option_one){
            showSimpleDialog();
//            Toast.makeText(this, "Option 1 is clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(id==R.id.option_two){
            Toast.makeText(this, "Option 2 is clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(menuItem);

    }

    // this is for context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.context_edit) {
            Toast.makeText(this, "Edit selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.context_delete) {
            Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }

    // this is for a dialoug
    private void showSimpleDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Option 1 Selected")
                .setMessage("You selected Option 1. Continue?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    finishAffinity(); // This will close the entire app
                })
//                .setPositiveButton("Yes", (dialog, which) ->
//                        Toast.makeText(this, "Confirmed", Toast.LENGTH_SHORT).show())
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }

    public void showSimpleDialog1(){
        new AlertDialog.Builder(this).setTitle("Are you sure you want to exit")
                .setMessage("Go for it")
                .setPositiveButton(
                        "Yes", (dialog, which) -> {
                            finishAffinity();
                        })
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }


}