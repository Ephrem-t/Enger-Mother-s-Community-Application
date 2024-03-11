package com.example.engerapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.engerapplication.R;
import com.example.engerapplication.activities.RecentUserActivity;
import com.example.engerapplication.activities.notificationActivity;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Find the message icon view
        ImageView messageIcon = view.findViewById(R.id.message_icon);



        // Find the notification icon view
        ImageView notificationIcon = view.findViewById(R.id.like_icon);







        // Set an OnClickListener to the message icon
        messageIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ChatActivity
                startActivity(new Intent(getActivity(), RecentUserActivity.class));
            }

        });
            // Set an OnClickListener to the message icon
        notificationIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    // Start the notificationActivity
                    startActivity(new Intent(getActivity(), notificationActivity.class));
                }

        });





        return view;
    }










}
