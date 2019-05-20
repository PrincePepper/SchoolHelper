package com.example.shool_helper.Database;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Query;

import java.util.List;

@android.arch.persistence.room.Dao
public interface Dao {

    @Query("SELECT * FROM Employees")
    List<Employees> getAll();

    @Query("SELECT * FROM Employees WHERE id = :id")
    Employees getById(long id);

    @Query("SELECT * FROM Employees WHERE Formula_name= :name")
    Employees getByName(String name);


    @Insert
    void insert(Employees employees);

    @Update
    void update(Employees employees);

    @Delete
    void delete(Employees employees);
}
