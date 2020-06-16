package com.sqw.ormdemosmy;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "ppppp")
class Perppp {



    @DatabaseField(id = true)
    private String name;
    @DatabaseField
    private String ser;

    public Perppp(String smy, String s) {
        name=smy;
        ser=s;
    }
    public Perppp( ) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    @Override
    public String toString() {
        return "Perppp{" +
                "name='" + name + '\'' +
                ", ser='" + ser + '\'' +
                '}';
    }
}
