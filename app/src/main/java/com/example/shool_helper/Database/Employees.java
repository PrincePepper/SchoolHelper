package com.example.shool_helper.Database;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Employees {

    @PrimaryKey(autoGenerate = true)
    public long id;

    private String formula;
    String formula_name;

    public Employees(String formula_name, String formula) {
        this.formula = formula;
        this.formula_name = formula_name;
    }


    public long getId() {
        return this.id;
    }

    public String getFormula() { return this.formula; }

    String getFormula_name() { return this.formula_name; }

}
