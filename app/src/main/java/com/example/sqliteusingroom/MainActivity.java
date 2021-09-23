package com.example.sqliteusingroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;

    static RoomDatabaseClass roomDatabaseClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        roomDatabaseClass = Room.databaseBuilder(getApplicationContext(),RoomDatabaseClass.class,"mydb").allowMainThreadQueries().build();


        if (findViewById(R.id.Container)!= null){
            if (savedInstanceState != null)
            {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.Container,new HomeFragment(),null).commit();
        }

    }
}