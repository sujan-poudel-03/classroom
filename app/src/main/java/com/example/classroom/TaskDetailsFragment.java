package com.example.classroom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TaskDetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_details, container, false);

        TextView titleView = view.findViewById(R.id.taskTitle);
        TextView descView = view.findViewById(R.id.taskDescription);

        Bundle args = getArguments();
        if (args != null) {
            titleView.setText(args.getString("title"));
            descView.setText(args.getString("description"));
        }

        return view;
    }
}