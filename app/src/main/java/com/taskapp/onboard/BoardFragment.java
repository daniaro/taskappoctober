package com.taskapp.onboard;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.taskapp.MainActivity;
import com.taskapp.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment {


    public BoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textTitle = view.findViewById(R.id.textTitle);
        Button btnStart = view.findViewById(R.id.btnStart);
        int pos = getArguments().getInt("pos");
        switch (pos) {
            case 0:
                imageView.setImageResource(R.drawable.smile1);
                textTitle.setText("Привет");
                btnStart.setVisibility(View.GONE);
                break;
            case 1:
                imageView.setImageResource(R.drawable.smile2);
                textTitle.setText("Как дела?");
                btnStart.setVisibility(View.GONE);
                break;
            case 2:
                textTitle.setText("Что делаешь?");
                btnStart.setVisibility(View.VISIBLE);
                break;
        }
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("settings", MODE_PRIVATE);
                preferences.edit().putBoolean("isShown", true).apply();
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
            }
        });

        return view;
    }

}
