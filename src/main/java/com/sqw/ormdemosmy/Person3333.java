package com.sqw.ormdemosmy;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "persons333")
public class Person3333 {


    public Person3333(String s, String s1) {
            name=s;
            password=s1;
    }

        @DatabaseField(id = true)
        private String name;
        @DatabaseField
        private String password;

    public Person3333() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
