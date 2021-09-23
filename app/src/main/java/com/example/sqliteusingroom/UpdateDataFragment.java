package com.example.sqliteusingroom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateDataFragment extends Fragment {

    private EditText idupdate,nameupdate,emailupdate;
    private Button updatebutton;

    public UpdateDataFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_data, container, false);

        idupdate = view.findViewById(R.id.updatedID);
        nameupdate = view.findViewById(R.id.inputupdatedname);
        emailupdate = view.findViewById(R.id.inputupdatedemail);
        updatebutton=view.findViewById(R.id.btnupdate);

        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ID = Integer.parseInt(idupdate.getText().toString());
                String name= nameupdate.getText().toString();
                String Email= emailupdate.getText().toString();


                Person person = new Person();
                person.setId(ID);
                person.setName(name);
                person.setEmail(Email);

                MainActivity.roomDatabaseClass.personDao().updateperson(person);
                Toast.makeText(getActivity(), "ID "+ID+" is Updated", Toast.LENGTH_LONG).show();

                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new HomeFragment(), null).commit();
            }
        });



        return  view;
    }
}