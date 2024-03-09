package com.example.engerapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.engerapplication.R;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;


    RelativeLayout  main_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       main_layout = findViewById(R.id.main_layout);

       bottomNavigation = findViewById(R.id.bottomNavigation);

        //For default fragment
        replace(new HomeFragment());

        bottomNavigation.show(1, true);// This is for default layout

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_search_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_add_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.baseline_chat_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.baseline_person_24));

        meownavigation();
        main_layout.setBackgroundColor(Color.parseColor("#FF5722"));

    }//====================ON create End===================

       private void meownavigation(){

           bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
               @Override
               public Unit invoke(MeowBottomNavigation.Model model) {

                   switch (model.getId()){

                       case 1:

                           replace(new HomeFragment());
                           main_layout.setBackgroundColor(Color.parseColor("#FF5722"));

                           break;

                       case 2:

                           replace(new SearchFragment());
                           main_layout.setBackgroundColor(Color.parseColor("#0C50FB"));

                           break;

                       case 3:

                           replace(new AddFragment());
                           main_layout.setBackgroundColor(Color.parseColor("#C73AB8"));

                           break;

                       case 4:

                           replace(new ChatFragment());
                           main_layout.setBackgroundColor(Color.parseColor("#673AB8"));

                           break;
                       case 5:

                           replace(new ProfileFragment());
                           main_layout.setBackgroundColor(Color.parseColor("#FFCFF8"));

                           break;
                   }
                   return null;
               }
           });




       }//===========


    private void replace(Fragment fragment){


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();




    }





}//====================code end===================