package com.example.classroom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.example.classroom.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskListFragment extends Fragment {

    private List<TaskModel> taskList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        LinearLayout listContainer = view.findViewById(R.id.taskListContainer);

        // Sample data
        taskList.add(new TaskModel("Task 1", "Short summary of Task 1"));
        taskList.add(new TaskModel("Task 2", "Short summary of Task 2"));
        taskList.add(new TaskModel("Task 3", "Short summary of Task 3"));
        taskList.add(new TaskModel("Task 4", "Short summary of Task 4"));

        for (TaskModel task : taskList) {
            TextView textView = new TextView(requireContext());
            textView.setText(task.getTitle() + "\n" + task.getDescription());
            textView.setPadding(16, 24, 16, 24);
            textView.setTextSize(16f);
            textView.setBackgroundResource(android.R.drawable.dialog_holo_light_frame);

            textView.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("title", task.getTitle());
                bundle.putString("description", task.getDescription());

                TaskDetailsFragment detailsFragment = new TaskDetailsFragment();
                detailsFragment.setArguments(bundle);

                if (getActivity().findViewById(R.id.fragment_detail_container) != null) {
                    // LANDSCAPE MODE - show on the right
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_detail_container, detailsFragment)
                            .commit();
                } else {
                    // PORTRAIT MODE - replace current screen
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, detailsFragment)
                            .addToBackStack(null)
                            .commit();
                }
            });
//            textView.setOnClickListener(v -> {
//                Bundle bundle = new Bundle();
//                bundle.putString("title", task.getTitle());
//                bundle.putString("description", task.getDescription());
//
//                TaskDetailsFragment detailsFragment = new TaskDetailsFragment();
//                detailsFragment.setArguments(bundle);
//
//                requireActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container, detailsFragment)
//                        .addToBackStack(null)
//                        .commit();
//            });

            listContainer.addView(textView);
        }

        return view;
    }
}