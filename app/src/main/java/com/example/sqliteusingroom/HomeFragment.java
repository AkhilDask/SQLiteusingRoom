package com.example.sqliteusingroom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener{

   private Button btnadd,btnview,btnupdate;

    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnadd = view.findViewById(R.id.add);
        btnupdate=view.findViewById(R.id.update);
        btnview=view.findViewById(R.id.view);
        btnview.setOnClickListener(this::onClick);

        btnadd.setOnClickListener(this::onClick);
        btnupdate.setOnClickListener(this::onClick);



        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.add:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new AddDataFragment(), null).addToBackStack(null).commit();
                break;
            case R.id.view:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new ViewFragment(), null).addToBackStack(null).commit();
                break;

            case R.id.update:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new UpdateDataFragment(), null).addToBackStack(null).commit();
                break;

        }

    }
}