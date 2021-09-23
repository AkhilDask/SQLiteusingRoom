package com.example.sqliteusingroom;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonDao  {

    @Insert
     void addPerson(Person person);

    @Query("select * from person")
    public List<Person>getPerson();

    @Delete
    public void deleteperson(Person person);

    @Update
    public void updateperson(Person person);
}
