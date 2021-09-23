package com.example.sqliteusingroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    List<Person> list;

    public RecyclerAdapter(List<Person>list){
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {

        holder.tvid.setText(String.valueOf(list.get(position).getId()));
        holder.tvname.setText(list.get(position).getName());
        holder.tvemail.setText(list.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvid,tvname,tvemail;
        Button deletebtn;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvid=itemView.findViewById(R.id.tv_id);
            tvname=itemView.findViewById(R.id.tvname);
            tvemail=itemView.findViewById(R.id.tv_email);
            deletebtn=itemView.findViewById(R.id.deletebutton);
            deletebtn.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {
            Person person = new Person();
            int ID = list.get(getAdapterPosition()).getId();

            person.setId(ID);
            MainActivity.roomDatabaseClass.personDao().deleteperson(person);
            Toast.makeText(deletebtn.getContext(), "Id "+ID+" is deleted", Toast.LENGTH_LONG).show();

            MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,new HomeFragment(),null).commit();

        }
    }
}
