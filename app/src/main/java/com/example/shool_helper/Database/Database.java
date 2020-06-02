package com.example.shool_helper.Database;

import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {Employees.class}, version = 1, exportSchema = false)

public abstract class Database extends RoomDatabase {
    public abstract Dao entityDao();
}
