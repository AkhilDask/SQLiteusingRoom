package com.example.sqliteusingroom;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class},version = 2)
public abstract class RoomDatabaseClass extends RoomDatabase {

    public abstract PersonDao personDao();
}
