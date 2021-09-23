package com.example.sqliteusingroom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddDataFragment extends Fragment {


    private EditText inputid,inputname,inputemail;
    private Button btnsave;
    public AddDataFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_data, container, false);

        inputid=view.findViewById(R.id.ID);
        inputname=view.findViewById(R.id.inputname);
        inputemail=view.findViewById(R.id.inputemail);
        btnsave=view.findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(inputid.getText().toString());




                String name= inputname.getText().toString();
                String email = inputemail.getText().toString();

                Person person = new Person();
                person.setId(id);

                person.setName(name);
                person.setEmail(email);

                MainActivity.roomDatabaseClass.personDao().addPerson(person);
                Toast.makeText(getActivity(), "datasaved", Toast.LENGTH_SHORT).show();
                inputid.setText("");
                inputname.setText("");
                inputemail.setText("");
            }
        });



        return  view;
    }
}